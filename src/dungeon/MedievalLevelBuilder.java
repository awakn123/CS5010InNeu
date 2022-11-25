package dungeon;

import java.util.List;

public class MedievalLevelBuilder {

    int level;
    int roomNumber;
    int monsterNumber;
    int treasureNumber;

    private List<Room> rooms;

    public MedievalLevelBuilder(int level, int roomNumber, int monsterNumber, int treasureNumber) {
        if (level < 0 || roomNumber < 0 || monsterNumber < 0 || treasureNumber < 0) {
            throw new IllegalArgumentException();
        }
        this.level = level;
        this.roomNumber = roomNumber;
        this.monsterNumber = monsterNumber;
        this.treasureNumber = treasureNumber;
    }

    public void addRoom(String description) {
        if (rooms.size() >= this.roomNumber) {
            throw new IllegalStateException();
        }
        this.rooms.add(new Room(description));
    }

    public void addGoblins(int roomIndexNumber, int numOfGoblinsToBeAdded) {

    }

    public void addOrc(int roomIndexNumber) {

    }

    public void addOgre(int roomIndexNumber) {

    }

    public void addHuman(int roomIndexNumber, String name, String description, int hp) {


    }

    public void addPotion(int roomIndexNumber) {
    }

    public void addGold(int roomIndexNumber, int goldNumber) {
    }

    public void addWeapon(int roomIndexNumber, String weaponDescription) {
    }

    public void addSpecial(int roomIndexNumber, String description, int value) {
        
    }

    public Level build() {
        return null;
    }
}
