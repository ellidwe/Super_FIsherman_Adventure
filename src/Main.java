import java.util.ArrayList;
import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    static boolean tTaskTriggered = false;

    static Scanner s = new Scanner(System.in);

    public static Fish newFish() {
        int randIntRarity = (int) (Math.random() * 10); //To get rarity
        int randIntFish = (int) (Math.random() * 7); //To get individual fish from rarity

        Fish fish = new Fish();

        if (randIntRarity == 9) { //Rare fish
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

    public static void fishingMinigame(Fish fish) {
        String goalStr;
        String userStr;

        tTaskTriggered = false;

        int timerSecs = (int) (Math.random() * 5) + 8;

        Timer fishingMinigameTimer = new Timer();
        TimerTask fishingMinigameTimertask = new FishingMinigameTask();

        goalStr = fish.getCatchingGoalStr();
        System.out.println("Type: " + goalStr);
        fishingMinigameTimer.schedule(fishingMinigameTimertask, timerSecs * 1000L);

        userStr = s.nextLine();

        fishingMinigameTimer.cancel();
        if (userStr.equalsIgnoreCase(goalStr)) {
            if (!tTaskTriggered) {
                System.out.println("Successful catch!");
                System.out.println(fish.getName() + " added to inventory!");
                System.out.println();
                Player.addToFishInventory(fish);
                fishingMinigameTimer.cancel();
            }
        } else {
            if (!tTaskTriggered)
            {
                System.out.println("Incorrect String!");
                System.out.println();
                fishingMinigameTimer.cancel();
            }
        }
    }

    public static void settTaskTriggered() {
        tTaskTriggered = true;
    }

    static Player player = new Player(3, 5, 1, new ArrayList<>());

    public static void npcQuestHandling(Npc npc)
    {
        String userYesOrNo = "";

        System.out.println(npc.questDialogue());

        if (!npc.getQuestItem().equalsIgnoreCase("0000")) {
            if (player.inventoryToString().contains(npc.getQuestItem().substring(npc.getIndex1(), npc.getIndex2()))) {
                System.out.println("Give them the " + npc.getQuestItem().substring(npc.getIndex1(), npc.getIndex2()) + "? (y to give)");
                userYesOrNo = s.nextLine();
                if (userYesOrNo.equalsIgnoreCase("y")) {
                    Player.removeFromFishInventory(player.findIndexOfFishName(npc.getQuestItem().substring(npc.getIndex1(), npc.getIndex2())));
                    System.out.println("You gave them the " + npc.getQuestItem().substring(npc.getIndex1(), npc.getIndex2()));
                }
            } else if (player.inventoryToString().contains(npc.getQuestItem().substring(npc.getIndex3(), npc.getIndex4()))) {
                System.out.println("Give them the " + npc.getQuestItem().substring(npc.getIndex3(), npc.getIndex4()) + "? (y to give)");
                userYesOrNo = s.nextLine();
                if (userYesOrNo.equalsIgnoreCase("y")) {
                    Player.removeFromFishInventory(player.findIndexOfFishName(npc.getQuestItem().substring(npc.getIndex3(), npc.getIndex4())));
                    System.out.println("You gave them the " + npc.getQuestItem().substring(npc.getIndex3(), npc.getIndex4()));
                }
            } else if (player.inventoryToString().contains(npc.getQuestItem().substring(npc.getIndex5(), npc.getIndex6()))) {
                System.out.println("Give them the " + npc.getQuestItem().substring(npc.getIndex5(), npc.getIndex6()) + "? (y to give)");
                userYesOrNo = s.nextLine();
                if (userYesOrNo.equalsIgnoreCase("y")) {
                    Player.removeFromFishInventory(player.findIndexOfFishName(npc.getQuestItem().substring(npc.getIndex5(), npc.getIndex6())));
                    System.out.println("You gave them the " + npc.getQuestItem().substring(npc.getIndex5(), npc.getIndex6()));
                }
            } else if (player.inventoryToString().contains(npc.getQuestItem().substring(npc.getIndex7(), npc.getIndex8()))) {
                System.out.println("Give them the " + npc.getQuestItem().substring(npc.getIndex7(), npc.getIndex8()) + "? (y to give)");
                userYesOrNo = s.nextLine();
                if (userYesOrNo.equalsIgnoreCase("y")) {
                    Player.removeFromFishInventory(player.findIndexOfFishName(npc.getQuestItem().substring(npc.getIndex7(), npc.getIndex8())));
                    System.out.println("You gave them the " + npc.getQuestItem().substring(npc.getIndex7(), npc.getIndex8()));
                }
            } else {
                System.out.println("You don't have the required fish!");
            }
        }
    }

    public static void main(String[] args) {

        Player player = new Player(3, 5, 1, new ArrayList<>());

        Npc npc1 = Player.newNpc();
        Npc npc2 = Player.newNpc();
        Npc npc3 = Player.newNpc();

        String userCmd = "";
        String userNpcChoice = "";

        System.out.println("You have " + player.getEnergy() + " actions left before resting.");
        System.out.print("What would you like to do? (fish, village, forage, inventory) ");
        System.out.println();
        //noinspection ConstantValue
        while (!userCmd.equalsIgnoreCase("fish")
                || (!(userCmd.equalsIgnoreCase("forage")))
                || (!(userCmd.equalsIgnoreCase("inventory"))) ||
                (!(userCmd.equalsIgnoreCase("village")))) {

            userCmd = s.nextLine();

            if (userCmd.equalsIgnoreCase("fish")) {
                fishingMinigame(newFish());

                player.setEnergy(player.getEnergy() - 1);
                if (player.getEnergy() == 0) {
                    player.rest();
                    if (player.getHunger() == 0) {
                        System.out.println("You starved. Game over.");
                        System.exit(0);
                    }
                    System.out.println("You rest, and your energy recovers.");
                    System.out.println("You're growing hungrier. Current hunger level: " + player.getHunger());
                }

                System.out.println("You have " + player.getEnergy() + " actions left before resting.");
                System.out.print("What would you like to do? (fish, village, forage, inventory) ");
            } else if (userCmd.equalsIgnoreCase("village")) {
                System.out.println("Who would you like to talk to? " + npc1.getName() + " (a), " + npc2.getName() + " (b) " + npc3.getName() + " (c)");

                while ((!userNpcChoice.equalsIgnoreCase("a")) || (!userNpcChoice.equalsIgnoreCase("b")) || (!userNpcChoice.equalsIgnoreCase("c"))) {

                    userNpcChoice = s.nextLine();

                    if (userNpcChoice.equalsIgnoreCase("a")) {
                        npcQuestHandling(npc1);
                    } else if (userNpcChoice.equalsIgnoreCase("b")) {
                        npcQuestHandling(npc2);
                    } else if (userNpcChoice.equalsIgnoreCase("c")) {
                        npcQuestHandling(npc3);
                    } else {
                        System.out.println("Unrecognized command!");
                    }

                }

                player.setEnergy(player.getEnergy() - 1);
                if (player.getEnergy() == 0) {
                    player.rest();
                    if (player.getHunger() == 0) {
                        System.out.println("You starved. Game over.");
                        System.exit(0);
                    }
                    System.out.println("You rest, and your energy recovers.");
                    System.out.println("You're growing hungrier. Current hunger level: " + player.getHunger());
                }

                System.out.println("You have " + player.getEnergy() + " actions left before resting.");
                System.out.print("What would you like to do? (fish, village, forage, inventory) ");
            } else if (userCmd.equalsIgnoreCase("forage")) {
                System.out.println("Not yet added, if you're playtesting ignore this");
                System.out.println();

                player.setEnergy(player.getEnergy() - 1);
                if (player.getEnergy() == 0) {
                    player.rest();
                    if (player.getHunger() == 0) {
                        System.out.println("You starved. Game over.");
                        System.exit(0);
                    }
                    System.out.println("You rest, and your energy recovers.");
                    System.out.println("You're growing hungrier. Current hunger level: " + player.getHunger());
                }

                System.out.println("You have " + player.getEnergy() + " actions left before resting.");
                System.out.print("What would you like to do? (fish, village, forage, inventory) ");
            } else if (userCmd.equalsIgnoreCase("inventory")) {
                System.out.println(player.inventoryToString());
                System.out.println();

                System.out.println("You have " + player.getEnergy() + " actions left before resting.");
                System.out.print("What would you like to do? (fish, village, forage, inventory) ");
            } else {
                System.out.println("Unrecognized command!");

                System.out.println("You have " + player.getEnergy() + " actions left before resting.");
                System.out.print("What would you like to do? (fish, village, forage, inventory) ");
            }
        }
    }
}