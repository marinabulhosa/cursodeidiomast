package controller;

import dao.TurmaDAO;
import model.Turma;
import java.util.List;

/*** Controlador para turmas.*/
public class TurmaController {

    private TurmaDAO dao = new TurmaDAO();

    public void salvar(Turma turma) throws Exception {
        dao.salvar(turma);
    }

    public List<Turma> listar() throws Exception {
        return dao.listar();
    }
}