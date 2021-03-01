package controller;

import java.util.ArrayList;
import model.CoffeSpace;

/**
 *
 * @author tharlys
 */
public class CoffeSpaceController {
    public static boolean SaveSpace(String name, int capacity) {
        CoffeSpace c = new CoffeSpace(name, capacity);
        return c.PersistirSpace();
    }
    
    /**
     * Retorna um ArrayList (vetor) de Strings
     * 
     * @return
     */
    public static ArrayList<String[]> getSpaces() {
        ArrayList<String[]> Spaces = new ArrayList();
        
        /**
         *  Mapear o objeto do tipo espaço de café para um vetor de String
         *  
         */
        ArrayList<CoffeSpace> C = CoffeSpace.getSpaces();
        
        if (C != null) {
            for (int i = 0; i < C.size(); i++) {
                String c[] = new String[2];
                c[0] = C.get(i).getName();
                c[1] = Integer.toString(C.get(i).getCapacity());

                Spaces.add(c);
            }
        }
        
        return Spaces;
    }
}
