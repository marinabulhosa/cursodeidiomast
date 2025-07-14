package dao;

import model.Funcionario;
import java.sql.;
import java.util.;

/*** DAO para manipulação da tabela de funcionários.*/
public class FuncionarioDAO {

    public void salvar(Funcionario f) throws Exception {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO funcionarios (nome, endereco, telefone, salario, cargo) VALUES (?, ?, ?, ?, ?)");
        stmt.setString(1, f.getNome());
        stmt.setString(2, f.getEndereco());
        stmt.setString(3, f.getTelefone());
        stmt.setDouble(4, f.getSalario());
        stmt.setString(5, f.getCargo());
        stmt.executeUpdate();
        conn.close();
    }

    public List<Funcionario> listar() throws Exception {
        List<Funcionario> lista = new ArrayList<>();
        Connection conn = Conexao.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM funcionarios");
        while (rs.next()) {
            Funcionario f = new Funcionario(
                rs.getString("nome"),
                rs.getString("endereco"),
                rs.getString("telefone"),
                rs.getDouble("salario"),
                rs.getString("cargo")
            );
            lista.add(f);
        }
        conn.close();
        return lista;
    }
}