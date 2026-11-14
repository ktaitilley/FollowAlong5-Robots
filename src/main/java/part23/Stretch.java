package part23;

import mbot.*;

// Guide: GUIDE.md in this folder, steps 1–4 (extends, super(), and a sensor field)
//
// SECTION C — Stretch. Do Stretch A, then Stretch B. The README says what each one should print.
// Stretch B adds a new class, Painter, at the bottom of this file.
//
// There is no main method here yet. Typing it is part of the stretch.
/*
1. runs the constructor
2.runs colorsensor code
3.runs chassis code
4.runs chassis code
5.runs painters code
 */
@MBotLab(world = "color-zones")
public class Stretch {
    public static void main(String[] args){
        Painter p = new Painter();
        System.out.println(p instanceof Painter);
        System.out.println(p instanceof MBot2);
        System.out.println(p instanceof Chassis);
        p.driveToRed();
    }

}

class Painter extends MBot2 {
    private ColorSensor eye;

    Painter() {
        super();
        eye = new ColorSensor(this);
    }

    void showColor() {
        String c = eye.color();
        if (c.equals("red")) {
            turnLedOn(1, 255, 0, 0);
        } else if (c.equals("green")) {
            turnLedOn(1, 0, 255, 0);
        } else if (c.equals("blue")) {
            turnLedOn(1, 0, 0, 255);
        } else if (c.equals("yellow")) {
            turnLedOn(1, 255, 200, 0);
        } else {
            turnLedOff(1);
        }
    }

    void driveToRed() {
        String last = "";
        while (!eye.color().equals("red")) {
            String c = eye.color();
            if (!c.equals(last)) {
                System.out.println("Now on " + c);
                last = c;
            }
            showColor();
            straight(5);
        }
        showColor();
        System.out.println("Stopped on red");
    }
}
