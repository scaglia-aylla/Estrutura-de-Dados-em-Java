package com.estruturasdados.fila;

/*implementando o conceito de fila */

public class Fila<T> {

    private No<T> refNoEntradaFila;


    /*Criando um construtor que instancia uma fila nula ou vazia */
    public Fila(){
        this.refNoEntradaFila = null;
    }

    /*metodo para adicionar um elemento no final da 
     fila ou seja enfileirar */
    public void enqueue(T object){
        No novoNo = new No(object);
        novoNo.setRefNo(refNoEntradaFila);
        refNoEntradaFila = novoNo;

    }

    /*metodo que retorna o primeiro da fila */
    public T first(){
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            while (true){
                if(primeiroNo.getRefNo() != null) {
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    break;
                }

            }
            return (T) primeiroNo.getObject();  
        }
        return null;
    }

    /*metodo que remove o objeto da frente da fila e o retorna,
     diminuindo o tamanho da fila */
    public T dequeue(){
        if(!this.isEmpty()){
            No primeiroNo = refNoEntradaFila;
            No noAuxiliar = refNoEntradaFila;
            while (true){
                if(primeiroNo.getRefNo() != null) {
                    noAuxiliar = primeiroNo;
                    primeiroNo = primeiroNo.getRefNo();
                }else{
                    noAuxiliar.setRefNo(null);
                    break;
                }

            } 
            return (T) primeiroNo.getObject(); 
        }
        return null;
    }

    /*Verificando se a fila está vazia */
    public boolean isEmpty(){
        return refNoEntradaFila == null ? true : false;
    }

    @Override
    public String toString() {
        String  stringRetorno = "";
        No noAuxiliar = refNoEntradaFila;

        if (refNoEntradaFila != null) {
            while (true) {
              stringRetorno += "[No {objeto=" + noAuxiliar.getObject() + "]}--->";

              if(noAuxiliar.getRefNo() != null) {
                noAuxiliar = noAuxiliar.getRefNo();
              }else{
                stringRetorno += null;
                break;
              }
            }
           
        }else{
            stringRetorno = null;
        }


        return stringRetorno;
    }
    
    
}

