package view;

import controller.AlunoController;
import model.Aluno;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/*** Interface gráfica para cadastro e listagem de alunos.*/
public class AlunoView extends JFrame {
    private JTextField txtMatricula, txtNome, txtEndereco, txtTelefone, txtEmail;
    private JTextArea txtLista;
    private AlunoController controller = new AlunoController();

    public AlunoView() {
        setTitle("Cadastro de Aluno");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        // Painel de entrada
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

        painelForm.add(new JLabel("Email:"));
        txtEmail = new JTextField();
        painelForm.add(txtEmail);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.addActionListener(this::salvarAluno);
        painelForm.add(btnSalvar);

        JButton btnListar = new JButton("Listar");
        btnListar.addActionListener(e -> listarAlunos());
        painelForm.add(btnListar);

        add(painelForm, BorderLayout.NORTH);

        txtLista = new JTextArea();
        txtLista.setEditable(false);
        add(new JScrollPane(txtLista), BorderLayout.CENTER);

        setVisible(true);
    }

    private void salvarAluno(ActionEvent e) {
        try {
            Aluno a = new Aluno(
                txtMatricula.getText(),
                txtNome.getText(),
                txtEndereco.getText(),
                txtTelefone.getText(),
                txtEmail.getText()
            );
            controller.salvar(a);
            JOptionPane.showMessageDialog(this, "Aluno salvo com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
        }
    }

    private void listarAlunos() {
        try {
            List<Aluno> alunos = controller.listar();
            txtLista.setText("");
            for (Aluno a : alunos) {
                txtLista.append(a.toString() + "\n");
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar: " + ex.getMessage());
        }
    }
}