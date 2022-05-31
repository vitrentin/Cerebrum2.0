package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela3 extends AppCompatActivity implements View.OnClickListener{
    private Button ma, mb, mc, md;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);
        ma = (Button) findViewById(R.id.ma);
        ma.setOnClickListener(this);
        mb = (Button) findViewById(R.id.mb);
        mb.setOnClickListener(this);
        mc = (Button) findViewById(R.id.mc);
        mc.setOnClickListener(this);
        md = (Button) findViewById(R.id.md);
        md.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == ma) {
            Intent i = new Intent(this, Tela3.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == mb) {
            Intent i = new Intent(this, Tela3.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == mc) {
            Intent i = new Intent(this, Tela3.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == md) {
            Intent i = new Intent(this, Tela3.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
    }
}