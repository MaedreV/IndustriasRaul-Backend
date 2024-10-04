package com.ifpe.industriaRaul.demo.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpe.industriaRaul.demo.model.entites.Funcionario;
import com.ifpe.industriaRaul.demo.model.repositories.FuncionarioRepository;

@RestController
//toda as origens
@CrossOrigin("*")
@RequestMapping("/funcionarios")
public class FuncionarioController {

    private final FuncionarioRepository funcionarioRepository = FuncionarioRepository.current;

    //cadastro de func
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarFuncionario(@RequestBody Funcionario funcionario) {
        try {
            funcionarioRepository.create(funcionario);
            return ResponseEntity.ok("Funcionário cadastrado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao cadastrar funcionário.");
        }
    }

    // listar por id(vou usar?)
    @GetMapping("/setor/{setorId}")
    public ResponseEntity<List<Funcionario>> listarFuncionariosPorSetor(@PathVariable int setorId) {
        try {
            List<Funcionario> funcionarios = funcionarioRepository.findBySetor(setorId);
            return ResponseEntity.ok(funcionarios);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }

    //listar todos funionarios
    @GetMapping
    public ResponseEntity<List<Funcionario>> listarTodosFuncionarios() {
        try {
            List<Funcionario> funcionarios = funcionarioRepository.findAll();
            return ResponseEntity.ok(funcionarios);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
