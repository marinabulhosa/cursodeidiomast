package service;

import dao.AulaDAO;
import dao.GastoDAO;
import dao.TurmaDAO;
import model.Aula;
import model.Gasto;
import model.Turma;

import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;

/* Classe de serviço que implementa a lógica de geração de relatórios financeiros.*/
public class RelatorioService {

    private final TurmaDAO turmaDAO = new TurmaDAO();
    private final AulaDAO aulaDAO = new AulaDAO();
    private final GastoDAO gastoDAO = new GastoDAO();

    /* Calcula o valor total arrecadado pelas turmas já iniciadas.*/
    public double calcularTotalArrecadado() {
        List<Turma> turmas = turmaDAO.listar();
        double total = 0.0;
        for (Turma t : turmas) {
            if (t.getDataInicio().before(new Date())) {
                total += t.getPreco() * t.getAlunos().size();
            }
        }
        return total;
    }

    /* Calcula o gasto já ocorrido com aulas realizadas. @param valorHoraGasto valor fixo por hora de aula*/
    public double calcularGastoAulasRealizadas(double valorHoraGasto) {
        List<Aula> aulas = aulaDAO.listar();
        double total = 0.0;
        Date hoje = new Date();

        for (Aula aula : aulas) {
            if (aula.getData().before(hoje)) {
                total += valorHoraGasto;
            }
        }
        return total;
    }

    /* Calcula os gastos ainda a acontecer com aulas agendadas. @param valorHoraGasto valor fixo por hora de aula*/
    public double calcularGastoPrevisto(double valorHoraGasto) {
        List<Aula> aulas = aulaDAO.listar();
        double total = 0.0;
        Date hoje = new Date();

        for (Aula aula : aulas) {
            if (!aula.getData().before(hoje)) {
                total += valorHoraGasto;
            }
        }
        return total;
    }

    /* Soma os gastos registrados manualmente.*/
    public double calcularGastosGerais() {
        List<Gasto> gastos = gastoDAO.listar();
        return gastos.stream().mapToDouble(Gasto::getValor).sum();
    }
}
