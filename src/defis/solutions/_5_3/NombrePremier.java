package defis.solutions._5_3;

import java.time.Duration;
import java.time.Instant;

public class NombrePremier {
	public interface Recherche {
		public boolean estTrouvé();
		public long getNombreTrouvé();
	}
	
	public static Recherche nouvelleRecherche(long nombre) {
		return new AlgoRecherche(nombre);
	}
	
	public static void traiter(Recherche recherche, int tempsLimite) {
		Instant fin = Instant.now().plus(Duration.ofMillis(tempsLimite));
		AlgoRecherche r = (AlgoRecherche)recherche;
		
		while(Instant.now().compareTo(fin) < 0 && !r.estTrouvé()) {
			r.itération();
		}
	}
	
	private static class AlgoRecherche implements Recherche {
		private static enum Etat {
			Init,
			Recherche,
			Trouvé
		}		
		private long diviseur;
		private long nombre;
		private Etat état = Etat.Init;
		
		public AlgoRecherche(long nombre) {
			this.nombre = nombre;
		}
		
		public void itération() {
			switch(état) {
			case Init:
				nombre++;
				diviseur = 2;
				état = Etat.Recherche;
				break;
			case Recherche:
				if(diviseur == nombre) {
					état = Etat.Trouvé;
				}
				else if(nombre % diviseur == 0) {
					état = Etat.Init;
				}
				else {
					diviseur++;
				}
				break;
			case Trouvé:
				break;
			}
		}
		
		@Override
		public boolean estTrouvé() {
			return état == Etat.Trouvé;
		}

		@Override
		public long getNombreTrouvé() {
			if(!estTrouvé()) {
				throw new IllegalStateException("Aucun nombre trouvé pour l'instant");
			}
			return nombre;
		}		
	}	
}
