package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

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

public class Tela4 extends AppCompatActivity implements View.OnClickListener{
    private Button qa, qb, qc, qd, proximoBtn;
    private TextView questao, questoes;
    private Timer tempo;
    private int tempoTotalMin = 1, segundos = 0;
    private List<ListaDeQuestoes> listaDeQuestoes;
    private int indiceDeQuestaoAtual = 0;
    private String opcaoSelecionada = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela4);

        questoes = findViewById(R.id.questoesq);
        questao = findViewById(R.id.questaoq);

        final ImageView voltar = findViewById(R.id.voltar4);

        qa = (Button) findViewById(R.id.qa);
        //qa.setOnClickListener(this);
        qb = (Button) findViewById(R.id.qb);
        //qb.setOnClickListener(this);
        qc = (Button) findViewById(R.id.qc);
        //qc.setOnClickListener(this);
        qd = (Button) findViewById(R.id.qd);
        //qd.setOnClickListener(this);
        proximoBtn = (Button) findViewById(R.id.proximo4);
        listaDeQuestoes = BancoDeQuestoes.getQuestoes("quimica");
        final TextView timer = findViewById(R.id.tempoq);
        startTimer(timer);

        questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
        questao.setText(listaDeQuestoes.get(0).getQuestao());
        qa.setText(listaDeQuestoes.get(0).getOp1());
        qb.setText(listaDeQuestoes.get(0).getOp2());
        qc.setText(listaDeQuestoes.get(0).getOp3());
        qd.setText(listaDeQuestoes.get(0).getOp4());

        qa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = qa.getText().toString();
                    qa.setBackgroundResource(R.drawable.botao_vermelho);
                    qa.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        qb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = qb.getText().toString();
                    qb.setBackgroundResource(R.drawable.botao_vermelho);
                    qb.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        qc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = qc.getText().toString();
                    qc.setBackgroundResource(R.drawable.botao_vermelho);
                    qc.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        qd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = qd.getText().toString();
                    qd.setBackgroundResource(R.drawable.botao_vermelho);
                    qd.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        proximoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    Toast.makeText(Tela4.this, "Por favor, selecione uma opção", Toast.LENGTH_SHORT).show();
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

                startActivity(new Intent(Tela4.this, Tela1.class));
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
            qa.setBackgroundResource(R.drawable.voltar2);


            qb.setBackgroundResource(R.drawable.voltar2);


            qc.setBackgroundResource(R.drawable.voltar2);


            qd.setBackgroundResource(R.drawable.voltar2);


            questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
            questao.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getQuestao());
            qa.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp1());
            qb.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp2());
            qc.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp3());
            qd.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp4());
        }
        else{
            Intent intent = new Intent(Tela4.this, Tela6.class);
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
                    Toast.makeText(Tela4.this, "Tempo esgotado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Tela4.this, Tela6.class);
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

        startActivity(new Intent(Tela4.this, Tela1.class));
        finish();
    }
    private void revelarResposta(){
        final String getResposta = listaDeQuestoes.get(indiceDeQuestaoAtual).getOpcerta();

        if(qa.getText().toString().equals(getResposta)){
            qa.setBackgroundResource(R.drawable.botao_verde);
            qa.setTextColor(Color.WHITE);
        }
        else if(qb.getText().toString().equals(getResposta)){
            qb.setBackgroundResource(R.drawable.botao_verde);
            qb.setTextColor(Color.WHITE);
        }
        else if(qc.getText().toString().equals(getResposta)){
            qc.setBackgroundResource(R.drawable.botao_verde);
            qc.setTextColor(Color.WHITE);
        }
        else if(qd.getText().toString().equals(getResposta)){
            qd.setBackgroundResource(R.drawable.botao_verde);
            qd.setTextColor(Color.WHITE);
        }
    }
    @Override
    public void onClick(View view) {
        /*if (view == qa) {
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
        }*/
    }
}