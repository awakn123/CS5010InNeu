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

    public String printSign(Aviary aviary) {
        String s="";
        if(aviary.getBirdList().size()==0){
            s=s+"There is no bird.";
        }
        for (int i = 0; i < aviary.getBirdList().size(); i++) {
            s = s + aviary.getBirdList().get(i).getName() + " : " +
                    aviary.getBirdList().get(i).getDescription() + "\n";
        }

        return s;
    }

    public String printMap() {
        //location+birds
        String s ="";
        for (int i = 0; i < this.getAviaryList().size(); i++) {
            s=s+ "Aviary "+this.getAviaryList().get(i)+":\n " +"\tLocation is " + this.getAviaryList().get(i).getLocation()+
                            ", Birds are "+this.getAviaryList().get(i).printBirdList()+"\n";
        }
        return s;
    }

    public String printIndex() {
        return null;
    }

}
