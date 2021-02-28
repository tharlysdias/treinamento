package controller;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import model.CoffeSpace;
import model.EventRoom;
import model.Person;

/**
 *
 * @author tharlys
 */
public class ConsultDataController {
    public static ArrayList getDados() {
        ArrayList<String[]> Consult = new ArrayList();
        
        ArrayList<Person> P = Person.getPersons();
        ArrayList<EventRoom> E = EventRoom.getRooms();
        ArrayList<CoffeSpace> C = CoffeSpace.getSpaces();
        
        List<Person> pessoa = new ArrayList<Person>();
        int controle = 0;
        for (int j = E.size(); j == 0; j--) {
            for (double i = (P.size()/E.size()); i < 1; i--) {
                
                controle++;
                
                pessoa.add(P.get(controle));
                E.get(controle).setListPerson(pessoa);
            }
        }
        
        if(E!=null) {
            for(int i = 0; i < P.size(); i++) {
                String d[] = new String[3];
                d[0] = P.get(i).getName();
                d[1] = E.get(i).getName();
                
                for (int j = 0; j < C.size(); j++) {
                    d[2] = C.get(j).getName();
                }

                Consult.add(d);
            }
        }
        
        return Consult;
    }
    
    public static ArrayList getDadosSegundo() {
        ArrayList<String[]> ConsultTwo = new ArrayList();
             
        ArrayList<Person> P = Person.getPersons();
        ArrayList<EventRoom> E = EventRoom.getRooms();
        ArrayList<CoffeSpace> C = CoffeSpace.getSpaces();
        
        List<Person> pessoaDois = new ArrayList<Person>();
        int controleDois = 0;
        for (int j = E.size(); j == 0; j--) {
            for (double i = (P.size()/E.size()); i < 1; i--) {
                
                controleDois++;
                
                pessoaDois.add(P.get(controleDois));
                E.get(controleDois).setListPerson(pessoaDois);
            }
        }
        
        if(E!=null) {
            for(int i = 0; i < P.size(); i++) {
                
                String d[] = new String[3]; // 3 - quantidade de colunas da tabela
                
                Collections.reverse(P);
                d[0] = P.get(i).getName();
                
                d[1] = E.get(i).getName();

                for (int j = 0; j < (C.size()-1); j++) {
                    d[2] = C.get(j).getName();
                }

                ConsultTwo.add(d);
            }
        }
        
        return ConsultTwo;
    }
    
    
}
