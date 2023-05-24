//*************************** ATENÇÃO! ****************************
// O método main() deve ser alterado somente nos comentários TODO.
// Todas as outras instruções devem permanecer intactas e o código
// deve funcionar conforme descrito no enunciado da atividade.
//*************************** ATENÇÃO! ****************************
// arquivo: src/MainApl2.java

// Bruno Gustavo Rocha - 32215029
// Francesco Zangrandi Coppola - 32271697
// Murilo Ramos do Nascimento - 32271166
// Natalia de Fatima Teixeira - 42129397
// Vitor Hugo Fiuza Garcia - 32270666

// TODO: Listar todas as referências consultadas para solucionar a atividade.

import apl2.DLinkedList;
import apl2.LinkedListOriginal;
import apl2.Node;
import apl2.Operation;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    LinkedListOriginal list = new LinkedListOriginal();
    Scanner aux = new Scanner(System.in);
    DLinkedList fixedList= new DLinkedList();
    DLinkedList filteredGradedList = new DLinkedList();
    DLinkedList filteredNonGradedList= new DLinkedList();
    DLinkedList aboveAverageList = new DLinkedList();
    float average;
    int n=0;
    while(n!=9){
   
      System.out.println("1-carregar dados");
      System.out.println("2-dados do sistema legado");
      System.out.println("3-dados no novo sistema");
      System.out.println("4-mostrar somente notas validas");
      System.out.println("5- mostrar somente notas invalidas");
      System.out.println("6-mostrar media e alunos acima da media");
      System.out.println("7-converter lista para String");
      System.out.println("8-testes do Sistema");
      System.out.println("9-Sair");
       n=aux.nextInt();
      
  
   
  
      
      // Carregar o conteúdo do arquivo "dados.txt" e adicionar cada linha como um nó na LinkedListOriginal list.
       if(n==1){
          loadFromFile(list);}
  
  		 if(n==2){
  		  System.out.println(">>>>>>>>>> Dados originais (sistema legado) >>>>>>>>>>");
  		  System.out.println(list);
  		  System.out.println("<<<<<<<<<< Dados originais (sistema legado) <<<<<<<<<<\n");
       }
         
        if(n==3){
  		 fixedList = Operation.map(list);
  		System.out.println(">>>>>>>>>> Dados convertidos para a nova representação dos dados >>>>>>>>>>");
  		System.out.println(fixedList);
  		System.out.println("<<<<<<<<<< Dados convertidos para a nova representação dos dados <<<<<<<<<<\n");}
  		if(n==4){
  		 filteredGradedList = Operation.filterRemoveNonGraded(fixedList);
  		System.out.println(">>>>>>>>>> Lista filtrada (somente notas válidas) >>>>>>>>>>");
  		System.out.println(filteredGradedList);
  		System.out.println("<<<<<<<<<< Lista filtrada (somente notas válidas) <<<<<<<<<<\n");}
  		if(n==5){
  		filteredNonGradedList = Operation.filterRemoveGraded(fixedList);
  		System.out.println(">>>>>>>>>> Lista filtrada (somente 'ausência de nota') >>>>>>>>>>");
  		System.out.println(filteredNonGradedList);
  		System.out.println("<<<<<<<<<< Lista filtrada (somente 'ausência de nota') <<<<<<<<<<\n");}
      if(n==6){
  		average = Operation.reduce(filteredGradedList);
  		System.out.println(">>>>>>>>>> Média das notas válidas >>>>>>>>>>");
  		System.out.println(average);
  		System.out.println("<<<<<<<<<< Média das notas válidas <<<<<<<<<<\n");
  		
  		 aboveAverageList = Operation.filterRemoveBelowAverage(filteredGradedList, average);
  		System.out.println(">>>>>>>>>> Lista com notas acima da média >>>>>>>>>>");
  		System.out.println(aboveAverageList);
  		System.out.println("<<<<<<<<<< Lista com notas acima da média <<<<<<<<<<\n");
      }
      if(n==7){
  		String contents = Operation.mapToString(fixedList);
  		System.out.println(">>>>>>>>>> Lista mapeada para uma única string >>>>>>>>>>");
  		System.out.println(contents);
  		System.out.println("<<<<<<<<<< Lista mapeada para uma única string <<<<<<<<<<\n");
      
      saveToFile(contents);}
      // Salvar o conteúdo da String contents em um arquivo chamado "dados.csv".
      
      if(n==8){
      Node test1 = fixedList.getNode("23.S1-999");
      System.out.println(">>>>>>>>>> test1 >>>>>>>>>>\n" + test1 + "\n<<<<<<<<<< test1 <<<<<<<<<<\n");
     
      Node test2 = fixedList.removeNode("23.S1-999");
      System.out.println(">>>>>>>>>> test2 >>>>>>>>>>\n" + test2 + "\n<<<<<<<<<< test2 <<<<<<<<<<\n");
  
      Node test3 = fixedList.getNode("23.S1-999");
      System.out.println(">>>>>>>>>> test3 >>>>>>>>>>\n" + test3 + "\n<<<<<<<<<< test3 <<<<<<<<<<\n");
  
      aboveAverageList.clear();
      System.out.println(">>>>>>>>>> aboveAverageList.clear() >>>>>>>>>>\n" + aboveAverageList + "\n<<<<<<<<<< aboveAverageList.clear() <<<<<<<<<<\n");
  
      DLinkedList testList = new DLinkedList();
      // Inserir um nó no início da lista testList com os dados ("ABC", "John Doe", 4.7f).
      testList.insert("ABC", "John Doe", (float) 4.7f);
      // Inserir um nó no final da lista testList com os dados ("XYZ", "Jane Doe", 9.9f).
      testList.append("XYZ", "Jane Doe", (float) 9.9f);
      // Inserir um nó no início da lista testList com os dados ("321", "Test", 2.3f).
      testList.insert("321", "Test", (float) 2.30f);
      // Inserir um nó no final da lista testList com os dados ("Nothing", "Yada yada yada", 99.9f).
      testList.append("Nothing", "Yada yada yada", 99.9f);
      System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
      System.out.println("testList.getHead(): " + testList.getHead());
      System.out.println("testList.getTail(): " + testList.getTail());
      System.out.println("testList.removeHead(): " + testList.removeHead());
      System.out.println("testList.removeTail(): " + testList.removeTail() + '\n');
      System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
      System.out.println("testList.getHead(): " + testList.getHead());
      System.out.println("testList.getTail(): " + testList.getTail());
      System.out.println("testList.removeNode(\"ABC\"): " + testList.removeNode("ABC") + '\n');
      System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
      System.out.println("testList.getHead(): " + testList.getHead());
      System.out.println("testList.getTail(): " + testList.getTail() + '\n');
      // Inserir um nó no início da lista testList com os dados ("qwerty", "QWERTY", 1.2f).
      testList.insert("qwerty", "QWERTY", 1.2f);
      // Inserir um nó no final da lista testList com os dados ("WASD", "wasd", 3.4f).
      testList.insert("WASD", "wasd", 3.4f);
      // Inserir um nó no início da lista testList com os dados ("ijkl", "IJKL", 5.6f).
      testList.insert("ijkl", "IJKL", 5.6f);
      // Inserir um nó no final da lista testList com os dados ("1234", "Um Dois Tres Quatro", 7.8f).
      testList.insert("1234", "Um Dois Tres Quatro", 7.8f);
      System.out.println(">>>>>>>>>> testList >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList <<<<<<<<<<\n");
      testList.clear();
      System.out.println(">>>>>>>>>> testList.clear() >>>>>>>>>>\n" + testList + "\n<<<<<<<<<< testList.clear() <<<<<<<<<<\n");
    }
      }
    }
  
  private static void loadFromFile(LinkedListOriginal list) {
    try {
      File file = new File("dados.txt");
      Scanner scanner = new Scanner(file);
      String line;
      String[] data;
      String nome;
      int id, nota, decimal;

      while (scanner.hasNextLine()) {
        line = scanner.nextLine();
        data = line.split("#");
        id = Integer.parseInt(data[0]);
        nome = data[1];
        nota = Integer.parseInt(data[2]);
        decimal = Integer.parseInt(data[3]);
        list.append(id, nome, nota, decimal);
      }

      scanner.close();
    } catch (IOException e) {
      e.printStackTrace();
      System.err.println("Erro ao ler o arquivo: " + e.getMessage());
    }
  }

  private static void saveToFile(String contents) {
    try {
      FileWriter writer = new FileWriter("dados.csv");
      writer.write(contents);
      writer.close();
      System.out.println("Arquivo salvo com sucesso: " + "dados.csv");
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
