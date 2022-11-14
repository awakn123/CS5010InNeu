package old;

/**
 * old.BirdType Class. Use for recording the information of the bird type, including the name, extinct, number of wings and its classification
 */
public class BirdType {
    private String name;
    private boolean extinct;
    private int numberOfWings;
    private Classification classification;

    /**
     * Construct a old.BirdType that has a provided name, extinct situation, number of wings and classification
     *
     * @param name           the name of the bird type
     * @param extinct        whether the bird type is extinct or not
     * @param numberOfWings  the number of wings that this kind of bird type has
     * @param classification this bird type belong to which classification
     */
    public BirdType(String name, boolean extinct, int numberOfWings, Classification classification) {
        this.name = name;
        this.extinct = extinct;
        this.numberOfWings = numberOfWings;
        this.classification = classification;
    }


    public String getTypeName() {
        return this.classification.getClassificationName();
    }

    public String getTypeCharacteristic() {
        return this.classification.getClassificationCharacteristic();
    }

    /**
     * Get the classification of the bird type
     *
     * @return the classification
     */
    public Classification getClassification() {
        return this.classification;
    }

    /**
     * Get the extinct situation of the bird type
     *
     * @return the extinct situation of the bird type
     */
    public boolean isExtinct() {
        return this.extinct;
    }

    /**
     * Get the number of wings of the bird type
     *
     * @return the number of wings of the bird type
     */

    public int getNumberOfWings() {
        return numberOfWings;
    }


}
