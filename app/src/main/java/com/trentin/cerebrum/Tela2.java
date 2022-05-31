package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela2 extends AppCompatActivity implements View.OnClickListener{
    private Button pa, pb, pc, pd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);
        pa = (Button) findViewById(R.id.pa);
        pa.setOnClickListener(this);
        pb = (Button) findViewById(R.id.pb);
        pb.setOnClickListener(this);
        pc = (Button) findViewById(R.id.pc);
        pc.setOnClickListener(this);
        pd = (Button) findViewById(R.id.pd);
        pd.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == pa) {
            Intent i = new Intent(this, Tela2.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == pb) {
            Intent i = new Intent(this, Tela2.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == pc) {
            Intent i = new Intent(this, Tela2.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == pd) {
            Intent i = new Intent(this, Tela2.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
    }
}