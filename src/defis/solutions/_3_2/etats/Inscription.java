package defis.solutions._3_2.etats;

import java.util.List;

import defis.solutions._3_2.Participant;

public class Inscription extends EtatCourse {
	EtatCourse suivant;
	
	public Inscription(int id, ContexteCourse contexte, EtatCourse suivant) {
		super(id, contexte);
		this.suivant = suivant;
	}

	@Override
	public Iterable<Participant> getClassement() {
		throw new IllegalStateException("La course n'a pas démarré, inscriptions en cours");
	}

	@Override
	public Participant getGagnant() {
		throw new IllegalStateException("La course n'a pas démarré, inscriptions en cours");
	}

	@Override
	public EtatCourse passerLaLigneDArrivée(Participant participant) {
		throw new IllegalStateException("La course n'a pas démarré, inscriptions en cours");
	}

	@Override
	public EtatCourse inscrire(Participant participant) {
		if(participant==null) {
			throw new NullPointerException("Le participant doit être renseigné");
		}
		List<Participant> inscrits = getContexte().getInscrits();
		
		if(inscrits.contains(participant)) {
			throw new IllegalArgumentException("Le/La participant-e est déjà inscrit-e");
		}
		inscrits.add(participant);
		return this;
	}

	@Override
	public EtatCourse démarrer() {
		return suivant;
	}

}
