package com.ifpe.industriaRaul.demo.model.entites;

public class Funcionario {

    int codigo;
    String nome;
    String email;
    String senha;
    Setor setor;
//  int setorCodigo;

    public Funcionario(int codigo, String nome, String email, String senha, Setor setor) {
        this.codigo = codigo;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.setor = setor;
    }

    // private List<Report> reports;
    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
