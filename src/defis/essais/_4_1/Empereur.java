package defis.essais._4_1;

public class Empereur {
	private final String nom;
	private final Empereur prédécesseur;
	
	public Empereur(String nom, Empereur prédécesseur) {
		if(prédécesseur == null) {
			throw new NullPointerException("Prédécesseur non valide");
		}
		this.nom = nom;
		this.prédécesseur = prédécesseur;
	}
	public Empereur(String nom) {
		this.nom = nom;
		this.prédécesseur = null;
	}
	public String getNom() {
		return this.nom;
	}
	public boolean estLePremier() {
		return this.prédécesseur == null;
	}
	public Empereur getPrédécesseur() {
		if(prédécesseur==null) {
			throw new IllegalStateException("Pas de prédécesseur pour le premier empereur !");
		}
		return this.prédécesseur;
	}
	public static Empereur[] extraireListe(Empereur récent) {
		return null;
	}
}
