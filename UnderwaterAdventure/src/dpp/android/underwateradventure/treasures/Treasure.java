package dpp.android.underwateradventure.treasures;

/**
 * Klasa reprezentująca skarb jaki można znaleźć na dnie morza :D
 * @author dpp
 *
 */
public class Treasure {
	private String name; //Nazwa naszego skarbu
	private int value;	//Wartość skarbu w złocie
	private String description;	//Opis skarbu
	private final int hunterPoints;	//Punkty poszukiwacza przyznawane dodatkowo za super skarby
	
	/**
	 * Konstruktor
	 * @param name Nazwa skarbu
	 * @param value Wartość skarbu
	 * @param description Opis fabularny dla skarbu
	 * @param hunterPoints Punkty poszukiwacza
	 */
	public Treasure(String name, int value, String description, int hunterPoints) {
		super();
		this.name = name;
		this.value = value;
		this.description = description;
		this.hunterPoints = hunterPoints;
	}

	/**
	 * Pobiera nazwę skarbu: ZŁOTO, ANTYK, LEGENDARY
	 * @return zwraca nazwę naszego skarbu
	 */
	public String getName() {
		return name;
	}

	/**
	 * Pobiera wartość skarbu w złocie
	 * @return wartość wydobytego skarbu w złocie
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Pobiera opis fabularny naszego skarbu
	 * @return opis fabularny skarbu
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Zwraca punkty poszukiwacza za jakieś mega rzadkie skarby. Za samo złoto będzie to zero
	 * @return punkty poszukiwacza za mega rzadkie skarby
	 */
	public int getHunterPoints() {
		return hunterPoints;
	}
	
	
	
}
