package br.com.collection.list;
/*
 * Dadas as seguintes informações sobre minhas séries favoritas,
 * crie um conjunto e ordene este conjunto exibindo:
 * (nome - genero - tempo de episodio);
 *
 * Serie1 = Nome: got, genero: fantasia, tempoEpisodio: 60
 * Serie2 = Nome: dark, genero: drama, tempoEpisodio: 60
 * Serie3 = Nome: that '70s show, genero: comedia, tempoEpisodio: 25
 * */
import java.util.*;

public class ExemploOrdenacaoSet {
  public static void main(String[] args) {
    System.out.println("--\tOrdem aleatória\t--");

    Set<Serie> minhasSeries = new HashSet<>(){{ // hash set ordena a lista de ordem aleatória
      add(new Serie("got", "fantasia", 60));
      add(new Serie("dark", "drama", 60));
      add(new Serie("that '70s show", "comedia", 25));
    }};

  for(Serie serie: minhasSeries) {
    System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
  }

    System.out.println("--\tOrdem insercao\t--");
    Set<Serie> minhasSeries1 = new LinkedHashSet<>(){{ // LinkedHashSet ordena a lista em ordem de insercao
      add(new Serie("got", "fantasia", 60));
      add(new Serie("dark", "drama", 60));
      add(new Serie("that '70s show", "comedia", 25));
    }};

    for(Serie serie: minhasSeries) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }

    System.out.println("--\tOrdem natural(tempoEpisodio)\t--");
    Set<Serie> minhasSeries2 = new TreeSet<>(minhasSeries1);
    for(Serie serie: minhasSeries2) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }


    System.out.println("--\tOrdem Nome/Genero/TempoEpisodio\t--");
    Set<Serie> minhasSeries3 = new TreeSet<>(new ComparatorNomeGeneroTempoEpisodio());
    minhasSeries3.addAll(minhasSeries);
    for(Serie serie: minhasSeries3) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }

    System.out.println("--\tOrdem Genero\t--");
    Set<Serie> minhasSeries4 = new TreeSet<>(new ComparatorGenero());
    minhasSeries4.addAll(minhasSeries2);
    for(Serie serie: minhasSeries3) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }

    System.out.println("--\tOrdem Tempo Episodio\t--");
    Set<Serie> minhasSeries5 = new TreeSet<>();
    minhasSeries5.addAll(minhasSeries);
    for(Serie serie: minhasSeries5) {
      System.out.println(serie.getNome() + " - " + serie.getGenero() + " - " + serie.getTempoEpisodio());
    }


  }
}

class Serie implements Comparable<Serie>{
  private String nome;
  private String genero;
  private Integer tempoEpisodio;

  public Serie(String nome, String genero, Integer tempoEpisodio) {
    this.nome = nome;
    this.genero = genero;
    this.tempoEpisodio = tempoEpisodio;
  }

  public String getNome() {
    return nome;
  }

  public String getGenero() {
    return genero;
  }

  public Integer getTempoEpisodio() {
    return tempoEpisodio;
  }

  @Override
  public String toString() {
    return "{" +
            "nome='" + nome + '\'' +
            ", genero='" + genero + '\'' +
            ", tempoEpisodio=" + tempoEpisodio +
            '}';
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) return true;
    if (object == null || getClass() != object.getClass()) return false;
    Serie serie = (Serie) object;
    return Objects.equals(nome, serie.nome) && Objects.equals(genero, serie.genero) && Objects.equals(tempoEpisodio, serie.tempoEpisodio);
  }

  @Override
  public int hashCode() {
    return Objects.hash(nome, genero, tempoEpisodio);
  }

  @Override
  public int compareTo(Serie serie) {
    int tempoEpisodio = Integer.compare(this.getTempoEpisodio(), serie.getTempoEpisodio());
    if(tempoEpisodio != 0) return  tempoEpisodio;
    return this.getGenero().compareTo(serie.getGenero());
  }
}

class ComparatorNomeGeneroTempoEpisodio implements Comparator<Serie> {

  @Override
  public int compare(Serie s1, Serie s2) {
    //se meus nomes forem diferentes, eu comparo por nome
    int nome = s1.getNome().compareTo(s2.getNome());
    if(nome != 0) return nome;

    //se meus nomes forem iguais e meus generos diferentes, eu comparo por genero
    int genero = s1.getGenero().compareTo(s2.getGenero());
    if(genero != 0 ) return genero;

    //se nome e genero for igual, eu comparo por tempo de episodio
    return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
  }
}

class ComparatorGenero implements Comparator<Serie> {

  @Override
  public int compare(Serie s1, Serie s2) {
    int genero = s1.getGenero().compareTo(s2.getGenero());
    if(genero != 0) return genero;
    return Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());

  }
}

class ComparatorTempoEpisodio implements Comparator<Serie> {
  public int compare(Serie s1, Serie s2) {
    int tempoEpisodio = Integer.compare(s1.getTempoEpisodio(), s2.getTempoEpisodio());
    if(tempoEpisodio != 0) return  tempoEpisodio;

    return s1.getNome().compareTo(s2.getNome());
  }
}