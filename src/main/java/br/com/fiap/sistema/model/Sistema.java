package br.com.fiap.sistema.model;

import br.com.fiap.pessoa.model.Pessoa;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "TB_SISTEMA", uniqueConstraints = {
        @UniqueConstraint(name = "UK_SIGLA_TB_SISTEMA", columnNames = {"SIGLA_TB_SISTEMA"})
})
public class Sistema {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_TB_SISTEMA")
    @SequenceGenerator(name = "SQ_TB_SISTEMA", sequenceName = "SQ_TB_SISTEMA")
    @Column(name = "ID_TB_SISTEMA")
    private Long id;

    @Column(name = "NOME_TB_SISTEMA", nullable = false)
    private String nome;

    @Column(name = "SIGLA_TB_SISTEMA", nullable = false)
    private String sigla;

    @ManyToMany(mappedBy = "sistemas", cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @OrderBy("name asc")
    private Set<Pessoa> responsaveis = new LinkedHashSet<>();

    public Sistema(String nome, String sigla) {
        this.nome = nome;
        this.sigla = sigla;
    }

    public Sistema(Long id, String nome, String sigla, Set<Pessoa> responsaveis) {
        this.id = id;
        this.nome = nome;
        this.sigla = sigla;
        this.responsaveis = responsaveis;
    }

    public Sistema addResponsavel(Pessoa pessoa) {
        this.responsaveis.add(pessoa);
        return this;
    }

    public Sistema removeResponsavel(Pessoa pessoa) {
        this.responsaveis.remove(pessoa);
        return this;
    }

    public Set<Pessoa> getResponsaveis() {
        return Collections.unmodifiableSet(this.responsaveis);
    }

    public Long getId() {
        return id;
    }

    public Sistema setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Sistema setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getSigla() {
        return sigla;
    }

    public Sistema setSigla(String sigla) {
        this.sigla = sigla;
        return this;
    }

    @Override
    public String toString() {
        return "Sistema{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", sigla='" + sigla + '\'' +
                ", responsaveis=" + responsaveis +
                '}';
    }
}
