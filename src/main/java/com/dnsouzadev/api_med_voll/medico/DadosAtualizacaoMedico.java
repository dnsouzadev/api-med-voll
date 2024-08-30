package com.dnsouzadev.api_med_voll.medico;

import com.dnsouzadev.api_med_voll.endereco.DadosEndereco;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull Long id,
        String nome,
        String telefone,
        DadosEndereco endereco
) {
}
