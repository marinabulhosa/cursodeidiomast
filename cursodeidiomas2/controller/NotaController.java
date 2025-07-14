package controller;

import dao.NotaDAO;
import model.Nota;
import java.util.List;

/*** Controlador das notas dos alunos.*/
public class NotaController {

    private NotaDAO dao = new NotaDAO();

    public void salvar(Nota nota) throws Exception {
        dao.salvar(nota);
    }

    public List<Nota> listar() throws Exception {
        return dao.listar();
    }

}