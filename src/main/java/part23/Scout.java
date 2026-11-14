package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–5
//
// Part 23 — inheritance: your own robot class, built on top of MBot2.
//
// SECTION A — FOLLOW ALONG: type the Scout class from the guide.
//    Step 1 changes the class line below: that is the one line you DO change.
//    Leave the "package part23;" line and the "import mbot.*;" line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

public class Scout extends MBot2{
    private String name;
    //creates a private string variable
    private Scanner scanner;
    //creates a private scanner variable
    public Scout(String name) {
        super();
        //
        this.name = name;
        //assigns name to name
        this.scanner = new Scanner(this);
        //assigns scanner to a new scanner
    }
    public int driveUntilBlocked() {
        int moves = 0;
        //creates a int variable and assigns it 0
        while (readUltrasonic() > 25) {
            //creates a loop that stops when ultrasonic is more than 25
            straight(5);
            //calls the method
            moves++;
            //adds 1 to moves
        }
        return moves;
        //returns moves
    }

    public int openestIndex() {
        double[] d = scanner.scan();
        //
        int best = 0;
        //creates a int variable and assigns it 0
        for (int i = 1; i < d.length; i++) {
            //creates a loop
            if (d[i] > d[best]) {
                //if conditions are met
                best = i;
                //best equals i
            }
        }
        return best;
        //return best
    }
    public void turnTowardOpenSide() {
        int i = openestIndex();
        //creates a int variable and assigns it to openest index
        if (Scanner.ANGLES[i] > 0) {
            //if conditions are met
            turnLeft(90);
            //turn left
        } else {
            turnRight(90);
            //turn right
        }
    }

    public String toString() {
        return name + " the scout";
        //returns the statement
    }


}
