package old;

import java.util.*;

/**
 * old.Conservatory Class. Use for getting food and aviary information in conservatory and
 * printing information of given aviary and information of all the aviaries
 */
public class Conservatory {

    public List<Aviary> aviaryList = new ArrayList<>();

    public Map<Food, Integer> foodTypeQuantities = new HashMap<>();

    /**
     * get all the aviaries in the conservatory
     *
     * @return the list of aviaries
     */
    public List<Aviary> getAviaryList() {
        return aviaryList;
    }

    /**
     * Print a sign for any given aviary that gives a description of the birds
     * it houses and any interesting information that it may have about that animal.
     * If aviary==null, we should give a prompt that there is no aviary.
     * If there's no bird, return "there is no bird".
     * If there are some birds, return the birds' location and their information.
     *
     * @param aviary thr given aviary
     * @return the birds the given aviary houses and information of the birds
     */
    public String printSign(Aviary aviary) {
        String s = "";
        if (aviary == null) {
            s = s + "There is no aviary.";
            return s;
        }
        if (aviary.getBirdList().size() == 0) {
            s = s + "There is no bird.";
        }
        for (int i = 0; i < aviary.getBirdList().size(); i++) {
            s = s + aviary.getBirdList().get(i).getName() + " : " +
                    aviary.getBirdList().get(i).getDescription() + "\n";
        }

        return s;
    }

    /**
     * Print a "map" that lists all the aviaries by location and the birds they house
     *
     * @return the information of all the aviaries by location and the birds they house
     */

    public String printMap() {
        String s = "";
        for (int i = 0; i < this.getAviaryList().size(); i++) {
            s = s + "old.Aviary " + i + ":\n " + "\tLocation is " + this.getAviaryList().get(i).getLocation() +
                    ", Birds are " + this.getAviaryList().get(i).printBirdList() + "\n";
        }
        return s;
    }

    /**
     * Rescue new bird:
     * If the bird is extinct, we should not keep it in aviary, will return false;
     * If not, try to add the bird into each existed aviary, {@link Aviary#addBird(Bird) the aviary principle}.
     * If all aviaries fail, try to add a new aviary if the number of aviaries is less than 20.
     * If fails too, we cannot rescue it, return false;
     * If succeeded, will add food type into the food type quantities.
     *
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
            Aviary aviary = new Aviary("old.Aviary number " + aviaryList.size());
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
     *
     * @return
     */
    public String printIndex() {
        PriorityQueue<Bird> birdQueue = new PriorityQueue<>(new BirdComparator());
        aviaryList.forEach(aviary -> aviary.getBirdList().forEach((bird) -> birdQueue.add(bird)));
        StringBuilder indexBuilder = new StringBuilder();
        while (!birdQueue.isEmpty()) {
            Bird bird = birdQueue.poll();
            indexBuilder.append("The bird name is:").append(bird.getName()).append(", locates in ")
                    .append(bird.getAviary().getLocation()).append(System.lineSeparator());
        }
        System.out.println(indexBuilder);
        return indexBuilder.toString();
    }

    /**
     * get Current old.Food type quantities.
     *
     * @return
     */
    public Map<Food, Integer> getFoodTypeQuantities() {
        return foodTypeQuantities;
    }
}
