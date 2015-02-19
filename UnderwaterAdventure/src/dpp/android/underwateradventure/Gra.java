package dpp.android.underwateradventure;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

/**
 * Klasa reprezentuje grę i jej przebieg
 * 
 * @author dpp
 * 
 */
public class Gra extends Activity {

	private Plansza plansza;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		plansza = new Plansza(this);
		//setContentView(plansza);
		LinearLayout line=new LinearLayout(this);
		line.addView(plansza);
		setContentView(line);
	}
}
