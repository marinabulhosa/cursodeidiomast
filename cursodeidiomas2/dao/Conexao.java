package dao;

import java.sql.Connection;
import java.sql.DriverManager;

/*** Responsável por fornecer a conexão com o banco de dados SQLite.*/
public class Conexao {
    private static final String URL = "jdbc:sqlite:banco.db";

    
    /*** Retorna uma conexão ativa com o banco de dados.*/
    public static Connection getConnection() throws Exception {
        return DriverManager.getConnection(URL);
    }
}