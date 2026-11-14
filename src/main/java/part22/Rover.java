package part22;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–9
//
// Part 22 — behaviors: methods that use the sensors to decide what the robot does.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part22;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.

public class Rover {
    private String name;
    // creates a private string variable
    private Chassis base;
    //creates a private chassis variable
    private Ultrasonic eyes;
    //creates a private ultrasonic variable
    private LineSensor floor;
    //creates a private linesensor variable
    private boolean lineWasLeft;
    //creates a private boolean variable
    public Rover(String name) {
        this.name = name;
        //assigns name to name
        this.base = new Chassis();
        // assigns base to a new chassis
        this.eyes = new Ultrasonic(base);
        //assigns base to a new chassis
        this.floor = new LineSensor(base);
        //assigns base to a new chassis
    }
    public int driveUntilBlocked(double cm) {
        int moves = 0;
        // creates a int variable named moves and assigns it 0
        while (eyes.distance() > cm) {
            //creates a loop that stops when eyes distance is greater than cm
            base.straight(5);
            //call the method for base
            moves++;
            //adds 1 to moves
        }
        return moves;
    }
    public void goAroundLeft(double sideways) {
        base.turnLeft(90);
        //call the method for base
        base.straight(sideways);
        //call the method for base
        base.turnRight(90);
        //call the method for base
    }
    public void reachGoal() {
        int first = driveUntilBlocked(15);
        //creates a int variable named first and assigns it driveuntilblocked(15)
        System.out.println("Blocked after " + first + " moves. Going round.");
        //prints the statement
        goAroundLeft(60);
        //calls the method
        int second = driveUntilBlocked(15);
        //creates a int variable named second and assigns it driveuntilblocked(15)
        System.out.println("Blocked after " + second + " moves. That is the far wall.");
        //prints the statement
        base.turnRight(90);
        //call the method for rover
        base.straight(50);
        //call the method for rover
    }
    public void followLine(int steps) {
        for (int i = 0; i < steps; i++) {
            //creates a loop
            int s = floor.status();
            //creates a int variable named s and assigns it floor status
            if (s == 4 || s == 8 || s == 12) {
                //if all conditions are met do the following

                base.turnLeft(4);
                //call the method for rover
                lineWasLeft = true;
                //assigns linewasleft to true
            } else if (s == 1 || s == 2 || s == 3) {
                //if all conditions are met do the following
                base.turnRight(4);
                //call the method for rover
                lineWasLeft = false;
                //assigns linewasleft to false
            } else if (s == 0) {
                // if all conditions are met do the following
                if (lineWasLeft) {
                    //call the method for rover
                    base.turnLeft(4);
                    //call the method for rover
                } else {
                    //call the method for rover
                    base.turnRight(4);
                    //call the method for rover
                }
            } else {
                base.straight(1);
                //call the method for rover
            }
        }
    }
    public String toString() {
        return name + " the rover";
        // return the statement
    }

}
