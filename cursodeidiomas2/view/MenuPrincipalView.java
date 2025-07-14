package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

/*** Tela principal do sistema com acesso aos módulos.*/
public class MenuPrincipalView extends JFrame {
    public MenuPrincipalView() {
        setTitle("Sistema de Curso de Idiomas");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2));

        addButton("Alunos", e -> new AlunoView());
        addButton("Professores", e -> new ProfessorView());
        addButton("Funcionários", e -> new FuncionarioView());
        addButton("Turmas", e -> new TurmaView());
        addButton("Aulas", e -> new AulaView());
        addButton("Notas", e -> new NotaView());
        addButton("Gastos", e -> new GastoView());
        addButton("Relatórios", e -> new RelatorioView());

        setVisible(true);
    }

    private void addButton(String label, AbstractAction action) {
        JButton btn = new JButton(label);
        btn.addActionListener(action);
        add(btn);
    }
}