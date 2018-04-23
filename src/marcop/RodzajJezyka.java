package marcop;

public enum RodzajJezyka {
	PL(0),EN(1),SP(2);
	private int nr;
	
	RodzajJezyka(int nr){
		this.nr=nr;
	}
	
	public int getNr() {
		return nr;
	}
}
