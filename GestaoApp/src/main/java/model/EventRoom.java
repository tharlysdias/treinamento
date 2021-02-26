package model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import util.FileRoom;

/**
 *
 * @author tharlys
 */
public class EventRoom {
    
    // Atributos da sala do evento
    private String name;
    private int capacity;
    
    // A sala do evento tem uma lista de pessoas
    ArrayList<Person> listPerson;

    // Criando construtores
    public EventRoom() {
        listPerson = new ArrayList();
    }

    public EventRoom(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        listPerson = new ArrayList();
    }
    
    public EventRoom(JSONObject json) {
        this.name = json.getString("nome");
        this.capacity = json.getInt("lotacao");
        listPerson = new ArrayList();
    }
    
    
    // Métodos de acesso
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("nome", this.name);
        json.put("lotacao", this.capacity);
        return json;
    }
    
    // Metodo para manipular o ArrayList de pessoas
    // Retorna a lista inteira de pessoas
    public ArrayList<Person> getListPerson() {
        return listPerson;
    }

    // Atribui uma lista de pessoas ao atributo
    public void setListPerson(ArrayList<Person> listPerson) {
        this.listPerson = listPerson;
    }
    
    // Adiciona uma pessoa a lista
    public void addPerson(Person P) {
        // Muda o atributo sala da pessoa
        P.setRoom(this); // Informa a sala que a pessoa está
        listPerson.add(P);
    }
    
    // Insere uma sala na base de dados
    public boolean PersistirRoom() {
        JSONObject json = this.toJson();
        
        String base = FileRoom.Read();
        JSONArray jA = new JSONArray();
        if (!base.isEmpty() && base.length() > 5) {
            jA = new JSONArray(base);
        }
        
        jA.put(json);
        
        FileRoom.Write(jA.toString());
        
        return true;
    }
    
    // Retorna um ArrayList (vetor) do tipo sala
    public static ArrayList<EventRoom> getRooms() {
        ArrayList<EventRoom> rooms = new ArrayList();
        
        // Ler a base de dados
        String base = FileRoom.Read();
        JSONArray jA = new JSONArray(base);
        
        if (base.isEmpty() || base.length() < 5) {
            return null;
        }
        
        for (int i = 0; i < jA.length(); i++) {
            EventRoom R = new EventRoom(jA.getJSONObject(i));
            rooms.add(R);
        }
        
        return rooms;
    }
}
