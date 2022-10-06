import java.util.*;

public class ConservatoryRescue {

    public List<Aviary> aviaryList = new ArrayList<>();

    public Map<Food, Integer> foodTypeQuantities = new HashMap<>();

    /**
     * Rescue new bird:
     * If the bird is extinct, we should not keep it in aviary, will return false;
     * If not, try to add the bird into each existed aviary, {@link Aviary#addBird(Bird) the aviary principle}.
     * If all aviaries fail, try to add a new aviary if the number of aviaries is less than 20.
     * If fails too, we cannot rescue it, return false;
     * If succeed, will add food type into the food type quantities.
     * @param bird the bird that we want to rescue.
     * @return whether we rescue the bird successfully.
     */
    public boolean rescue(Bird bird) {
        if (bird.getBirdType().isExtinct()) {
            return false;
        }
        for (Aviary aviary : aviaryList) {
            if (aviary.addBird(bird)) {
                this.addFoodType(bird);
                return true;
            }
        }
        if (aviaryList.size() < 20) {
            Aviary aviary = new Aviary("Aviary number " + aviaryList.size());
            aviary.addBird(bird);
            aviaryList.add(aviary);
            this.addFoodType(bird);
            return true;
        }
        return false;
    }

    private void addFoodType(Bird bird) {
        bird.getFoodList().stream().forEach((food) -> {
            foodTypeQuantities.put(food, foodTypeQuantities.getOrDefault(food, 0) + 1);
        });
    }

    /**
     * Print and return the name and its location of current birds in this conservatory,
     * in an alphabetical sorted way by bird name.
     * @return
     */
    public String printIndex() {
        PriorityQueue<Bird> birdQueue = new PriorityQueue<>(new BirdComparator());
        aviaryList.forEach(aviary -> aviary.getBirdList().forEach((bird) -> birdQueue.add(bird)));
        StringBuilder indexBuilder = new StringBuilder();
        while(!birdQueue.isEmpty()) {
            Bird bird = birdQueue.poll();
            indexBuilder.append("The bird name is:").append(bird.getName()).append(", locates in ")
                    .append(bird.getAviary().getLocation()).append(System.lineSeparator());
        }
        System.out.println(indexBuilder);
        return indexBuilder.toString();
    }
}
