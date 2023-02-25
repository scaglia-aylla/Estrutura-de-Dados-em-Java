package com.estruturasdados.circular;

public class ListaCircular<T> {
   
    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    public ListaCircular() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanhoLista = 0;
    }

    /*método para adicionar um elemento pela cauda */
    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);
        if(tamanhoLista == 0){
            this.cabeca = novoNo;
            this.cauda = this.cabeca;
            this.cabeca.setNoProximo(cauda);
        }else{
            novoNo.setNoProximo(this.cauda);
            this.cabeca.setNoProximo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;
    }

    /*metodo para remover um elemento da lista pela cauda */
    public void remove(int index){
        if(index >= this.tamanhoLista)
            throw new IndexOutOfBoundsException("O índice é maior que o tamanho da lista");

        No<T> noAuxiliar = cauda;
        if(index == 0){ //estou na cauda
            this.cauda = this.cauda.getNoProximo();
            this.cabeca.setNoProximo(this.cauda);
        }else if(index == 1){
            this.cauda.setNoProximo(this.cauda.getNoProximo().getNoProximo());
        }else{
            for(int i = 0; i < index-1; i++){
                noAuxiliar = noAuxiliar.getNoProximo();
            }
            noAuxiliar.setNoProximo(noAuxiliar.getNoProximo().getNoProximo());
        }
        this.tamanhoLista--;
    }

    /*metodo para buscar um elemento na lista */
    public T get(int index){
        return getNo(index).getConteudo();
    }

    /*metodo que implementa a lógica necessária para buscar um elemento na 
     lista e auxilia outros metodos */
    private No<T> getNo(int index){
        if(isEmpty())
            throw new IndexOutOfBoundsException("A lista está vazia");

        if(index == 0){
            return this.cauda;
        }

        No<T> noAuxiliar = this.cauda;
        for(int i = 0; (i < index) && (noAuxiliar != null); i++){
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        return noAuxiliar;
    }

    /*metodo para saber se a lista está vazia ou não */
    public boolean isEmpty(){
        return this.tamanhoLista == 0 ? true : false;
    }

    /*metodo que retorna o tamanho da lista */
    public int size(){
        return this.tamanhoLista;
    }

    /*to string sobrecarregado para melhorar a visualização */
    @Override
    public String toString() {
        String strRetorno = "";
        No<T> noAuxiliar = this.cauda;
        for(int i = 0; i < size(); i++){
            strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() +"}]--->";
            noAuxiliar = noAuxiliar.getNoProximo();
        }
        strRetorno += size() != 0 ? "(Retorna ao início)" : "[]";
        return strRetorno;
    }
}