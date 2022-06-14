package com.trentin.cerebrum;

public class ListaDeQuestoes {
    private String questao, op1, op2, op3, op4, opcerta, respostaSelecionada, materia;
    private Boolean checa;
    private int imagem;

    public ListaDeQuestoes(int imagem,Boolean checa,String materia,String questao, String op1, String op2, String op3, String op4, String opcerta,String respostaSelecionada) {
        this.imagem = imagem;
        this.checa = checa;
        this.materia = materia;
        this.questao = questao;
        this.op1 = op1;
        this.op2 = op2;
        this.op3 = op3;
        this.op4 = op4;
        this.opcerta = opcerta;
        this.respostaSelecionada = respostaSelecionada;
    }
    public int getImagem(){ return imagem;}
    public Boolean getCheca(){ return checa;}
    public String getMateria(){ return materia;}
    public String getQuestao() {
        return questao;
    }
    public String getOp1() {
        return op1;
    }
    public String getOp2() {
        return op2;
    }
    public String getOp3() {
        return op3;
    }
    public String getOp4() {
        return op4;
    }
    public String getOpcerta() {
        return opcerta;
    }
    public String getRespostaSelecionada() {
        return respostaSelecionada;
    }

    public void setRespostaSelecionada(String respostaSelecionada) {
        this.respostaSelecionada = respostaSelecionada;
    }
}
