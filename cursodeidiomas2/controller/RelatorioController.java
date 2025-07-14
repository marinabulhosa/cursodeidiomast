package controller;

import dao.AulaDAO;
import dao.GastoDAO;
import dao.TurmaDAO;
import dao.ProfessorDAO;
import model.Gasto;
import model.Turma;
import model.Aula;
import model.Professor;
import java.time.LocalDate;
import java.util.List;

/*** Controlador para geração de relatórios financeiros.*/
public class RelatorioController {

    private GastoDAO gastoDAO = new GastoDAO();
    private TurmaDAO turmaDAO = new TurmaDAO();
    private AulaDAO aulaDAO = new AulaDAO();
    private ProfessorDAO professorDAO = new ProfessorDAO();

    /*** Calcula total arrecadado de turmas já iniciadas até hoje.*/
    public double calcularTotalArrecadado() throws Exception {
        double total = 0;
        for (Turma t : turmaDAO.listar()) {
            if (t.getDataInicio().isBefore(LocalDate.now())) {
                total += t.getPreco() * t.getAlunos().size();
            }
        }
        return total;
    }

    /*** Soma os gastos já ocorridos (gastos fixos e professores).*/
    public double calcularGastoRealizado() throws Exception {
        double total = 0;
        for (Gasto g : gastoDAO.listar()) {
            if (g.getData().isBefore(LocalDate.now())) {
                total += g.getValor();
            }
        }
        return total;
    }

    /*** Soma os gastos futuros com aulas agendadas.*/
    public double calcularGastoPrevisto(double valorHoraAula) throws Exception {
        double total = 0;
        for (Aula a : aulaDAO.listar()) {
            if (a.getData().isAfter(LocalDate.now())) {
                long horas = java.time.Duration.between(a.getHoraInicio(), a.getHoraFim()).toHours();
                total += horas * valorHoraAula;
            }
        }
        return total;
    }
}