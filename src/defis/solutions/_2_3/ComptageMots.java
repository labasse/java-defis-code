package defis.solutions._2_3;

public class ComptageMots {
	private enum Etat {
		Espace,
		Mot
	}
	private final static String SEPARATEURS = "'-.;:?! \t\n\r";
	
	private static boolean estUnSéparateur(char caractère) {
		return SEPARATEURS.indexOf(caractère) >= 0;
	}
	
	public static int compter(String phrase) {
		Etat état = Etat.Espace;
		int nombreMots = 0;
		
		for(int i=0; i<phrase.length(); i++) {
			char caractère = phrase.charAt(i);
			
			switch(état) {
			case Espace:
				if( !estUnSéparateur(caractère) ) {
					état = Etat.Mot;
					nombreMots++;
				}
				break;
			case Mot:
				if( estUnSéparateur(caractère) ) {
					état = Etat.Espace;
				}
				break;
			}
		}
		return nombreMots;
	}
}
