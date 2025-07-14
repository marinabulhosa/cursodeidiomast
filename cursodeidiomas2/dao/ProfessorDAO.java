package dao;

import model.Professor;
import java.sql.;
import java.util.;

/*** Classe de acesso ao banco para a entidade Professor.*/
public class ProfessorDAO {

    public void salvar(Professor p) throws Exception {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO professores (matricula, nome, endereco, telefone, valorHora) VALUES (?, ?, ?, ?, ?)");
        stmt.setString(1, p.getMatricula());
        stmt.setString(2, p.getNome());
        stmt.setString(3, p.getEndereco());
        stmt.setString(4, p.getTelefone());
        stmt.setDouble(5, p.getValorHora());
        stmt.executeUpdate();
        conn.close();

        // Linguas (salvar em tabela separada: professor_linguas)
        for (String lingua : p.getLinguas()) {
            PreparedStatement ling = conn.prepareStatement(
                "INSERT INTO professor_linguas (matricula, lingua) VALUES (?, ?)");
            ling.setString(1, p.getMatricula());
            ling.setString(2, lingua);
            ling.executeUpdate();
        }
    }

    public List<Professor> listar() throws Exception {
        List<Professor> lista = new ArrayList<>();
        Connection conn = Conexao.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM professores");
        while (rs.next()) {
            String matricula = rs.getString("matricula");

            // Buscar línguas separadamente
            List<String> linguas = new ArrayList<>();
            PreparedStatement lingStmt = conn.prepareStatement(
                "SELECT lingua FROM professor_linguas WHERE matricula = ?");
            lingStmt.setString(1, matricula);
            ResultSet lingRS = lingStmt.executeQuery();
            while (lingRS.next()) {
                linguas.add(lingRS.getString("lingua"));
            }

            Professor p = new Professor(
                matricula,
                rs.getString("nome"),
                rs.getString("endereco"),
                rs.getString("telefone"),
                rs.getDouble("valorHora"),
                linguas
            );
            lista.add(p);
        }
        conn.close();
        return lista;
    }
}