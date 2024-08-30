package com.dnsouzadev.api_med_voll.domain.paciente;

import com.dnsouzadev.api_med_voll.domain.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco endereco) {
}
