package defis;

import static org.junit.Assert.*;
import java.util.Arrays;
import java.util.Random;
import org.junit.Test;

import defis.essais._5_1.TriParPivot;


public class _5_1_LesTraitementsBienParalleles {

	@Test
	public void testTableauVide() {
		Integer [] tableau = {  };
		TriParPivot tri = new TriParPivot( 1<<6 );
		
		tri.trier(tableau);
		assertArrayEquals(new Integer[] {}, tableau);
	}

	@Test
	public void testTableauALenvers() {
		Integer [] tableau = new Integer[8000];
		Integer [] attendu = remplirÀLEnversDupliquerEtTrier(tableau);
		TriParPivot tri = new TriParPivot( 16 );
		
		tri.trier(tableau);
		assertArrayEquals(attendu, tableau);
	}
	
	@Test
	public void testGrandTableauAléatoire() {
		Integer [] tableau = new Integer[5000000];
		Integer [] attendu = remplirDupliquerEtTrier(tableau);
		TriParPivot tri = new TriParPivot( 16 );
		
		tri.trier(tableau);
		assertArrayEquals(attendu, tableau);
	}
	
	private Integer[] dupliquerEtTrier(Integer[] tableau) {
		Integer[] trié = tableau.clone();
		
		Arrays.sort( trié );
		return trié;
	}

	private Integer[] remplirÀLEnversDupliquerEtTrier(Integer[] tableau) {
		for(int i=0; i<tableau.length; i++) {
			tableau[i] = tableau.length - i;
		}
		return dupliquerEtTrier(tableau);
	}		
	
	private Integer[] remplirDupliquerEtTrier(Integer[] tableau) {
		int max = tableau.length;
		Random hasard = new Random(0); 
		
		for(int i=0; i<tableau.length; i++) {
			tableau[i] = hasard.nextInt(max);
		}
		return dupliquerEtTrier(tableau);
	}
	

}
