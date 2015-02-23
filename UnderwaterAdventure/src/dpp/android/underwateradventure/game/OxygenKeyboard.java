package dpp.android.underwateradventure.game;

import java.util.Arrays;

import dpp.android.underwateradventure.R;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;

/**
 * Klasa odpowiadająca za pole, 
 * na którym będziemy wybierać pola, 
 * na których gracz chce umieścić dodatkowe zapasy tlenu (tlen jest zbierany automatycznie
 * @author dpp
 *
 */
public class OxygenKeyboard extends Dialog {

	protected static final String ZNACZNIK="OXYGEN KEYBOARD";
	
	private final Gra gra;
	
	//Tablica przechowywująca referencje do check boxów z okna dialogowego
	private final CheckBox[] klawisze=new CheckBox[24];
	private View przyciskGotowe;
	
	
	
	public OxygenKeyboard(Context context, Gra gra) {
		super(context);
		// TODO Auto-generated constructor stub
		this.gra=gra;
	}
	

	
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		setContentView(R.layout.oxygen_setter);
		setComponents();
		ustawNasluchiwanie();
		
	}
	
	/**
	 * Ustawia check boxy pod tablicę z informacjami i przycisk gotowy
	 */
	private void setComponents(){
		klawisze[0]=(CheckBox)findViewById(R.id.oxygen_1);
		klawisze[1]=(CheckBox)findViewById(R.id.oxygen_2);
		klawisze[2]=(CheckBox)findViewById(R.id.oxygen_3);
		klawisze[3]=(CheckBox)findViewById(R.id.oxygen_4);
		klawisze[4]=(CheckBox)findViewById(R.id.oxygen_5);
		klawisze[5]=(CheckBox)findViewById(R.id.oxygen_6);
		klawisze[6]=(CheckBox)findViewById(R.id.oxygen_7);
		klawisze[7]=(CheckBox)findViewById(R.id.oxygen_8);
		klawisze[8]=(CheckBox)findViewById(R.id.oxygen_9);
		klawisze[9]=(CheckBox)findViewById(R.id.oxygen_10);
		klawisze[10]=(CheckBox)findViewById(R.id.oxygen_11);
		klawisze[11]=(CheckBox)findViewById(R.id.oxygen_12);
		klawisze[12]=(CheckBox)findViewById(R.id.oxygen_13);
		klawisze[13]=(CheckBox)findViewById(R.id.oxygen_14);
		klawisze[14]=(CheckBox)findViewById(R.id.oxygen_15);
		klawisze[15]=(CheckBox)findViewById(R.id.oxygen_16);
		klawisze[16]=(CheckBox)findViewById(R.id.oxygen_17);
		klawisze[17]=(CheckBox)findViewById(R.id.oxygen_18);
		klawisze[18]=(CheckBox)findViewById(R.id.oxygen_19);
		klawisze[19]=(CheckBox)findViewById(R.id.oxygen_20);
		klawisze[20]=(CheckBox)findViewById(R.id.oxygen_21);
		klawisze[21]=(CheckBox)findViewById(R.id.oxygen_22);
		klawisze[22]=(CheckBox)findViewById(R.id.oxygen_23);
		klawisze[23]=(CheckBox)findViewById(R.id.oxygen_24);
		
		przyciskGotowe=findViewById(R.id.button_oxygen_ready);
	}
	
	/**
	 * Metoda ustawia obiekty nasłuchujące na check boxy i przycisk zakończenia
	 */
	private void ustawNasluchiwanie(){
		
		/*Najpierw trzeba ustawić nasłuchiwanie dla Check Boxów, jeśli jakiś zostanie wciśnięty
		 * trzeba sprawdzić, czy wciśnięto już ich 5 i jeśli tak, to trzeba pozostałe powyłączać, 
		 * a jeśli nie to nic nie robić, względnie, gdy się odznaczy jakiś to trzeba je na nowo 
		 * uruchomić*/
		for(int i=0; i<klawisze.length; i++){
			
			klawisze[i].setOnCheckedChangeListener(new OnCheckedChangeListener() {
				
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
					// TODO Wstawić metodę, która robi to co jest w komentarzu powyżej
					checkCheckBoxFields();
				}
			});
		}
		
		/*Potem trzeba ustawić przycisk zakończenie, który odpali TYLKO WTEDY GDY ZOSTANIE ZAZNACZONE 
		 * 5 butli z tlenem*/	
		przyciskGotowe.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Wstawić jakąś metodę, która w tym miejscu zadziała
				checkButton();
			}
		});
		
	}
	
	/**
	 * Metoda zajmuje się sprawdzeniem, czy 5 pól zostało zaznaczonych
	 */
	private void checkCheckBoxFields(){
		int border=5, counter=0;
		
		int[] zaznaczone=new int[5];
		
		Log.d(ZNACZNIK, "Uruchamiam sprawdzacz zgodności CheckBoxów");
		
		for(int i=0; i<klawisze.length; i++){
			if(klawisze[i].isChecked()){
				//Dodaj index do tablicy przechowująca zaznaczone elementy
				zaznaczone[counter]=i;
				counter++;			
			}
			if(counter==border){
				Log.d(ZNACZNIK, "Osiągnięto limit wyłączam nieużytki");
				
				/*Iterujemy się po polach, jeśli numerek któregoś się NIE zgadza wyłączamy go*/
				for(int j=0;j<klawisze.length; j++){
					if(!klawisze[j].isChecked())
						klawisze[j].setEnabled(false);
				}
				break;
			}else{
				Log.d(ZNACZNIK, "Limit nieosiągnięty robię enable'a na wszystkich");
				for(int j=0; j<klawisze.length; j++){
						klawisze[j].setEnabled(true);
				}
			}
		}
		
	}
	
	/**
	 * Metoda sprawdza, które pola zostały oznaczone i jeśli wszystko się zgadza głowne pole z 
	 * zaznaczonymi polami zostaje ustawione
	 */
	private void checkButton(){
		int border=5, counter=0;
		
		int[] zaznaczone=new int[5];
		
		Log.d(ZNACZNIK, "Uruchamiam sprawdzacz zgodności przycisku do checkboxów");
		
		for(int i=0; i<klawisze.length; i++){
			if(klawisze[i].isChecked()){
				zaznaczone[counter]=i;
				counter++;
				if(counter==border){
					//Skoro osiągnięto limit wrzuć w odpowiednie miejsce oznaczone pola
					//Trzeba je najpierw posortować, bo nie wiemy w jakiej kolejności użytkownik je wprowadzał
					Arrays.sort(zaznaczone);
					Log.d(ZNACZNIK, "Uruchamiam sprawdzacz zgodności przycisku do checkboxów "+"posortowane "+checkSort(zaznaczone));
					gra.setOxygenFields(zaznaczone);
					gra.setOxygenSet(true);
					dismiss();
					break;
				}
			}
		}
	}
	
	/**
	 * Metoda dla debuggera, sprawdzamy, czy została posortowana tablica dla butli z tlenem
	 */
	private String checkSort(int [] tab){
		StringBuilder sb=new StringBuilder();
		for(int i=0; i<tab.length; i++){
			sb.append(tab[i]);
			sb.append(" ");
		}
		
		return sb.toString();
	}



}
