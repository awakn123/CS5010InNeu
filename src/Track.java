import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Track {
    private Map<Integer, Bird> birdMap = new HashMap<>();

    public List<Bird> getBirdList() {
        return birdMap.values().stream().collect(Collectors.toList());
    }
}
