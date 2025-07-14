package view;

import controller.ProfessorController;
import model.Professor;

import javax.swing.;
import java.awt.;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.util.List;

public class ProfessorView extends JFrame {
    private JTextField txtMatricula, txtNome, txtEndereco, txtTelefone, txtValorHora;
    private JTextArea txtLista;
    private ProfessorController controller = new ProfessorController();

    public ProfessorView() {
        setTitle("Cadastro de Professor");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel painelForm = new JPanel(new GridLayout(6, 2));
        painelForm.add(new JLabel("Matrícula:"));
        txtMatricula = new JTextField();
        painelForm.add(txtMatricula);

        painelForm.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        painelForm.add(txtNome);

        painelForm.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField();
        painelForm.add(txtEndereco);

        painelForm.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        painelForm.add(txtTelefone);

        painelForm.add(new JLabel("Valor Hora:"));
        txtValorHora = new JTextField();
        painelForm.add(txtValorHora);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(this::salvar);
        painelForm.add(btnSalvar);

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(e -> listar());
        painelForm.add(btnListar);

        add(painelForm, BorderLayout.NORTH);

        txtLista = new JTextArea();
        add(new JScrollPane(txtLista), BorderLayout.CENTER);

        setVisible(true);
    }

    private void salvar(ActionEvent e) {
        try {
            Professor p = new Professor(
                txtMatricula.getText(),
                txtNome.getText(),
                txtEndereco.getText(),
                txtTelefone.getText(),
                Double.parseDouble(txtValorHora.getText()),
                new ArrayList<>()
            );
            controller.salvar(p);
            JOptionPane.showMessageDialog(this, "Professor salvo com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void listar() {
        try {
            List<Professor> lista = controller.listar();
            txtLista.setText("");
            for (Professor p : lista) {
                txtLista.append(p.toString() + "\n");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar: " + ex.getMessage());
        }
    }
}