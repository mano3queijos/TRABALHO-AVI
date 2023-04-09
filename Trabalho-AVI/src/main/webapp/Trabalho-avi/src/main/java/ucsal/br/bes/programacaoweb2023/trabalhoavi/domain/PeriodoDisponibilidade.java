package ucsal.br.bes.programacaoweb2023.trabalhoavi.domain;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class PeriodoDisponibilidade {

	private LocalDate dataDisponibilidade;
	private LocalTime horaInicialDisponibilidade;
	private LocalTime horaFinalDisponibilidade;

	public PeriodoDisponibilidade(LocalDate dataDisponibilidade, LocalTime horaInicialDisponibilidade,
			LocalTime horaFinalDisponibilidade) {
		super();
		this.dataDisponibilidade = dataDisponibilidade;
		this.horaInicialDisponibilidade = horaInicialDisponibilidade;
		this.horaFinalDisponibilidade = horaFinalDisponibilidade;
	}

	public LocalDate getDataDisponibilidade() {
		return dataDisponibilidade;
	}

	public void setDataDisponibilidade(LocalDate dataDisponibilidade) {
		this.dataDisponibilidade = dataDisponibilidade;
	}

	public LocalTime getHoraInicialDisponibilidade() {
		return horaInicialDisponibilidade;
	}

	public void setHoraInicialDisponibilidade(LocalTime horaInicialDisponibilidade) {
		this.horaInicialDisponibilidade = horaInicialDisponibilidade;
	}

	public LocalTime getHoraFinalDisponibilidade() {
		return horaFinalDisponibilidade;
	}

	public void setHoraFinalDisponibilidade(LocalTime horaFinalDisponibilidade) {
		this.horaFinalDisponibilidade = horaFinalDisponibilidade;
	}

}
