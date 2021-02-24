package model;

/**
 *
 * @author tharlys
 */
public class EventRoom {
    
    // Atributos da sala do evento
    private int id;
    private String name;
    private int capacity;

    // Criando construtores
    public EventRoom() {
    }

    public EventRoom(int id, String name, int capacity) {
        this.id = id;
        this.name = name;
        this.capacity = capacity;
    }

    // Métodos de acesso
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    // Método publico que retorna uma String, a qual recebe o nome da classe, como também tem o nome do atributo e o valor que está armazenado no atributo
    @Override
    public String toString() {
        return "EventRoom{" + "id=" + id + ", name=" + name + ", capacity=" + capacity + '}';
    }
    
}
