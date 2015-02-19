package dpp.android.underwateradventure;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;

public class main extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main_menu_layout);
		
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*
		 * // Inflate the menu; this adds items to the action bar if it is
		 * present. getMenuInflater().inflate(R.menu.main, menu);
		 */
		super.onCreateOptionsMenu(menu);

		// Konfiguracja obiektów nasłuchujących kliknięcia dla przycisków
		//Należy zakomentować, kiedy chcemy testować 2D
		View przyciskGra=findViewById(R.id.game);
		przyciskGra.setOnClickListener(this);
		View przyciskWyjscie = findViewById(R.id.exit);
		przyciskWyjscie.setOnClickListener(this);
		setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		return true;
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.game:
			Intent intencja=new  Intent(this, Gra.class);
			startActivity(intencja);
			break;
		case R.id.exit:
			finish();
			break;
		}
	}

}
