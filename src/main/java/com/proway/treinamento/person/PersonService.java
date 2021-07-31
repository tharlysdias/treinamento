package com.proway.treinamento.person;

import com.proway.treinamento.coffee.Coffee;
import com.proway.treinamento.coffee.CoffeeService;
import com.proway.treinamento.event.Event;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final Person person;
    private final Event event;
    private final Coffee coffee;
    private final PersonRepository repository;
    private final CoffeeService coffeeService;

//    public static ArrayList getDados() {
//        ArrayList<String[]> Consult = new ArrayList();
//
//        ArrayList<Person> P = Person.getPersons();
//        ArrayList<Event> E = Event.getRooms();
//        ArrayList<Coffee> C = Coffee.getSpaces();
//
//        List<Person> pessoa = new ArrayList<Person>();
//        int controle = 0;
//        for (int j = E.size(); j == 0; j--) {
//            for (double i = (P.size()/E.size()); i < 1; i--) {
//
//                controle++;
//
//                pessoa.add(P.get(controle));
//                E.get(controle).setListPerson(pessoa);
//            }
//        }
//
//        if(E!=null) {
//            for(int i = 0; i < P.size(); i++) {
//                String d[] = new String[3];
//
//                d[0] = P.get(i).getName();
//
//                for (int k = 0; k < E.size(); k++) {
//                    d[1] = E.get(k).getName();
//                }
//
//                for (int j = 0; j < C.size(); j++) {
//                    d[2] = C.get(j).getName();
//                }
//                Consult.add(d);
//            }
//        }
//
//        return Consult;
//    }
//
//    public static ArrayList getDadosSegundo() {
//        ArrayList<String[]> ConsultTwo = new ArrayList();
//
//        ArrayList<Person> P = Person.getPersons();
//        ArrayList<Event> E = Event.getRooms();
//        ArrayList<Coffee> C = Coffee.getSpaces();
//
//        List<Person> pessoaDois = new ArrayList<Person>();
//        int controleDois = 0;
//        for (int j = E.size(); j == 0; j--) {
//            for (double i = (P.size()/E.size()); i < 1; i--) {
//
//                controleDois++;
//
//                pessoaDois.add(P.get(controleDois));
//                E.get(controleDois).setListPerson(pessoaDois);
//            }
//        }
//
//        if(E!=null) {
//            Collections.reverse(P);
//            for(int i = 0; i < P.size(); i++) {
//
//                String d[] = new String[3]; // 3 - quantidade de colunas da tabela
//
//                d[0] = P.get(i).getName();
//
//                for (int k = 0; k < (E.size() - 1); k++) {
//                    d[1] = E.get(k).getName();
//                }
//
//                for (int j = 0; j < (C.size()-1); j++) {
//                    d[2] = C.get(j).getName();
//                }
//
//                ConsultTwo.add(d);
//            }
//        }
//
//        return ConsultTwo;
//    }
    
}
