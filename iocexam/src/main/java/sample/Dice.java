package sample;

public class Dice {
	private int face;
	
	public Dice() {
		System.out.println("Dice() 생성자 호출");
	}
	
	public Dice(int face) {
		this.face = face;
		System.out.println("Dice(face) 생성자 호출");
	}
	
	public int getNumber() {
		return (int)(Math.random() * face) + 1;
	}
}
