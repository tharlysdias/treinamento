package com.proway.treinamento.person;

import com.proway.treinamento.coffee.CoffeeService;
import com.proway.treinamento.event.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;
    private final CoffeeService coffeeService;
    private final EventService eventService;

    //    public List<String[]> getData() {
//        List<String[]> result = new ArrayList<>();
//
//        List<Person> people = repository.findAll();
//        List<Event> events = eventService.listAll();
//        List<Coffee> coffees = coffeeService.listAll();
//
//        List<Person> pessoa = new ArrayList<>();
//        int controle = 0;
//
//        for (int j = coffees.size(); j == 0; j--) {
//            for (double i = (people.size() / events.size()); i < 1; i--) {
//
//                controle++;
//
//                pessoa.add(people.get(controle));
//                events.get(controle).setListPerson(pessoa);
//            }
//        }
//
//        if (events != null) {
//            for (int i = 0; i < people.size(); i++) {
//                String d[] = new String[3];
//
//                d[0] = people.get(i).getName();
//
//                for (int k = 0; k < events.size(); k++) {
//                    d[1] = events.get(k).getName();
//                }
//
//                for (int j = 0; j < coffees.size(); j++) {
//                    d[2] = coffees.get(j).getName();
//                }
//                result.add(d);
//            }
//        }
//
//        return result;
//    }

//    public static List getDados() {
//        List<String[]> Consult = new List();
//
//        List<Person> P = Person.getPersons();
//        List<Event> E = Event.getRooms();
//        List<Coffee> C = Coffee.getSpaces();
//
//        List<Person> pessoa = new List<Person>();
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
//    public static List getDadosSegundo() {
//        List<String[]> ConsultTwo = new List();
//
//        List<Person> P = Person.getPersons();
//        List<Event> E = Event.getRooms();
//        List<Coffee> C = Coffee.getSpaces();
//
//        List<Person> pessoaDois = new List<Person>();
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
