//******************** ATENÇÃO! *********************
// O conteúdo deste arquivo não deve ser modificado!
//******************** ATENÇÃO! *********************
// arquivo: src/apl2/NodeOriginal.java
// Bruno Gustavo Rocha - 32215029
// Francesco Zangrandi Coppola - 32271697
// Murilo Ramos do Nascimento - 32271166
// Natalia de Fatima Teixeira - 42129397
// Vitor Hugo Fiuza Garcia - 32270666

package apl2;

public class NodeOriginal {

  private int id;
  private String nome;
  private int inteiro;
  private int decimo;
  private NodeOriginal next;

  public NodeOriginal() {
    this(-1, "", 0, 0, null);
  }

  public NodeOriginal(int id, String nome, int inteiro, int decimo, NodeOriginal next) {
    this.id = id;
    this.nome = nome;
    this.inteiro = inteiro;
    this.decimo = decimo;
    this.next = next;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getInteiro() {
    return inteiro;
  }

  public void setInteiro(int inteiro) {
    this.inteiro = inteiro;
  }

  public int getDecimo() {
    return decimo;
  }

  public void setDecimo(int decimo) {
    this.decimo = decimo;
  }

  public NodeOriginal getNext() {
    return next;
  }

  public void setNext(NodeOriginal next) {
    this.next = next;
  }
  // construtores do last

  @Override
  public String toString() {
    return "[dados: (" + id + ";" + nome + ";" + inteiro + ";" + decimo + ") | next: " + next + "]";
  }
}