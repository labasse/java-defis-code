package defis.essais._5_2;

import java.util.function.BinaryOperator;

public class CompteEstBon {
	private final static Opération[] opérations={
		new Opération('*', (a, b) -> a != 1 && b != 1     ? a * b : 0 ),
		new Opération('/', (a, b) -> b != 1 && a % b == 0 ? a / b : 0 ),
		new Opération('+', (a, b) -> a + b),
		new Opération('-', (a, b) -> a > b ? a - b : 0)
	};			

	private final Tirage tirage;
	
	public CompteEstBon(Tirage tirage) {
		this.tirage = tirage;
	}
	
	public void afficherSolutions() {
		for(int i = 0; i<tirage.taille(); i++) {
			int terme1 = tirage.retirer(i);
			
			for(int j = 0; j<tirage.taille(); j++) {
				int terme2 = tirage.retirer(j);
				
				essayerOpérations(terme1, terme2);
				tirage.ajouter(j, terme2);
			}
			tirage.ajouter(i, terme1);
		}
	}
	
	private void essayerOpérations(int terme1, int terme2) {
		for(Opération op : opérations) {
			int total = op.calculer(terme1, terme2);
			
			if(total == tirage.getObjectif()) {
				// TODO : Afficher votre solution ici
				System.out.println("Solution trouvée");
			}
			else if(total != 0) {
				tirage.ajouterFin(total);
				afficherSolutions();
				tirage.retirerFin();
			}
		}
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
}
