package util;

/**Classe utilitária para operações com Strings.*/
public class StringUtil {

    /**Verifica se a string está vazia ou nula. @param valor string a ser verificada  @return true se for nula ou vazia, false caso contrário*/
    public static boolean isNullOrEmpty(String valor) {
        return valor == null || valor.trim().isEmpty();
    }

    /** Retorna uma string padronizada (com primeira letra maiúscula). @param valor string original  @return string com capitalização*/
    public static String capitalize(String valor) {
    if (isNullOrEmpty(valor)) return valor;
    return valor.substring(0, 1).toUpperCase() + valor.substring(1).toLowerCase();
    }
}