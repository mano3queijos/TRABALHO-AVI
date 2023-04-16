package ucsal.br.bes.programacaoweb2023.trabalhoavi.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class PeriodoDisponibilidade {

	private String diaDisponibilidade;
	private String horaInicialAtendimento;
	private String horaFinalAtendimento;

	public PeriodoDisponibilidade(String diaDisponibilidade, String horaInicialAtendimento,
			String horaFinalAtendimento) {
		this.diaDisponibilidade = diaDisponibilidade;
		this.horaInicialAtendimento = horaInicialAtendimento;
		this.horaFinalAtendimento = horaFinalAtendimento;
	}

	public String getDiaDisponibilidade() {
		return diaDisponibilidade;
	}

	public void setDiaDisponibilidade(String diaDisponibilidade) {
		this.diaDisponibilidade = diaDisponibilidade;
	}

	public String getHoraInicialAtendimento() {
		return horaInicialAtendimento;
	}

	public void setHoraInicialAtendimento(String horaInicialAtendimento) {
		this.horaInicialAtendimento = horaInicialAtendimento;
	}

	public String getHoraFinalAtendimento() {
		return horaFinalAtendimento;
	}

	public void setHoraFinalAtendimento(String horaFinalAtendimento) {
		this.horaFinalAtendimento = horaFinalAtendimento;
	}

	@Override
	public String toString() {
		return "Dia: " + diaDisponibilidade + "]" + "[Hora Inicial Atendimento:" + horaInicialAtendimento + "]"
				+ "[Hora Final Atendimento:" + horaFinalAtendimento;
	}

}