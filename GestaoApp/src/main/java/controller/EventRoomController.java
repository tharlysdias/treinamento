package controller;

import java.util.ArrayList;
import model.EventRoom;

/**
 *
 * @author tharlys
 */
public class EventRoomController {
    public static boolean SaveRoom(String name, int capacity) {
        EventRoom e = new EventRoom(name, capacity);
        return e.PersistirRoom();
    }
    
    // Retorna um ArrayList (vetor) de Strings
    public static ArrayList<String[]> getRooms() {
        ArrayList<String[]> Rooms = new ArrayList();
        
        // Mapear o objeto do tipo sala para um vetor de String
        ArrayList<EventRoom> E = EventRoom.getRooms();
        
        if (E != null) {
            for (int i = 0; i < E.size(); i++) {
                String e[] = new String[2];
                e[0] = E.get(i).getName();
                e[1] = Integer.toString(E.get(i).getCapacity());

                Rooms.add(e);
            }
        }
        
        return Rooms;
    }
}
