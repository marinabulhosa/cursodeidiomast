package view;

import controller.AulaController;
import model.Aula;

import javax.swing.;
import java.awt.;
import java.awt.event.ActionEvent;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**

Interface gráfica para cadastrar e listar aulas.
*/
public class AulaView extends JFrame {
    private JTextField txtTurma, txtData, txtHoraInicio, txtHoraFim, txtProfessor;
    private JTextArea txtLista;
    private AulaController controller = new AulaController();

    public AulaView() {
        setTitle("Cadastro de Aula");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(6, 2));
        form.add(new JLabel("Turma:"));
        txtTurma = new JTextField();
        form.add(txtTurma);

        form.add(new JLabel("Data (dd/MM/yyyy):"));
        txtData = new JTextField();
        form.add(txtData);

        form.add(new JLabel("Hora Início (HH:mm):"));
        txtHoraInicio = new JTextField();
        form.add(txtHoraInicio);

        form.add(new JLabel("Hora Fim (HH:mm):"));
        txtHoraFim = new JTextField();
        form.add(txtHoraFim);

        form.add(new JLabel("Professor (opcional):"));
        txtProfessor = new JTextField();
        form.add(txtProfessor);

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
            Aula a = new Aula(txtTurma.getText(),txtData.getText(),txtHoraInicio.getText(),txtHoraFim.getText(),txtProfessor.getText().isEmpty() ? null : txtProfessor.getText());
            controller.salvar(a);
            JOptionPane.showMessageDialog(this, "Aula salva com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar aula: " + ex.getMessage());
        }
    }

    private void listar() {
        try {
            List<Aula> aulas = controller.listar();
            txtLista.setText("");
            for (Aula a : aulas) {
                txtLista.append(a.toString() + "\n");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar: " + ex.getMessage());
        }
    }
}