import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Conservatory Class. Use for getting food and aviary information in conservatory and
 * printing information of given aviary and information of all the aviaries
 */
public class Conservatory {

    public List<Aviary> aviaryList = new ArrayList<>();

    public Map<Food, Integer> foodTypeQuantities = new HashMap<>();

    /**
     * Get food and according quantities
     *
     * @return the map of food and according quantities
     */
    public Map<Food, Integer> getFoodTypeQuantities() {
        return getFoodTypeQuantities();
    }

    /**
     * get all the aviaries in the conservatory
     *
     * @return the list of aviaries
     */
    public List<Aviary> getAviaryList() {
        return aviaryList;
    }

    /**
     * Print a sign for any given aviary that gives a description of the birds
     * it houses and any interesting information that it may have about that animal.
     * If aviary==null, we should give a prompt that there is no aviary.
     * If there's no bird, return "there is no bird".
     * If there are some birds, return the birds' location and their information.
     *
     * @param aviary thr given aviary
     * @return the birds the given aviary houses and information of the birds
     */
    public String printSign(Aviary aviary) {
        String s = "";
        if (aviary == null) {
            s = s + "There is no aviary.";
            return s;
        }
        if (aviary.getBirdList().size() == 0) {
            s = s + "There is no bird.";
        }
        for (int i = 0; i < aviary.getBirdList().size(); i++) {
            s = s + aviary.getBirdList().get(i).getName() + " : " +
                    aviary.getBirdList().get(i).getDescription() + "\n";
        }

        return s;
    }

    /**
     * Print a "map" that lists all the aviaries by location and the birds they house
     *
     * @return the information of all the aviaries by location and the birds they house
     */

    public String printMap() {
        String s = "";
        for (int i = 0; i < this.getAviaryList().size(); i++) {
            s = s + "Aviary " + i + ":\n " + "\tLocation is " + this.getAviaryList().get(i).getLocation() +
                    ", Birds are " + this.getAviaryList().get(i).printBirdList() + "\n";
        }
        return s;
    }

    public String printIndex() {
        return null;
    }

}
