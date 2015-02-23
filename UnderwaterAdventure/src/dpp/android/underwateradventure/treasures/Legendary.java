package dpp.android.underwateradventure.treasures;

/**
 * Klasa reprezentująca legendarne przedmioty
 * @author dpp
 *
 */
public class Legendary extends Treasure {
	
	//Za legendarne otrzymujemy 2 punkty poszukiwacza
	private final static int hunterPoints=2;
	
	/**
	 * Konstruktor skarbów typu Legendary
	 * @param name Nazwa skarbu
	 * @param value Wartość skarbu
	 * @param description Opis fabularny dla skarbu
	 */
	public Legendary(String name, int value, String description) {
		super(name, value, description, hunterPoints);
		// TODO Auto-generated constructor stub
	}
	
	/**
	 * Pobiera nazwę skarbu: ZŁOTO, ANTYK, LEGENDARY
	 * @return zwraca nazwę naszego skarbu
	 */
	public String getName() {
		return super.getName();
	}

	/**
	 * Pobiera wartość skarbu w złocie
	 * @return wartość wydobytego skarbu w złocie
	 */
	public int getValue() {
		return super.getValue();
	}

	/**
	 * Pobiera opis fabularny naszego skarbu
	 * @return opis fabularny skarbu
	 */
	public String getDescription() {
		return super.getDescription();
	}

	/**
	 * Zwraca punkty poszukiwacza za jakieś mega rzadkie skarby. Za samo złoto będzie to zero
	 * @return punkty poszukiwacza za mega rzadkie skarby
	 */
	public int getHunterPoints() {
		return super.getHunterPoints();
	}
}
