package model;

/**
 *
 * @author tharlys
 */
public class EventRoom {
    
    // Atributos da sala do evento
    private String name;
    private int capacity;

    // Criando construtores
    public EventRoom() {
        
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
}
