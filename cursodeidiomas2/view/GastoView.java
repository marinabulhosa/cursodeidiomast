package view;

import controller.GastoController;
import model.Gasto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.List;

/**Interface gráfica para cadastrar e listar gastos*/
public class GastoView extends JFrame {
    private JTextField txtDescricao, txtValor, txtData;
    private JTextArea txtLista;
    private GastoController controller = new GastoController();

    public GastoView() {
        setTitle("Cadastro de Gasto");
        setSize(500, 350);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel form = new JPanel(new GridLayout(4, 2));
        form.add(new JLabel("Descrição:"));
        txtDescricao = new JTextField();
        form.add(txtDescricao);

        form.add(new JLabel("Valor:"));
        txtValor = new JTextField();
        form.add(txtValor);

        form.add(new JLabel("Data (dd/MM/yyyy):"));
        txtData = new JTextField();
        form.add(txtData);

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
            Gasto g = new Gasto(txtDescricao.getText(),Double.parseDouble(txtValor.getText()),txtData.getText());
            controller.salvar(g);
            JOptionPane.showMessageDialog(this, "Gasto salvo com sucesso!");
        } catch (Exception ex) {
        JOptionPane.showMessageDialog(this, "Erro ao salvar: " + ex.getMessage());
        }
    }

    private void listar() {
        try {
            List<Gasto> gastos = controller.listar();
            txtLista.setText("");
            for (Gasto g : gastos) {
                txtLista.append(g.toString() + "\n");
        }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro ao listar: " + ex.getMessage());
        }
    }
}