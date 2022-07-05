package com.trentin.cerebrum;



import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;


import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Tela6 extends AppCompatActivity implements View.OnClickListener{
    private Button menu, exit;
    private float contMateriap,contP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela6);
        menu = (Button) findViewById(R.id.menu);
        menu.setOnClickListener(this);
        exit = (Button) findViewById(R.id.sair2);
        exit.setOnClickListener(this);

        final TextView respostasCorretas = findViewById(R.id.respostascorretas);
        final TextView respostasCorretas2 = findViewById(R.id.acertos);
        final TextView respostasIncorretas = findViewById(R.id.respostasincorretas);
        final TextView repostasTotais = findViewById(R.id.total);

        final int getRespostasCorretas = getIntent().getIntExtra("totalp",0);
        final int getRespostasIncorretas = getIntent().getIntExtra("incorreta",0);
        final int getRespostasCorretas2 = getIntent().getIntExtra("correta",0);
        final float getContP = getIntent().getFloatExtra("contMateriap",0);
        final int getRespostasTotais = (getRespostasCorretas2 + getRespostasIncorretas);
        contP = getContP;
        contMateriap = getRespostasCorretas2;
        respostasCorretas.setText(String.valueOf(getRespostasCorretas));
        respostasCorretas2.setText(String.valueOf(getRespostasCorretas2));
        respostasIncorretas.setText(String.valueOf(getRespostasIncorretas));
        repostasTotais.setText(String.valueOf(getRespostasTotais));
    }

    @Override
    public void onClick(View view) {
        if (view == menu) {
            Intent i = new Intent(this, Tela1.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            i.putExtra("contMateriap", contP);
            startActivity(i);
        }
        if (view == exit) {
            finishAffinity();
        }
    }

}