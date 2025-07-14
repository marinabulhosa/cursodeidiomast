package view;

import controller.TurmaController;
import model.Turma;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**

Interface gráfica para cadastro de turmas.
*/
public class TurmaView extends JFrame {
    private JTextField txtId, txtInicio, txtFim, txtLingua, txtNivel, txtPreco;
    private JTextArea txtLista;
    private TurmaController controller = new TurmaController();

    public TurmaView() {
        setTitle("Cadastro de Turmas");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(7, 2));
        form.add(new JLabel("ID:"));
        txtId = new JTextField();
        form.add(txtId);

        form.add(new JLabel("Data Início (dd/MM/yyyy):"));
        txtInicio = new JTextField();
        form.add(txtInicio);

        form.add(new JLabel("Data Fim (dd/MM/yyyy):"));
        txtFim = new JTextField();
        form.add(txtFim);

        form.add(new JLabel("Língua:"));
        txtLingua = new JTextField();
        form.add(txtLingua);

        form.add(new JLabel("Nível:"));
        txtNivel = new JTextField();
        form.add(txtNivel);

        form.add(new JLabel("Preço:"));
        txtPreco = new JTextField();
        form.add(txtPreco);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(this::salvar);
        form.add(btnSalvar);

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(e -> listar());
        form.add(btnListar);

        add(form, BorderLayout.NORTH);

        txtLista = new JTextArea();
        add(new JScrollPane(txtLista), BorderLayout.CENTER);

        setVisible(true);
    }

    private void salvar(ActionEvent e) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
            Turma t = new Turma(txtId.getText(), sdf.parse(txtInicio.getText()), sdf.parse(txtFim.getText()), txtLingua.getText(),txtNivel.getText(),Double.parseDouble(txtPreco.getText()));
            controller.salvar(t);
            JOptionPane.showMessageDialog(this, "Turma salva!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void listar() {
        try {
            List<Turma> turmas = controller.listar();
            txtLista.setText("");
            for (Turma t : turmas) {
                txtLista.append(t.toString() + "\n");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }
}