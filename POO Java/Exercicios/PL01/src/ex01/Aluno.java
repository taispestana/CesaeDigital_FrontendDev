package ex01;

public class Aluno {
  private String nome;
  private int numero;
  private int media;

  //Construtor da classe Aluno
  public Aluno(String nome, int numero, int media) {
    this.nome = nome;
    this.numero = numero;
    this.media = media;
  }

  //Metodos getters para aceder aos atributos privados
  public String getNome() {
    return nome;
  }

  public int getNumero() {
    return numero;
  }

  public int getMedia() {
    return media;
  }

  //metodo para exibir informacoes do aluno
  public void exibirInfo() {
    System.out.println("Nome: " + nome);
    System.out.println("Numero: " + numero);
    System.out.println("Media: " + media);
  }

}