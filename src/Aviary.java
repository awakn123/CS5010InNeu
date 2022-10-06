import java.util.ArrayList;
import java.util.List;

public class Aviary {
    private static int maxId = 0;
    private int id;
    private List<Bird> birdList = new ArrayList<>();
    private String location;
    private String type;

    public Aviary(String location) {
        this.location = location;
        this.id = maxId;
        maxId++;
    }

    public List<Bird> getBirdList() {
        return birdList;
    }

    public String getLocation() {
        return location;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
