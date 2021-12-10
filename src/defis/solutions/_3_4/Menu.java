package defis.solutions._3_4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class Menu {
	private List<Élément> éléments;
	
	public Menu(Élément...éléments) {
		this.éléments = Arrays.asList(éléments);
	}
	public Iterable<Élément> getÉléments() {
		return éléments;
	}
	public Élément getÉlément(int indice) {
		return éléments.get(indice);
	}
	public static class Élément {
		private String titre;
		private Runnable action;
		private Supplier<Boolean> activer;
		
		public Élément(String titre, Runnable action, Supplier<Boolean> activer) {
			this.titre = titre;
			this.action = action;
			this.activer = activer;
		}
		public Élément(String titre, Runnable action) {
			this(titre, action, () -> true);
		}
		public String toString() {
			return titre;
		}
		public void exécuter() {
			action.run();
		}
		public boolean estActif() {
			return activer.get().booleanValue();
		}
	}	
}
