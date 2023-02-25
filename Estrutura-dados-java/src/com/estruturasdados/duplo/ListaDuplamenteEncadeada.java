package com.estruturasdados.duplo;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;


    public ListaDuplamenteEncadeada(){
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    /*metodo para saber o tamanho da lista */
    public int size(){
        return tamanhoLista;
    }

    /*metodo para buscar um Nó */
    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    /*metodo para adicionar no fim da lista */
    public void add(T elemento){
        NoDuplo<T> novoNo = new NoDuplo<T>(elemento);
        novoNo.setNoProximo(null);
        novoNo.setNoPrevio(ultimoNo);

        if (primeiroNo == null) {
            primeiroNo = novoNo;
        }
        if (ultimoNo != null) {
            ultimoNo.setNoProximo(novoNo);
        }
        ultimoNo = novoNo;
        tamanhoLista++;
    }

    /*metodo para adicionar um elemento em qualquer lugar da lista */
    public void add(int index, T elemento){
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> novoNo = new NoDuplo<T>(elemento);
        novoNo.setNoProximo(noAuxiliar);

        if (novoNo.getNoProximo() != null) {
            novoNo.setNoPrevio(noAuxiliar.getNoPrevio());
            novoNo.getNoProximo().setNoPrevio(novoNo);
        }else{
            novoNo.setNoPrevio(ultimoNo);
            ultimoNo = novoNo;
        }

        if(index == 0){
            primeiroNo = novoNo;
        }else{
            novoNo.getNoPrevio().setNoProximo(novoNo);
        }
        tamanhoLista++;
    }
    /*metodo para remover um elemento */
    public void remove(int index){
        if (index == 0) {
            primeiroNo = primeiroNo.getNoProximo();
            if(primeiroNo != null){
                primeiroNo.setNoPrevio(null);
            }
        } else {
           NoDuplo<T> noAuxiliar = getNo(index);
           noAuxiliar.getNoPrevio().setNoProximo(noAuxiliar.getNoProximo());
           if(noAuxiliar != ultimoNo){
            noAuxiliar.getNoProximo().setNoPrevio(noAuxiliar.getNoPrevio());
           }else{
            ultimoNo = noAuxiliar;
           }

        }
        this.tamanhoLista--;
    }
    
    /*método auxiliar para outros metodos .para pegar o Nó */
    private NoDuplo<T> getNo(int index){

        NoDuplo<T> noAuxiliar = primeiroNo;

        for(int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    @Override
    public String toString() {
        String strRetorno = "";

        NoDuplo<T> noAuxiliar = primeiroNo;
        for(int i = 0; i< size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();

        }
        strRetorno += "null";
        return strRetorno;

    }
    
    
}