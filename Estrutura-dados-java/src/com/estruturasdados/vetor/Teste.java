package com.estruturasdados.vetor;




import com.estruturasdados.fila.Fila;

public class Teste {
    public static void main(String[] args)  {
        Stack stack = new Stack(3);

        stack.push(1); // inserindo 1 na Stack
        stack.push(2); // inserindo 2 na Stack

        stack.pop(); // removendo o elemento superior (2)
        stack.pop(); // removendo o elemento superior (1)

        stack.push(3); // inserindo 3 na Stack

        System.out.println("O elemento do superior da pilha é " + stack.peek());
        System.out.println("O tamanho da pilha é " + stack.size());

        stack.pop(); // removendo o elemento superior (3)

        // verifica se a Stack está vazia
        if (stack.isEmpty()) {
            System.out.println("A pilha está vazia");
        } else {
            System.out.println("A pilha não está vazia");
        }
    }
}

