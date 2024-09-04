package com.dnsouzadev.api_med_voll.domain.consulta;

import com.dnsouzadev.api_med_voll.domain.medico.Medico;
import com.dnsouzadev.api_med_voll.domain.medico.MedicoRepository;
import com.dnsouzadev.api_med_voll.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaDeConsultas {

    @Autowired
    private ConsultaRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;


    public void agendar(DadosAgendamentoConsulta dados) {
        var paciente = pacienteRepository.findById(dados.idPaciente()).orElseThrow();
        var medico = escolherMedico(dados);

        var consulta = new Consulta(null, medico, paciente, dados.data());

        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta dados) {
        if (dados.idMedico() != null) {
            return medicoRepository.getReferenceById(dados.idMedico());
        }

        if (dados.especialidade() == null) {
            throw new IllegalArgumentException("Especialidade é obrigatória");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(dados.especialidade(), dados.data());
    }

}
