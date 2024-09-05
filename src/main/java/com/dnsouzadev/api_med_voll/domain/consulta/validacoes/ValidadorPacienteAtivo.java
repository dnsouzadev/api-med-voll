package com.dnsouzadev.api_med_voll.domain.consulta.validacoes;

import com.dnsouzadev.api_med_voll.domain.consulta.DadosAgendamentoConsulta;
import com.dnsouzadev.api_med_voll.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private PacienteRepository pacienteRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var pacienteAtivo = pacienteRepository.findAtivoById(dados.idPaciente());

        if (!pacienteAtivo) {
            throw new IllegalArgumentException("Paciente não está ativo");
        }
    }
}
