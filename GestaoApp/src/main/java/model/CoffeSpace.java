package model;

import java.util.ArrayList;

/**
 *
 * @author tharlys
 */
public class CoffeSpace {
    
    // Atributo do espaço de café
    private String name;
    private int capacity;
    ArrayList<Person> listPersonCoffe;

    // Criando construtores
    public CoffeSpace() {
        // Instanciando o ArrayList
        listPersonCoffe = new ArrayList();
    }

    public CoffeSpace(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        listPersonCoffe = new ArrayList();
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
    
    // Metodo para manipular o ArrayList
    // Retorna a lista inteira de pessoas no espaço de café
    public ArrayList<Person> getListPersonCoffe() {
        return listPersonCoffe;
    }

    // Atribui a lista de pessoas informada ao atributo
    public void setListPersonCoffe(ArrayList<Person> listPersonCoffe) {
        this.listPersonCoffe = listPersonCoffe;
    }
    
    // Adiciona uma pessoa a lista
    public void addPersonCoffe(Person P) {
        P.setSpace(this); // Informa o espaço de café que a pessoa está (Muda o atributo space da person para o espaço que ela está)
        listPersonCoffe.add(P); // Adiciona uma pessoa a um espaço de café
    }
}
