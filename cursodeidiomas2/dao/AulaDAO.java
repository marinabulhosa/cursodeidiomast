package dao;

import model.Aula;
import model.Professor;
import model.Turma;
import java.sql.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

/*** DAO responsável pelas aulas agendadas do curso.*/
public class AulaDAO {

    /*** Salva uma nova aula no banco.*/
    public void salvar(Aula aula) throws Exception {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO aulas (id, turma_id, data, horaInicio, horaFim, professor_matricula) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, aula.getId());
        stmt.setInt(2, aula.getTurma().getId());
        stmt.setString(3, aula.getData().toString());
        stmt.setString(4, aula.getHoraInicio().toString());
        stmt.setString(5, aula.getHoraFim().toString());
        stmt.setString(6, aula.getProfessor() != null ? aula.getProfessor().getMatricula() : null);
        stmt.executeUpdate();
        conn.close();
    }

    /*** Lista todas as aulas cadastradas com turma e professor associados.*/
    public List<Aula> listar() throws Exception {
        List<Aula> lista = new ArrayList<>();
        Connection conn = Conexao.getConnection();

        String sql = "SELECT a.id, a.data, a.horaInicio, a.horaFim, " +
                    "t.id as turma_id, t.dataInicio, t.dataFim, t.lingua, t.nivel, t.preco, " +
                    "p.matricula, p.nome, p.endereco, p.telefone, p.valorHora " +
                    "FROM aulas a " +
                    "JOIN turmas t ON a.turma_id = t.id " +
                    "LEFT JOIN professores p ON a.professor_matricula = p.matricula";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // Constrói objeto Turma
            Turma turma = new Turma(
                rs.getInt("turma_id"),
                LocalDate.parse(rs.getString("dataInicio")),
                LocalDate.parse(rs.getString("dataFim")),
                rs.getString("lingua"),
                rs.getString("nivel"),
                rs.getDouble("preco"),
                new ArrayList<>() // Alunos omitidos
            );

            // Constrói objeto Professor, se houver
            Professor professor = null;
            String matricula = rs.getString("matricula");
            if (matricula != null) {
                professor = new Professor(
                    matricula,
                    rs.getString("nome"),
                    rs.getString("endereco"),
                    rs.getString("telefone"),
                    rs.getDouble("valorHora"),
                    new ArrayList<>() // Linguas omitidas
                );
            }

            // Constrói objeto Aula
            Aula aula = new Aula(
                rs.getInt("id"),
                turma,
                LocalDate.parse(rs.getString("data")),
                LocalTime.parse(rs.getString("horaInicio")),
                LocalTime.parse(rs.getString("horaFim")),
                professor
            );

            lista.add(aula);
        }

        conn.close();
        return lista;
    }

    /*** Atualiza a data de uma aula (posterga o início).*/
    public void reagendar(int id, LocalDate novaData) throws Exception {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "UPDATE aulas SET data = ? WHERE id = ?");
        stmt.setString(1, novaData.toString());
        stmt.setInt(2, id);
        stmt.executeUpdate();
        conn.close();
    }

    /*** Registra o professor no momento do início da aula.*/
    public void iniciarAula(int idAula, String matriculaProfessor) throws Exception {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "UPDATE aulas SET professor_matricula = ? WHERE id = ?");
        stmt.setString(1, matriculaProfessor);
        stmt.setInt(2, idAula);
        stmt.executeUpdate();
        conn.close();
    }
}