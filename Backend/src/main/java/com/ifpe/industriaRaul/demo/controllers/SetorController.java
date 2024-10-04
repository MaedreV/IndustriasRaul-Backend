package com.ifpe.industriaRaul.demo.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpe.industriaRaul.demo.model.entites.Setor;
import com.ifpe.industriaRaul.demo.model.repositories.SetorRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/setores")
public class SetorController {

    private final SetorRepository setorRepository = SetorRepository.current;

    // cadastrar novo setor
    @PostMapping("/cadastrar")
    public ResponseEntity<String> cadastrarSetor(@RequestBody Setor setor) {
        try {
            setorRepository.create(setor);
            return ResponseEntity.ok("Setor cadastrado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao cadastrar setor.");
        }
    }

    // listar todos os setores
    @GetMapping("/listar")
    public ResponseEntity<List<Setor>> listarSetores() {
        try {
            List<Setor> setores = setorRepository.findAll();
            return ResponseEntity.ok(setores);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
