package dpp.android.underwateradventure.game;

import dpp.android.underwateradventure.treasures.Treasure;

/**
 * Klasa reprezentująca pole planszy z naszą grą
 * @author dpp
 *
 */
public class GameField {
	
	////////////////////////////////////////POLA
	//Numer pola
	private int fieldID;
	//Skarb, który może znaleźć się na danym polu
	private Treasure treasure;
	//Opcjonalna na polu może być butla z tlenem
	private int oxygen;
	//////////////////////////////////////METODY
	/**
	 * Konstruktor klasy GameField, tworzymy w nim identyfikator pola, 0 OZNACZA Start/Metę
	 * @param fieldID identyfikator pola 0 OZNACZA Start/Metę
	 */
	public GameField(int fieldID){
		this.fieldID=fieldID;
		//Tu trzeba wygenerować skarb :D
	}
	
}
