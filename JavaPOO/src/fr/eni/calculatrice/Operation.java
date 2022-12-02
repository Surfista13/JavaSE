package fr.eni.calculatrice;

public class Operation extends DepassementCapaciteException {

	public int ajouter(int ent1, int ent2) throws DepassementCapaciteException{
		
		int sum = ent1 + ent2;
		long sumVerif = (long)ent1 + (long)ent2 ;
		
		if(sum != sumVerif) {
			throw new DepassementCapaciteException();
		} else {
			return sum;
		}
		
	}
	
	public int soustraire(int ent1, int ent2) throws DepassementCapaciteException{
		
		int soustraction = ent1 - ent2;
		long soustractionVerif = (long)ent1 - (long)ent2 ;
		
		if(soustraction != soustractionVerif) {
			throw new DepassementCapaciteException();
		} else {
			return soustraction;
		}
		
	}
	
	public int multiplication(int ent1, int ent2) throws DepassementCapaciteException{
		
		int multi = ent1 * ent2;
		long multiVerif = (long)ent1 * (long)ent2 ;
		
		if(multi != multiVerif) {
			throw new DepassementCapaciteException();
		} else {
			return multi;
		}
		
	}
	
	public int division(int ent1, int ent2) throws Division0Exception{
		int div;
		try {
			div = ent1 / ent2;
			
		}catch(Exception e){
			throw new Division0Exception() ;
		}
		return div;
	}
	
 }

