package dpp.android.underwateradventure;

import android.app.Activity;
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
		LinearLayout l2=new LinearLayout(this);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(
	            LinearLayout.LayoutParams.MATCH_PARENT,
	            LinearLayout.LayoutParams.MATCH_PARENT);
		//l2.setLayoutParams(layoutParams);
		l2.setBackgroundColor(getResources().getColor(R.color.main_board));
		l.setOrientation(LinearLayout.VERTICAL);
		l2.setOrientation(LinearLayout.VERTICAL);
		Button b=new Button(this);
		b.setText("VAAAAAAAAAAAAAAAAAAAAAAT");
		Button b2=new Button(this);
		b2.setText("VAAAAAAAAAAAAAAAAAAAAAAT");
		
		l2.addView(b);
		
		
		
		
		l.addView(plansza);
		l.addView(l2);
		l.addView(b2);
		ScrollView sv=new ScrollView(this);
		//sv.addView(l);
		setContentView(l);
	}
}
