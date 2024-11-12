import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    private static String str = "";

    static TimerTask fishingMinigameTimer = new TimerTask()
    {
        public void run()
        {

            if(str.isEmpty())
            {
                System.out.println("Out of time, type anything to end.");
            }
        }
    };


    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        Fish testFish = new Fish("Test Fish", 2, 0);

        //Catch fish
        String goalStr;
        String userStr = "";

        Timer timer = new Timer();

        goalStr = testFish.getCatchingGoalStr();
        System.out.println("Type: " + goalStr);

        timer.schedule(fishingMinigameTimer, 10*1000);

        userStr = s.nextLine();

            timer.cancel();
            if (userStr.equalsIgnoreCase(goalStr)) {
                System.out.println("Successful catch!");
                //Add fish to inventory
            } else {
                System.out.println("Incorrect String!");
            }
        }
    }