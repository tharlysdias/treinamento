package com.proway.treinamento.coffee;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * @author Tharlys de Souza Dias <tharlys.souza@outlook.com>
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Coffee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;

    //    @ManyToMany
//    private List<Person> people = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "coffee_person",
//            joinColumns = @JoinColumn(name = "coffee_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
//    private List<Person> people = new ArrayList<>();

//    // O espaço de café tem uma lista de pessoas
//    ArrayList<Person> listPersonCoffe;
//
//    public Coffee(JSONObject json) {
//        this.name = json.getString("nome");
//        this.capacity = json.getInt("lotacao");
//    }
//
//    public JSONObject toJson() {
//        JSONObject json = new JSONObject();
//        json.put("nome", this.name);
//        json.put("lotacao", this.capacity);
//        return json;
//    }
//
//    // Adiciona uma pessoa a lista
//    public void addPersonCoffe(Person P) {
//        P.setSpace(this); // Informa o espaço de café que a pessoa está (Muda o atributo space da person para o espaço que ela está)
//        listPersonCoffe.add(P); // Adiciona uma pessoa a um espaço de café
//    }
//
//    // Insere um espaço de café na base de dados
//    public boolean PersistirSpace() {
//        JSONObject json = this.toJson();
//
//        String base = FileSpace.Read();
//        JSONArray jA = new JSONArray();
//        if (!base.isEmpty() && base.length() > 5) {
//            jA = new JSONArray(base);
//        }
//
//        jA.put(json);
//
//        FileSpace.Write(jA.toString());
//
//        return true;
//    }
//
//    // Retorna um ArrayList (vetor) do tipo espaço de café
//    public static ArrayList<Coffee> getSpaces() {
//        ArrayList<Coffee> spaces = new ArrayList();
//
//        // Ler a base de dados
//        String base = FileSpace.Read();
//        JSONArray jA = new JSONArray(base);
//
//        if (base.isEmpty() || base.length() < 5) {
//            return null;
//        }
//
//        for (int i = 0; i < jA.length(); i++) {
//            Coffee C = new Coffee(jA.getJSONObject(i));
//            spaces.add(C);
//        }
//
//        return spaces;
//    }
}
