package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;



public class Tela1 extends AppCompatActivity implements View.OnClickListener{
    private Button portugues, matematica, quimica, geografia, todos;
    private float contMateriap,contP, total,res,res2;
   // private SharedPreferences cont = getPreferences(Context.MODE_PRIVATE);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela1);
        portugues = findViewById(R.id.portugues);
        portugues.setOnClickListener(this);
        matematica = findViewById(R.id.matematica);
        matematica.setOnClickListener(this);
        quimica = findViewById(R.id.quimica);
        quimica.setOnClickListener(this);
        geografia = findViewById(R.id.geografia);
        geografia.setOnClickListener(this);
        todos = findViewById(R.id.todas);
        todos.setOnClickListener(this);
        SharedPreferences shared = getSharedPreferences("sh",0);
        contP = getIntent().getFloatExtra("contMateriap",0);
        contMateriap += shared.getFloat("var",0);
        total = shared.getFloat("var2",0);
        res = (contMateriap/total)*100;
        SharedPreferences.Editor editor = shared.edit();
        res2 += contP;
        editor.putFloat("var3",res2);
        editor.commit();
        res2 = shared.getFloat("var3",0);
        String port = String.valueOf(res2)+"%"+" "+"Português";
        //portugues.setText(port);
        // 5 +5 10 +5 15 +5 20 +0 20 +10 30 +5 35
    }

    @Override
    public void onClick(View view) {
        if (view == portugues) {
            Intent i = new Intent(this, Tela2.class);
            i.putExtra("contMateriap",contMateriap);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == matematica) {
            Intent i = new Intent(this, Tela3.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == quimica) {
            Intent i = new Intent(this, Tela4.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == geografia) {
            Intent i = new Intent(this, Tela5.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == todos) {
            Intent i = new Intent(this, Todas.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
    }
}