package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela5 extends AppCompatActivity implements View.OnClickListener{
    private Button ga, gb, gc, gd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela5);
        ga = (Button) findViewById(R.id.ga);
        ga.setOnClickListener(this);
        gb = (Button) findViewById(R.id.gb);
        gb.setOnClickListener(this);
        gc = (Button) findViewById(R.id.gc);
        gc.setOnClickListener(this);
        gd = (Button) findViewById(R.id.gd);
        gd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == ga) {
            Intent i = new Intent(this, Tela5.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == gb) {
            Intent i = new Intent(this, Tela5.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == gc) {
            Intent i = new Intent(this, Tela5.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == gd) {
            Intent i = new Intent(this, Tela5.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
    }
}