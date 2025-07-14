package controller;

import dao.GastoDAO;
import model.Gasto;
import java.util.List;

/*** Controlador para os gastos do sistema.*/
public class GastoController {
    private GastoDAO dao = new GastoDAO();

    public void salvar(Gasto gasto) throws Exception {
        dao.salvar(gasto);
    }

    public List<Gasto> listar() throws Exception {
        return dao.listar();
    }
}