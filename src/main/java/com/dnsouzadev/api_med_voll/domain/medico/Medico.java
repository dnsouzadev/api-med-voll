package com.dnsouzadev.api_med_voll.domain.medico;

import com.dnsouzadev.api_med_voll.domain.endereco.Endereco;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

import java.util.Objects;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private boolean ativo;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(CadastroMedico medico) {
        this.ativo = true;
        this.nome = medico.nome();
        this.email = medico.email();
        this.telefone = medico.telefone();
        this.crm = medico.crm();
        this.especialidade = medico.especialidade();
        this.endereco = new Endereco(
                medico.endereco().logradouro(),
                medico.endereco().bairro(),
                medico.endereco().cep(),
                medico.endereco().cidade(),
                medico.endereco().uf(),
                medico.endereco().complemento(),
                medico.endereco().numero()
        );
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medico medico = (Medico) o;
        return id == medico.id;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }

    public void atualizarInfo(@Valid DadosAtualizacaoMedico dados) {
        if (dados.nome() != null) this.nome = dados.nome();
        if (dados.telefone() != null) this.telefone = dados.telefone();
        if (dados.endereco() != null) this.endereco.atualizarInfo(dados.endereco());
    }

    public void excluir() {
        this.ativo = false;
    }
}
