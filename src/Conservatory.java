import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conservatory {

    public List<Aviary> aviaryList = new ArrayList<>();

    public Map<Food, Integer> foodTypeQuantities = new HashMap<>();

    public Map<Food, Integer> getFoodTypeQuantities() {
        return getFoodTypeQuantities();
    }

    public List<Aviary> getAviaryList(){
        return aviaryList;
    }

    public Map printSign(Aviary aviary) {
        Map<String, String> birdInformation = new HashMap<>();
        for (int i = 0; i < aviary.getBirdList().size(); i++) {
            birdInformation.put(String.valueOf(aviary.getBirdList().get(i)),aviary.getBirdList().get(i).getDescription());
        }
        return birdInformation;
    }

    public String printMap(Conservatory conservatory) {
        Map<String, String> aviaryInformation = new HashMap<>();
        //location+birds
        String s ="";
        for (int i = 0; i < conservatory.getAviaryList().size(); i++) {
            aviaryInformation.put(String.valueOf(conservatory.getAviaryList().get(i)),
                    "Location is " + String.valueOf(conservatory.getAviaryList().get(i).getLocation())+
                            ", Birds in this aviary are "+conservatory.getAviaryList().get(i).printBirdList());
        }
        return s;
    }

    public String printIndex() {
        return null;
    }

}
