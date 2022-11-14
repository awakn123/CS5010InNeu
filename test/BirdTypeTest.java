import old.BirdType;
import old.Classification;
import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class BirdTypeTest {

    private BirdType birdtype;

    @Before
    public void set(){
        birdtype= new BirdType( "hawk" , false, 2, Classification.BirdsOfPrey );

    }

    @org.junit.Test
    public void getClassification() {
        assertEquals( "BirdsOfPrey", birdtype.getTypeName());
        assertEquals( "Birds of prey all have sharp, hooked beaks with visible nostrils. They include hawks, eagles, and osprey.", birdtype.getTypeCharacteristic());
    }

    @org.junit.Test
    public void isExtinct() {
        assertEquals(false , birdtype.isExtinct());
    }

    @org.junit.Test
    public void getNumberOfWings() {
        assertEquals(2 , birdtype.getNumberOfWings());
    }
}