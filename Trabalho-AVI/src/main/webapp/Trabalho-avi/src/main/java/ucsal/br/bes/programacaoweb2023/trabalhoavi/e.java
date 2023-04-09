package ucsal.br.bes.programacaoweb2023.trabalhoavi;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class e {

	public static void main(String[] args) {
	System.out.println("oi");	
	
	Scanner scan = new Scanner(System.in);
	

	System.out.println("Informe a a hora");
	String hour =  scan.next();
	DateTimeFormatter parserHora= DateTimeFormatter.ofPattern("HH mm");
	LocalTime hora = LocalTime.parse(hour, parserHora);
//	DateTimeFormatter formatterHora = DateTimeFormatter.ofPattern("HH:mm");
//	String horaFormatada = formatterHora.format(hora); // 21:20:10
	System.out.println(hora);

	}

}
