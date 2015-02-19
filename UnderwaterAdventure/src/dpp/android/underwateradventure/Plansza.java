package dpp.android.underwateradventure;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;


/**
 * Klasa odpowiadająca za rysowanie planszy naszej gry
 * @author dpp
 *
 */
public class Plansza extends View {

	//Rozmiary plansz mają być 2/3 wysokości
	private static int wysokosc;
	private static int szerokosc;
	
	private static int poleWysokosc;
	private static int poleSzerokosc;
	
	
	private Rect backgroundRectangle;//Prostokąt tła planszy
	public Plansza(Context context) {
		super(context);
		
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected void onSizeChanged(int s, int w, int staras, int staraw){
		wysokosc=getHeight()/3*2;
		szerokosc=getWidth();
		poleWysokosc=wysokosc/5;
		poleSzerokosc=szerokosc/5;
		backgroundRectangle=new Rect();
		backgroundRectangle.set(0,0,szerokosc,wysokosc);
		super.onSizeChanged(s, w, staras, staraw);
	}
	
	@SuppressLint("ResourceAsColor")
	@Override
	protected void onDraw(Canvas plotno) {
		
		Paint tlo=new Paint();
		tlo.setColor(getResources().getColor(R.color.main_board));
		//Rysuje prostokąt planszy
		plotno.drawRect(backgroundRectangle, tlo);
		
		
		//Odpowiada za linie siatki planszy
		Paint lines=new Paint();
		lines.setColor(getResources().getColor(R.color.board_line));
		//Rysuje planszę
		
		for(int i=0; i<6; i++){
			//Linie pionowe
			plotno.drawLine(i*poleSzerokosc, 0, i*poleSzerokosc, wysokosc, lines);
			//Linie poziome
			plotno.drawLine(0, i*poleWysokosc, szerokosc, i*poleWysokosc, lines);
		}
		
		
		
	}

}
