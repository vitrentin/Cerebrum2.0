package com.trentin.cerebrum;

import android.content.Context;
import android.content.Intent;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Tela2 extends AppCompatActivity implements View.OnClickListener{
    private Button pa, pb, pc, pd, proximoBtn;
    private ScrollView sview;
    private TextView questao, questoes;
    private Timer tempo;
    private int tempoTotalMin = 0, segundos = 0;
    private float contMateria, cont;
    private final List<ListaDeQuestoes> listaDeQuestoes = new ArrayList<>();
    private List<ListaDeQuestoes> listaDeQuestoesTemp;
    private int indiceDeQuestaoAtual = 0;
    private String opcaoSelecionada = "";
    private ImageView imagemP;
    private LinearLayout telaP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        questoes = findViewById(R.id.questoesp);
        questao = findViewById(R.id.questaop);
        telaP = findViewById(R.id.telap);
        final ImageView voltar = findViewById(R.id.voltar2);
        pa = findViewById(R.id.pa);
        //pa.setOnClickListener(this);
        pb = findViewById(R.id.pb);
        //pb.setOnClickListener(this);
        pc = findViewById(R.id.pc);
        //pc.setOnClickListener(this);
        pd = findViewById(R.id.pd);
        //pd.setOnClickListener(this);
        sview = findViewById(R.id.sviewp);
        proximoBtn = findViewById(R.id.proximo2);
        imagemP = findViewById(R.id.imageP);
        final TextView timer = findViewById(R.id.tempop);
        listaDeQuestoesTemp = BancoDeQuestoes.getQuestoes("portugues");

      /*  if(listaDeQuestoes.get(0).getImagem() != 0){
            imagem = findViewById(listaDeQuestoes.get(0).getImagem());
        } */
        Collections.shuffle(listaDeQuestoesTemp);
        for(int i=0;i<5;i++){
            listaDeQuestoes.add(listaDeQuestoesTemp.get(i));
        }
        startTimer(timer);
        String indice = (indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size();
        questoes.setText(indice);
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

        pa.setText(ra);
        pb.setText(rb);
        pc.setText(rc);
        pd.setText(rd);
        int img = listaDeQuestoes.get(0).getImagem();
        Drawable drawableP = getResources().getDrawable(img);
        imagemP.setImageDrawable(drawableP);
        telaP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tela2.this, zoom.class);
                intent.putExtra("img",listaDeQuestoes.get(indiceDeQuestaoAtual).getImagem());
                intent.putExtra("texto",listaDeQuestoes.get(indiceDeQuestaoAtual).getQuestao());
                startActivity(intent);
            }

        });
        questao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tela2.this, zoom.class);
                intent.putExtra("img",listaDeQuestoes.get(indiceDeQuestaoAtual).getImagem());
                intent.putExtra("texto",listaDeQuestoes.get(indiceDeQuestaoAtual).getQuestao());
                startActivity(intent);
            }

        });
        imagemP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tela2.this, zoom.class);
                intent.putExtra("img",listaDeQuestoes.get(indiceDeQuestaoAtual).getImagem());
                intent.putExtra("texto",listaDeQuestoes.get(indiceDeQuestaoAtual).getQuestao());
                startActivity(intent);
            }

        });
        pa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = pa.getText().toString();
                    pa.setBackgroundResource(R.drawable.botao_vermelho);
                    pa.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    pa.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        pb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = pb.getText().toString();
                    pb.setBackgroundResource(R.drawable.botao_vermelho);
                    pb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    pb.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        pc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = pc.getText().toString();
                    pc.setBackgroundResource(R.drawable.botao_vermelho);
                    pc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    pc.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        pd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    opcaoSelecionada = pd.getText().toString();
                    pd.setBackgroundResource(R.drawable.botao_vermelho);
                    pd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#CF2F2F")));
                    pd.setTextColor(Color.WHITE);

                    revelarResposta();

                    listaDeQuestoes.get(indiceDeQuestaoAtual).setRespostaSelecionada(opcaoSelecionada);
                }
            }
        });
        proximoBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(opcaoSelecionada.isEmpty()){
                    Toast.makeText(Tela2.this, "Por favor, selecione uma opção", Toast.LENGTH_SHORT).show();
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
                Intent i = new Intent(Tela2.this, Tela1.class);
                Bundle b = new Bundle();
                i.putExtras(b);
                startActivity(i);
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
            pa.setBackgroundResource(R.drawable.corner);
            pa.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            pb.setBackgroundResource(R.drawable.voltar2);
            pb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            pc.setBackgroundResource(R.drawable.voltar2);
            pc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            pd.setBackgroundResource(R.drawable.voltar2);
            pd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            String indice = (indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size();
            questoes.setText(indice);
           /* if(listaDeQuestoes.get(indiceDeQuestaoAtual).getImagem() != 0){
                imagem = findViewById(listaDeQuestoes.get(indiceDeQuestaoAtual).getImagem());
            } */

            int img = listaDeQuestoes.get(indiceDeQuestaoAtual).getImagem();
            Drawable drawableP = getResources().getDrawable(img);
            imagemP.setImageDrawable(drawableP);
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

            pa.setText(ra);
            pb.setText(rb);
            pc.setText(rc);
            pd.setText(rd);
        }
        else{
            float t = listaDeQuestoes.size();
            //t = total.getInt("totalp", t);
            Intent intent = new Intent(Tela2.this, Tela6.class);
            intent.putExtra("correta",getRespostasCorretas());
            intent.putExtra("incorreta",getRespostasIncorretas());
            intent.putExtra("contMateriap", cont);
            intent.putExtra("totalp",listaDeQuestoesTemp.size());
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
                        String tempo = minutosFinais+":"+segundosFinais;
                        timer.setText(tempo);
                    }
                });
            }
        }, 1000,1000);
    }
    private int getRespostasCorretas(){
        int respostasCorretas = 0;
        final float contP = getIntent().getFloatExtra("contMateriap",0);
        cont = contP;
        for(int i=0;i<listaDeQuestoes.size();i++){
            final String getRespostaSelecionada = listaDeQuestoes.get(i).getRespostaSelecionada();
            final String getRespostas = listaDeQuestoes.get(i).getOpcerta();

            if(getRespostaSelecionada.compareToIgnoreCase(getRespostas)==0){
                Boolean getCheca = listaDeQuestoesTemp.get(i).getCheca();
                SharedPreferences shared = getSharedPreferences("sh",0);
                SharedPreferences.Editor editor = shared.edit();
                editor.putFloat("var",contMateria);
                if(getCheca == false){
                    getCheca = true;
                    listaDeQuestoesTemp.get(i).setCheca(getCheca);
                    contMateria++;
                    cont++;
                    contMateria = shared.getFloat("var",0);

                }
                editor.commit();
                respostasCorretas++;
                editor.putFloat("var2",listaDeQuestoesTemp.size()); // 20
            }

        }
        /*
        if(getCheca == false){
                getCheca = true;
                listaDeQuestoes.get(i).setCheca(getCheca);
                contMateria++;
            }
            if(getRespostaSelecionada.compareToIgnoreCase(getRespostas)==0){
                respostasCorretas++;
                SharedPreferences shared = getSharedPreferences("sh",0);
                SharedPreferences.Editor editor = shared.edit();
                editor.putFloat("var",contMateria);
                editor.putFloat("var2",listaDeQuestoesTemp.size());
                editor.commit();
            }
         */
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

        startActivity(new Intent(Tela2.this, Tela1.class));
        finish();
    }
    private void revelarResposta(){
        final String getResposta = listaDeQuestoes.get(indiceDeQuestaoAtual).getOpcerta();

        if(pa.getText().toString().equals(getResposta)){
            pa.setBackgroundResource(R.drawable.botao_verde);
            pa.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            pa.setTextColor(Color.WHITE);
        }
        else if(pb.getText().toString().equals(getResposta)){
            pb.setBackgroundResource(R.drawable.botao_verde);
            pb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            pb.setTextColor(Color.WHITE);
        }
        else if(pc.getText().toString().equals(getResposta)){
            pc.setBackgroundResource(R.drawable.botao_verde);
            pc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            pc.setTextColor(Color.WHITE);
        }
        else if(pd.getText().toString().equals(getResposta)){
            pd.setBackgroundResource(R.drawable.botao_verde);
            pd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#55BD44")));
            pd.setTextColor(Color.WHITE);
        }
    }
    @Override
    public void onClick(View view) {
    }
}