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

public class Tela2 extends AppCompatActivity implements View.OnClickListener{
    private Button pa, pb, pc, pd, proximoBtn;
    private TextView questao, questoes;
    private Timer tempo;
    private int tempoTotalMin = 1, segundos = 0;
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
        //final TextView selecionarMaterias = findViewById(R.id.materias);
        //final String getSelecionarMaterias = getIntent().getStringExtra("selecionarMateria");
        //selecionarMateria.setText(getSelecionarMateria);
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
            //pa.setTextColor(Color.parseColor("#1F6BB8"));

            pb.setBackgroundResource(R.drawable.voltar2);


            pc.setBackgroundResource(R.drawable.voltar2);


            pd.setBackgroundResource(R.drawable.voltar2);


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
                if(segundos == 0){
                    tempoTotalMin--;
                    segundos = 59;
                }
                else if(segundos == 1 && tempoTotalMin == 0){
                    tempo.purge();
                    tempo.cancel();
                    Toast.makeText(Tela2.this, "Tempo esgotado", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(Tela2.this, Tela6.class);
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

        startActivity(new Intent(Tela2.this, Tela1.class));
        finish();
    }
    private void revelarResposta(){
        final String getResposta = listaDeQuestoes.get(indiceDeQuestaoAtual).getOpcerta();

        if(pa.getText().toString().equals(getResposta)){
            pa.setBackgroundResource(R.drawable.botao_verde);
            pa.setTextColor(Color.WHITE);
        }
        else if(pb.getText().toString().equals(getResposta)){
            pb.setBackgroundResource(R.drawable.botao_verde);
            pb.setTextColor(Color.WHITE);
        }
        else if(pc.getText().toString().equals(getResposta)){
            pc.setBackgroundResource(R.drawable.botao_verde);
            pc.setTextColor(Color.WHITE);
        }
        else if(pd.getText().toString().equals(getResposta)){
            pd.setBackgroundResource(R.drawable.botao_verde);
            pd.setTextColor(Color.WHITE);
        }
    }
    @Override
    public void onClick(View view) {
       /* if (view == pa) {
            Intent i = new Intent(this, Tela2.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == pb) {
            Intent i = new Intent(this, Tela2.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == pc) {
            Intent i = new Intent(this, Tela2.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }
        if (view == pd) {
            Intent i = new Intent(this, Tela2.class);
            Bundle b = new Bundle();
            i.putExtras(b);
            startActivity(i);
        }*/
    }
}