package dpp.android.underwateradventure.game;

import dpp.android.underwateradventure.R;
import dpp.android.underwateradventure.R.layout;
import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;

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
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		plansza = new Plansza(this);
		//setContentView(plansza);
		plansza.setTop(50);
		
		LinearLayout l=new LinearLayout(this);
		l.setOrientation(LinearLayout.VERTICAL);
		
		
		LayoutInflater li = this.getLayoutInflater();
		
		
		l.addView(plansza);
		li.inflate(R.layout.game_gui_layout, l);
		
		setContentView(l);
	}
}
