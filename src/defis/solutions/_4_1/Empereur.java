package defis.solutions._4_1;

public class Empereur {
	private final String nom;
	private final Empereur prédécesseur;
	
	public Empereur(String nom, Empereur prédécesseur) {
		this.nom = nom;
		this.prédécesseur = prédécesseur;
	}
	public Empereur(String nom) {
		this(nom, null);
	}
	public String getNom() {
		return nom;
	}
	public boolean estLePremier() {
		return prédécesseur == null;
	}
	public Empereur getPrédécesseur() {
		return prédécesseur;
	}
	private static Empereur[] extraireListe(Empereur courant, int nombre) {
		Empereur[] résultat = courant.estLePremier() 
			? new Empereur[nombre]
			: extraireListe(courant.getPrédécesseur(), nombre+1);
		
		résultat[résultat.length-nombre] = courant;
		return résultat;
	}
	public static Empereur[] extraireListe(Empereur récent) {
		return extraireListe(récent, 1);
	}
}
