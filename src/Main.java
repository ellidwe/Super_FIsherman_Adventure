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
            if (!tTaskTriggered) {
                System.out.println("Incorrect String!");
                System.out.println();
                fishingMinigameTimer.cancel();
            }
        }
    }

    public static void settTaskTriggered() {
        tTaskTriggered = true;
    }

    static Player player = new Player(3, 5, 1, 0, new ArrayList<>());

    public static void npcQuestHandling(Npc npc) {
        String userYesOrNo = "";

        System.out.println(npc.questDialogue());

        if (!npc.getQuestItem().equalsIgnoreCase("0000")) {
            if (player.inventoryToString().contains(npc.getQuestItem().substring(npc.getIndex1(), npc.getIndex2()))) {
                System.out.println("Give them the " + npc.getQuestItem().substring(npc.getIndex1(), npc.getIndex2()) + "? (y to give)");
                userYesOrNo = s.nextLine();
                if (userYesOrNo.equalsIgnoreCase("y")) {
                    Player.removeFromFishInventory(player.findIndexOfFishName(npc.getQuestItem().substring(npc.getIndex1(), npc.getIndex2())));
                    System.out.println("You gave them the " + npc.getQuestItem().substring(npc.getIndex1(), npc.getIndex2()) + ". You get 20 points!");
                    player.setScore(player.getScore() + 20);

                }
            } else if (player.inventoryToString().contains(npc.getQuestItem().substring(npc.getIndex3(), npc.getIndex4()))) {
                System.out.println("Give them the " + npc.getQuestItem().substring(npc.getIndex3(), npc.getIndex4()) + "? (y to give)");
                userYesOrNo = s.nextLine();
                if (userYesOrNo.equalsIgnoreCase("y")) {
                    Player.removeFromFishInventory(player.findIndexOfFishName(npc.getQuestItem().substring(npc.getIndex3(), npc.getIndex4())));
                    System.out.println("You gave them the " + npc.getQuestItem().substring(npc.getIndex3(), npc.getIndex4()) + ". You get 20 points!");
                    player.setScore(player.getScore() + 20);

                }
            } else if (player.inventoryToString().contains(npc.getQuestItem().substring(npc.getIndex5(), npc.getIndex6()))) {
                System.out.println("Give them the " + npc.getQuestItem().substring(npc.getIndex5(), npc.getIndex6()) + "? (y to give)");
                userYesOrNo = s.nextLine();
                if (userYesOrNo.equalsIgnoreCase("y")) {
                    Player.removeFromFishInventory(player.findIndexOfFishName(npc.getQuestItem().substring(npc.getIndex5(), npc.getIndex6())));
                    System.out.println("You gave them the " + npc.getQuestItem().substring(npc.getIndex5(), npc.getIndex6()) + ". You get 20 points!");
                    player.setScore(player.getScore() + 20);

                }
            } else if (player.inventoryToString().contains(npc.getQuestItem().substring(npc.getIndex7(), npc.getIndex8()))) {
                System.out.println("Give them the " + npc.getQuestItem().substring(npc.getIndex7(), npc.getIndex8()) + "? (y to give)");
                userYesOrNo = s.nextLine();
                if (userYesOrNo.equalsIgnoreCase("y")) {
                    Player.removeFromFishInventory(player.findIndexOfFishName(npc.getQuestItem().substring(npc.getIndex7(), npc.getIndex8())));
                    System.out.println("You gave them the " + npc.getQuestItem().substring(npc.getIndex7(), npc.getIndex8()) + ". You get 20 points!");
                    player.setScore(player.getScore() + 20);
                }
            } else {
                System.out.println("You don't have the required fish!");
            }
        }
    }

    public static void main(String[] args) {

        System.out.println("Welcome to Super Fisherman Adventure! Your goal in the game is to earn the most points before you die of starvation. \nYou can earn points via catching fish, and either selling them to the fish buyer, or, if you have the right fish, \ngiving them to an NPC in the village to complete a quest. \nHave fun! \n");

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
                    npc1 = Player.newNpc();
                    npc2 = Player.newNpc();
                    npc3 = Player.newNpc();
                    if (player.getHunger() == 0) {
                        System.out.println("You starved. Game over.");
                        System.out.println("Score: " + player.getScore());
                        System.exit(0);
                    }
                    System.out.println("You rest, and your energy recovers.");
                    System.out.println("You're growing hungrier. Current hunger level: " + player.getHunger());
                }

                System.out.println("You have " + player.getEnergy() + " actions left before resting.");
                System.out.print("What would you like to do? (fish, village, forage, inventory) ");
            } else if (userCmd.equalsIgnoreCase("village")) {
                System.out.println("Who would you like to talk to? (a) " + npc1.getName() + " (b) " + npc2.getName() + " (c) " + npc3.getName() + " (d) the fish buyer (leave) or nobody?");

                while ((!userNpcChoice.equalsIgnoreCase("a")) || (!userNpcChoice.equalsIgnoreCase("b")) || (!userNpcChoice.equalsIgnoreCase("c")) || (!userNpcChoice.equalsIgnoreCase("d")) || (!userNpcChoice.equalsIgnoreCase("leave"))) {

                    userNpcChoice = s.nextLine();

                    if (userNpcChoice.equalsIgnoreCase("a")) {
                        npcQuestHandling(npc1);
                        System.out.println("Who would you like to talk to? (a) " + npc1.getName() + " (b) " + npc2.getName() + " (c) " + npc3.getName() + " (d) the fish buyer (leave) or nobody?");
                    } else if (userNpcChoice.equalsIgnoreCase("b")) {
                        npcQuestHandling(npc2);
                        System.out.println("Who would you like to talk to? (a) " + npc1.getName() + " (b) " + npc2.getName() + " (c) " + npc3.getName() + " (d) the fish buyer (leave) or nobody?");
                    } else if (userNpcChoice.equalsIgnoreCase("c")) {
                        npcQuestHandling(npc3);
                        System.out.println("Who would you like to talk to? (a) " + npc1.getName() + " (b) " + npc2.getName() + " (c) " + npc3.getName() + " (d) the fish buyer (leave) or nobody?");
                    } else if (userNpcChoice.equalsIgnoreCase("d")) {
                        System.out.println("\"Welcome to the shop! What're ya sellin'!\"");
                        for (int i = 0; i < Player.getFishInventory().size(); i++ ) {
                            System.out.println("Would you like to sell your " + Player.getFishInventory().get(i).getName() + " (y to sell)");
                            String userY = s.nextLine();
                            if (userY.equalsIgnoreCase("y")) {
                                System.out.println("Sold " + Player.getFishInventory().get(i).getName() + " for " + Player.getFishInventory().get(i).getPrice() + " points");
                                player.setScore(player.getScore() + Player.getFishInventory().get(i).getPrice());
                                Player.removeFromFishInventory(Player.getFishInventory().indexOf(Player.getFishInventory().get(i)));
                            }
                        }
                        System.out.println("\"Have a good one!\"");
                        System.out.println();
                        System.out.println("Who would you like to talk to? (a) " + npc1.getName() + " (b) " + npc2.getName() + " (c) " + npc3.getName() + " (d) the fish buyer (leave) or nobody?");
                    } else if (userNpcChoice.equalsIgnoreCase("leave")) {
                        break;
                    } else {
                        System.out.println("Unrecognized command!");
                        System.out.println("Who would you like to talk to? (a) " + npc1.getName() + " (b) " + npc2.getName() + " (c) " + npc3.getName() + " (d) the fish buyer (leave) or nobody?");

                    }
                }

                player.setEnergy(player.getEnergy() - 1);
                if (player.getEnergy() == 0) {
                    player.rest();
                    npc1 = Player.newNpc();
                    npc2 = Player.newNpc();
                    npc3 = Player.newNpc();
                    if (player.getHunger() == 0) {
                        System.out.println("You starved. Game over.");
                        System.out.println("Score: " + player.getScore());
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
                    npc1 = Player.newNpc();
                    npc2 = Player.newNpc();
                    npc3 = Player.newNpc();
                    if (player.getHunger() == 0) {
                        System.out.println("You starved. Game over.");
                        System.out.println("Score: " + player.getScore());
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
