import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ExemploList {
    public static void main(String[] args) {
        //Data uma lista com 7 notas de um aluno[7, 8.5, 9.3, 5, 7, 0, 3.6 ], faça:

        //formas de instanciar uma lista

//    List notas = new ArrayList();// antes do java 5
//    List<Double> notas = new ArrayList<>(); // Generics (jdk5) - Diamond Operator(jdk 7)
//    ArrayList<Double> notas = new ArrayList<>(); // Não recomendável ,pois e ideial programar voltado para interface e nao implementacao
//    List<Double> notas = new ArrayList<>(Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6));
//    List<Double> notas = Arrays.asList(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); // essa forma e limitada pois nao permite adicionar ou retirar objetos do array
//        List<Double> notas = List.of(7d, 8.5, 9.3, 5d, 7d, 0d, 3.6); nao posso adicionar ou remover itens nesse tipo de instancia

        System.out.println("Crie uma lista e adicione as sete notas:");
        List<Double> notas = new ArrayList<>();
        notas.add(7d);
        notas.add(8.5);
        notas.add(9.3);
        notas.add(5d);
        notas.add(8d);
        notas.add(0d);
        notas.add(3.6);
        System.out.println(notas.toString());

        System.out.println("Exiba a posição da nota 5.0 -> " + notas.indexOf(5d));
        System.out.println("Adicione na lista a nota 8.0 na posição 4 " );
        notas.add(4, 8d);
        System.out.println(notas);

        System.out.println("Substitua a nota 5.0 pela 6.0");
        notas.set(notas.indexOf(5d), 6d);
        System.out.println(notas);

        System.out.println("Confira se a nota 5.0 está na lista: " + notas.contains(5d));

//        System.out.println("Exiba todas as notas na ordem em que foram informados: " );
//        for( Double nota: notas) System.out.println(nota);



    }

}
