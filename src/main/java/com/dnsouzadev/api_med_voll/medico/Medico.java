package com.dnsouzadev.api_med_voll.medico;

import com.dnsouzadev.api_med_voll.endereco.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter @Setter @NoArgsConstructor @AllArgsConstructor
@Entity
@Table
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nome;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

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
}
