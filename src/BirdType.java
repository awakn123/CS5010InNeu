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

    public Classification getClassification(){
        return this.classification;
    }

    public boolean isExtinct (){
        return this.extinct;
    }

    public int getNumberOfWings (){
        return numberOfWings;
    }




}
