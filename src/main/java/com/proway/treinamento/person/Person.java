package com.proway.treinamento.person;

import com.proway.treinamento.coffee.Coffee;
import com.proway.treinamento.event.Event;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Trata-se da {@link Person} que o sistema possui.
 *
 * @author Tharlys de Souza Dias <tharlys.souza@outlook.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String lastName;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "person_event",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"))
    private List<Event> events = new ArrayList<>();

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "person_coffee",
            joinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "coffee_id", referencedColumnName = "id"))
    private List<Coffee> coffees = new ArrayList<>();

//    @ManyToMany
//    private List<Coffee> coffees = new ArrayList<>();

//    // Converte JSON para pessoa (Person)
//    public Person(JSONObject json) {
//        this.name = json.getString("nome");
//        this.lastName = json.getString("sobrenome");
//    }
//
//    // Converte pessoa (Person) para JSON (toJson)
//    public JSONObject toJson() {
//        JSONObject json = new JSONObject();
//        json.put("nome", this.name);
//        json.put("sobrenome", this.lastName);
//        return json;
//    }
//
//    // Persistir dados no arquivo
//    // Metodo que insere uma pessoa na base de dados
//    public boolean Persistir() {
//        JSONObject json = this.toJson(); // JSON da pessoa
//        // Recuperar as pessoas do arquivo para poder inserir no arquivo
//        String base = File.Read(); // Carrega a base de dados
//
//        JSONArray jsonArray = new JSONArray();
//        if (!base.isEmpty() && base.length() > 5) {
//            jsonArray = new JSONArray(base); // Cria um Array novo
//        }
//
//        jsonArray.put(json);
//
//        File.Write(jsonArray.toString());
//
//        return true;
//    }
//
//    // Metodo que retorna todos os alunos da base de dados
//    public static ArrayList<Person> getPersons() {
//        ArrayList<Person> persons = new ArrayList();
//        String base = File.Read(); // Conteudo do arquivo de texto
//
//        if (base.isEmpty() || base.length() < 5) {
//            return null;
//        }
//
//        JSONArray jsonArray = new JSONArray(base); // Vetor de JSON
//        for (int i = 0; i < jsonArray.length(); i++) {
//            Person P = new Person(jsonArray.getJSONObject(i)); // Pra cada objeto JSON cria uma pessoa
//            persons.add(P); // Pra cada pessoa, inclui no vetor de pessoas (Recuperando todas as pessoas)
//        }
//        return persons;
//    }

}
