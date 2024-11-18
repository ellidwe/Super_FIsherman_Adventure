import java.util.ArrayList;

public class Player {

    int energy;
    int hunger;
    private static ArrayList<Fish> fishInventory = new ArrayList<Fish>();

    Player(int energy, int hunger, ArrayList<Fish> FishInventory)
    {
        this.energy = energy;
        this.hunger = hunger;
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
    }

    public void moreHungry()
    {
        setHunger(getHunger() - 1);
        if (getHunger() == 0) {
            System.out.println("You starved to death. Game over.");
            System.exit(0);
        }
    }
}
