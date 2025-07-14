package view;

import controller.RelatorioController;

import javax.swing.*;
import java.awt.*;

/**Interface gráfica para exibição dos relatórios financeiros.*/
public class RelatorioView extends JFrame {
    private JTextArea txtRelatorio;
    private RelatorioController controller = new RelatorioController();

    public RelatorioView() {
        setTitle("Relatórios Financeiros");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());
        txtRelatorio = new JTextArea();
        txtRelatorio.setEditable(false);
        add(new JScrollPane(txtRelatorio), BorderLayout.CENTER);

        JButton btnGerar = new JButton("Gerar Relatório");
        btnGerar.addActionListener(e -> gerarRelatorio());
        add(btnGerar, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void gerarRelatorio() {
        try {
            String relatorio = controller.gerarRelatorio();
            txtRelatorio.setText(relatorio);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao gerar relatório: " + ex.getMessage());
        }
    }
}