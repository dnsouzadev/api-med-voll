package com.dnsouzadev.api_med_voll.medico;

import com.dnsouzadev.api_med_voll.endereco.DadosEndereco;

public record CadastroMedico(
        String nome,
        String email,
        String crm,
        Especialidade especialidade,
        DadosEndereco endereco
) {
}
