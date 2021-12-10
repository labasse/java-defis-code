package defis;

//import defis.solutions._2_3.ComptageMots;
import static org.junit.Assert.*;
import org.junit.Test;

import defis.essais._2_3.ComptageMots;

public class _2_3_SavezVousCompter {

	@Test
	public void testUnMot() {
		assertEquals(1, ComptageMots.compter("Bonjour"));
	}
	@Test
	public void testUnePhraseSimple() {
		assertEquals(4, ComptageMots.compter("Bonjour tout le monde"));
	}
	@Test
	public void testPhraseAvecPonctuations() {
		assertEquals(10, ComptageMots.compter("Hélas ! Et, sans ton sourire,\nQue ferai-je du matin ?"));
	}
	@Test
	public void testChaîneVide() {
		assertEquals(0, ComptageMots.compter(""));
	}
	@Test
	public void testChaîneAvecEspacements() {
		assertEquals(0, ComptageMots.compter(" \n\t\r "));
	}

}
