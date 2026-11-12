package part21;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 2–8
//
// Part 21 — composition: a Rover HAS-A Chassis and HAS-AN Ultrasonic.
//
// SECTION A — FOLLOW ALONG: type the Rover class from the guide in this class.
//    Leave the "package part21;" line, the "import mbot.*;" line and the class line alone.
//    Type everything else yourself.
//
// SECTION B — COMMENTS: when you finish, put a // comment ABOVE every line of code,
//    saying in YOUR OWN WORDS what that line does.
//
// SECTION C — STRETCH B adds a LineSensor and two methods to this class.

public class Rover {
    private String name;
    //creates a private String variable
    private Chassis base;
    //creates a private chassis vaariable
    private Ultrasonic eyes;
    // creates a private ultrasonic variable
    public Rover(String name) {
        this.name = name;
        //assigns name to name
        this.base = new Chassis();
        //assigns the chassis variable to a new chassis
        this.eyes = new Ultrasonic(base);
        // assigns ultrasonic eyes variable to new ultrasonic
    }
    public boolean somethingAhead(double cm) {
        return eyes.distance() < cm;
        // returns eyes once it calls the method
    }
    public void driveUntilBlocked() {
        while (!somethingAhead(20)) {
            //loops while something is 20 cm ahead
            base.straight(5);
            //base calls the method
        }
    }
    public String toString() {
        return name + " the rover";
        //returns the statement
    }

}
