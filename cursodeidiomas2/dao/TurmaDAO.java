package dao;

import model.Turma;
import java.sql.;
import java.util.;

/*** DAO para manipular as turmas.*/
public class TurmaDAO {

    public void salvar(Turma t) throws Exception {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO turmas (id, dataInicio, dataFim, lingua, nivel, preco) VALUES (?, ?, ?, ?, ?, ?)");
        stmt.setInt(1, t.getId());
        stmt.setString(2, t.getDataInicio().toString());
        stmt.setString(3, t.getDataFim().toString());
        stmt.setString(4, t.getLingua());
        stmt.setString(5, t.getNivel());
        stmt.setDouble(6, t.getPreco());
        stmt.executeUpdate();
        conn.close();
    }

    public List<Turma> listar() throws Exception {
        // Por simplicidade, retorna turmas sem carregar alunos ainda
        List<Turma> lista = new ArrayList<>();
        Connection conn = Conexao.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM turmas");
        while (rs.next()) {
            Turma t = new Turma(
                rs.getInt("id"),
                java.time.LocalDate.parse(rs.getString("dataInicio")),
                java.time.LocalDate.parse(rs.getString("dataFim")),
                rs.getString("lingua"),
                rs.getString("nivel"),
                rs.getDouble("preco"),
                new ArrayList<>() // Lista de alunos pode ser carregada separadamente
            );
            lista.add(t);
        }
        conn.close();
        return lista;
    }
}