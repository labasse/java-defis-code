package defis.solutions._3_4.vues;

import java.io.IOException;
import java.io.OutputStreamWriter;

import defis.solutions._3_4.Menu;

public class VueMenu implements Vue {
	private Menu menu;
	
	public VueMenu(Menu menu) {
		this.menu = menu;
	}
	
	@Override
	public void rendre(OutputStreamWriter sortie, OutputStreamWriter erreur) throws IOException {
		int indice = 1;
		
		for(Menu.Élément élément : menu.getÉléments()) {
			sortie.write(
				élément.estActif()
					? String.format( "%2d) %s\n", indice+1, élément) 
					: String.format( " -) %s\n" , élément
				)
			);
		}
		sortie.write("\n");
	}

}
