import java.util.TimerTask;

public class FishingMinigameTask extends TimerTask {

    public void run()
    {
        System.out.print("The fish got away!! Type anything to exit.");
        Main.settTaskTriggered();
    }
}