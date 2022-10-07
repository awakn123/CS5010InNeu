import java.util.ArrayList;
import java.util.List;

/**
 * Aviary Class. Use for recording the id, location of the aviary and type of birds in it. Also use for adding the bird.
 */
public class Aviary {
    private static int maxId = 0;
    private static List<Classification> NOT_MIXED_CLASSIFICATIONS = new ArrayList<>();
    private static final String CAN_MIXED = "canMixed";

    static {
        NOT_MIXED_CLASSIFICATIONS.add(Classification.FlightlessBirds);
        NOT_MIXED_CLASSIFICATIONS.add(Classification.BirdsOfPrey);
        NOT_MIXED_CLASSIFICATIONS.add(Classification.Waterfowl);
    }

    private int id;
    private List<Bird> birdList = new ArrayList<>();
    private String location;
    private String type;

    /**
     * Construct an Aviary object that has the provided location
     *
     * @param location the location of the given aviary
     */
    public Aviary(String location) {
        this.location = location;
        this.id = maxId;
        maxId++;
    }

    /**
     * Get the bird list in the aviary
     *
     * @return the bird list
     */
    public List<Bird> getBirdList() {
        return birdList;
    }

    /**
     * Get the location of the aviary
     *
     * @return the location
     */
    public String getLocation() {
        return location;
    }


    /**
     * Try to add the bird into this aviary.
     * If the aviary is full(size >=5), will return false;
     * If the bird cannot be mixed with other birds in the aviary, will return false;
     * Other scenarios will succeed.
     *
     * @param bird The bird that wants to join.
     * @return Whether it is added successfully.
     */
    public boolean addBird(Bird bird) {
        if (this.birdList.size() >= 5) {
            return false;
        }
        // Handle those scenarios that the bird must live with same classification.
        if (NOT_MIXED_CLASSIFICATIONS.contains(bird.getBirdType().getClassification())) {
            if (this.type == null) {
                this.birdList.add(bird);
                this.type = bird.getBirdType().getClassification().getClassificationName();
            } else if (this.type.equals(bird.getBirdType().getClassification().getClassificationName())) {
                this.birdList.add(bird);
            } else {
                return false;
            }
        } else {
            // Handle those scenarios that the bird can be mixed with others.
            if (this.type == null || CAN_MIXED.equals(this.type)) {
                this.birdList.add(bird);
                this.type = CAN_MIXED;
            } else {
                return false;
            }
        }
        bird.setAviary(this);
        return true;
    }

    /**
     * print names of all the birds in the aviary
     *
     * @return the names of the birds
     */

    public String printBirdList() {
        String s = "";
        s = s + birdList.get(0).getName();
        for (int i = 1; i < birdList.size(); i++) {
            s = s + ", " + birdList.get(i).getName();
        }
        return s;
    }

}
