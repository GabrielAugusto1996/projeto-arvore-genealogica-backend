package br.com.arvore.genealogica.models;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@Table(name = "tb_usuario")
public class Usuario implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private Integer codigo;

    @NotNull
    @Column(name = "nome", length = 50)
    private String nome;

    @Column(name = "celular", length = 15)
    private String celular;

    @NotNull
    @Column(name = "email", length = 40)
    private String email;

    @Column(name = "senha", length = 15)
    private String senha;

    @Column(name = "data_cadastro")
    private LocalDate dataCadastro;

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public LocalDate getDataCadastro() {
        return dataCadastro;
    }

    public void setDataCadastro(LocalDate dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public Usuario(Integer codigo, String email, String senha) {
        this.codigo = codigo;
        this.email = email;
        this.senha = senha;
    }

    public Usuario() {}

}