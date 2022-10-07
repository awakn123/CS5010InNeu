import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Conservatory {

    public List<Aviary> aviaryList = new ArrayList<>();

    public Map<Food, Integer> foodTypeQuantities = new HashMap<>();

    public Map<Food, Integer> getFoodTypeQuantities()
    {
        return getFoodTypeQuantities();
    }

    public List<Aviary> getAviaryList(){
        return aviaryList;
    }

    public Map printSign(Aviary aviary) {
        Map<String, String> birdInformation = new HashMap<>();
        String s="";
        for (int i = 0; i < aviary.getBirdList().size(); i++) {
            s = s + aviary.getBirdList().get(i).getName() + " : " +
                    aviary.getBirdList().get(i).getDescription() + "\n";
        }

        return birdInformation;
    }

    public String printMap(Conservatory conservatory) {
        Map<String, String> aviaryInformation = new HashMap<>();
        //location+birds
        String s ="";
        for (int i = 0; i < conservatory.getAviaryList().size(); i++) {
            s=s+ "Aviary "+conservatory.getAviaryList().get(i)+":\n " +"\tLocation is " + conservatory.getAviaryList().get(i).getLocation()+
                            ", Birds are "+conservatory.getAviaryList().get(i).printBirdList()+"\n";
        }
        return s;
    }

    public String printIndex() {
        return null;
    }

}
