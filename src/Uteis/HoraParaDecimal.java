package Uteis;

/**
 * @Autor Alexandre
 * @Data 08/08/2018
 */
public class HoraParaDecimal {

    //formato de entrada deve ser 00:00
    public static String Converter(String hora) {
        try {
            String horaDecimal;
            String minFinal;
            String horaFinal;

            horaFinal = "" + hora.charAt(0) + hora.charAt(1);

            String minutos = "" + hora.charAt(3) + hora.charAt(4);

            if (minutos.equals("00")) {
                minFinal = minutos;
            } else {
                int minInt = Integer.parseInt(minutos);

                double minCompleto = (double) minInt / 60;

                minFinal = Double.toString(minCompleto).substring(2);
            }

            horaDecimal = horaFinal + "." + minFinal;

            return horaDecimal;
        } catch (Exception e) {
            return "0.00";
        }
    }
}
