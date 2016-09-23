import java.util.ArrayList;

public class Bowling {
	
	private ArrayList<Throw> tabThrow;
	
	public ArrayList<Throw> getThrows(){
		if (tabThrow == null){
			raiseException(1);
			return null;
		}
		return tabThrow;
	}
	
	public Bowling(ArrayList<Throw> tab){
		if (tab.size() != 10){
			raiseException(0);
		}
		else{
			this.tabThrow = tab;
		}
		GenerateSparAndStrike();
	}
	
	private void raiseException(int nb){
		if(nb == 0){
			System.err.println("EXCEPTION | Le nombre de lancer est différent de 10 !");
		}
		if(nb == 1){
			System.err.println("EXCEPTION | La partie est mal initialisé, vérifiez vos lancers.");
		}
	}
	
	private void GenerateSparAndStrike(){
		if(tabThrow == null){
			raiseException(1);
		}
		else{
			Throw tMem = new Throw(0,0);
			Boolean isSpare = false;
			Boolean isStrike = false;
			for(Throw i : tabThrow){
				if(isSpare){
					tMem.firstThrow += i.firstThrow;
					isSpare = false;
				}
				if(isStrike){
					if (i.firstThrow == 10){
						tMem.firstThrow += i.firstThrow + i.secondThrow;						
					}
					else {
						tMem.firstThrow += i.firstThrow + i.secondThrow;
						isStrike = false;
					}
				}
				if(i.firstThrow == 10 && !isStrike){
					tMem = i;
					isStrike = true;
				}
				else if(i.firstThrow + i.secondThrow == 10){
					tMem = i;
					isSpare = true;
				}
			}
		}
		
	}
	
	public int GetScore(){
		if(tabThrow == null){
			raiseException(1);
			return 0;
		}
		int score = 0;
		for(Throw i : tabThrow){
			score += i.firstThrow + i.secondThrow;
		}
		return score;
	}

}
