package view;

import controller.NotaController;
import model.Nota;

import javax.swing;
import java.awt;
import java.awt.event.ActionEvent;
import java.util.List;

/**Interface gráfica para atribuição de notas aos alunos nas turmas.*/
public class NotaView extends JFrame {
    private JTextField txtTurma, txtAluno, txtNota;
    private JTextArea txtLista;
    private NotaController controller = new NotaController();

    public NotaView() {
        setTitle("Registro de Notas");
        setSize(450, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(4, 2));
        form.add(new JLabel("Turma:"));
        txtTurma = new JTextField();
        form.add(txtTurma);

        form.add(new JLabel("Aluno:"));
        txtAluno = new JTextField();
        form.add(txtAluno);

        form.add(new JLabel("Nota:"));
        txtNota = new JTextField();
        form.add(txtNota);

        JButton btnSalvar = new JButton("Registrar Nota");
        btnSalvar.addActionListener(this::salvar);
        form.add(btnSalvar);

        JButton btnListar = new JButton("Listar Notas");
        btnListar.addActionListener(e -> listar());
        form.add(btnListar);

        add(form, BorderLayout.NORTH);

        txtLista = new JTextArea();
        add(new JScrollPane(txtLista), BorderLayout.CENTER);

        setVisible(true);
    }

    private void salvar(ActionEvent e) {
        try {
        Nota n = new Nota( txtTurma.getText(),txtAluno.getText(),Double.parseDouble(txtNota.getText()));
        controller.salvar(n);
        JOptionPane.showMessageDialog(this, "Nota registrada!");
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void listar() {
        try {
            List<Nota> notas = controller.listar();
            txtLista.setText("");
            for (Nota n : notas) {
            txtLista.append(n.toString() + "\n");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar notas: " + ex.getMessage());
        }
    }
}

