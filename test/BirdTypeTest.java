import org.junit.Before;

import static org.junit.Assert.assertEquals;

public class BirdTypeTest {

    private BirdType birdtype;

    @Before
    public void set(){
        birdtype= new BirdType( "hawk" , false, 2,Classification.BirdsOfPrey );

    }

    @org.junit.Test
    public void getClassification() {
        //assertEquals( , birdtype.isExtinct());return Classification.BirdsOfPrey.;
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