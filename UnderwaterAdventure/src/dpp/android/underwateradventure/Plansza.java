package dpp.android.underwateradventure;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
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
		wysokosc=getHeight();
		szerokosc=getWidth();
		poleWysokosc=wysokosc/5;
		poleSzerokosc=szerokosc/5;
		backgroundRectangle=new Rect();
		backgroundRectangle.set(0,0,szerokosc,wysokosc);
		super.onSizeChanged(s, w, staras, staraw);
	}
	
	@Override
	protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

	    int desiredWidth = getWidth();
	    int desiredHeight = getHeight();

	    int widthMode = MeasureSpec.getMode(widthMeasureSpec);
	    int widthSize = MeasureSpec.getSize(widthMeasureSpec);
	    int heightMode = MeasureSpec.getMode(heightMeasureSpec);
	    int heightSize = MeasureSpec.getSize(heightMeasureSpec);

	    int width;
	    int height;
	    width = widthSize;
	    height = heightSize/3*2;
	    /*//Measure Width
	    if (widthMode == MeasureSpec.EXACTLY) {
	        //Must be this size
	        width = widthSize;
	    } else if (widthMode == MeasureSpec.AT_MOST) {
	        //Can't be bigger than...
	        width = Math.min(desiredWidth, widthSize);
	    } else {
	        //Be whatever you want
	        width = desiredWidth;
	    }

	    //Measure Height
	    if (heightMode == MeasureSpec.EXACTLY) {
	        //Must be this size
	        height = heightSize;
	    } else if (heightMode == MeasureSpec.AT_MOST) {
	        //Can't be bigger than...
	        height = Math.min(desiredHeight, heightSize);
	    } else {
	        //Be whatever you want
	        height = desiredHeight;
	    }*/

	    //MUST CALL THIS
	    setMeasuredDimension(width, height);
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
