package defis.solutions._3_4.vues;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.function.Supplier;

import defis.essais._3_2.Participant;

public class VueClassement implements Vue {
	private Supplier<Iterable<Participant>> classement;
	
	public VueClassement(Supplier<Iterable<Participant>> classement) {
		this.classement = classement;
	}

	@Override
	public void rendre(OutputStreamWriter sortie, OutputStreamWriter erreur) throws IOException {
		int position = 1;
		
		sortie.write("CLASSEMENT :\n");
		for(Participant participant : classement.get()) {
			sortie.write(String.format("%4d) %s\n", position++, participant));				
		}
		sortie.write("\n");
	}

}
