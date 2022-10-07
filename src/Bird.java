import java.util.ArrayList;
import java.util.List;

/**
 * Bird class. The class represents q bird.
 * The Bird has id, type, the food they eat, name, description and the aviary it lives in.
 */
public class Bird {
    private static int maxId = 1;
    private int id;
    private BirdType birdType;
    private List<Food> foodList = new ArrayList<>();
    private String name;
    private String description;
    private Aviary aviary;

    /**
     * Construct a bird object that has a provided bird type and id
     *
     * @param birdType the bird type to be given to this bird
     */

    public Bird(BirdType birdType) {
        this.birdType = birdType;
        this.id = maxId;
        maxId++;
    }

    /**
     * Construct a bird that has a provided bird type, id and name
     *
     * @param name     the name to be given to the bird
     * @param birdType the bird type to be given to the bird type
     */
    public Bird(String name, BirdType birdType) {
        this.birdType = birdType;
        this.id = maxId;
        maxId++;
        this.name = name;
    }

    /**
     * Get the id of the bird
     *
     * @return the id of the bird
     */

    public int getId() {
        return id;
    }

    /**
     * Get the type of the bird
     *
     * @return the type of the bird
     */

    public BirdType getBirdType() {
        return birdType;
    }

    /**
     * Get the food list that the bird eat
     *
     * @return food list the bird eat
     */

    public List<Food> getFoodList() {
        return foodList;
    }

    /**
     * Set the food list that the  bird eat
     *
     * @param foodList the food list that the bird eat
     */

    public void setFoodList(List<Food> foodList) {
        this.foodList = foodList;
    }

    /**
     * mark the food that the bird preferred to eat.
     * @param food
     */

    public void eat(String food) {
        Food foodEnum = Food.valueOf(food);
        if (foodList.contains(foodEnum)) {
            return;
        }
        foodList.add(foodEnum);
    }

    /**
     * Get the vocabulary that parrot learned
     * Will report an exception for this is not a parrot.
     *
     * @return
     */

    public List<String> getVocabulary() {
        throw new IllegalCallerException("The id:" + id + " does not refer to a parrot.");
    }

    /**
     * Get the parrot's favorite saying.
     * Will report an exception for this is not a parrot.
     *
     * @return
     */

    public String getFavorite() {
        throw new IllegalCallerException("The id:" + id + " does not refer to a parrot.");
    }

    /**
     * Set parrot's favourite saying
     * Will report an exception for this is not a parrot.
     *
     * @param favorite
     */
    public void setFavorite(String favorite) {
        throw new IllegalCallerException("The id:" + id + " does not refer to a parrot.");
    }

    /**
     * Set the vocabulary that parrot learned
     * Will report an exception for this is not a parrot.
     *
     * @param vocabulary
     */

    public void setVocabulary(List<String> vocabulary) {
        throw new IllegalCallerException("The id:" + id + " does not refer to a parrot.");
    }

    /**
     * Get the water body that the shorebird or waterfowl live by
     * Will report an exception for this is not a shorebird or waterfowl.
     *
     * @return
     */
    public String getWaterBody() {
        throw new IllegalCallerException("The id:" + id + " does not refer to a shorebird or waterfowl.");
    }

    /**
     * Set the water body that the shorebird or waterfowl live by
     * Will report an exception for this is not a shorebird or waterfowl.
     *
     * @param waterBody the water body that the shorebird or waterfowl live by
     */
    public void setWaterBody(String waterBody) {
        throw new IllegalCallerException("The id:" + id + " does not refer to a shorebird or waterfowl.");
    }

    /**
     * Get the name of the bird
     *
     * @return the bird's name
     */
    public String getName() {
        return name;
    }

    /**
     * Get the description of the bird
     *
     * @return
     */
    public String getDescription() {
        return description;
    }

    /**
     * Set the description of the bird
     *
     * @param description the description of the bird
     */

    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * Get the aviary that the bird lives in
     *
     * @return
     */

    public Aviary getAviary() {
        return aviary;
    }

    /**
     * Set the aviary that the bird lives in
     *
     * @param aviary
     */

    public void setAviary(Aviary aviary) {
        this.aviary = aviary;
    }
}
