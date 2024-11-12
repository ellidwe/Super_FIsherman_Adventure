import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {

    static String str = "";
    static Scanner s = new Scanner(System.in);

    static TimerTask fishingMinigameTimer = new TimerTask()
    {
        public void run()
        {

            if(str.isEmpty())
            {
                System.out.println("Out of time.");
                s.close();
            }
        }
    };


    public static void main(String[] args) {

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