package com.dnsouzadev.api_med_voll.domain.medico;

import com.dnsouzadev.api_med_voll.domain.endereco.Endereco;

/**
 * DTO for {@link Medico}
 */
public record DadosDetalhamentoMedico(long id, String nome, String email, String crm, String telefone, Especialidade especialidade,
                                      Endereco endereco) {

    public DadosDetalhamentoMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getTelefone(), medico.getEspecialidade(), medico.getEndereco());
    }
}