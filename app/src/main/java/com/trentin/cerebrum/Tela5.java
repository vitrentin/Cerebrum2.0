package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Tela5 extends AppCompatActivity implements View.OnClickListener{
    private Button ga, gb, gc, gd,proximoBtn;
    private TextView questao, questoes;
    //private Timer tempo;
    //private int tempoTotalMin = 1, segundos = 0;
    private List<ListaDeQuestoes> listaDeQuestoes;
    private int indiceDeQuestaoAtual = 0;
    private String opcaoSelecionada = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela5);

        questoes = findViewById(R.id.questoesg);
        questao = findViewById(R.id.questaog);

        final ImageView voltar = findViewById(R.id.voltar5);

        ga = (Button) findViewById(R.id.ga);
        //ga.setOnClickListener(this);
        gb = (Button) findViewById(R.id.gb);
        //gb.setOnClickListener(this);
        gc = (Button) findViewById(R.id.gc);
        //gc.setOnClickListener(this);
        gd = (Button) findViewById(R.id.gd);
        //gd.setOnClickListener(this);
        proximoBtn = (Button) findViewById(R.id.proximo5);
        listaDeQuestoes = BancoDeQuestoes.getQuestoes("geografia");
        final TextView timer = findViewById(R.id.tempog);
       // startTimer(timer);

        questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
        questao.setText(listaDeQuestoes.get(0).getQuestao());
        ga.setText(listaDeQuestoes.get(0).getOp1());
        gb.setText(listaDeQuestoes.get(0).getOp2());
        gc.setText(listaDeQuestoes.get(0).getOp3());
        gd.setText(listaDeQuestoes.get(0).getOp4());

        ga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = ga.getText().toString();
                    ga.setBackgroundResource(R.drawable.botao_vermelho);
                    ga.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    ga.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        gb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = gb.getText().toString();
                    gb.setBackgroundResource(R.drawable.botao_vermelho);
                    gb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    gb.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        gc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = gc.getText().toString();
                    gc.setBackgroundResource(R.drawable.botao_vermelho);
                    gc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    gc.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        gd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = gd.getText().toString();
                    gd.setBackgroundResource(R.drawable.botao_vermelho);
                    gd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    gd.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        proximoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    Toast.makeText(Tela5.this, "Por favor, selecione uma opção", Toast.LENGTH_SHORT).show();
                }
                else{
                    mudarProximaQuestao();
                }
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //tempo.purge();
                //tempo.cancel();

                startActivity(new Intent(Tela5.this, Tela1.class));
                finish();
            }
        });
    }
    private void mudarProximaQuestao(){
        indiceDeQuestaoAtual++;
        if((indiceDeQuestaoAtual+1) == listaDeQuestoes.size()){
            proximoBtn.setText("Enviar quiz");
        }
        if(indiceDeQuestaoAtual < listaDeQuestoes.size()){
            opcaoSelecionada = "";
            ga.setBackgroundResource(R.drawable.voltar2);
            ga.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            gb.setBackgroundResource(R.drawable.voltar2);
            gb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            gc.setBackgroundResource(R.drawable.voltar2);
            gc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            gd.setBackgroundResource(R.drawable.voltar2);
            gd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));

            questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
            questao.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getQuestao());
            ga.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp1());
            gb.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp2());
            gc.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp3());
            gd.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp4());
        }
        else{
            Intent intent = new Intent(Tela5.this, Tela6.class);
            intent.putExtra("correta",getRespostasCorretas());
            intent.putExtra("incorreta",getRespostasIncorretas());
            startActivity(intent);

            finish();
        }
    }
    /*
    private void startTimer(TextView timer){
        tempo = new Timer();
        tempo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(segundos == 0){
                    tempoTotalMin--;
                    segundos = 5;
                }
                else if(segundos == 1 && tempoTotalMin == 0){
                    tempo.purge();
                    tempo.cancel();
                    Toast.makeText(Tela5.this, "Tempo esgotado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Tela5.this, Tela1.class);
                    //intent.putExtra("coreta",getRespostasCorretas());
                    //intent.putExtra("incorreta", getRespostasIncorretas());
                    startActivity(intent);

                    finish();
                }
                else{
                    segundos--;
                }
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String minutosFinais = String.valueOf(tempoTotalMin);
                        String segundosFinais = String.valueOf(segundos);

                        if(minutosFinais.length() == 1){
                            minutosFinais = "0"+minutosFinais;
                        }
                        if(segundosFinais.length() == 1){
                            segundosFinais = "0"+segundosFinais;
                        }
                        timer.setText(minutosFinais+":"+segundosFinais);
                    }
                });
            }
        }, 1000,1000);
    }*/
    private int getRespostasCorretas(){
        int respostasCorretas = 0;
        for(int i=0;i<listaDeQuestoes.size();i++){
            final String getRespostaSelecionada = listaDeQuestoes.get(i).getRespostaSelecionada();
            final String getRespostas = listaDeQuestoes.get(i).getOpcerta();

            if(getRespostaSelecionada.equals(getRespostas)){
                respostasCorretas++;
            }
        }
        return respostasCorretas;
    }
    private int getRespostasIncorretas(){
        int respostasIncorretas = 0;
        for(int i=0;i<listaDeQuestoes.size();i++){
            final String getRespostaSelecionada = listaDeQuestoes.get(i).getRespostaSelecionada();
            final String getRespostas = listaDeQuestoes.get(i).getOpcerta();

            if(!getRespostaSelecionada.equals(getRespostas)){
                respostasIncorretas++;
            }
        }
        return respostasIncorretas;
    }
    @Override
    public void onBackPressed() {
        //tempo.purge();
        //tempo.cancel();

        startActivity(new Intent(Tela5.this, Tela1.class));
        finish();
    }
    private void revelarResposta(){
        final String getResposta = listaDeQuestoes.get(indiceDeQuestaoAtual).getOpcerta();

        if(ga.getText().toString().equals(getResposta)){
            ga.setBackgroundResource(R.drawable.botao_verde);
            ga.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            ga.setTextColor(Color.WHITE);
        }
        else if(gb.getText().toString().equals(getResposta)){
            gb.setBackgroundResource(R.drawable.botao_verde);
            gb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            gb.setTextColor(Color.WHITE);
        }
        else if(gc.getText().toString().equals(getResposta)){
            gc.setBackgroundResource(R.drawable.botao_verde);
            gc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            gc.setTextColor(Color.WHITE);
        }
        else if(gd.getText().toString().equals(getResposta)){
            gd.setBackgroundResource(R.drawable.botao_verde);
            gd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            gd.setTextColor(Color.WHITE);
        }
    }
    @Override
    public void onClick(View view) {
       /* if (view == ga) {
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
        }*/
    }
}