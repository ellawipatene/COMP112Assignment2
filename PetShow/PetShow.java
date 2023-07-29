// This program is copyright VUW.
// You are granted permission to use it to construct your answer to a COMP102 assignment.
// You may not distribute it in any other way without permission.

/* Code for COMP-102-112 - 2021T1, Assignment 2
 * Name: Ella Wipatene
 * Username: wipateella
 * ID: 300558005
 */

import ecs100.*;
import java.awt.Color;

/** Program to create simple animated animal character using the
 *  Animal class.  
 */

public class PetShow{
    /** animate creates two or several animals on the window.
     *  Then animates them according to a fixed script by calling a series
     *  of methods on the animals.
     *  
     *  CORE
     */
    public void animate(){
        /*# YOUR CODE HERE */
        Animal bird = new Animal("Bird", "Fred", 350, 350); 
        Animal dog = new Animal("Dog", "Bob", 250, 350); 
        
        bird.diagonal(-5); 
        
        bird.goRight(250);
        for (int i = 0; i < 5; i++){
            bird.jump(80);
        }
        
        dog.goLeft(250); 
        for (int i = 0; i < 5; i++){
            dog.jump(80);
        }
        
        bird.goLeft(200);
        dog.goRight(200);
        
        bird.introduce("Hello"); 
        dog.introduce("Heya"); 
        bird.shout("Lets dance!"); 
        
        for (int i = 0; i < 50; i++){
            dog.goLeft(1);
            bird.goLeft(1);
            dog.goRight(1);
            bird.goRight(1);
        }
    }

    /** threeAnimalsRoutine creates three animals on the window.
     *  Then makes each animal do the same routine in turn.
     *  You should define a routine method, and threeAnimalsRoutine
     *   should call the routine method three times, to make
     *   each of the three animals perform the routine in turn.
     *   
     *   COMPLETION
     */
    public void threeAnimalsRoutine(){
        Animal turtle = new Animal("Turtle", "Tom", 5, 5); 
        Animal snake = new Animal("Snake", "Sam", 5, 150); 
        Animal dinosaur = new Animal ("Dinosaur", "Dan", 5, 300); 
        Animal tiger = new Animal ("Tiger", "Ted", 650, 300); 
        
        tiger.speak("Welcome to the annual");
        tiger.speak("Vic athletics day!");
        tiger.speak("The first event will be hurdles.");
        tiger.goRight(500); 
        
        UI.fillRect( 300, 300, 10, 100);
        UI.fillRect( 700, 300, 10, 100);
        
        routine(dinosaur, 0); 
        routine(snake, 300);
        routine(turtle, 600);
    }

    /** makes the animal character do a little routine
     */
    public void routine(Animal contestant, int down){
        contestant.jump(-1 * down); 
        contestant.goRight(130); 
        for (int i = 0; i < 3; i++){
            contestant.jump(260);
            contestant.goRight(230);
            contestant.jump(-260);
            contestant.goRight(150);
        }
    }
    
    
    public void challenge(){
        Animal turtle = new Animal("Turtle", "Tom", 5, 5); 
        Animal snake = new Animal("Snake", "Sam", 5, 150); 
        Animal dinosaur = new Animal ("Dinosaur", "Dan", 5, 300); 
        Animal tiger = new Animal ("Tiger", "Ted", 650, 300); 
        
        tiger.speak("The second event will be");
        tiger.speak("long jump!");
        tiger.goRight(500); 
    
        setUpLongJump();
        doLongJump(dinosaur, 0, 2.3);
        doLongJump(snake, 300, 4.6);
        doLongJump(turtle, 600, 3.3);
         
        tiger.goLeft(500);
        tiger.speak("The third event will be");
        tiger.speak("100 meter sprints!");
        tiger.goRight(500);
        
        setUpSprint();
        doSprint(dinosaur, 0, 300, 22); 
        doSprint(snake, 100, 10, 22); 
        doSprint(turtle, 100, 1000, 22);
        
        tiger.goLeft(1050);
        tiger.goRight(1);
        setUpPodium(); 
        tiger.speak("Here are the results");
        tiger.speak("for the Vic athletics.");
        
        doAwards(tiger, turtle, "third", "Tom the Turtle", 800, 100); 
        doAwards(tiger, dinosaur, "second", "Dan the Dinosaur", 450, 100); 
        doAwards(tiger, snake, "first", "Sam the Snake", 600, 200); 
        dinosaur.goRight(1); 
        
        tiger.goRight(1);
        UI.setColor(Color.black); 
        UI.setFontSize(10);
        tiger.speak("Thats the end,");
        tiger.speak("See you again next year.");
    }
    
    public void setUpLongJump(){
        UI.fillRect( 0, 430, 250, 100);
        UI.setColor(Color.yellow); 
        UI.fillRect( 200, 430, 50, 100);
        UI.setColor(Color.orange); 
        UI.fillRect( 250, 430, 50, 100);
        UI.setColor(Color.red);
        UI.fillRect( 300, 430, 50, 100);
        UI.setColor(Color.black);
        UI.fillRect( 350, 430, 10, 100);
        Color sand = new Color(235, 233, 188);
        UI.setColor(sand); 
        UI.fillRect( 360, 430, 400, 100);
        UI.setColor(Color.black); 
        UI.fillRect( 760, 430, 300, 100);
    }
    
    public void doLongJump(Animal contestant, int down, double dist){
        contestant.jump(-1 * down); 
        UI.fillRect( 0, 430, 200, 100);
        contestant.goRight(250); 
        contestant.diagonal(-1 * dist);
        contestant.diagonalDown(-1 * dist);
        UI.sleep(1000); 
        contestant.speak("I jumped " + dist + " meters."); 
        contestant.goRight(600);
    }
    
    public void setUpSprint(){
        UI.setColor(Color.green);
        UI.fillRect( 0, 430, 1000, 100);
        UI.setColor(Color.black);
        UI.fillRect( 0, 430, 130, 100);
        UI.fillRect( 750, 430, 100, 100);
    }
    
    public void doSprint(Animal contestant, int startDist, int speed, int dist){
        contestant.goLeft(345 + startDist);
        contestant.shout("READY, SET, G0!"); 
        contestant.runLeft(dist, speed); 
        contestant.goLeft(200); 
    }
    
    public void setUpPodium(){
        UI.setColor(Color.black); 
        UI.fillRect( 0, 430, 1000, 100);
        UI.fillRect( 300, 380, 420, 50);
        UI.fillRect( 440, 330, 140, 50);
        UI.setColor(Color.white); 
        UI.setFontSize(40); 
        UI.drawString("1", 500, 380);
        UI.drawString("2", 360, 430);
        UI.drawString("3", 640, 430);
    }
    
    public void doAwards(Animal tiger, Animal contestant, String place, String name, int right, int jump){
        UI.setColor(Color.black); 
        UI.setFontSize(10);
        tiger.goRight(1);
        tiger.speak("In " + place + " place we have...");
        tiger.speak(name);
        
        contestant.goRight(right);
        setUpPodium(); 
        contestant.jump(jump);
        setUpPodium();
    }
    
    /** Make buttons to let the user run the methods */
    public void setupGUI(){
        UI.initialise();
        UI.addButton("Clear", UI::clearGraphics );
        UI.addButton("Animate", this::animate );
        UI.addButton("Three", this::threeAnimalsRoutine );
        UI.addButton("Challenge", this::challenge );
        UI.addButton("Quit", UI::quit );
        UI.setDivider(0);       // Expand the graphics area
    }

    public static void main(String[] args){
        PetShow ps = new PetShow();
        ps.setupGUI();
    }
}

