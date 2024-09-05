package com.dnsouzadev.api_med_voll.domain.endereco;

import jakarta.persistence.Embeddable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Embeddable
public class Endereco {
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private String uf;
    private String complemento;
    private String numero;

    public Endereco(@NotNull @Valid DadosEndereco endereco) {
    }

    public Endereco(String logradouro, String bairro, String cep, String cidade, String uf, String complemento, String numero) {
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
        this.numero = numero;
    }

    public void atualizarInformacoes(DadosEndereco endereco) {
        if (endereco.logradouro() != null) this.logradouro = endereco.logradouro();
        if (endereco.bairro() != null) this.bairro = endereco.bairro();
        if (endereco.cep() != null) this.cep = endereco.cep();
        if (endereco.cidade() != null) this.cidade = endereco.cidade();
        if (endereco.uf() != null) this.uf = endereco.uf();
        if (endereco.complemento() != null) this.complemento = endereco.complemento();
        if (endereco.numero() != null) this.numero = endereco.numero();
    }
}
