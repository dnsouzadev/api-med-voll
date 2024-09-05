package com.dnsouzadev.api_med_voll.domain.consulta.validacoes;

import com.dnsouzadev.api_med_voll.domain.consulta.DadosAgendamentoConsulta;
import com.dnsouzadev.api_med_voll.domain.medico.MedicoRepository;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository medicoRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() == null) {
            return;
        }

        var medicoAtivo = medicoRepository.findAtivoById(dados.idMedico());
        System.out.println("Medico ativo: " + medicoAtivo);
        if (!medicoAtivo) {
            throw new ValidationException("Médico não está ativo");
        }
    }
}
