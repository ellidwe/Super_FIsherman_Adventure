import java.util.TimerTask;

public class FishingMinigameTask extends TimerTask {

    public boolean timerTaskExecuted;

    public void run()
    {
        System.out.println("The fish got away!! Type anything to exit.");
        Main.settTaskTriggered();
    }
}