package defis.solutions._5_2;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;
import java.util.function.BinaryOperator;

public class CompteEstBon extends RecursiveAction {
	private final static int PARALLELISME = 16; 
	private final static Opération[] opérations={
		new Opération('*', (a, b) -> a != 1 && b != 1     ? a * b : 0 ),
		new Opération('/', (a, b) -> b != 1 && a % b == 0 ? a / b : 0 ),
		new Opération('+', (a, b) -> a + b),
		new Opération('-', (a, b) -> a > b ? a - b : 0)
	};			

	private final Tirage tirage;
	private final String solution;
	
	public CompteEstBon(Tirage tirage) {
		this(tirage, "");
	}
	private CompteEstBon(Tirage tirage, String solution) {
		this.tirage = tirage;
		this.solution = solution;
	}
		
	public void afficherSolutions() {
		ForkJoinPool pool = new ForkJoinPool(PARALLELISME);
		
		pool.invoke(this);
	}

	@Override
	protected void compute() {
		for(int i = 0; i<tirage.taille(); i++) {
			for(int j = 0; j<tirage.taille(); j++) {
				if(i!=j) {
					essayerOpérations(i, j);
				}
			}
		}	
	}

	private void essayerOpérations(int indiceTerme1, int indiceTerme2) {
		List<CompteEstBon> pistes = new ArrayList<>();
		
		for(Opération op : opérations) {
			int total = op.calculer(
				tirage.get(indiceTerme1),
				tirage.get(indiceTerme2)
			);
			String nouvelleSolution = String.format(
				"%s%d %c %d = %d\n",
				solution,
				tirage.get(indiceTerme1),
				op.getSymbole(),
				tirage.get(indiceTerme2),
				total
			);
			if(total == tirage.getObjectif()) {				
				System.out.println(nouvelleSolution);
			}
			else if(total != 0) {
				pistes.add(new CompteEstBon(
					tirage.modifier(indiceTerme1, indiceTerme2, total), 
					nouvelleSolution
				));
			}
		}
		invokeAll(pistes);
	}

	private static class Opération
	{
		private final char symbole;
		private final BinaryOperator<Integer> opérateur;
		
		public Opération(char symbole, BinaryOperator<Integer> opérateur) {
			this.symbole = symbole;
			this.opérateur = opérateur;
		}
		public int getSymbole() {
			return symbole;
		}
		public int calculer(int op1, int op2) {
			return opérateur.apply(op1, op2);
		}		
	}
	
	private static final long serialVersionUID = 1L;	
}
