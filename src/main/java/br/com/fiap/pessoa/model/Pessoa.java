package br.com.fiap.pessoa.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "TB_PESSOA")
//adicionando anotations
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "TP_PESSOA")
public abstract class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_PESSOA")
    @Column(name = "ID_TB_PESSOA")
    protected Long id;

    @Column(name = "NOME_TB_PESSOA", nullable = false)
    protected String nome;


    @Column(name = "DTNASC_TB_PESSOA")
    protected LocalDate nascimento;

    public Pessoa() {
    }

    public Pessoa(Long id, String nome, LocalDate nascimento) {
        this.id = id;
        this.nome = nome;
        this.nascimento = nascimento;
    }

    public Long getId() {
        return id;
    }

    public Pessoa setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Pessoa setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public LocalDate getNascimento() {
        return nascimento;
    }

    public Pessoa setNascimento(LocalDate nascimento) {
        this.nascimento = nascimento;
        return this;
    }

    @Override
    public boolean equals(Object o) {

        if (Objects.isNull(o)) return false;

        if (this == o) return true;
        if (!(o instanceof Pessoa pessoa)) return false;

        if (Objects.isNull(this.getId())) return false;

        return getId().equals(pessoa.getId());
    }
}
