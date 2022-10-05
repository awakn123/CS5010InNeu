public class BirdType {
    private String name ;
    private boolean extinct ;
    private int numberOfWings ;
    private Classification classification;

    public BirdType(String name, boolean extinct, int numberOfWings, Classification classification){
        this.name = name;
        this.extinct= extinct;
        this.numberOfWings = numberOfWings;
        this.classification=classification;
    }

    public String getTypeName(){
        return this.classification.getClassificationName();
    }

    public String getTypeCharacteristic(){
        return this.classification.getClassificationCharacteristic();
    }

    public Classification getClassification() {
        return this.classification;
    }


    public boolean isExtinct (){
        return this.extinct;
    }

    public int getNumberOfWings (){
        return numberOfWings;
    }




}
