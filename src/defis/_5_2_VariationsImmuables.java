package defis;

import defis.solutions._5_2.CompteEstBon;
import defis.solutions._5_2.Tirage;

public class _5_2_VariationsImmuables {

	public static void main(String [] args) {
		Tirage tirage = new Tirage(new Integer[] { 4, 1, 101, 2 }, 33 );
		CompteEstBon c = new CompteEstBon(tirage);
		
		c.afficherSolutions();		
	}
}
