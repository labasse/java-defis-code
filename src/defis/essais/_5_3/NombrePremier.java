package defis.essais._5_3;

public class NombrePremier {
	public interface Recherche {
		public boolean estTrouvé();
		public long getNombreTrouvé();
	}
	public static Recherche nouvelleRecherche(long nombre) {
		return new AlgoRecherche(nombre);
	}
	
	public static void traiter(Recherche recherche, int tempsLimite) {
		AlgoRecherche r = (AlgoRecherche)recherche;
		long nombre = r.getNombre();;
		long diviseur;
		
		do {
			nombre++;
			diviseur = 2;			
			while( diviseur < nombre && nombre % diviseur != 0 ) {
				diviseur++;
			}			
		}
		while(diviseur < nombre);		
		r.setNombreTrouvé(nombre);
	}
	
	private static class AlgoRecherche implements Recherche {
		private long nombreTrouvé;
		private boolean trouvé = false;
		private final long nombre;
		
		public AlgoRecherche(long nombre) {
			this.nombre = nombre;
		}		
		@Override
		public boolean estTrouvé() {
			return trouvé;
		}
		@Override
		public long getNombreTrouvé() {
			if(!estTrouvé()) {
				throw new IllegalStateException("Aucun nombre trouvé pour l'instant");
			}
			return nombreTrouvé;
		}
		public void setNombreTrouvé(long nombreTrouvé) {
			this.nombreTrouvé = nombreTrouvé;
			this.trouvé = true;
		}
		public long getNombre() {
			return nombre;
		}
	}
}
