import java.lang.reflect.Array;
import java.util.ArrayList;

public class Player {

    int energy;
    int hunger;
    private static ArrayList<Fish> inventory = new ArrayList<Fish>();

    Player(int energy, int hunger, ArrayList<Fish> inventory)
    {
        this.energy = energy;
        this.hunger = hunger;
        Player.inventory = inventory;
    }

    public static void addToInventory(Fish fish)
    {
        inventory.add(fish);
    }

    public String inventoryToString()
    {
        String result = "Inventory: ";

        for (int i = 0; i < inventory.size(); i++)
        {
            result += inventory.get(i).name;

            if (i == inventory.size() - 1)
            {
                result += ".";
            } else {
                result += ", ";
            }
        }
        return result;
    }

}
