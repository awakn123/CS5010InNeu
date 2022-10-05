public enum Classification {
    BirdsOfPrey("BirdsOfPrey", "Birds of prey all have sharp, hooked beaks with visible nostrils. They include hawks, eagles, and osprey."),
    FlightlessBirds("Flightless birds", "Flightless birds live on the ground and have no (or undeveloped) wings. They include the emus, kiwis, and moas. Some (but not all) of these birds are extinct."),
    Owls("Owls", "Owls are distinguished by the facial disks that frame the eyes and bill."),
    Parrots("Parrots","Parrots have a short, curved beak and are known for their intelligence and ability to mimic sounds. Many pet parrots can learn a vocabulary of up to 100 words and often adopt a single \"favorite\" saying.  They include the rose-ring parakeet, gray parrot, and sulfur-crested cockatoo."),
    Pigeons("Pigeons","Pigeons are known for feeding their young bird milk, which are very similar to the milk of mammals. Found all over the world, there are several varieties that are extinct."),
    Shorebirds("Shorebirds","Shorebirds include the great auk, horned puffin, and African Jacana. They live near water sources including wetlands, freshwater and saltwater shorelands, even the ocean."),
    Waterfowl("Waterfowl", "Waterfowl are another classification that live near water sources (fresh or salt) and include ducks, swans, and geese.");
    private String name;
    private String characteristic;
    private Classification(String name, String characteristic) {
        this.name = name;
        this.characteristic = characteristic;
    }

    public String getClassificationName(){
        return name;
    }
    public String getClassificationCharacteristic(){
        return characteristic;
    }
}
