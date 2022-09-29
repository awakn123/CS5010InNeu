public enum Classification {
    BirdsOfPrey("BirdsOfPrey", "Birds of prey all have sharp, hooked beaks with visible nostrils. They include hawks, eagles, and osprey."),
    FlightlessBirds("Flightless birds", "Flightless birds live on the ground and have no (or undeveloped) wings. They include the emus, kiwis, and moas. Some (but not all) of these birds are extinct."),;

    private String name;
    private String characteristic;
    private Classification(String name, String characteristic) {
        this.name = name;
        this.characteristic = characteristic;
    }
}
