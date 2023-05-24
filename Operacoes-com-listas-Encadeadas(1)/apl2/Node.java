//arquivo: src/apl2/Node.java

// Bruno Gustavo Rocha - 32215029
// Francesco Zangrandi Coppola - 32271697
// Murilo Ramos do Nascimento - 32271166
// Natalia de Fatima Teixeira - 42129397
// Vitor Hugo Fiuza Garcia - 32270666

package apl2;

// -- A classe Node (que pertence ao pacote apl2) deve conter os atributos que
// representam a nova versão dos dados de uma pessoa, conforme descrito no
// enunciado da atividade Apl2.
// -- A classe deve conter os construtores apropriados, assim como os métodos
// getters e setters.
// -- A classe também representa um nó que é usado na implementação da lista
// duplamente encadeada (classe DLinkedList).
// -- A classe deve sobrescrever (override) o método public String toString()
// {...}, retornando uma string com os valores dos atributos da classe.

public class Node {
  private String ID;
  private String nome;
  private float nota;
  private Node next;
  private Node last; 

  //Portanto, o novo sistema deve trabalhar com uma base de dados em formato texto que contém
  //o seguinte formato:
  //ID da pessoa, nome da pessoa, nota da pessoa <----

  public Node() {
    this("", "", 99, null, null);
  }

  public Node(String ID, String nome, float nota, Node next, Node last) {
    this.ID = ID;
    this.nome = nome;
    this.nota = nota;
    this.next = next;
    this.last = last;

  }

  public String getID() {
    return ID;
  }

  public void setID(String iD) {
    ID = iD;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public float getNota() {
    return nota;
  }

  public void setNota(float nota) {
    this.nota = nota;
  }

  public Node getNext() {
    return next;
  }

  public void setNext(Node next) {
    this.next = next;
  }

  public Node getPrev() {
    return last;
  }

  public void setPrev(Node last) {
    this.last = last;
  }

  @Override
  public String toString() {
    return "[dados: (" + ID + ";" + nome + ";" + ") | next:  " +next+ "]";

  }
}