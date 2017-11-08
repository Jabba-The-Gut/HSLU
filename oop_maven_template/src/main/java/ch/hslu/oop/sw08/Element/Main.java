package ch.hslu.oop.sw08.Element;

public class Main {

	public static void main(String[] args) {
		Blei elem = new Blei("Blei", 20);
		Quecksilber elem2 = new Quecksilber("Quecksilber", 200);
		Stickstoff elem3 = new Stickstoff("Stickstoff", -246);
		
		System.out.println(elem.toString());
		System.out.println(elem2.toString());
		System.out.println(elem3.toString());

	}

}
