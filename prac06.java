package com.example.manejograficos;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;



public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);
        setContentView(new EjemploView(this));
    }
    public class EjemploView extends View {
        private Drawable miImagen;
        public EjemploView (Context context)
        {
            super(context);
            Resources res=context.getResources();
            miImagen = res.getDrawable(R.drawable.mi_imagen);
            miImagen.setBounds(100,300,400,600);
        }
        @Override
        protected void onDraw(Canvas canvas) {
            Path path = new Path();
            path.moveTo(50,100);
            path.cubicTo(60,70,150,90,200,110);
            path.lineTo(300,200);
            Paint pincel1 = new Paint(); //Se crea un objeto Paint
            pincel1.setColor(Color.BLUE); //Se establece el color del pincel
            pincel1.setStrokeWidth(8); //Ancho del pincel
            pincel1.setStyle(Paint.Style.STROKE); //Estilo de la línea
            canvas.drawPath(path, pincel1);
            pincel1.setStrokeWidth(1);
            pincel1.setStyle(Paint.Style.FILL);
            pincel1.setTextSize(20);
            pincel1.setTypeface(Typeface.SANS_SERIF);
            canvas.drawTextOnPath("Programación de Dispositivos Móviles", path,
                    10, 40, pincel1);

            miImagen.draw(canvas);

        }
    }
}
