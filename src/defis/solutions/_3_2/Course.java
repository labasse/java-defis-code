package defis.solutions._3_2;

import defis.solutions._3_2.etats.Arrivee;
import defis.solutions._3_2.etats.ContexteCourse;
import defis.solutions._3_2.etats.EnCours;
import defis.solutions._3_2.etats.EtatCourse;
import defis.solutions._3_2.etats.Inscription;

public class Course {
	public final static int
		INSCRIPTION = 0,
		EN_COURS = 1,
		ARRIVEE = 2;
	private final ContexteCourse contexte = new ContexteCourse();
	private final Categorie catégorie;
	private EtatCourse état =
		new Inscription(INSCRIPTION, contexte, 
			new EnCours(EN_COURS   , contexte,
				new Arrivee(ARRIVEE, contexte)
			)
		);
			
	public Course(Categorie catégorie) {
		if(catégorie==null) {
			throw new NullPointerException("La catégorie doit être renseignée");
		}
		this.catégorie = catégorie;
	}
	public Categorie getCatégorie() {
		return catégorie; 
	}
	public int getÉtat() {
		return this.état.getId();
	}
	public Iterable<Participant> getInscrits() {
		return état.getClassement();
	}
	public Iterable<Participant> getClassement() {
		return état.getClassement();
	}
	public Participant getGagnant() {
		return état.getGagnant();
	}
	public void inscrire(Participant participant) {
		état = état.inscrire(participant);
	}
	public void démarrer() {
		état = état.démarrer();
	}
	public void passerLaLigneDArrivée(Participant participant) {
		état = état.passerLaLigneDArrivée(participant);
	}	
}
