import java.util.ArrayList;

public class Player {

    int energy;
    int hunger;
    private static ArrayList<Fish> FishInventory = new ArrayList<Fish>();

    Player(int energy, int hunger, ArrayList<Fish> FishInventory)
    {
        this.energy = energy;
        this.hunger = hunger;
        Player.FishInventory = FishInventory;
    }

    public static void addToFishInventory(Fish fish)
    {
        FishInventory.add(fish);
    }

    public String inventoryToString()
    {
        String result = "Inventory: ";

        for (int i = 0; i < FishInventory.size(); i++)
        {
            result += FishInventory.get(i).name;

            if (i == FishInventory.size() - 1)
            {
                result += ".";
            } else {
                result += ", ";
            }
        }
        return result;
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
            //kill player
        }
    }
}
