package controller;

import dao.FuncionarioDAO;
import model.Funcionario;
import java.util.List;

/*** Controlador para gerenciamento de funcionários.*/
public class FuncionarioController {

    private FuncionarioDAO dao = new FuncionarioDAO();

    public void salvar(Funcionario f) throws Exception {
        dao.salvar(f);
    }

    public List<Funcionario> listar() throws Exception {
        return dao.listar();
    }
}