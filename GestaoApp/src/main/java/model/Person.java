package model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import util.File;

/**
 *
 * @author tharlys
 */
public class Person {
    
    // Atributos da pessoa (Estão privados para garantir o encapsulamento das informações de cada objeto).
    private String name;
    private String lastName;
    
    // Criando Construtor
    public Person() {
        
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    
    // Converte JSON para Person
    public Person(JSONObject json) {
        this.name = json.getString("nome");
        this.lastName = json.getString("sobrenome");
    }
    
    // Getters and Setters
    // Métodos de acesso
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
    // Converte Person para JSON (toJson)
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("nome", this.name);
        json.put("sobrenome", this.lastName);
        return json;
    }
    
    // Persistir dados no arquivo
    public boolean Persistir() {
        JSONObject json = this.toJson(); // JSON da pessoa
        // Recuperar as pessoas do arquivo para poder inserir no arquivo
        String base = File.Read(); // Ler a base de dados
        JSONArray jsonArray = new JSONArray(base); // Pega o Array de JSON
        jsonArray.put(json);
        
        File.Write(jsonArray.toString());
        
        return true;
    }
    
    public static ArrayList<Person> getPersons() {
        ArrayList<Person> persons = new ArrayList();
        String base = File.Read(); // Conteudo do arquivo de texto
        
        if(base.isEmpty() || base.length() < 5) {
            return null;
        }
        
        JSONArray jsonArray = new JSONArray(base); // Vetor de JSON
        for(int i = 0; i < jsonArray.length(); i++) {
            Person P = new Person(jsonArray.getJSONObject(i)); // Pra cada objeto JSON cria uma pessoa
            persons.add(P); // Pra cada pessoa, inclui ele no vetor de pessoas (Recuperando todas as pessoas)
        }
        return persons;
    }
    
}