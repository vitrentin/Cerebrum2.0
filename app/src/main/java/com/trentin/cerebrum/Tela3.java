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

public class Tela3 extends AppCompatActivity implements View.OnClickListener{
    private Button ma, mb, mc, md, proximoBtn;
    private TextView questao, questoes;
    private Timer tempo;
    private int tempoTotalMin = 1, segundos = 0;
    private List<ListaDeQuestoes> listaDeQuestoes;
    private int indiceDeQuestaoAtual = 0;
    private String opcaoSelecionada = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela3);

        questoes = findViewById(R.id.questoesm);
        questao = findViewById(R.id.questaom);

        final ImageView voltar = findViewById(R.id.voltar3);

        ma = (Button) findViewById(R.id.ma);
        //ma.setOnClickListener(this);
        mb = (Button) findViewById(R.id.mb);
        //mb.setOnClickListener(this);
        mc = (Button) findViewById(R.id.mc);
        //mc.setOnClickListener(this);
        md = (Button) findViewById(R.id.md);
        //md.setOnClickListener(this);
        proximoBtn = (Button) findViewById(R.id.proximo3);
        listaDeQuestoes = BancoDeQuestoes.getQuestoes("matematica");
        final TextView timer = findViewById(R.id.tempom);
        startTimer(timer);

        questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
        questao.setText(listaDeQuestoes.get(0).getQuestao());
        ma.setText(listaDeQuestoes.get(0).getOp1());
        mb.setText(listaDeQuestoes.get(0).getOp2());
        mc.setText(listaDeQuestoes.get(0).getOp3());
        md.setText(listaDeQuestoes.get(0).getOp4());

        ma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = ma.getText().toString();
                    ma.setBackgroundResource(R.drawable.botao_vermelho);
                    ma.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    ma.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        mb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = mb.getText().toString();
                    mb.setBackgroundResource(R.drawable.botao_vermelho);
                    mb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    mb.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        mc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = mc.getText().toString();
                    mc.setBackgroundResource(R.drawable.botao_vermelho);
                    mc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    mc.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        md.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = md.getText().toString();
                    md.setBackgroundResource(R.drawable.botao_vermelho);
                    md.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    md.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        proximoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    Toast.makeText(Tela3.this, "Por favor, selecione uma opção", Toast.LENGTH_SHORT).show();
                }
                else{
                    mudarProximaQuestao();
                }
            }
        });
        voltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tempo.purge();
                tempo.cancel();

                startActivity(new Intent(Tela3.this, Tela1.class));
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
            ma.setBackgroundResource(R.drawable.voltar2);
            ma.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            mb.setBackgroundResource(R.drawable.voltar2);
            mb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            mc.setBackgroundResource(R.drawable.voltar2);
            mc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            md.setBackgroundResource(R.drawable.voltar2);
            md.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));

            questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
            questao.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getQuestao());
            ma.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp1());
            mb.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp2());
            mc.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp3());
            md.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp4());
        }
        else{
            Intent intent = new Intent(Tela3.this, Tela6.class);
            intent.putExtra("correta",getRespostasCorretas());
            intent.putExtra("incorreta",getRespostasIncorretas());
            startActivity(intent);

            finish();
        }
    }
    private void startTimer(TextView timer){
        tempo = new Timer();
        tempo.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if(segundos == 0){
                    tempoTotalMin--;
                    segundos = 59;
                }
                else if(segundos == 1 && tempoTotalMin == 0){
                    tempo.purge();
                    tempo.cancel();
                    Toast.makeText(Tela3.this, "Tempo esgotado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Tela3.this, Tela6.class);
                    intent.putExtra("coreta",getRespostasCorretas());
                    intent.putExtra("incorreta", getRespostasIncorretas());
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
    }
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
        int respostasCorretas = 0;
        for(int i=0;i<listaDeQuestoes.size();i++){
            final String getRespostaSelecionada = listaDeQuestoes.get(i).getRespostaSelecionada();
            final String getRespostas = listaDeQuestoes.get(i).getOpcerta();

            if(!getRespostaSelecionada.equals(getRespostas)){
                respostasCorretas++;
            }
        }
        return respostasCorretas;
    }
    @Override
    public void onBackPressed() {
        tempo.purge();
        tempo.cancel();

        startActivity(new Intent(Tela3.this, Tela1.class));
        finish();
    }
    private void revelarResposta(){
        final String getResposta = listaDeQuestoes.get(indiceDeQuestaoAtual).getOpcerta();

        if(ma.getText().toString().equals(getResposta)){
            ma.setBackgroundResource(R.drawable.botao_verde);
            ma.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            ma.setTextColor(Color.WHITE);
        }
        else if(mb.getText().toString().equals(getResposta)){
            mb.setBackgroundResource(R.drawable.botao_verde);
            mb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            mb.setTextColor(Color.WHITE);
        }
        else if(mc.getText().toString().equals(getResposta)){
            mc.setBackgroundResource(R.drawable.botao_verde);
            mc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            mc.setTextColor(Color.WHITE);
        }
        else if(md.getText().toString().equals(getResposta)){
            md.setBackgroundResource(R.drawable.botao_verde);
            md.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            md.setTextColor(Color.WHITE);
        }
    }
    @Override
    public void onClick(View view) {
       /* if (view == ma) {
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
        }*/
    }
}