package util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**Classe utilitária para conversão de datas entre String e Date.*/
public class DateUtil {

private static final SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

/**

Converte uma string no formato dd/MM/yyyy para um objeto Date.

@param dataStr a data como string

@return o objeto Date correspondente

@throws ParseException se a data estiver mal formatada
*/
public static Date stringToDate(String dataStr) throws ParseException {
return sdf.parse(dataStr);
}

/**

Converte um objeto Date para uma string no formato dd/MM/yyyy.

@param date o objeto Date

@return a string representando a data
*/
public static String dateToString(Date date) {
return sdf.format(date);
}
}