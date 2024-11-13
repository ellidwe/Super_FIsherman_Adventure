import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {


    static String str = "";
    static Scanner s = new Scanner(System.in);


    static TimerTask fishingMinigameTimertask = new TimerTask()
    {
        public void run()
        {

            if(str.isEmpty())
            {
                System.out.println("The fish got away!!");
                s.close();
            }
        }
    };

    public static Fish newFish()
    {
        int randIntRarity = (int) (Math.random() * 10); //To get rarity
        int randIntFish = (int) (Math.random() * 7); //To get individual fish from rarity

        Fish fish = new Fish();

        if (randIntRarity == 9) //Rare fish
        {
            switch (randIntFish) {
                case 0:
                    fish.setFishStats("Hammerhead shark", 2, 10);
                    break;
                case 1:
                    fish.setFishStats("Great white shark", 2, 10);
                    break;
                case 2:
                    fish.setFishStats("King salmon", 2, 7);
                    break;
                case 3:
                    fish.setFishStats("Sea turtle", 2, 8);
                    break;
                case 4:
                    fish.setFishStats("Blue marlin", 2, 8);
                    break;
                case 5:
                    fish.setFishStats("Swordfish", 2, 9);
                    break;
                case 6:
                    fish.setFishStats("Box jellyfish", 2, 1);
                    break;
            }
        } else if ((randIntRarity >= 6) && (randIntRarity <= 8)) { //Uncommon fish
            switch (randIntFish) {
                case 0:
                    fish.setFishStats("Tuna fish", 1, 5);
                    break;
                case 1:
                    fish.setFishStats("Salmon", 1, 5);
                    break;
                case 2:
                    fish.setFishStats("Tilapia", 1, 4);
                    break;
                case 3:
                    fish.setFishStats("Electric eel", 1, 2);
                    break;
                case 4:
                    fish.setFishStats("Piranha", 1, 3);
                    break;
                case 5:
                    fish.setFishStats("Bullfrog", 1, 2);
                    break;
                case 6:
                    fish.setFishStats("Blue crab", 1, 3);
                    break;
                  }
        } else { //Common fish
            switch (randIntFish) {
                case 0:
                    fish.setFishStats("Minnow", 0, 1);
                    break;
                case 1:
                    fish.setFishStats("Sea bass", 0, 2);
                    break;
                case 2:
                    fish.setFishStats("Goldfish", 0, 2);
                    break;
                case 3:
                    fish.setFishStats("Clownfish", 0, 2);
                    break;
                case 4:
                    fish.setFishStats("Koi fish", 0, 3);
                    break;
                case 5:
                    fish.setFishStats("Trout", 0, 3);
                    break;
                case 6:
                    fish.setFishStats("Carp", 0, 1);
                    break;
            }
        }
        return fish;
    }

    public static void fishingMinigame(Fish fish)
    {
        String goalStr;
        String userStr = "";
        int timerSecs = (int) (Math.random() * 5) + 8;

        Timer fishingMinigameTimer = new Timer();

        goalStr = fish.getCatchingGoalStr();
        System.out.println("Type: " + goalStr);

        fishingMinigameTimer.schedule(fishingMinigameTimertask, timerSecs * 1000L);

        userStr = s.nextLine();

        fishingMinigameTimer.cancel();
        if (userStr.equalsIgnoreCase(goalStr)) {
            System.out.println("Successful catch!");
            System.out.println(fish.getName() + " added to inventory!");
        } else {
            System.out.println("Incorrect String!");
        }
    }

    public static void main(String[] args) {

        Fish fish = new Fish("Test fish", 2, 2);

        fishingMinigame(fish);

    }
}