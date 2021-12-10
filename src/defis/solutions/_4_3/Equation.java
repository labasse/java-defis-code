package defis.solutions._4_3;

import java.text.CharacterIterator;
import java.text.StringCharacterIterator;
import java.util.HashMap;
import java.util.function.BinaryOperator;

public class Equation {
	private static HashMap<Character, Opération> opérations;
	
	static {
		opérations = new HashMap<Character, Equation.Opération>();
		
		opérations.put('*', new Opération(3, (a, b) -> a * b));
		opérations.put('/', new Opération(3, (a, b) -> a / b));
		
		opérations.put('+', new Opération(2, (a, b) -> a + b));
		opérations.put('-', new Opération(2, (a, b) -> a - b));
		
		opérations.put(')'                   , new Opération(1));
		opérations.put(CharacterIterator.DONE, new Opération(0));
	}
	public static double calculer(String equation) {
		return expression(new StringCharacterIterator(equation), 0);
	}
	private static double expression(CharacterIterator it, int priorité) {
		double total = operande(it);
		Opération op;
		
		while((op = opérationPrioritaire(it, priorité)) != null) {
			total = op.calculer(total, it);
		}
		return total;
	}
	private static Opération opérationPrioritaire(CharacterIterator it, int priorité) {
		Opération op = opérations.get(it.current());
		
		return op.getPriorité() > priorité ? op : null;
	}
	private static double operande(CharacterIterator it) {
		char caractère = it.current();
		
		it.next();
		return caractère=='(' ? expression(it, 0) : (double)(caractère-'0');
	}	
	private static class Opération
	{
		private int priorité;
		private BinaryOperator<Double> opérateur;
		
		public Opération(int priorité) {
			this(priorité, null);
		}
		public Opération(int priorité, BinaryOperator<Double> opérateur) {
			this.priorité = priorité;
			this.opérateur = opérateur;
		}
		public double calculer(double total, CharacterIterator it) {
			it.next();
			return opérateur==null 
				? total 
				: opérateur.apply(total, expression(it, getPriorité()));
		}
		public int getPriorité() {
			return priorité;
		}		
	}
}
