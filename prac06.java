package com.example.graphics;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import android.content.res.Resources;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    public Drawable miImagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View{
        public EjemploView (Context context){
            super(context);
            Resources res = context.getResources();
            miImagen = res.getDrawable(R.drawable.mi_imagen);
            //miImagen = ResourcesCompat.getDrawable(getResources(), R.drawable.mi_imagen, null);
            miImagen.setBounds(30, 300, 400, 400);
        }
        @Override
        protected void onDraw(Canvas canvas){
           /* Paint pincel1 = new Paint(); //Create a new Paint object
            Paint pincel2 = new Paint(); //Create a new Paint object
            Paint pincel3 = new Paint();
            pincel1.setColor(Color.BLUE); //establish the color of the Paint object

            pincel1.setStrokeWidth(8); //Width of Paint object
            pincel1.setStyle(Paint.Style.STROKE); //Line style
            canvas.drawCircle(150,150,100,pincel1);//paint a circle

            //second circle color red
            pincel2.setColor(Color.argb(127, 255, 0, 0));
            canvas.drawCircle(200,200,100,pincel2);
            //third circle color green
            pincel3.setColor(Color.argb(100,0,255,0));
            pincel3.setStyle(Paint.Style.FILL);//line style
            canvas.drawCircle(250, 150, 100, pincel3);*/
            /*
            Path path = new Path();
            path.addCircle(150, 150, 100, Path.Direction.CW); //counter clockwise
            canvas.drawColor(Color.WHITE);

            Paint circlePaint = new Paint();
            Paint textPaint = new Paint();

            //pincel1.setColor(Color.BLUE); //stroke color

            circlePaint.setColor(Color.argb(0,0,0,255));
            circlePaint.setStrokeWidth(8); //stoke width
            circlePaint.setStyle(Paint.Style.STROKE); //stroke style
            //canvas.drawPath(path, pincel1);
            textPaint.setColor(Color.BLUE);
            textPaint.setStrokeWidth(1);
            textPaint.setStyle(Paint.Style.FILL);
            textPaint.setTextSize(20);
            textPaint.setTypeface(Typeface.SANS_SERIF);
            //drawing the circle
            canvas.drawPath(path, circlePaint);
            //drawing the text
            canvas.drawTextOnPath("Programming of mobile devices", path, 10, 40, textPaint);
            */

            /*
            Path path = new Path();
            path.moveTo(50, 100);
            path.cubicTo(60, 70,150, 90,200, 110);
            path.lineTo(300, 200);

            Paint pincel1 = new Paint();
            pincel1.setColor(Color.BLUE);
            pincel1.setStrokeWidth(8);
            pincel1.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, pincel1);
            pincel1.setStrokeWidth(1);
            pincel1.setStyle(Paint.Style.FILL);
            pincel1.setTextSize(20);
            pincel1.setTypeface(Typeface.SANS_SERIF);
            canvas.drawTextOnPath("Programming of mobile devices", path, 5, -10, pincel1);*/
            super.onDraw(canvas);
            Path path = new Path();
            path.moveTo(50, 100);
            path.cubicTo(60, 70, 150, 90, 200, 110);
            path.lineTo(300, 200);

            Paint pincel1 = new Paint();
            pincel1.setColor(Color.BLUE);
            pincel1.setStrokeWidth(8);
            pincel1.setStyle(Paint.Style.STROKE);
            canvas.drawPath(path, pincel1);
            pincel1.setStrokeWidth(1);
            pincel1.setStyle(Paint.Style.FILL);
            pincel1.setTextSize(20);
            pincel1.setTypeface(Typeface.SANS_SERIF);
            canvas.drawTextOnPath("Programming of mobile devices", path, 10, 40, pincel1);
            miImagen.draw(canvas);
        }
    }
}
