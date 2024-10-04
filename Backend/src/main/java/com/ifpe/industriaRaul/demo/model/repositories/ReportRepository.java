package com.ifpe.industriaRaul.demo.model.repositories;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ifpe.industriaRaul.demo.model.entites.Funcionario;
import com.ifpe.industriaRaul.demo.model.entites.Report;
import com.ifpe.industriaRaul.demo.model.entites.Setor;

public class ReportRepository implements Repository<Report, Integer> {

    @Override
    public void create(Report report) throws SQLException {
        String sql = "INSERT INTO report(tipo, data, funcionario_codigo, setor_codigo) VALUES (?, ?, ?, ?)";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setString(1, report.getTipo());
        pstm.setTimestamp(2, java.sql.Timestamp.valueOf(report.getData()));
        pstm.setInt(3, report.getFuncionario().getCodigo());
        pstm.setInt(4, report.getSetor().getCodigo());
        pstm.execute();
    }

    @Override
    public Report read(Integer codigo) throws SQLException {
        String sql = "SELECT * FROM report WHERE codigo=?";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setInt(1, codigo);
        ResultSet rs = pstm.executeQuery();
        if (rs.next()) {
            Funcionario funcionario = new FuncionarioRepository().read(rs.getInt("funcionario_codigo"));
            Setor setor = new SetorRepository().read(rs.getInt("setor_codigo"));
            return new Report(rs.getInt("codigo"), rs.getString("tipo"), rs.getTimestamp("data").toLocalDateTime(), funcionario, setor);
        }
        return null;
    }

    @Override
    public void update(Report report) throws SQLException {
        String sql = "UPDATE report SET tipo=?, data=?, funcionario_codigo=?, setor_codigo=? WHERE codigo=?";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setString(1, report.getTipo());
        pstm.setTimestamp(2, java.sql.Timestamp.valueOf(report.getData()));
        pstm.setInt(3, report.getFuncionario().getCodigo());
        pstm.setInt(4, report.getSetor().getCodigo());
        pstm.setInt(5, report.getCodigo());
        pstm.executeUpdate();
    }

    @Override
    public void delete(Integer codigo) throws SQLException {
        String sql = "DELETE FROM report WHERE codigo=?";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setInt(1, codigo);
        pstm.execute();
    }

    public List<Report> findAll() throws SQLException {
        String sql = "SELECT * FROM report";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        ResultSet rs = pstm.executeQuery();
        List<Report> reports = new ArrayList<>();
        while (rs.next()) {
            Funcionario funcionario = new FuncionarioRepository().read(rs.getInt("funcionario_codigo"));
            Setor setor = new SetorRepository().read(rs.getInt("setor_codigo"));
            reports.add(new Report(rs.getInt("codigo"), rs.getString("tipo"), rs.getTimestamp("data").toLocalDateTime(), funcionario, setor));
        }
        return reports;
    }

    public List<Report> findBySetor(int setorId) throws SQLException {
        String sql = "SELECT * FROM report WHERE setor_codigo=?";
        PreparedStatement pstm = ConnectionManager.getCurrentConnection().prepareStatement(sql);
        pstm.setInt(1, setorId);
        ResultSet rs = pstm.executeQuery();
        List<Report> reports = new ArrayList<>();
        while (rs.next()) {
            Funcionario funcionario = new FuncionarioRepository().read(rs.getInt("funcionario_codigo"));
            Setor setor = new SetorRepository().read(rs.getInt("setor_codigo"));
            reports.add(new Report(rs.getInt("codigo"), rs.getString("tipo"), rs.getTimestamp("data").toLocalDateTime(), funcionario, setor));
        }
        return reports;
    }
}
