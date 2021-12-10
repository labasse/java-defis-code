package defis;

//import defis.solutions._4_3.Equation;
import static org.junit.Assert.*;
import org.junit.Test;

import defis.essais._4_3.Equation;


public class _4_3_LeSensDesPriorites {

	@Test
	public void testChiffre() {
		assertEquals(2.0, Equation.calculer("2"), 0.01);
	}
	
	@Test
	public void testSomme() {
		assertEquals(5.0, Equation.calculer("2+3"), 0.01);
	}
	
	@Test
	public void testSommes() {
		assertEquals(9.0, Equation.calculer("2+3+4"), 0.01);
	}
	
	@Test
	public void testProduits() {
		assertEquals(24.0, Equation.calculer("2*3*4"), 0.01);
	}
	
	@Test
	public void testProduitPuisSomme() {
		assertEquals(10.0, Equation.calculer("2*3+4"), 0.01);
	}
	
	@Test
	public void testSommePuisProduit() {
		assertEquals(14.0, Equation.calculer("2+3*4"), 0.01);
	}
	
	@Test
	public void testProduitPuisSommeAvecParenthèses() {
		assertEquals(27.0, Equation.calculer("3*(4+5)"), 0.01);
	}
	
	@Test
	public void testSommeAvecParenthèsesPuisProduit() {
		assertEquals(20.0, Equation.calculer("(2+3)*4"), 0.01);
	}
	
	@Test
	public void testSommePuisSommeAvecParenthèsesPuisProduit() {
		assertEquals(21.0, Equation.calculer("1+(2+3)*4"), 0.01);
	}
	
	@Test
	public void testEquationComplexe() {
		assertEquals(22.0, Equation.calculer("((3-1+4+2*3)/6+9)*(3-1)"), 0.01);
	}
}
