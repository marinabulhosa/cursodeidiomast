package util;

import javax.swing.JOptionPane;

/*** Classe utilitária para exibir mensagens de alerta e erro com JOptionPane.*/
public class AlertUtil {

    /*** Exibe uma mensagem de informação. * @param mensagem Texto da mensagem a ser exibida.*/
    public static void exibirMensagem(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Informação", JOptionPane.INFORMATION_MESSAGE);
    }

    /*** Exibe uma mensagem de erro.* @param mensagem Texto da mensagem de erro.*/
    public static void exibirErro(String mensagem) {
        JOptionPane.showMessageDialog(null, mensagem, "Erro", JOptionPane.ERROR_MESSAGE);
    }
}