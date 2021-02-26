package model;

import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;
import util.FileSpace;

/**
 *
 * @author tharlys
 */
public class CoffeSpace {
    
    // Atributo do espaço de café
    private String name;
    private int capacity;
    
    // O espaço de café tem uma lista de pessoas
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
    
    public CoffeSpace(JSONObject json) {
        this.name = json.getString("nome");
        this.capacity = json.getInt("lotacao");
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
    
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("nome", this.name);
        json.put("lotacao", this.capacity);
        return json;
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
    
    // Insere um espaço de café na base de dados
    public boolean PersistirSpace() {
        JSONObject json = this.toJson();
        
        String base = FileSpace.Read();
        JSONArray jA = new JSONArray();
        if (!base.isEmpty() && base.length() > 5) {
            jA = new JSONArray(base);
        }
        
        jA.put(json);
        
        FileSpace.Write(jA.toString());
        
        return true;
    }
    
    // Retorna um ArrayList (vetor) do tipo espaço de café
    public static ArrayList<CoffeSpace> getSpaces() {
        ArrayList<CoffeSpace> spaces = new ArrayList();
        
        // Ler a base de dados
        String base = FileSpace.Read();
        JSONArray jA = new JSONArray(base);
        
        if (base.isEmpty() || base.length() < 5) {
            return null;
        }
        
        for (int i = 0; i < jA.length(); i++) {
            CoffeSpace C = new CoffeSpace(jA.getJSONObject(i));
            spaces.add(C);
        }
        
        return spaces;
    }
}
