package defis;

import java.util.Scanner;

import defis.essais._3_2.Categorie;
import defis.essais._3_2.Course;
import defis.essais._3_2.Participant;

public class _3_2_LeNullCEstNul {
	public static void main(String [] args) {
		String [] menu = new String[] {
			"Inscrire un nouveau participant",
			"Démarrer la course",
			"Arrivée d'un participant",
			"Classement",
			"Gagnant-e",
			"Quitter"
		};
		Scanner clavier = new Scanner(System.in);
		boolean fini = false;
		
		Categorie catégorie = args.length > 0 ? new Categorie(args[0]) : null;
		Course course = new Course(catégorie);
		
		while( !fini ) {
			int choix;
			
			do {
				for(int i=0; i<menu.length; i++) {
					System.out.printf("%d) %s\n", i+1, menu[i]);
				}
				System.out.printf("Votre choix (1-%d) : ", menu.length);
				try {
					choix = Integer.parseInt(clavier.next());						
				}
				catch(NumberFormatException e) {
					choix = 0;
				}				
			}
			while(choix < 1 || menu.length < choix);
			
			System.out.println();
			switch(choix) {
			case 1 : inscrire  (course, clavier	); break;
			case 2 : démarrer  (course			); break;
			case 3 : arrivée   (course, clavier	); break;
			case 4 : classement(course			); break;
			case 5 : vainqueur (course			); break;
			case 6 : fini = true; 
			}
		}
		System.out.println("Bye");
		clavier.close();
	}
	public static void inscrire(Course course, Scanner clavier) {
		System.out.print("Nom du participant : ");
		try {
			course.inscrire(new Participant(clavier.next()));
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	public static void démarrer(Course course) {
		try {
			course.démarrer();
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}	
	}
	public static void arrivée(Course course, Scanner clavier) {
		System.out.print("Nom du participant : ");
		try {
			course.passerLaLigneDArrivée(new Participant(clavier.next()));
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}		
	}
	public static void classement(Course course) {
		if(course.getClassement()==null) {
			System.err.println("Inscriptions en cours");
		}
		else if(!course.getClassement().iterator().hasNext()) {
			System.err.println("Course non terminée");
		}
		else {
			System.out.println("CLASSEMENT :");
			int position = 1;
			
			for(Participant participant : course.getClassement()) {
				System.out.printf("%4d) %s\n", position++, participant);				
			}
			System.out.println();
		}
	}
	public static void vainqueur(Course course) {
		if(course.getGagnant() == null) {
			System.err.println("Inscriptions ou course en cours");
		}
		else {
			System.out.println(course.getGagnant());
		}
	}
}
