package model;

/**
 *
 * @author tharlys
 */
public class CoffeSpace {
    
    // Atributo do espaço de café
    private int id;
    private String name;
    private int capacity;

    // Criando construtores
    public CoffeSpace() {
    }

    public CoffeSpace(int id, String name, int capacity) {
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

    // Método publico que retorna uma String, a qual recebe o nome da classe e o valor que esta armazenado no atributo
    @Override
    public String toString() {
        return "CoffeSpace{" + "id=" + id + ", name=" + name + ", capacity=" + capacity + '}';
    }
    
}
