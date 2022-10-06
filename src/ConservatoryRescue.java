import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConservatoryRescue {

    public List<Aviary> aviaryList = new ArrayList<>();

    public Map<Food, Integer> foodTypeQuantities = new HashMap<>();

    public boolean rescue(Bird bird) {
        if (bird.getBirdType().isExtinct()) {
            return false;
        }
        for (Aviary aviary: aviaryList) {
            if (aviary.addBird(bird)) {
                return true;
            }
        }
        if (aviaryList.size() < 20) {
            Aviary aviary = new Aviary("The aviary locates in number " + aviaryList.size());
            aviary.addBird(bird);
            aviaryList.add(aviary);
            return true;
        }
        return false;
    }
}
