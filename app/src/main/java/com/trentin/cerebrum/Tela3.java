package com.trentin.cerebrum;

import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
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

public class Tela3 extends AppCompatActivity implements View.OnClickListener{
    private Button ma, mb, mc, md, proximoBtn;
    private ScrollView sview;
    private TextView questao, questoes;
    private Timer tempo;
    private int tempoTotalMin = 0, segundos = 0;
    private List<ListaDeQuestoes> listaDeQuestoes = new ArrayList<>();
    private List<ListaDeQuestoes> listaDeQuestoesTemp;
    private int indiceDeQuestaoAtual = 0;
    private String opcaoSelecionada = "";
    private ImageView imagemM;
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
        sview = (ScrollView) findViewById(R.id.sviewm);
        proximoBtn = (Button) findViewById(R.id.proximo3);
        imagemM = findViewById(R.id.imageM);
        listaDeQuestoesTemp = BancoDeQuestoes.getQuestoes("matematica");
        Collections.shuffle(listaDeQuestoesTemp);
        for(int i=0;i<5;i++){
            listaDeQuestoes.add(listaDeQuestoesTemp.get(i));
        }
        final TextView timer = findViewById(R.id.tempom);
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

        ma.setText(ra);
        mb.setText(rb);
        mc.setText(rc);
        md.setText(rd);
        int img = listaDeQuestoes.get(0).getImagem();
        Drawable drawableM = getResources().getDrawable(img);
        imagemM.setImageDrawable(drawableM);
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
        for(int i=0; i< listaDeQuestoes.size();i++){
            if(indiceDeQuestaoAtual==i){
                sview.smoothScrollTo(0,0);
            }
        }
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
            int img = listaDeQuestoes.get(indiceDeQuestaoAtual).getImagem();
            Drawable drawableM = getResources().getDrawable(img);
            imagemM.setImageDrawable(drawableM);
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

            ma.setText(ra);
            mb.setText(rb);
            mc.setText(rc);
            md.setText(rd);
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