package com.dnsouzadev.api_med_voll.domain.consulta.validacoes;

import com.dnsouzadev.api_med_voll.domain.consulta.DadosAgendamentoConsulta;
import org.springframework.stereotype.Component;

@Component
public class ValidadorHorarioAntecedencia implements ValidadorAgendamentoDeConsulta {

    public void validar(DadosAgendamentoConsulta dados) {
        var dataConsulta = dados.data();
        var dataAtual = java.time.LocalDateTime.now();

        var diferencaEmHoras = java.time.Duration.between(dataAtual, dataConsulta).toMinutes();

        if (diferencaEmHoras < 30) {
            throw new IllegalArgumentException("Consulta deve ser agendada com no mínimo 30 minutos de antecedência");
        }
    }

}
