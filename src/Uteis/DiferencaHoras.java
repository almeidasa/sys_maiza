package Uteis;

/**
 * @Autor Alexandre
 * @Data 08/08/2018
 */
public class DiferencaHoras {

    public static String Calcular(String horaUm, String horaDois) {
        float horaInicio = Float.parseFloat(HoraParaDecimal.Converter(horaUm));
        float horaFim = Float.parseFloat(HoraParaDecimal.Converter(horaDois));
        float res = Math.abs(horaFim - horaInicio);

        String diferenca = DecimalParaHora.Converter(Float.toString(res));
        return diferenca;
    }
}
