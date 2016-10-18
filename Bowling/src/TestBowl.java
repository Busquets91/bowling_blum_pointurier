import java.util.ArrayList;

public class TestBowl {
	
	private int nbTuple;
	
	public TestBowl(){
		this.nbTuple = 10;
	}
	
	private Boolean sommeIsOk(Bowling bowl, int expected){
		int obtained = bowl.GetScore();
		return (expected == obtained);
	}
	
	private Boolean nbThrowIsBigger(Bowling bowl){
		if (bowl.getThrows() != null){
			return bowl.getThrows().size() > this.nbTuple;			
		}
		return false;
	}
	
	private Boolean nbThrowIsSmaller(Bowling bowl){
		if (bowl.getThrows() != null){
			return bowl.getThrows().size() < this.nbTuple;			
		}
		return false;
	}
	
	private Boolean valThrowIsOk(Bowling bowl){
		if (bowl.getThrows() == null){
			return false;			
		}
		for(Throw t : bowl.getThrows()){
			if(t.firstThrow < 0){
				return false;
			}
			if(t.secondThrow < 0){
				return false;
			}
		}
		return true;
	}
	
	private Boolean sumThrowIsOk(Bowling bowl){
		if (bowl.getThrows() == null){
			return false;			
		}
		for(Throw t : bowl.getThrows()){
			if(t.firstThrow + t.secondThrow > 10){
				return false;
			}
		}
		return true;
	}
	
	public void Tester(Bowling bowl, int result){
		System.out.println("SOMME IS OK: " + this.sommeIsOk(bowl, result));
		System.out.println("NB THROW IS SMALL: " + this.nbThrowIsSmaller(bowl));
		System.out.println("NB THROW IS BIG: " + this.nbThrowIsBigger(bowl));	
		System.out.println("VAL THROW IS OK: " + this.valThrowIsOk(bowl));
		System.out.println("SOMME THROW IS OK" + this.sumThrowIsOk(bowl));	
	}

	public static void main(String[] args) {
		/*INITIALISATION*/
		ArrayList<Throw> tab = new ArrayList<Throw>();
		ArrayList<Throw> tab1 = new ArrayList<Throw>();
		
		Throw t = new Throw(1,3);
		tab.add(t);
		t = new Throw(6,3);
		tab.add(t);
		t = new Throw(8,1);
		tab.add(t);
		t = new Throw(10,0);
		tab.add(t);
		t = new Throw(10,1);
		tab.add(t);		
		t = new Throw(0,0);
		tab.add(t);	
		t = new Throw(-1,5);
		tab.add(t);
		t = new Throw(1,5);
		tab.add(t);
		t = new Throw(1,5);
		tab.add(t);
		t = new Throw(1,5);
		tab.add(t);
		t = new Throw(1,5);
		tab.add(t);
		
		t = new Throw(5,5);
		tab1.add(t);
		
		Bowling bowl1 = new Bowling(tab);
		Bowling bowl2 = new Bowling(tab1);
		
		TestBowl test = new TestBowl();		
		System.out.println("\n\nTEST n1:\n");
		test.Tester(bowl1, 71);

		System.out.println("\n\nTEST n2:\n");
		test.Tester(bowl2, 10);
		
		System.out.println("\n\nFIN TEST\n");
	}
}
