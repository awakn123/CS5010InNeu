public class BirdType {
    private String name ;
    private boolean extinct ;
    private int numberOfWings ;
    private Classification classification;

    public BirdType(String name, boolean extinct, int numberOfWings, Classification classification){
        name = this.name;
        extinct= this.extinct;
        numberOfWings = this.numberOfWings;
        classification=this.classification;
    }

    public String getTypeName(){
        return this.classification.getClassificationName();
    }

    public String getTypeCharacteristic(){
        return this.classification.getClassificationCharacteristic();
    }


    public boolean isExtinct (){
        return this.extinct;
    }

    public int getNumberOfWings (){
        return numberOfWings;
    }




}
