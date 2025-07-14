import javax.swing.SwingUtilities;
import view.MenuPrincipalView;

/*** Classe principal da aplicação. * Inicia o sistema carregando a interface do menu principal.*/
public class Main {
    public static void main(String[] args) {
        // Executa a interface gráfica na thread de eventos do Swing
        SwingUtilities.invokeLater(() -> {
            new MenuPrincipalView(); // Exibe o menu principal com os botões de acesso aos módulos
        });
    }
}







//SwingUtilities.invokeLater(): garante que a GUI seja executada na Event Dispatch Thread, como recomendado pela arquitetura do Swing.//
//new MenuPrincipalView(): instancia a interface principal do sistema, onde o usuário acessa os módulos como aluno, professor, turma, relatórios etc.//