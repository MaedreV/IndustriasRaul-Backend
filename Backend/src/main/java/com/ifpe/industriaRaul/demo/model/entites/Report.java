package com.ifpe.industriaRaul.demo.model.entites;

import java.time.LocalDateTime;

public class Report {

    int codigo;
    String tipo;
    LocalDateTime data;
    Funcionario funcionario;
    Setor setor;

    public Report(int codigo, String tipo, LocalDateTime data, Funcionario funcionario, Setor setor) {
        this.codigo = codigo;
        this.tipo = tipo;
        this.data = data;
        this.funcionario = funcionario;
        this.setor = setor;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public Setor getSetor() {
        return setor;
    }

    public void setSetor(Setor setor) {
        this.setor = setor;
    }
}
