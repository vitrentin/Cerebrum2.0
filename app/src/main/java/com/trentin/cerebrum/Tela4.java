package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Tela4 extends AppCompatActivity implements View.OnClickListener{
    private Button qa, qb, qc, qd, proximoBtn;
    private ScrollView sview;
    private TextView questao, questoes;
    private Timer tempo;
    private int tempoTotalMin = 0, segundos = 0;
    private List<ListaDeQuestoes> listaDeQuestoes = new ArrayList<>();
    private List<ListaDeQuestoes> listaDeQuestoesTemp;
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
        sview = (ScrollView) findViewById(R.id.sviewq);
        proximoBtn = (Button) findViewById(R.id.proximo4);
        listaDeQuestoesTemp = BancoDeQuestoes.getQuestoes("quimica");
        Collections.shuffle(listaDeQuestoesTemp);
        for(int i=0;i<5;i++){
            listaDeQuestoes.add(listaDeQuestoesTemp.get(i));
        }
        final TextView timer = findViewById(R.id.tempoq);
        startTimer(timer);

        questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
        questao.setText(listaDeQuestoes.get(0).getQuestao());
        ArrayList<String> questions = new ArrayList<>();
        questions.add(listaDeQuestoes.get(0).getOp1());
        questions.add(listaDeQuestoes.get(0).getOp2());
        questions.add(listaDeQuestoes.get(0).getOp3());
        questions.add(listaDeQuestoes.get(0).getOp4());
        Collections.shuffle(questions);
        String ra = questions.get(0);
        String rb = questions.get(1);
        String rc = questions.get(2);
        String rd = questions.get(3);

        qa.setText(ra);
        qb.setText(rb);
        qc.setText(rc);
        qd.setText(rd);

        qa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = qa.getText().toString();
                    qa.setBackgroundResource(R.drawable.botao_vermelho);
                    qa.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
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
                    qb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
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
                    qc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
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
                    qd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
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
        if(indiceDeQuestaoAtual==0){
            sview.smoothScrollTo(0,0);
        }
        indiceDeQuestaoAtual++;
        if((indiceDeQuestaoAtual+1) == listaDeQuestoes.size()){
            proximoBtn.setText("Enviar quiz");
        }
        if(indiceDeQuestaoAtual < listaDeQuestoes.size()){
            opcaoSelecionada = "";
            qa.setBackgroundResource(R.drawable.voltar2);
            qa.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            qb.setBackgroundResource(R.drawable.voltar2);
            qb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            qc.setBackgroundResource(R.drawable.voltar2);
            qc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            qd.setBackgroundResource(R.drawable.voltar2);
            qd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));

            questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
            questao.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getQuestao());
            ArrayList<String> questions = new ArrayList<>();
            questions.add(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp1());
            questions.add(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp2());
            questions.add(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp3());
            questions.add(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp4());
            Collections.shuffle(questions);
            String ra = questions.get(0);
            String rb = questions.get(1);
            String rc = questions.get(2);
            String rd = questions.get(3);

            sview.smoothScrollTo(0,0);

            qa.setText(ra);
            qb.setText(rb);
            qc.setText(rc);
            qd.setText(rd);
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
                segundos++;
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        String minutosFinais = String.valueOf(tempoTotalMin);
                        String segundosFinais = String.valueOf(segundos);

                        if(segundos<10){
                            segundosFinais = "0"+segundosFinais;
                        }
                        if(tempoTotalMin<10){
                            minutosFinais = "0"+minutosFinais;
                        }
                        if(segundos == 59){
                            segundosFinais = "0";
                            segundos = 0;
                            segundosFinais = "0"+segundosFinais;
                            tempoTotalMin++;
                            minutosFinais = String.valueOf(tempoTotalMin);
                            minutosFinais = "0"+minutosFinais;
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
        tempo.purge();
        tempo.cancel();

        startActivity(new Intent(Tela4.this, Tela1.class));
        finish();
    }
    private void revelarResposta(){
        final String getResposta = listaDeQuestoes.get(indiceDeQuestaoAtual).getOpcerta();

        if(qa.getText().toString().equals(getResposta)){
            qa.setBackgroundResource(R.drawable.botao_verde);
            qa.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            qa.setTextColor(Color.WHITE);
        }
        else if(qb.getText().toString().equals(getResposta)){
            qb.setBackgroundResource(R.drawable.botao_verde);
            qb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            qb.setTextColor(Color.WHITE);
        }
        else if(qc.getText().toString().equals(getResposta)){
            qc.setBackgroundResource(R.drawable.botao_verde);
            qc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            qc.setTextColor(Color.WHITE);
        }
        else if(qd.getText().toString().equals(getResposta)){
            qd.setBackgroundResource(R.drawable.botao_verde);
            qd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
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