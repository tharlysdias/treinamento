package util;

import java.io.File;
import java.io.IOException;
import static org.junit.Assert.*;
import org.junit.Rule;

import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * Simula a criação de uma pasta e um arquivo temporario, utilizando a 
 * anotação Rule que cria a pasta antes da execução do teste
 * Simula a operação de execeção garantindo a criação do arquivo
 * 
 * @author tharlys
 */
public class FileTest {
    
    @Rule
    // Anotação Rule: A pasta temporaria (tempFolder), será criada antes da execução do teste
    public TemporaryFolder tempFolder = new TemporaryFolder();

    @Test
    public void shouldCreateNewFileInTemporaryFolder() throws IOException {
        // Cria um arquivo na pasta temporaria
        File created = tempFolder.newFile("base_de_dados.txt");
        
        // Verifica se o arquivo foi criado
        assertTrue(created.isFile());
        // Verifica se a raiz do arquivo é o mesmo do arquivo criado acima
        assertEquals(tempFolder.getRoot(), created.getParentFile());
    }

}
