package dao;

import model.Gasto;
import java.sql.;
import java.time.LocalDate;
import java.util.;

/*** DAO para gerenciar os gastos do sistema.*/
public class GastoDAO {

    public void salvar(Gasto g) throws Exception {
        Connection conn = Conexao.getConnection();
        PreparedStatement stmt = conn.prepareStatement(
            "INSERT INTO gastos (id, descricao, valor, data) VALUES (?, ?, ?, ?)");
        stmt.setInt(1, g.getId());
        stmt.setString(2, g.getDescricao());
        stmt.setDouble(3, g.getValor());
        stmt.setString(4, g.getData().toString());
        stmt.executeUpdate();
        conn.close();
    }

    public List<Gasto> listar() throws Exception {
        List<Gasto> lista = new ArrayList<>();
        Connection conn = Conexao.getConnection();
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM gastos");
        while (rs.next()) {
            Gasto g = new Gasto(
                rs.getInt("id"),
                rs.getString("descricao"),
                rs.getDouble("valor"),
                LocalDate.parse(rs.getString("data"))
            );
            lista.add(g);
        }
        conn.close();
        return lista;
    }
}