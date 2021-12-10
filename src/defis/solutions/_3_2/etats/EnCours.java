package defis.solutions._3_2.etats;

import defis.solutions._3_2.Participant;

public class EnCours extends EtatCourse {

	private EtatCourse suivant;
	
	public EnCours(int id, ContexteCourse contexte, EtatCourse suivant) {
		super(id, contexte);
		this.suivant = suivant;
	}

	@Override
	public Iterable<Participant> getClassement() {
		throw new IllegalStateException("La course n'est pas terminée");
	}

	@Override
	public Participant getGagnant() {
		throw new IllegalStateException("La course n'est pas terminée");
	}

	@Override
	public EtatCourse inscrire(Participant participant) {
		throw new IllegalStateException("Inscriptions fermées, la course est commencée");
	}

	@Override
	public EtatCourse démarrer() {
		throw new IllegalStateException("La course est déjà démarrée");
	}

	@Override
	public EtatCourse passerLaLigneDArrivée(Participant participant) {
		return suivant.passerLaLigneDArrivée(participant);
	}	
}
