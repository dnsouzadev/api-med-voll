package com.dnsouzadev.api_med_voll.domain.consulta.validacoes;

import com.dnsouzadev.api_med_voll.domain.consulta.ConsultaRepository;
import com.dnsouzadev.api_med_voll.domain.consulta.DadosAgendamentoConsulta;

public class ValidadorPacienteSemOutraConsultaNoDia {

    private ConsultaRepository consultaRepository;

    public void validar(DadosAgendamentoConsulta dados) {
        var primeiroHorario = dados.data().withHour(7);
        var ultimoHorario = dados.data().withHour(18);
        var pacientePossuiOutraConsultaNoDia = consultaRepository.existsByPacienteIdAndDataBetween(dados.idPaciente(), primeiroHorario, ultimoHorario);
        if (pacientePossuiOutraConsultaNoDia) {
            throw new IllegalArgumentException("Paciente possui outra consulta no mesmo dia");
        }
    }
}
