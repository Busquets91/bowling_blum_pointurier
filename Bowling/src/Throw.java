
public class Throw {
	
	public int firstThrow;
	public int secondThrow;
	
	public Throw(int un, int deux){
		if(un < 0 || deux <0){
			raiseException(0);
		}
		else if(un + deux > 10){
			raiseException(1);
		}
		else{
			this.firstThrow = un;
			this.secondThrow = deux;			
		}
	}
	
	public void add(int val){
		this.secondThrow += val;
	}
	
	private void raiseException(int nb){
		if(nb == 0){
			System.err.println("EXCEPTION | Un des lancer est inférieur à 0 !");
		}
		if(nb == 1){
			System.err.println("EXCEPTION | La somme des lancers est supérieur à 10 !");
		}
	}

}
