package ucsal.br.bes.programacaoweb2023.trabalhoavi.domain;

import java.time.LocalDate;
import java.time.LocalTime;

public class PeriodoDisponibilidade {

	private LocalDate diaDisponibilidade;
	private LocalTime horaInicialAtendimento;
	private LocalTime horaFinalAtendimento;

	public PeriodoDisponibilidade(LocalDate diaDisponibilidade, LocalTime horaInicialAtendimento,
			LocalTime horaFinalAtendimento) {
		super();
		this.diaDisponibilidade = diaDisponibilidade;
		this.horaInicialAtendimento = horaInicialAtendimento;
		this.horaFinalAtendimento = horaFinalAtendimento;
	}

	public LocalDate getDiaDisponibilidade() {
		return diaDisponibilidade;
	}

	public void setDiaDisponibilidade(LocalDate diaDisponibilidade) {
		this.diaDisponibilidade = diaDisponibilidade;
	}

	public LocalTime getHoraInicialAtendimento() {
		return horaInicialAtendimento;
	}

	public void setHoraInicialAtendimento(LocalTime horaInicialAtendimento) {
		this.horaInicialAtendimento = horaInicialAtendimento;
	}

	public LocalTime getHoraFinalAtendimento() {
		return horaFinalAtendimento;
	}

	public void setHoraFinalAtendimento(LocalTime horaFinalAtendimento) {
		this.horaFinalAtendimento = horaFinalAtendimento;
	}

}