package defis;

//import defis.solutions._5_3.NombrePremier;
import static org.junit.Assert.*;

import java.time.Duration;
import java.time.Instant;

import org.junit.Test;

import defis.essais._5_3.NombrePremier;

public class _5_3_ItererParIntermittence {

	@Test
	public void testPetitNombreEn1s() {
		NombrePremier.Recherche recherche = NombrePremier.nouvelleRecherche(7);
		
		NombrePremier.traiter(recherche, 1000); 
		
		assertTrue(recherche.estTrouvé());
		assertEquals(11, recherche.getNombreTrouvé());
	}

	@Test
	public void testGrandNombreEnPlusieursIntervallesDe100ms() {
		NombrePremier.Recherche recherche = NombrePremier.nouvelleRecherche(179424691L);
		long compteur = 0;
		
		do {
			Instant début = Instant.now();
			
			NombrePremier.traiter(recherche, 100);
			Duration durée = Duration.between( début , Instant.now() ) ;
			
			assertTrue(durée.toMillis() <= 100L);
			compteur ++;			
		}
		while(!recherche.estTrouvé());
		assertTrue(compteur>1);
		assertEquals(179424697L, recherche.getNombreTrouvé());
	}

	
}
