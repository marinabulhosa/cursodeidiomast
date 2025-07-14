package controller;

import dao.AulaDAO;
import model.Aula;
import java.time.LocalDate;
import java.util.List;

/*** Controlador para gerenciamento de aulas.*/
public class AulaController {

    private AulaDAO dao = new AulaDAO();

    public void salvar(Aula aula) throws Exception {
        dao.salvar(aula);
    }

    public List<Aula> listar() throws Exception {
        return dao.listar();
    }

    /*** Permite reagendar uma aula.*/
    public void reagendar(int id, LocalDate novaData) throws Exception {
        dao.reagendar(id, novaData);
    }

    /*** Registra o professor no momento do início da aula.*/
    public void iniciarAula(int idAula, String matriculaProfessor) throws Exception {
        dao.iniciarAula(idAula, matriculaProfessor);
    }
}