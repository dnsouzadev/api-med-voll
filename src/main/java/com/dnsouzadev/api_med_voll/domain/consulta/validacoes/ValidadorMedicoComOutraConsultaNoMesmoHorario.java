package com.dnsouzadev.api_med_voll.domain.consulta.validacoes;

import com.dnsouzadev.api_med_voll.domain.consulta.ConsultaRepository;
import com.dnsouzadev.api_med_voll.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaNoMesmoHorario implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var medicoPossuiOutraConsultaNoMesmoHorario = consultaRepository.existsByMedicoIdAndData(dados.idMedico(), dados.data());

        if (medicoPossuiOutraConsultaNoMesmoHorario) {
            throw new IllegalArgumentException("Médico possui outra consulta no mesmo horário");
        }
    }
}
