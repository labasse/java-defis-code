package defis;

import static org.junit.Assert.*;
import org.junit.Test;

import defis.essais._4_4.TriParPivot;

import java.util.Arrays;
import java.util.Random;

public class _4_4_DesamorcerLaBombe {

	@Test
	public void testTableauVide() {
		Integer [] tableau = {  };
		TriParPivot tri = new TriParPivot();
		
		tri.trier(tableau);
		assertArrayEquals(new Integer[] {}, tableau);
	}

	@Test
	public void testTableauALenvers() {
		Integer [] tableau = new Integer[50000];
		Integer [] attendu = remplirÀLEnversDupliquerEtTrier(tableau);
		TriParPivot tri = new TriParPivot();
		
		tri.trier(tableau);
		assertArrayEquals(attendu, tableau);
	}
	
	@Test
	public void testGrandTableauAléatoire() {
		Integer [] tableau = new Integer[100000];
		Integer [] attendu = remplirDupliquerEtTrier(tableau);
		TriParPivot tri = new TriParPivot();
		
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
