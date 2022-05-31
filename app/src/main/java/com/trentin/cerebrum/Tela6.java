package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Tela6 extends AppCompatActivity implements View.OnClickListener{
    private Button menu, exit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela6);
        menu = (Button) findViewById(R.id.menu);
        menu.setOnClickListener(this);
        exit = (Button) findViewById(R.id.sair2);
        exit.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == menu) {
            Intent i = new Intent(this, Tela1.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == exit) {
            finishAffinity();
        }
    }

}