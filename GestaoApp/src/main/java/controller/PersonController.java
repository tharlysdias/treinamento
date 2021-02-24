package controller;

import java.util.ArrayList;
import model.Person;

/**
 *
 * @author tharlys
 */
public class PersonController {
    public static boolean SavePerson(String name, String lastName) {
        Person person = new Person(name, lastName);
        return person.Persistir();
    }
    
    // Retorna um vetor de strings
    public static ArrayList<String[]> getPersons() {
        // Vetor de strings para mostrar na interface
        ArrayList<String[]> Persons = new ArrayList();
        
        ArrayList<Person> P = Person.getPersons();
        
        // Se a lista de pessoas for diferente de nulo eu faço o tratamento
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
