package defis.solutions._5_1.forkjoin;

import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class TriParPivot {
	private int maxTâches;
	
	public TriParPivot(int maxTâches) {
		this.maxTâches = maxTâches;
	}
	
	public <T extends Comparable<? super T>> void trier(T [] tableau) {
		ForkJoinPool pool = new ForkJoinPool(maxTâches);
		
		pool.invoke(new TriRécursif<T>(tableau, 0, tableau.length));
	}
	
	private static class TriRécursif<T extends Comparable<? super T>> extends RecursiveAction {
		private final static int TAILLE_SEUIL = 512;
		private T [] tableau;
		private int premier, dernier;
		
		public TriRécursif(T [] tableau, int premier, int dernier) {
			this.tableau = tableau;
			this.premier = premier;
			this.dernier = dernier;
		}

		@Override
		protected void compute() {
			trier(tableau, premier, dernier);
		}
		private void trier(T [] tableau, int premier, int dernier) {
			if (premier >= dernier) {
		        return;
		    }
			int pos = premier;
			
		    for(int fin = dernier-1; pos < fin; ) {
		    	permuter(
		    		tableau, pos+1,
		    		tableau[pos+1].compareTo(tableau[pos]) < 0 ? pos++ : fin--
		    	);
		    }
		    if(pos-premier < TAILLE_SEUIL) {
		    	trier(tableau, premier  , pos );
			    trier(tableau, pos + 1, dernier);
		    }
		    else {
		    	invokeAll(
		    		new TriRécursif<T>(tableau, premier, pos),
		    		new TriRécursif<T>(tableau, pos + 1, dernier)
		    	);
		    }
		    		
		}
		private static <T> void permuter(T[] tableau, int indice1, int indice2) {
			T tmp = tableau[indice1];
			
			tableau[indice1] = tableau[indice2];
			tableau[indice2] = tmp;
		}
		// Requis par RecursiveAction qui est sérialisable
		private static final long serialVersionUID = 1L;		
	}
}
