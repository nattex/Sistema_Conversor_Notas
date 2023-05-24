//*************************** ATENÇÃO! *****************************
// As assinaturas dos métodos desta classe não devem ser alteradas!
//*************************** ATENÇÃO! *****************************
// arquivo: src/apl2/Operation.java

// Bruno Gustavo Rocha - 32215029
// Francesco Zangrandi Coppola - 32271697
// Murilo Ramos do Nascimento - 32271166
// Natalia de Fatima Teixeira - 42129397
// Vitor Hugo Fiuza Garcia - 32270666

package apl2;
import java.util.*;

public class Operation {

  public static DLinkedList map(final LinkedListOriginal original) {
    DLinkedList novalista = new DLinkedList(); // se cria a lista que ira ser armazenado os dados
    int n = original.getCount(), i = 0, id, inteiro, decimo;
    String nome; // quantidade de nós na lista antiga "n"+variaveis auxiliares

    NodeOriginal aux; // Nó tipo original
    Node Aux = new Node(); // Nó tipo novo
    Date d = new Date();
    int year = (d.getYear() + 1900) % 1000; // conseguir ano atual
    char S; // variavel auxiliar
    aux = original.getHead(); // pega o primeiro Nó para percorer a lista
    while (i < n) { // percorre a lista antiga inteira
      id = aux.getId(); // pega Id do Nó
      nome = aux.getNome(); //pega Nome do Nó
      inteiro = aux.getInteiro(); //Pega nota parte inteira
      decimo = aux.getDecimo(); //Pega nota parte decima
      if ((id / 100) % 2 == 0) { // se o primeiro digito de Id for par semestre =   e se for impar semestre =1
        S = '2';
      } else {
        S = '1';
      }

      String iD = Integer.toString(year) + '.' + "S" + S + '-' + Integer.toString(id);
      if (inteiro != -1 && decimo != -1) { // verificando se há notas invalidas
        novalista.append(iD, nome, (float) inteiro + ((float) decimo) / 10);
        // se nao adiciona inteiro + (decimo/10)
      } else {
        novalista.append(iD, nome, 99);
      }

      // coloca esse Nó na lista
      aux = aux.getNext(); // pega o proximo Nó

      i++; // variavel de controle de repetiçao
    }

    return novalista; // retorna nova lista
  }

  // retorna Dlikedlsit somente nota valida
  public static DLinkedList filterRemoveNonGraded(final DLinkedList data) {
    Node aux = data.getHead(), aux2;
    DLinkedList filtro = new DLinkedList();
    int n = data.getCount();
    int i = 0; //pega tamanho da lisra
    float nota;
    while (n > i) { //percorre a lista
      nota = aux.getNota();
      
      if (nota == 99) { //se nota for 99 ignora
        aux = aux.getNext();
      } else { //adiciona na lista
        aux2=aux;
        aux = aux.getNext();
        filtro.append(aux2.getID(),aux2.getNome(),aux2.getNota());
        
      }

      i++;
    }
    return filtro;
  }
  //retorna Dlikedlsit somente com nota invalida
  public static DLinkedList filterRemoveGraded(final DLinkedList data) {

    Node aux = data.getHead(), aux2;
    int n = data.getCount();
    int i = 0; //pega tamanho da lista
    float nota;
    
    DLinkedList filtro = new DLinkedList();
    while (n > i+2) { //percorre a lista
      nota = aux.getNota();
      
      if (nota == 99) { //se nota  for 99
        aux2=aux;
        aux = aux.getNext();
        filtro.append(aux2.getID(),aux2.getNome(),aux2.getNota()); // adiciona na lista 
        
      } else {

        aux = aux.getNext(); // se nao ignora

      }
      i++;
    }

    return filtro;
  }

  public static DLinkedList filterRemoveBelowAverage(final DLinkedList data, float average) {
    Node aux = data.getHead(), aux2;
    int n = data.getCount(), i = 0;
    float nota;
    DLinkedList filtro = new DLinkedList();
    while (n > i) {
      nota = aux.getNota();
      
      if (nota < average ) { //se a nota for abaixo da media
        aux = aux.getNext(); //ignora
      } 
      if(nota>=average ){
        filtro.append(aux.getID(),aux.getNome(),aux.getNota()); //se for maior adiciona a listra filtro
        aux = aux.getNext();
      }

      i++;
    }
    return data;
  }

  public static float reduce(final DLinkedList data) {
    Node aux = data.getHead();
    int n = data.getCount(), i = 0;
    float nota = 0;
    while (n > i) {
      nota += aux.getNota(); //soma todas as notas
      aux = aux.getNext();
      i++;
    }
    return nota / n; //retorna dividindo pela quantidade de nos
  }

  public static String mapToString(final DLinkedList data) {
    Node aux = data.getHead();
    int n = data.getCount(), i = 0;
    float nota = 0;
    StringBuilder resultado = new StringBuilder();
    while (n > i) { //percorre a lista
      resultado.append(aux.getID()).append(";").append(aux.getNome()).append(";").append(Float.toString(aux.getNota())).append("\n"); //adiciona todas as informacoes em uma string
      aux = aux.getNext();
      i++;
    }
    return resultado.toString();
  }
}