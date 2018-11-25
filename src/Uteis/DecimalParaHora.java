package Uteis;

/**
 * @Autor Alexandre
 * @Data 08/08/2018
 */
public class DecimalParaHora {

    //formato de entrada deve ser 00.00 ou 0.00
    public static String Converter(String decimal) {
        String horaFormatada = "";

        long ss = Math.round(Double.parseDouble(decimal.replace(",", ".")) * 3600);
        long hh = ss / 3600;
        long mm = (ss - 3600 * hh) / 60;
        horaFormatada = (hh <= 9 ? "0" : "") + hh + ":" + (mm <= 9 ? "0" : "") + mm;

        return horaFormatada;
    }
}
