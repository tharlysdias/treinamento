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
    
    private EventRoom room; // A pessoa está dentro de uma sala
    private CoffeSpace space; // A pessoa está dentro de um espaço de café
    
    // Criando Construtor
    public Person() {
        
    }

    public Person(String name, String lastName) {
        this.name = name;
        this.lastName = lastName;
    }
    
    // Converte JSON para pessoa (Person)
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

    public EventRoom getRoom() {
        return room;
    }

    public void setRoom(EventRoom room) {
        this.room = room;
    }

    public CoffeSpace getSpace() {
        return space;
    }

    public void setSpace(CoffeSpace space) {
        this.space = space;
    }
    
    
    // Converte pessoa (Person) para JSON (toJson)
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("nome", this.name);
        json.put("sobrenome", this.lastName);
        return json;
    }
    
    // Persistir dados no arquivo
    // Metodo que insere uma pessoa na base de dados
    public boolean Persistir() {
        JSONObject json = this.toJson(); // JSON da pessoa
        // Recuperar as pessoas do arquivo para poder inserir no arquivo
        String base = File.Read(); // Carrega a base de dados
        
        JSONArray jsonArray = new JSONArray();
        if(!base.isEmpty() && base.length() > 5) {
            jsonArray = new JSONArray(base); // Cria um Array novo
        }
        
        jsonArray.put(json);
        
        File.Write(jsonArray.toString());
        
        return true;
    }
    
    // Metodo que retorna todos os alunos da base de dados
    public static ArrayList<Person> getPersons() {
        ArrayList<Person> persons = new ArrayList();
        String base = File.Read(); // Conteudo do arquivo de texto
        
        if(base.isEmpty() || base.length() < 5) {
            return null;
        }
        
        JSONArray jsonArray = new JSONArray(base); // Vetor de JSON
        for(int i = 0; i < jsonArray.length(); i++) {
            Person P = new Person(jsonArray.getJSONObject(i)); // Pra cada objeto JSON cria uma pessoa
            persons.add(P); // Pra cada pessoa, inclui no vetor de pessoas (Recuperando todas as pessoas)
        }
        return persons;
    }
    
}
