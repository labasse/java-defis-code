package defis.solutions._3_3;

import static org.junit.Assert.*;
import org.junit.Test;

import defis.essais._3_3.Joueur;

public class NeVousRepetezPas {
	
	private void séquenceJeu(Match m, Joueur... joueurs) {
		for(Joueur j : joueurs) {
			m.marquer(j);
		}
	}
	private Match séquenceJeu(Joueur... joueurs) {
		Match m = new Match();
		
		séquenceJeu(m, joueurs);
		return m;
	}
	
	public Match séquenceJeu40a() {
		return séquenceJeu(
			 Joueur.B,
			 Joueur.B,
			Joueur.A,
			 Joueur.B,
			Joueur.A,
			Joueur.A
		);
	}
	
	private void séquenceManche(Match m, Joueur... joueurs) {
		for(Joueur j : joueurs) {
			séquenceJeu(m, j, j, j, j);
		}
	}
	
	private Match séquenceManche(Joueur... joueurs) {
		Match m = new Match();
		
		séquenceManche(m, joueurs);
		return m;
	}
		
	private Match séquenceMancheJeuDécisif() {
		return séquenceManche(
		 	 Joueur.B,
			 Joueur.B,
			 Joueur.B,
			Joueur.A,
			 Joueur.B,
			Joueur.A,
			 Joueur.B,
			Joueur.A,
			Joueur.A,
			Joueur.A
		);
	}

	private void assertScoreJeu(int scoreAttenduA, int scoreAttenduB, Match m) {
		assertEquals(scoreAttenduA, m.getScoreJeu(Joueur.A));
		assertEquals(scoreAttenduB, m.getScoreJeu(Joueur.B));
	}
	
	private void assertJeuB(Match m) {
		assertScoreJeu(0, 0, m);
		assertScoreManche(0, 1, m, 0);
	}
	
	private void assertVictoireManche(int scoreAttenduA, int scoreAttenduB, Match m) {
		assertScoreManche(scoreAttenduA, scoreAttenduB, m, 0);
		assertEquals(1, m.getIndiceManche());
		assertScoreManche(0, 0, m, 1);
	}
	
	private void assertScoreManche(int scoreAttenduA, int scoreAttenduB, Match m, int indiceManche) {
		assertEquals(scoreAttenduA, m.getScoreManche(Joueur.A, indiceManche));
		assertEquals(scoreAttenduB, m.getScoreManche(Joueur.B, indiceManche));
	}
	
	private void assertAucunAvantage(Match m) {
		assertFalse(m.avantage(Joueur.A));
		assertFalse(m.avantage(Joueur.B));		
	}
	
	@Test
	public void testMatchInitialisation() {
		Match match = new Match();
		
		assertScoreJeu   (0, 0, match);
		assertScoreManche(0, 0, match, 0);
		assertAucunAvantage(match);
		assertEquals(0, match.getIndiceManche());
	}
	@Test
	public void testMatch15a0() {
		Match match = séquenceJeu(
			Joueur.A
		);		
		assertScoreJeu(15, 0, match);
		assertAucunAvantage(match);		
	}
	@Test
	public void testMatch30a15() {
		Match match = séquenceJeu(
			Joueur.A,
			 Joueur.B,
			Joueur.A
		);
		assertScoreJeu(30, 15, match);
	}
	@Test
	public void testMatch0a40() {
		Match match = séquenceJeu(
			Joueur.B,
			Joueur.B,
			Joueur.B
		);		
		assertScoreJeu(0, 40, match);
	}
	
	@Test
	public void testMatchEgalite() {
		Match match = séquenceJeu40a();
		
		assertScoreJeu(40, 40, match);
	}
	@Test
	public void testMatchAvantage() {
		Match match = séquenceJeu40a();
		
		match.marquer( Joueur.B );
		
		assertScoreJeu(40, 40, match);
		assertFalse(match.avantage(Joueur.A));
		assertTrue (match.avantage(Joueur.B));		
	}
	@Test
	public void testMatchEgaliteMultiple() {
		Match match = séquenceJeu40a();
				
		séquenceJeu(match, 
			 Joueur.B,
			Joueur.A ,
			Joueur.A ,
			 Joueur.B
		);
		assertScoreJeu(40, 40, match);
		assertAucunAvantage(match);		
	}
	@Test
	public void testMatchNouveauJeu() {
		Match match = séquenceJeu(
			 Joueur.B,
			Joueur.A ,
			 Joueur.B,
			 Joueur.B,
			Joueur.A ,
			 Joueur.B
		);
		assertJeuB(match);
	}
	
	@Test
	public void testMatchNouveauJeuApresAvantage() {
		Match match = séquenceJeu40a();
		
		séquenceJeu(match, 
			Joueur.B,
			Joueur.B
		);
		assertJeuB(match);
	}
	
	@Test
	public void testVictoire6a4() {
		Match match = séquenceManche(
			 Joueur.B,
			 Joueur.B,
			 Joueur.B,
			Joueur.A,
			 Joueur.B,
			Joueur.A,
			Joueur.A,
			Joueur.A,
			Joueur.A,
			Joueur.A
		);		
		assertVictoireManche(6, 4, match);
	}
	
	@Test
	public void testManche6a5() {
		Match match = séquenceMancheJeuDécisif();
		
		séquenceManche(match, Joueur.A);
		
		assertScoreManche(6, 5, match, 0);
		assertEquals(0, match.getIndiceManche());
	}
	
	@Test
	public void testManche7a5() {
		Match match = séquenceMancheJeuDécisif();
		
		séquenceManche(match, 
			Joueur.A,
			Joueur.A
		);
		assertVictoireManche(7,  5, match);
	}
	
	@Test
	public void testManche8a6() {
		Match match = séquenceMancheJeuDécisif();
		
		séquenceManche(match, 
			Joueur.A,
			 Joueur.B,
			Joueur.A,
			Joueur.A
		);
		assertVictoireManche(8,  6, match);
	}
	
}
