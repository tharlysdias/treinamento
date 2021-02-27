package controller;

import java.util.ArrayList;
import model.CoffeSpace;
import model.EventRoom;
import model.Person;

/**
 *
 * @author tharlys
 */
public class ConsultDataController {
    public static ArrayList<String[]> getDados(Person person, EventRoom eventRoom, CoffeSpace coffespace) {
        ArrayList<String[]> Dados = new ArrayList();
        
        ArrayList<Person> P = Person.getPersons();
        ArrayList<EventRoom> E = EventRoom.getRooms();
        ArrayList<CoffeSpace> C = CoffeSpace.getSpaces();
        
        ArrayList<Person> dataPerson = new ArrayList(P);
        ArrayList<EventRoom> dataRoom = new ArrayList(E);
        ArrayList<CoffeSpace> dataSpace = new ArrayList(C);
        
//        if(P!=null) {
//            for(int i = 0; i < P.size(); i++) {
//                P.get(i).getName();
//
//                dataPerson.add(P.get(i));
//            }
//        }
        
        for (int i = 0; i < dataPerson.size(); i++) {
            
            if (dataPerson.size()%2 == 0 && dataRoom.size()%2 == 0) {
                for (int j = 0; j < (dataPerson.size()/2); j++) {
                    
                    dataRoom.get(j).addPerson(dataPerson.get(j));
                }
                
                if (dataPerson.get(i).getName().equalsIgnoreCase(dataRoom.get(i).getListPerson())) {
                    
                }
            } else if (dataRoom.size()%2 == 0) {
                // Não pode dividir pelo número de salas
                // A diferença de pessoas em cada sala tem que ser no máximo 1
            } else {
                // A quantidade de pessoas e salas é impar
                // Precisa respeitar a regra de no máximo 1 pessoa de diferença da outra sala
            }
        }
        
        return Dados;
    }
}
