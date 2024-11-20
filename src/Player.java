import java.util.ArrayList;

public class Player {

    int energy;
    int hunger;
    int rests;
    private static ArrayList<Fish> fishInventory = new ArrayList<Fish>();

    Player(int energy, int hunger, int rests, ArrayList<Fish> FishInventory)
    {
        this.energy = energy;
        this.hunger = hunger;
        this.rests = rests;
        Player.fishInventory = FishInventory;
    }

    public static void addToFishInventory(Fish fish)
    {
        fishInventory.add(fish);
    }

    public static void removeFromFishInventory(int indexToRemove)
    {
        fishInventory.remove(indexToRemove);
    }

    public String inventoryToString()
    {
        String result = "Inventory: ";

        for (int i = 0; i < fishInventory.size(); i++)
        {
            result += fishInventory.get(i).name;

            if (i == fishInventory.size() - 1)
            {
                result += ".";
            } else {
                result += ", ";
            }
        }
        return result;
    }

    public int findIndexOfFishName(String fishName)
    {
        int numCommas = 0;
        int indexOfTarget = inventoryToString().indexOf(fishName);
        String invBeforeTarget = inventoryToString().substring(0, indexOfTarget);

        if (!invBeforeTarget.isEmpty()) {
            for (int i = 0; i < invBeforeTarget.length(); i++) {
                if (invBeforeTarget.charAt(i) == ',') {
                    numCommas++;
                }
            }
        }
        return numCommas;
    }

    public int getEnergy()
    {
        return energy;
    }

    public int getHunger()
    {
        return hunger;
    }

    public void setEnergy(int newEnergy)
    {
        energy = newEnergy;
    }

    public void setHunger(int newHunger)
    {
        hunger = newHunger;
    }

    public void rest()
    {
        setEnergy(3);
        moreHungry();
        rests += 1;
    }

    public static Npc newNpc()
    {
        Npc npc = new Npc ("", 0, 0, 0, 0, 0, 0, 0, 0, 0);
        int randInt = (int) (Math.random() * 9);
        switch (randInt) {
            case 0:
                npc.setNpcStats("Expert fisherman", 0,0,0,0,0,0,0,0,0);
                return npc;
            case 1:
                npc.setNpcStats("Exotic pet fan", 1,0,10,12,25,27,35,35,35);
                return npc;
            case 2:
                npc.setNpcStats("Little kid", 2,0,17,19,35,35,35,35,35);
                return npc;
            case 3:
                npc.setNpcStats("Mr. Carp", 3,0,4,4,4,4,4,4,4);
                return npc;
            case 4:
                npc.setNpcStats("Sushi chef", 4,0,12,14,20,22,31,33,44);
                return npc;
            case 5:
                npc.setNpcStats("Trustworthy man", 5,0,7,9,21,23,36,36,36);
                return npc;
            case 6:
                npc.setNpcStats("Dejected fisherman", 6,0,0,0,0,0,0,0,0);
                return npc;
            case 7:
                npc.setNpcStats("Super Fisherman Adventure player", 7,0,0,0,0,0,0,0,0);
                return npc;
            case 8:
                npc.setNpcStats(":)", 8,0,0,0,0,0,0,0,0);
                return npc;
        }
        return npc;
    }

    public void moreHungry()
    {
        setHunger(getHunger() - 1);
    }
}
