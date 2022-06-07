package com.trentin.cerebrum;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
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

public class Todas extends AppCompatActivity implements View.OnClickListener{
    private Button ta,tb,tc,td, proximoBtn;
    private ScrollView sview;
    private TextView questao, questoes, selecionarMaterias;
    private Timer tempo;
    private int tempoTotalMin = 0, segundos = 0;
    private List<ListaDeQuestoes> listaDeQuestoes = new ArrayList<>();
    private List<ListaDeQuestoes> listaDeQuestoesTemp;
    private int indiceDeQuestaoAtual = 0;
    private String opcaoSelecionada = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_todas);

        questoes = findViewById(R.id.questoestodas);
        questao = findViewById(R.id.questaotodas);

        final ImageView voltar = findViewById(R.id.voltar6);

        ta = (Button) findViewById(R.id.qta);

        tb = (Button) findViewById(R.id.qtb);

        tc = (Button) findViewById(R.id.qtc);

        td = (Button) findViewById(R.id.qtd);

        selecionarMaterias = (TextView) findViewById(R.id.materia);
        //String getSelecionarMaterias = getIntent().getStringExtra("selecionarMateria");
        //selecionarMateria.setText(getSelecionarMateria);
        sview = (ScrollView) findViewById(R.id.sviewt);
        proximoBtn = (Button) findViewById(R.id.proximo6);
        listaDeQuestoesTemp = BancoDeQuestoes.getQuestoes("todas");
        Collections.shuffle(listaDeQuestoesTemp);
        for(int i=0;i<10;i++){
            listaDeQuestoes.add(listaDeQuestoesTemp.get(i));
        }
        final TextView timer = findViewById(R.id.tempotodas);
        startTimer(timer);
        selecionarMaterias.setText(listaDeQuestoes.get(0).getMateria());
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

        ta.setText(ra);
        tb.setText(rb);
        tc.setText(rc);
        td.setText(rd);

        ta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = ta.getText().toString();
                    ta.setBackgroundResource(R.drawable.botao_vermelho);
                    ta.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    ta.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = tb.getText().toString();
                    tb.setBackgroundResource(R.drawable.botao_vermelho);
                    tb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    //tb.setBackgroundResource(R.color.red);
                    tb.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        tc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = tc.getText().toString();
                    tc.setBackgroundResource(R.drawable.botao_vermelho);
                    tc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    tc.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        td.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = td.getText().toString();
                    td.setBackgroundResource(R.drawable.botao_vermelho);
                    td.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    td.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        proximoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    Toast.makeText(Todas.this, "Por favor, selecione uma opção", Toast.LENGTH_SHORT).show();
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

                startActivity(new Intent(Todas.this, Tela1.class));
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
            ta.setBackgroundResource(R.drawable.voltar2);
            ta.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            tb.setBackgroundResource(R.drawable.voltar2);
            tb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            tc.setBackgroundResource(R.drawable.voltar2);
            tc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            td.setBackgroundResource(R.drawable.voltar2);
            td.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));

            questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
            selecionarMaterias.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getMateria());
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

            ta.setText(ra);
            tb.setText(rb);
            tc.setText(rc);
            td.setText(rd);
        }
        else{
            Intent intent = new Intent(Todas.this, Tela6.class);
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
        startActivity(new Intent(Todas.this, Tela1.class));
        finish();
    }
    private void revelarResposta(){
        final String getResposta = listaDeQuestoes.get(indiceDeQuestaoAtual).getOpcerta();

        if(ta.getText().toString().equals(getResposta)){
            ta.setBackgroundResource(R.drawable.botao_verde);
            ta.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            ta.setTextColor(Color.WHITE);
        }
        else if(tb.getText().toString().equals(getResposta)){
            tb.setBackgroundResource(R.drawable.botao_verde);
            tb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            tb.setTextColor(Color.WHITE);
        }
        else if(tc.getText().toString().equals(getResposta)){
            tc.setBackgroundResource(R.drawable.botao_verde);
            tc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            tc.setTextColor(Color.WHITE);
        }
        else if(td.getText().toString().equals(getResposta)){
            td.setBackgroundResource(R.drawable.botao_verde);
            td.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            td.setTextColor(Color.WHITE);
        }
    }
    @Override
    public void onClick(View view) {
    }
}