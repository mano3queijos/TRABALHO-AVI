package ucsal.br.bes.programacaoweb2023.trabalhoavi.persistence;

import java.util.ArrayList;
import java.util.List;

import ucsal.br.bes.programacaoweb2023.trabalhoavi.domain.Coordenador;

public class CoordenadoresDao {

	private static List<Coordenador> coordenadores = new ArrayList<>();

	public static void adicionar(Coordenador coordenador) {
		coordenadores.add(coordenador);
	}

	public static void remover(int posRmv) {
		coordenadores.remove(posRmv);

	}

	public static void atualizar(Integer posAtt, Coordenador coordenador) {
		coordenadores.set(posAtt, coordenador);
	}
}