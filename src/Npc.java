public class Npc {

    private String name;
    private int questMarker;

    Npc(String name, int questMarker) {
        this.name = name;
        this.questMarker = questMarker;
    }

    public String questDialogue() {
        switch (questMarker) {
            case 0:
                return "Wonderful day for fishing!";
            case 1:
                return "Y'know, I've always wanted a pet that ISN'T a fish.";
        }
        return "";
    }

    public String getQuestItem() {
        switch (questMarker) {
            case 1: return "Sea turtle, Box jellyfish, Bullfrog";
        }
        return "";
    }

}
