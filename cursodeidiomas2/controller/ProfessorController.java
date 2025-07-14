package controller;

import dao.ProfessorDAO;
import model.Professor;
import java.util.List;

/*** Controlador para manipulação de professores.*/
public class ProfessorController {

    private ProfessorDAO dao = new ProfessorDAO();

    public void salvar(Professor p) throws Exception {
        dao.salvar(p);
    }

    public List<Professor> listar() throws Exception {
        return dao.listar();
    }
}