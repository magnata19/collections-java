package br.com.collection.list;

import java.util.*;

public class ExemploSet {
  public static void main(String[] args) {
    //Data uma lista com 7 notas de um aluno[7, 8.5, 9.3, 5, 7, 0, 3.6 ], faça:

    System.out.println("Crie um conjunto e adicione as notas.");
    Set<Double> notas = new HashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
    System.out.println(notas);

//    System.out.println("Exiba a posição da nota 5"); a interface set não permite pesquisar por index

//    System.out.println("Adicione na lista a nota 8.0 na posicao 4"); a interface set nao permite trabalhar com posicao

//    System.out.println("Substitua a nota 5.0 pela nota 6.0"); a interface set nao tem o metodo set para alterarmos o elemento

    System.out.println("Confira se a nota 5.0 está no conjunto: " + notas.contains(5d));

//    System.out.println("Exiba a terceira nota adicionada."); a interface set nao tem o metodo get para retornar o index

    System.out.println("Exiba a menor nota: " + Collections.min(notas));

    System.out.println("Exiba a maior nota: " + Collections.max(notas));

    System.out.println("Exiba a soma dos valores");
    Iterator<Double> minhasNotas = notas.iterator();
    Double soma = 0d;
    while(minhasNotas.hasNext()){
      Double next = minhasNotas.next();
      soma += next;
    }
    System.out.println("A soma total das notas é: " + soma);

    System.out.println("Exiba a média das notas: " + (soma/notas.size()));

    System.out.println("Remova a nota 0: ");
    notas.remove(0d);
    System.out.println(notas);

//    System.out.println("Remova a nota da posicao 0"); // a interface set nao tem indice

    System.out.println("Remova as notas menores que 7 e exiba a lista");
    Iterator<Double> minhasNotas2 = notas.iterator();
    while(minhasNotas2.hasNext()){
      Double next2 = minhasNotas2.next();
      if(next2 < 7) minhasNotas2.remove();
    }
    System.out.println(notas);

    System.out.println("Exiba todas as notas na ordem em que foram informadas: ");
    Set<Double> notas1 = new LinkedHashSet<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
    System.out.println(notas1); // repare q o 7 foi adicionado apenas 1 vez.

    System.out.println("Exiba todas as notas na ordem crescente: ");
    Set<Double> crescente = new TreeSet<>(notas1);
    System.out.println(crescente);

    System.out.println("Apague todo conjunto");
    notas.clear();

    System.out.println("Confira se o conjunto está vazio: " + notas.isEmpty());
    System.out.println("Confira se o conjunto está vazio: " + notas1.isEmpty());

  }
}
