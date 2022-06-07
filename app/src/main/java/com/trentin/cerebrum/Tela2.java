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

public class Tela2 extends AppCompatActivity implements View.OnClickListener{
    private Button pa, pb, pc, pd, proximoBtn;
    private TextView questao, questoes;
    private Timer tempo;
    private int tempoTotalMin = 0, segundos = 0, contMateria=0;
    private List<ListaDeQuestoes> listaDeQuestoes;
    private int indiceDeQuestaoAtual = 0;
    private String opcaoSelecionada = "";
    //private final List<ListaDeQuestoes> listaDeQuestoes = new ArrayList<>();
    //private AppCompatButton op1, op2, op3,op4,opcerta, proximoBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela2);

        questoes = findViewById(R.id.questoesp);
        questao = findViewById(R.id.questaop);

        final ImageView voltar = findViewById(R.id.voltar2);
        pa = (Button) findViewById(R.id.pa);
        //pa.setOnClickListener(this);
        pb = (Button) findViewById(R.id.pb);
        //pb.setOnClickListener(this);
        pc = (Button) findViewById(R.id.pc);
        //pc.setOnClickListener(this);
        pd = (Button) findViewById(R.id.pd);
        //pd.setOnClickListener(this);
        proximoBtn = (Button) findViewById(R.id.proximo2);
        final TextView timer = findViewById(R.id.tempop);
        listaDeQuestoes = BancoDeQuestoes.getQuestoes("portugues");
        startTimer(timer);

        questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
        questao.setText(listaDeQuestoes.get(0).getQuestao());
        pa.setText(listaDeQuestoes.get(0).getOp1());
        pb.setText(listaDeQuestoes.get(0).getOp2());
        pc.setText(listaDeQuestoes.get(0).getOp3());
        pd.setText(listaDeQuestoes.get(0).getOp4());

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

                startActivity(new Intent(Tela2.this, Tela1.class));
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
            pa.setBackgroundResource(R.drawable.corner);
            pa.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            pb.setBackgroundResource(R.drawable.voltar2);
            pb.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            pc.setBackgroundResource(R.drawable.voltar2);
            pc.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));
            pd.setBackgroundResource(R.drawable.voltar2);
            pd.setBackgroundTintList(ColorStateList.valueOf(Color.parseColor("#9A4DA7")));

            questoes.setText((indiceDeQuestaoAtual+1)+"/"+listaDeQuestoes.size());
            questao.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getQuestao());
            pa.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp1());
            pb.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp2());
            pc.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp3());
            pd.setText(listaDeQuestoes.get(indiceDeQuestaoAtual).getOp4());
        }
        else{
            Intent intent = new Intent(Tela2.this, Tela6.class);
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
                Boolean getCheca = listaDeQuestoes.get(i).getCheca();
                if(!getCheca){
                    contMateria++;
                }
            }

        }
        return respostasCorretas;
    }
    public int getContMateria(){
        return contMateria;
    }
    public List<ListaDeQuestoes> getListaDeQuestoes(){
        return listaDeQuestoes;
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