// Bruno Gustavo Rocha - 32215029
// Francesco Zangrandi Coppola - 32271697
// Murilo Ramos do Nascimento - 32271166
// Natalia de Fatima Teixeira - 42129397
// Vitor Hugo Fiuza Garcia - 32270666

package apl2;

//Declaração da classe
public class DLinkedList {
  private Node head;
  private Node tail;
  private int count;

  // Declaração do construtor
  public DLinkedList() {
    head = null;
    tail = null;
    count = 0;
  }

  // Função para alocar um Node que contém os dados da pessoa e inserir o novo nó no início da lista
  public void insert(String iD, String nome, float nota) {
    Node newNode = new Node(iD, nome, nota, head, tail);
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setNext(head);
      head.setPrev(newNode);
      head = newNode;
    }
    head.setPrev(null);
    count++;
    head.setPrev(null);
    tail.setNext(null);
  }

  // Função para alocar um Node que contém os dados da pessoa e inserir o novo nó no final da lista
  public void append(String iD, String nome, float nota) {
    Node newNode = new Node(iD, nome, nota, head, tail);
    if (isEmpty()) {
      head = newNode;
      tail = newNode;
    } else {
      newNode.setPrev(tail);
      tail.setNext(newNode);
      tail = newNode;
      tail.setNext(null);
      head.setPrev(null);
    }
    count++;
  }

  public void append(Node newNode) {

    if (this.isEmpty()) {
      head = newNode;
      //System.out.println("true'");
    } else {

      tail.setNext(newNode);
    }
    tail = newNode;
    count++;
    head.setPrev(null);
    tail.setNext(null);
  }

  //Função para remover o nó do início da lista
  public Node removeHead() {
    if (isEmpty()) {
      return null;
    }
    Node removedNode = head;
    if (head == tail) {
      head = null;
      tail = null;
    } else {
      head = head.getNext();
      head.setPrev(null);
    }
    removedNode.setNext(null);
    count--;
    head.setPrev(null);
    tail.setNext(null);
    return removedNode;
  }

  //Função para remover o nó do final da lista
  public Node removeTail() {
    if (isEmpty()) {
      return null;
    }
    Node removedNode = tail;
    if (head == tail) {
      head = null;
      tail = null;
    } else {
      tail = tail.getPrev();
      tail.setNext(null);
    }
    removedNode.setPrev(null);
    count--;
    head.setPrev(null);
    tail.setNext(null);
    return removedNode;
  }

  // Função que remove o nó que contém o ID da pessoa
  public Node removeNode(String id) {
    Node nodeToRemove = getNode(id);
    if (nodeToRemove == null) {
      return null;
    }
    if (nodeToRemove == head) {
      return removeHead();
    }
    if (nodeToRemove == tail) {
      return removeTail();
    }
    Node prevNode = nodeToRemove.getPrev();
    Node nextNode = nodeToRemove.getNext();
    prevNode.setNext(nextNode);
    nextNode.setPrev(prevNode);
    nodeToRemove.setPrev(null);
    nodeToRemove.setNext(null);
    count--;
    return nodeToRemove;
  }

  //Referencia o nó do início da lista
  public Node getHead() {
    return head;
  }

  //Referencia o nó do final da lista
  public Node getTail() {
    return tail;
  }

  // Função que retorna uma referência para o nó que contém o ID da pessoa da lista.
  public Node getNode(String id) {
    Node currentNode = head;
    int i = 0;
    while (i < count) {
      if (currentNode.getID().equals(id)) {
        return currentNode;
      }
      currentNode = currentNode.getNext();
      i++;
    }
    return null;
  }

  //Função que retorna a quantidade de nós da lista
  public int getCount() {
    return count;
  }

  //Função que retorna true se a lista estiver vazia ou false, caso contrário
  public boolean isEmpty() {
    return count == 0;

  }

  //Função que esvazia a lista
  public void clear() {
    while (head != null) {
      Node nextNode = head.getNext();
      head.setPrev(null);
      head.setNext(null);
      head = nextNode;
    }
    tail = null;
    count = 0;
  }

  //Função que retorna uma string com o conteúdo da lista
  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    int i = 0;
    sb.append("(").append(count).append(") \n");

    Node node = head;
    while (i < count) {
      sb.append("(")
        .append(node.getID())
        .append(" ; ")
        .append(node.getNome())
        .append(" ; ")
        .append(node.getNota())
        .append(") -> \n");
      node = node.getNext();

      i++;

    }
    sb.append("null.");

    return sb.toString();
  }
}