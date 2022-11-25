package dungeon;

import java.util.ArrayList;
import java.util.List;

public class MedievalLevelBuilder {

    private int level;
    private int roomNumber;
    private int monsterNumber;
    private int treasureNumber;

    private List<Room> rooms;

    private int currentMonsterNumber;

    private int currentTreasureNumber;

    private static final String goblinDesc = "mischievous and very unpleasant, vengeful, and greedy creature whose primary purpose is to cause trouble to humankind";
    private static final String orcDesc = "brutish, aggressive, malevolent being serving evil";

    private static final String ogreDesc = "large, hideous man-like being that likes to eat humans for lunch";

    private static final String potionDesc = "a healing potion";
    private static final String goldDesc = "pieces of gold";

    public MedievalLevelBuilder(int level, int roomNumber, int monsterNumber, int treasureNumber) {
        if (level < 0 || roomNumber < 0 || monsterNumber < 0 || treasureNumber < 0) {
            throw new IllegalArgumentException();
        }
        this.level = level;
        this.roomNumber = roomNumber;
        this.monsterNumber = monsterNumber;
        this.treasureNumber = treasureNumber;
        this.rooms = new ArrayList<>();
    }

    public void addRoom(String description) {
        if (rooms.size() >= this.roomNumber) {
            throw new IllegalStateException();
        }
        this.rooms.add(new Room(description));
    }

    public void addGoblins(int roomIndexNumber, int numOfGoblinsToBeAdded) {
        Room room = checkMonsterNumAndGetRoom(roomIndexNumber, numOfGoblinsToBeAdded);
        for (int i = 0; i < numOfGoblinsToBeAdded; i++) {
            room.addMonster(new Monster("goblin", goblinDesc, 7));
        }
        this.currentMonsterNumber += numOfGoblinsToBeAdded;
    }

    private Room checkMonsterNumAndGetRoom(int roomIndexNumber, int monsterNum) {
        if (roomIndexNumber < 0 || roomIndexNumber >= this.rooms.size()) {
            throw new IllegalArgumentException();
        }
        if (this.currentMonsterNumber + monsterNum > this.monsterNumber) {
            throw new IllegalStateException();
        }

        Room room = this.rooms.get(roomIndexNumber);
        return room;
    }

    public void addOrc(int roomIndexNumber) {
        Room room = checkMonsterNumAndGetRoom(roomIndexNumber, 1);
        room.addMonster(new Monster("orc", orcDesc, 20));
        this.currentMonsterNumber += 1;
    }

    public void addOgre(int roomIndexNumber) {
        Room room = checkMonsterNumAndGetRoom(roomIndexNumber, 1);
        room.addMonster(new Monster("ogre", ogreDesc, 50));
        this.currentMonsterNumber += 1;
    }

    public void addHuman(int roomIndexNumber, String name, String description, int hp) {
        Room room = checkMonsterNumAndGetRoom(roomIndexNumber, 1);
        room.addMonster(new Monster(name, description, hp));
        this.currentMonsterNumber += 1;
    }

    private Room checkTreasureNumAndGetRoom(int roomIndexNumber, int treasureNumber) {
        if (roomIndexNumber < 0 || roomIndexNumber >= this.rooms.size()) {
            throw new IllegalArgumentException();
        }
        if (this.currentTreasureNumber + treasureNumber > this.treasureNumber) {
            throw new IllegalStateException();
        }

        Room room = this.rooms.get(roomIndexNumber);
        return room;
    }

    public void addPotion(int roomIndexNumber) {
        Room room = this.checkTreasureNumAndGetRoom(roomIndexNumber, 1);
        room.addTreasure(new Treasure(potionDesc, 1));
        this.currentTreasureNumber++;
    }

    public void addGold(int roomIndexNumber, int goldNumber) {
        Room room = this.checkTreasureNumAndGetRoom(roomIndexNumber, 1);
        room.addTreasure(new Treasure(goldDesc, goldNumber));
        this.currentTreasureNumber++;
    }

    public void addWeapon(int roomIndexNumber, String weaponDescription) {
        Room room = this.checkTreasureNumAndGetRoom(roomIndexNumber, 1);
        room.addTreasure(new Treasure(weaponDescription, 10));
        this.currentTreasureNumber++;
    }

    public void addSpecial(int roomIndexNumber, String description, int value) {
        Room room = this.checkTreasureNumAndGetRoom(roomIndexNumber, 1);
        room.addTreasure(new Treasure(description, value));
        this.currentTreasureNumber++;

    }

    public Level build() {
        if (this.rooms.size() != this.roomNumber ||
                this.currentMonsterNumber != this.monsterNumber ||
                this.currentTreasureNumber != this.treasureNumber) {
            throw new IllegalStateException();
        }
        Level result = new Level(this.level);
        for (int i = 0; i < this.rooms.size(); i++) {
            Room room = this.rooms.get(i);
            result.addRoom(room.getDescription());
            for (Monster monster : room.getMonsters()) {
                result.addMonster(i, new Monster(monster.getName(), monster.getDescription(), monster.getHitpoints()));
            }
            for (Treasure treasure : room.getTreasures()) {
                result.addTreasure(i, new Treasure(treasure.getDescription(), treasure.getValue()));
            }
        }
        return result;
    }
}
