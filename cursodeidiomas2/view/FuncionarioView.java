package view;

import controller.FuncionarioController;
import model.Funcionario;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**

Interface gráfica para cadastro e listagem de funcionários.
*/
public class FuncionarioView extends JFrame {
    private JTextField txtNome, txtEndereco, txtTelefone, txtSalario;
    private JComboBox<String> cbCargo;
    private JTextArea txtLista;
    private FuncionarioController controller = new FuncionarioController();

    public FuncionarioView() {
        setTitle("Cadastro de Funcionário");
        setSize(500, 400);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(6, 2));
        form.add(new JLabel("Nome:"));
        txtNome = new JTextField();
        form.add(txtNome);

        form.add(new JLabel("Endereço:"));
        txtEndereco = new JTextField();
        form.add(txtEndereco);

        form.add(new JLabel("Telefone:"));
        txtTelefone = new JTextField();
        form.add(txtTelefone);

        form.add(new JLabel("Salário:"));
        txtSalario = new JTextField();
        form.add(txtSalario);

        form.add(new JLabel("Cargo:"));
        cbCargo = new JComboBox<>(new String[]{"Secretário", "Gerente"});
        form.add(cbCargo);

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
        Funcionario f = new Funcionario(cbCargo.getSelectedItem().toString(),txtNome.getText(),txtEndereco.getText(),txtTelefone.getText(), Double.parseDouble(txtSalario.getText()));
        controller.salvar(f);
        JOptionPane.showMessageDialog(this, "Funcionário salvo com sucesso!");
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage());
        }
    }

    private void listar() {
        try {
        List<Funcionario> lista = controller.listar();
        txtLista.setText("");
        for (Funcionario f : lista) {
            txtLista.append(f.toString() + "\n");
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar: " + ex.getMessage());
        }
    }
}