import java.util.Scanner;
import java.util.Date;
public class Main {

    public static void main(String[] args) {

        String goalStr = "";
        String userStr = "";

        Date startTimeDate = new Date();
        long startTime;

        Scanner s = new Scanner(System.in);
        Fish testFish = new Fish("Test Fish", 2, 0);

        //Catch fish
        goalStr = testFish.getCatchingGoalStr();
        System.out.println("Type: " + goalStr);

        startTime = startTimeDate.getTime();
        //Gonna run out of time in class but the idea is make a loop that increments a variable that equals starttime by one per ms
        //that passes while the loop is executing until its greater than starttime plus (secs*1000) and if the userStr is correct or incorrect
        // in that time then break the loop or if the loop finishes say "ran out of time" probably a while loop
        userStr = s.nextLine();

        if (userStr.equalsIgnoreCase(goalStr)) {
            System.out.println("Successful catch!");
            //Add fish to inventory
        } else {
            System.out.println("Incorrect String!");
        }
    }
}