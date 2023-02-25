package com.estruturasdados.vetor;

/*Exemplo  de estrutura de Dados com a classe Stack (Pilha)*/

public class Stack {

    private int arr[];
    private int top;
    private int capacity;

   

    // Construtor para inicializar a Stack
    public Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Função utilitária para adicionar um elemento `x` à Stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Programa Terminado");
            System.exit(-1);
        }

        System.out.println("Inserindo dados" + x);
        arr[++top] = x;
    }

    // Função utilitária para remover um elemento do topo da Stack
    public int pop() {
        // verifica se há underflow da Stack
        if (isEmpty()) {
            System.out.println("Programa Terminado");
            System.exit(-1);
        }

        System.out.println("Removendo dados " + peek());

        // diminui o tamanho da Stack em 1 e (opcionalmente) retorna o elemento
        // estourado
        return arr[top--];
    }

    // Função utilitária para retornar o elemento do topo da Stack
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.exit(-1);
        }

        return -1;
    }

    // Função utilitária para retornar o tamanho da Stack
    public int size() {
        return top + 1;
    }

    // Função utilitária para verificar se a Stack está vazia ou não
    public boolean isEmpty() {
        return top == -1; // or return size() == 0;
    }

    // Função utilitária para verificar se a Stack está cheia ou não
    public boolean isFull() {
        return top == capacity - 1; // or return size() == capacity;
    }
    
   
}


