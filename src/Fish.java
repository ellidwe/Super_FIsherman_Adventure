import java.util.Scanner;
public class Fish {

    String name;
    int difficulty;
    int price;

    Fish(String name, int difficulty, int price) {
        this.name = name;
        this.difficulty = difficulty;
        this.price = price;
    }

    public void catchFish() {
        Scanner s = new Scanner(System.in);
        int randInt = (int) (Math.random() * 5);
        String goalStr = "";

        switch (randInt) {
            case 0: //If randInt is 0
                switch (difficulty) {
                    case 0: //If difficulty is 0
                        goalStr = "Fishing!";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                    case 1: //If difficulty is 1
                        goalStr = "Fish are friends, not food";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                    case 2: //If difficulty is 2
                        goalStr = "The early fish gets the (bait) worm";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                }
                break;
            case 1: //If randInt is 1
                switch (difficulty) {
                    case 0: //If difficulty is 0
                        goalStr = "Splish splash";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                    case 1: //If difficulty is 1
                        goalStr = "I fish; therefore, I am";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                    case 2: //If difficulty is 2
                        goalStr = "One fish, two fish, red fish, blue fish";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                }
                break;
            case 2: //If randInt is 2
                switch (difficulty) {
                    case 0: //If difficulty is 0
                        goalStr = "Go fish!";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                    case 1: //If difficulty is 1
                        goalStr = "Man I Love Fishing!!!.";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                    case 2: //If difficulty is 2
                        goalStr = "There are plenty of fish in the sea";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                }
                break;
            case 3: //If randInt is 3
                switch (difficulty) {
                    case 0: //If difficulty is 0
                        goalStr = "Out fishin'";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                    case 1: //If difficulty is 1
                        goalStr = "Hook, line, and sinker";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                    case 2: //If difficulty is 2
                        goalStr = "Born to fish, forced to talk to my wife";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                }
                break;
            case 4: //If randInt is 4
                switch (difficulty) {
                    case 0: //If difficulty is 0
                        goalStr = "Carp diem";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                    case 1: //If difficulty is 1
                        goalStr = "You gotta be squidding me!";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                    case 2: //If difficulty is 2
                        goalStr = "A reel expert can tackle any problem";
                        System.out.println("Type \"" + goalStr + "\"");
                        break;
                }
                break;
        }
         
        String userStr = s.nextLine();
        
        if (userStr.equalsIgnoreCase(goalStr)) {
            System.out.println("Successful catch!");
            //Add fish to inventory
        } else {
            System.out.println("Unsuccessful");
        }
    }
}