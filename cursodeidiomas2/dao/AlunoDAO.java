package dao;

import model.Aluno;
import java.sql.;
import java.util.;

/*** Classe de acesso ao banco para a entidade Aluno.*/
public class AlunoDAO {

    public void salvar(Aluno a) throws Exception {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO alunos (matricula, nome, endereco, telefone, email) VALUES (?, ?, ?, ?, ?)");
        stmt.setString(1, a.getMatricula());
        stmt.setString(2, a.getNome());
        stmt.setString(3, a.getEndereco());
        stmt.setString(4, a.getTelefone());
        stmt.setString(5, a.getEmail());
        stmt.executeUpdate();
        conn.close();
    }

    public List<Aluno> listar() throws Exception {
        List<Aluno> lista = new ArrayList<>();
        Connection conn = Conexao.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM alunos");
        while (rs.next()) {
            Aluno a = new Aluno(
                rs.getString("matricula"),
                rs.getString("nome"),
                rs.getString("endereco"),
                rs.getString("telefone"),
                rs.getString("email")
            );
            lista.add(a);
        }
        conn.close();
        return lista;
    }

    public void excluir(String matricula) throws Exception {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement("DELETE FROM alunos WHERE matricula = ?");
        stmt.setString(1, matricula);
        stmt.executeUpdate();
        conn.close();
    }
}