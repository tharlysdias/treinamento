package com.proway.treinamento.event;

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
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private int capacity;

    //    @ManyToMany
//    private List<Person> people = new ArrayList<>();

//    @ManyToMany(fetch = FetchType.LAZY)
//    @JoinTable(name = "event_person",
//            joinColumns = @JoinColumn(name = "event_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "person_id", referencedColumnName = "id"))
//    private List<Person> people = new ArrayList<>();

//    // A sala do evento tem uma lista de pessoas
//    List<Person> listPerson;
//
//    public Event(JSONObject json) {
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
//    public void addPerson(Person P) {
//        // Muda o atributo sala da pessoa
//        P.setRoom(this); // Informa a sala que a pessoa está
//        listPerson.add(P);
//    }
//
//    // Insere uma sala na base de dados
//    public boolean PersistirRoom() {
//        JSONObject json = this.toJson();
//
//        String base = FileRoom.Read();
//        JSONArray jA = new JSONArray();
//        if (!base.isEmpty() && base.length() > 5) {
//            jA = new JSONArray(base);
//        }
//
//        jA.put(json);
//
//        FileRoom.Write(jA.toString());
//
//        return true;
//    }
//
//    // Retorna um ArrayList (vetor) do tipo sala
//    public static ArrayList<Event> getRooms() {
//        ArrayList<Event> rooms = new ArrayList();
//
//        // Ler a base de dados
//        String base = FileRoom.Read();
//        JSONArray jA = new JSONArray(base);
//
//        if (base.isEmpty() || base.length() < 5) {
//            return null;
//        }
//
//        for (int i = 0; i < jA.length(); i++) {
//            Event R = new Event(jA.getJSONObject(i));
//            rooms.add(R);
//        }
//
//        return rooms;
//    }
}
