package controller;

import java.util.ArrayList;
import model.Person;

/**
 * Classe que controla a aplicação, tanto a interação dos dados com a tela, 
 * como também faz outros controles na aplicação (diversos)
 * 
 * @author tharlys
 */
public class PersonController {
    public static boolean SavePerson(String name, String lastName) {
        Person person = new Person(name, lastName);
        return person.Persistir();
    }
    
    /**
     * Metodo retorna um vetor de strings
     * Evitando o envio do objeto (tipo pessoa) direto na interface
     * 
     * @return 
     */
    public static ArrayList<String[]> getPersons() {
        // Vetor de strings para mostrar na interface
        ArrayList<String[]> Persons = new ArrayList();
        
        ArrayList<Person> P = Person.getPersons();
        
        // Se a lista de pessoas for diferente de nulo, faz o tratamento
        if(P!=null) {
            for(int i = 0; i < P.size(); i++) {
                String p[] = new String[2];
                p[0] = P.get(i).getName();
                p[1] = P.get(i).getLastName();

                Persons.add(p);
            }
        }
        
        return Persons;
    }
}
