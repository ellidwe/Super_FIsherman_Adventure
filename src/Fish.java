public class Fish {

    String name;
    int difficulty;
    int price;

    Fish(String name, int difficulty, int price) {
        this.name = name;
        this.difficulty = difficulty;
        this.price = price;
    }

    public String getCatchingGoalStr() {
        int randInt = (int) (Math.random() * 5);
        String goalStr = "";

        switch (randInt) {
            case 0: //If randInt is 0
                switch (difficulty) {
                    case 0: //If difficulty is 0
                        goalStr = "Fishing!";
                        break;
                    case 1: //If difficulty is 1
                        goalStr = "Fish are friends, not food";
                        break;
                    case 2://If difficulty is 2
                        goalStr = "The early fish gets the (bait) worm";
                        break;
                }
                break;
            case 1: //If randInt is 1
                switch (difficulty) {
                    case 0: //If difficulty is 0
                        goalStr = "Splish splash";
                        break;
                    case 1: //If difficulty is 1
                        goalStr = "I fish; therefore, I am";
                        break;
                    case 2: //If difficulty is 2
                        goalStr = "One fish, two fish, red fish, blue fish";
                        break;
                }
                break;
            case 2: //If randInt is 2
                switch (difficulty) {
                    case 0: //If difficulty is 0
                        goalStr = "Go fish!";
                        break;
                    case 1: //If difficulty is 1
                        goalStr = "Man I Love Fishing!!!.";
                        break;
                    case 2: //If difficulty is 2
                        goalStr = "There are plenty of fish in the sea";
                        break;
                }
                break;
            case 3: //If randInt is 3
                switch (difficulty) {
                    case 0: //If difficulty is 0
                        goalStr = "Out fishin'";
                        break;
                    case 1: //If difficulty is 1
                        goalStr = "Hook, line, and sinker";
                        break;
                    case 2: //If difficulty is 2
                        goalStr = "Born to fish, forced to talk to my wife";
                        break;
                }
                break;
            case 4: //If randInt is 4
                switch (difficulty) {
                    case 0: //If difficulty is 0
                        goalStr = "Carp diem";
                        break;
                    case 1: //If difficulty is 1
                        goalStr = "You gotta be squidding me!";
                        break;
                    case 2: //If difficulty is 2
                        goalStr = "A reel expert can tackle any problem";
                        break;
                }
                break;
        }

        return goalStr;
    }
}