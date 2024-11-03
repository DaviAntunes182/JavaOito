import java.time.*;
import java.time.format.DateTimeFormatter;

public class AgoraDatas {
    public static void main(String[] args) {
        LocalDate hoje = LocalDate.now();
        // YYYY-mm-DD
        System.out.println(hoje);

        LocalDate olimpiadasRio = LocalDate.of(2016, Month.JUNE, 5);
        int anos = olimpiadasRio.getYear() - hoje.getYear();

        System.out.println(anos);

        Period periodo = Period.between(olimpiadasRio, hoje);
        System.out.println(periodo);
        System.out.println(periodo.getYears() + " anos " + periodo.getMonths() + " meses " + periodo.getDays() + " dias " );

        LocalDate DaquiQuatro = hoje.plusYears(4);
        System.out.println(DaquiQuatro);

        DateTimeFormatter formatador = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate amanha = hoje.plusDays(1);
        String dataFormatada = amanha.format(formatador);

        System.out.println(dataFormatada);

        LocalDateTime agora = LocalDateTime.now();
        System.out.println(agora);

        DateTimeFormatter formatadorHMS = DateTimeFormatter.ofPattern("dd/MM/yyyy hh:mm:ss");

        String agoraFormatado = agora.format(formatadorHMS);
        System.out.println(agoraFormatado);

        YearMonth mesAno = YearMonth.now();
        System.out.println(mesAno);
    }
}
