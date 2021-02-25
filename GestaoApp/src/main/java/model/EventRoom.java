package model;

import java.util.ArrayList;

/**
 *
 * @author tharlys
 */
public class EventRoom {
    
    // Atributos da sala do evento
    private String name;
    private int capacity;
    
    // O espaço do evento tem uma lista de pessoas
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
    
}
