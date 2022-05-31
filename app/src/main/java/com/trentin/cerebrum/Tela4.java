package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela4 extends AppCompatActivity implements View.OnClickListener{
    private Button qa, qb, qc, qd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4);
        qa = (Button) findViewById(R.id.ga);
        qa.setOnClickListener(this);
        qb = (Button) findViewById(R.id.gb);
        qb.setOnClickListener(this);
        qc = (Button) findViewById(R.id.gc);
        qc.setOnClickListener(this);
        qd = (Button) findViewById(R.id.gd);
        qd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == qa) {
            Intent i = new Intent(this, Tela4.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == qb) {
            Intent i = new Intent(this, Tela4.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == qc) {
            Intent i = new Intent(this, Tela4.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == qd) {
            Intent i = new Intent(this, Tela4.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
    }
}