package br.com.fiap.revisao.view;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DataTeste {
    public static void main(String[] args) {
        Calendar data = Calendar.getInstance();
        Calendar data2 = new GregorianCalendar(2024, Calendar.FEBRUARY, 29);

        // Formatador de datas
        SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

        // Exibindo a data atual
        System.out.println(formatador.format(data.getTime()));

        // Exibindo a data 10/10/2020
        System.out.println(formatador.format(data2.getTime()));

        // TODO: Criar um objeto com a data de nascimento 16/02/1997
        LocalDate nascimento = LocalDate.of(1997, 2, 16);
        // TODO: Outro com o horário de início da aula 19:00
        LocalTime inicio = LocalTime.of(19, 0);
        // TODO: Outro objeto com a data e hora da reunião de abertura do challenge (fictícia no ano de 2024)
        LocalDateTime abertura = LocalDateTime.of(2024, 3, 10, 19, 0);
        // TODO: Exibir os dados formatados
        DateTimeFormatter formatadorData = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        DateTimeFormatter formatadorHora = DateTimeFormatter.ofPattern("HH:mm");
        DateTimeFormatter formatadorDataHora = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        System.out.println(nascimento.format(formatadorData));
        System.out.println(inicio.format(formatadorHora));
        System.out.println(abertura.format(formatadorDataHora));


    }// fim do método main
}// fim da classe DataTeste