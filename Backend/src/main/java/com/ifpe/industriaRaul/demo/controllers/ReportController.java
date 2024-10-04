package com.ifpe.industriaRaul.demo.controllers;

import java.sql.SQLException;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ifpe.industriaRaul.demo.model.entites.Report;
import com.ifpe.industriaRaul.demo.model.repositories.ReportRepository;

@RestController
@CrossOrigin("*")
@RequestMapping("/reports")
public class ReportController {

    private final ReportRepository reportRepository = new ReportRepository();

    // cadastrar report
    @PostMapping("/registrar")
    public ResponseEntity<String> registrarProblema(@RequestBody Report report) {
        try {
            report.setData(LocalDateTime.now());

            if (report.getFuncionario() == null || report.getSetor() == null) {
                return ResponseEntity.status(400).body("Funcionário ou setor não podem ser nulos.");
            }

            reportRepository.create(report);
            return ResponseEntity.ok("Problema reportado com sucesso.");
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body("Erro ao reportar problema: " + e.getMessage());
        }
    }

    // exibir report por setor
    @GetMapping("/setor/{setorId}")
    public ResponseEntity<List<Report>> listarRelatoriosPorSetor(@PathVariable int setorId) {
        try {
            List<Report> reports = reportRepository.findBySetor(setorId);
            return ResponseEntity.ok(reports);
        } catch (SQLException e) {
            e.printStackTrace();
            return ResponseEntity.status(500).body(null);
        }
    }
}
