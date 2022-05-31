package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela1 extends AppCompatActivity implements View.OnClickListener{
    private Button port, mat, quim, geo, tod;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        port = (Button) findViewById(R.id.portugues);
        port.setOnClickListener(this);
        mat = (Button) findViewById(R.id.matematica);
        mat.setOnClickListener(this);
        quim = (Button) findViewById(R.id.quimica);
        quim.setOnClickListener(this);
        geo = (Button) findViewById(R.id.geografia);
        geo.setOnClickListener(this);
        tod = (Button) findViewById(R.id.todas);
        tod.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == port) {
            Intent i = new Intent(this, Tela2.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == mat) {
            Intent i = new Intent(this, Tela3.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == quim) {
            Intent i = new Intent(this, Tela4.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == geo) {
            Intent i = new Intent(this, Tela5.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == tod) {
            Intent i = new Intent(this, Tela6.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
    }
}