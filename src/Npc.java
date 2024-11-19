public class Npc {

    private String name;
    private int questMarker;
    private int index1;
    private int index2;
    private int index3;
    private int index4;
    private int index5;
    private int index6;
    private int index7;
    private int index8;

    Npc(String name, int questMarker, int index1, int index2, int index3, int index4, int index5, int index6, int index7, int index8) {
        this.name = name;
        this.questMarker = questMarker;
        this.index1 = index1;
        this.index2 = index2;
        this.index3 = index3;
        this.index4 = index4;
        this.index5 = index5;
        this.index6 = index6;
        this.index7 = index7;
        this.index8 = index8;
    }

    public String questDialogue() {
        switch (questMarker) {
            case 0:
                return "\"Wonderful day for fishing!\"";
            case 1:
                return "\"Y'know, I've always wanted a pet that ISN'T a fish.\"";
            case 2:
                return "\"I really really wanna see a shark! Do you got a shark on you?!\"";
            case 3:
                return "\"Everyone calls carp trash, but I'm quite fond of them! I'd love one right about now, in fact.\"";
            case 4:
                return "\"I could really go for some sushi. Do you have a good fish for sushi?\"";
            case 5:
                return "\"I want a really dangerous fish. Why? Uhhhh... no reason!\"";
            case 6:
                return "\"I hate fishing!!!!!!!! I never get anything good!!!!!\"";
            case 7:
                return "\"I hear that the guy who made this game is really cool!\"";
            case 8:
                return ":)";
        }
        return "";
    }

    public String getQuestItem() {
        switch (questMarker) {
            case 1:
                return "Sea turtle, Box jellyfish, Bullfrog0";
            case 2:
                return "Great white shark, Hammerhead shark00";
            case 3:
                return "Carp000";
            case 4:
                return "Electric eel, Salmon, Tuna fish, King salmon";
            case 5:
                return "Piranha, Electric eel, Box jellyfish0";
        }
        return "";
    }

    public int getIndex1() {
        return index1;
    }

    public int getIndex2() {
        return index2;
    }

    public int getIndex3() {
        return index3;
    }

    public int getIndex4() {
        return index4;
    }

    public int getIndex5() {
        return index5;
    }

    public int getIndex6() {
        return index6;
    }

    public int getIndex7() {
        return index7;
    }

    public int getIndex8() {
        return index8;
    }

}
