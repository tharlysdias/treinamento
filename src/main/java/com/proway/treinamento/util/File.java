package util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Classe File contem dois metodos, um para ler e outro para escrever no arquivo
 * 
 * @author tharlys
 */
public class File {

    // Constante
    private final static String Caminho = "base_de_dados.txt";

    /**
     * Metodo Read: faz a leitura do arquivo e retorna o arquivo completo
     * 
     * @return 
     */
    public static String Read() {
        String conteudo = "";
        try {
            FileReader arq = new FileReader(Caminho); // Cria um arquivo caminho informado
            BufferedReader lerArq = new BufferedReader(arq); // Para fazer a leitura
            String linha = "";
            try {
                linha = lerArq.readLine(); // Ler a linha
                while (linha != null) {
                    conteudo += linha + "\n";
                    linha = lerArq.readLine();
                }
                arq.close(); // Fecha o arquivo
                return conteudo;
            } catch (IOException ex) { // Faz o tratamento de exceção
                System.out.println("Erro: Não foi possível ler o arquivo!");
                return "";
            }
        } catch (FileNotFoundException ex) {
            System.out.println("Erro: Arquivo não encontrado!");
            return "";
        }
    }

    /**
     * Metodo Write: escreve o texto no arquivo encontrado e retorna um valor logico
     * 
     * @param Texto
     * @return 
     */
    public static boolean Write(String Texto) {
        try {
            FileWriter arq = new FileWriter(Caminho);
            PrintWriter gravarArq = new PrintWriter(arq); // Escreve no arquivo apontado
            gravarArq.print(Texto);
            gravarArq.close();
            return true;
        } catch (IOException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }
}
