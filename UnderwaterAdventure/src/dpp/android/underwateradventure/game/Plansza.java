package dpp.android.underwateradventure.game;

import dpp.android.underwateradventure.R;
import dpp.android.underwateradventure.R.color;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.FontMetrics;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.view.View;


/**
 * Klasa odpowiadająca za rysowanie planszy naszej gry
 * @author dpp
 *
 */
public class Plansza extends View {
	
	//TODO: Trzeba zrobić, żeby zaznaczały się ALBO NIEBIESKIE ALBO CZERWONE kości
	
	//Rozmiary plansz mają być 2/3 wysokości
	private static int wysokosc;
	private static int szerokosc;
	
	private static int poleWysokosc;
	private static int poleSzerokosc;

	
	/**
	 * Flaga oznaczająca czy gracz zdecydował się wrócić na powierzchnię
	 */
	private static boolean END;
	/**
	 * String
	 */
	private String startOrFinish;
	
	private Rect backgroundRectangle;//Prostokąt tła planszy
	
	/**
	 * Prostokąt oznaczający pozycję gracza
	 */
	private Rect playerRect;
	
	//Zmienne oznaczające pozycję gracza na planszy
	private int playerPositionX=0;
	private int playerPositionY=0;
	
	public Plansza(Context context) {
		super(context);	
		// TODO Auto-generated constructor stub
		startOrFinish="START";
		END=false;
	}
	
	/**
	 * Metoda zwracająca true w przypadku, gdy gracz zdecyduje się wracać na powierzchnię
	 * @return TRUE w przypadku, gdy gracz zdecyduje się wracać
	 */
	public static boolean isEND() {
		return END;
	}
	
	/**
	 * Ustawia flagę powrotu na powierzchnię
	 * @param eND True w przypadku decyzji o powrocie
	 */
	public static void setEND(boolean eND) {
		END = eND;
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
		playerRect=new Rect(playerPositionX, playerPositionY, playerPositionX+poleSzerokosc, playerPositionY+poleWysokosc);
		
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
		
		//WSTAWIANIE CYFR
		Paint rysujacyCyfry=new Paint();
		rysujacyCyfry.setStyle(Style.FILL);
		rysujacyCyfry.setTextSize(poleWysokosc*0.25f);//Ustawienie wielkości tekstu na 3/4 wysokości pola
		rysujacyCyfry.setTextScaleX(poleSzerokosc/poleWysokosc);
		rysujacyCyfry.setTextAlign(Paint.Align.CENTER);
		
		//Rysowanie na środku
		FontMetrics fm=rysujacyCyfry.getFontMetrics();
		float x=poleSzerokosc/2;
		float y=poleWysokosc/2-(fm.ascent+fm.descent)/2;
		
		Paint pl=new Paint();
		pl.setColor(getResources().getColor(R.color.player_color));
		//Rysowanie pozycji gracza
		plotno.drawRect(playerRect, pl);
		
		//Rysowanie wypełnienia planszy
		plotno.drawText(startOrFinish, x, y, rysujacyCyfry);
		int licznik=1;
		for(int i=0; i<5; i++){
			for(int j=0; j<5; j++){
				
				if(i==0 && j==0){
					//Rysowanie startu
					plotno.drawText(startOrFinish, x, y, rysujacyCyfry);
				}else{
					//Rysowanie kolejnych numerków planszy
					plotno.drawText(licznik+"", j*poleSzerokosc+x, i*poleWysokosc+y, rysujacyCyfry);
					licznik++;
				}
				
			}
		}
		
		
			
	}

}
