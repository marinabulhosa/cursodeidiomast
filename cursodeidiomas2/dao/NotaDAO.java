package dao;

import model.Aluno;
import model.Nota;
import model.Turma;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/*** DAO responsável por manipular os registros de notas dos alunos.*/
public class NotaDAO {

    /*** Salva uma nova nota no banco de dados.*/
    public void salvar(Nota nota) throws Exception {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO notas (aluno_matricula, turma_id, valor) VALUES (?, ?, ?)");
        stmt.setString(1, nota.getAluno().getMatricula());
        stmt.setInt(2, nota.getTurma().getId());
        stmt.setDouble(3, nota.getValor());
        stmt.executeUpdate();
        conn.close();
    }

    /*** Retorna todas as notas cadastradas no sistema com dados de aluno e turma.*/
    public List<Nota> listar() throws Exception {
        List<Nota> lista = new ArrayList<>();

        // Abre a conexão com o banco
        Connection conn = Conexao.getConnection();

        // Executa a consulta das notas e associa com tabelas de alunos e turmas
        String sql = "SELECT n.valor, a.matricula, a.nome, a.endereco, a.telefone, a.email, " +
                    "t.id, t.dataInicio, t.dataFim, t.lingua, t.nivel, t.preco " +
                    "FROM notas n " +
                    "JOIN alunos a ON n.aluno_matricula = a.matricula " +
                    "JOIN turmas t ON n.turma_id = t.id";

        PreparedStatement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            // Monta objeto aluno
            Aluno aluno = new Aluno(
                rs.getString("matricula"),
                rs.getString("nome"),
                rs.getString("endereco"),
                rs.getString("telefone"),
                rs.getString("email")
            );

            // Monta objeto turma
            Turma turma = new Turma(
                rs.getInt("id"),
                java.time.LocalDate.parse(rs.getString("dataInicio")),
                java.time.LocalDate.parse(rs.getString("dataFim")),
                rs.getString("lingua"),
                rs.getString("nivel"),
                rs.getDouble("preco"),
                new ArrayList<>() // lista de alunos omitida aqui
            );

            // Cria a nota e adiciona à lista
            Nota nota = new Nota(aluno, turma, rs.getDouble("valor"));
            lista.add(nota);
        }

        conn.close();
        return lista;
    }
}