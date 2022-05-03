import processing.core.PApplet;
import processing.event.*;

/**
* Practices the use of various types of inputs to create a terrible interactive drawing program
* @author: T. Guo
*
*/

public class Sketch extends PApplet {
	
  float fltCircleSize = 10;

  int intCircleX = 200;
  int intCircleY = 100;
  int intCircleYSpd = 2;
  int intCircleXSpd = 2;

  boolean upPressed = false;
  boolean downPressed = false;
  boolean leftPressed = false;
  boolean rightPressed = false;
  
  int intLineStartX = 0;
  int intLineStartY = 0;



  public void settings() {
    size(400, 400);
  }


  public void setup() {
    background(255, 127, 80);
    strokeWeight(0);
    stroke(255);
  }


  public void draw() {

    // resets the screen when the SHIFT key is pressed
	  if (keyPressed){
      if (keyCode == SHIFT){
        background(255, 127, 80);
      }
      // Draw a white circle only if a keyboard key is pressed
      fill(255);
      ellipse(intCircleX, intCircleY, fltCircleSize, fltCircleSize);
    }

    // Set the circle's coordinates to the mouse coordinates while the mouse is pressed
    if (mousePressed){
      intCircleY = mouseY;
      intCircleX = mouseX;
    }
    
    // Move the circle according to the keyboard input functions
    if (upPressed) {
      intCircleY -= intCircleYSpd;
    }
    if (downPressed) {
      intCircleY += intCircleYSpd;
     }
    if (leftPressed) {
      intCircleX -= intCircleXSpd;
    }
    if (rightPressed) {
      intCircleX += intCircleXSpd;
    }

  }

  // Set booleans when wasd keys are pressed
  public void keyPressed() {
    if (key == 'w') {
      upPressed = true;
    }
    else if (key == 's') {
      downPressed = true;
    }
    else if (key == 'a') {
      leftPressed = true;
    }
    else if (key == 'd') {
      rightPressed = true;
    }
  }

  // Set booleans when wasd keys are released
  public void keyReleased() {
    if (key == 'w') {
      upPressed = false;
    }
    else if (key == 's') {
      downPressed = false;
    }
    else if (key == 'a') {
      leftPressed = false;
    }
    else if (key == 'd') {
      rightPressed = false;
    }
  }

  /**
  * Increase or decrease the size of the circles/lines drawn according
  * to the mouse scroll and draw the circle to show the size
  * @param event The scrolling MouseEvent used to obtain the amount scrolled
  */ 
  public void mouseWheel(MouseEvent event){
    fltCircleSize -= event.getCount();
    fill(255);
    ellipse(intCircleX, intCircleY, fltCircleSize, fltCircleSize);
  }


  // Get the mouse coordinates when the mouse starts to drag
  public void mouseDragged(){ 
    if (intLineStartX == 0){
      intLineStartX = mouseX;
      intLineStartY = mouseY;
    }
  }


  /**
  * When the mouse is released after dragging, draw a line between the starting
  * mouse coordinates and the current mouse coordinates, then reset the coords
  */ 
  public void mouseReleased(){
    if ( intLineStartX != 0){
      strokeWeight(fltCircleSize);
      line(intLineStartX, intLineStartY, mouseX, mouseY);
      strokeWeight(0);
      intLineStartX = 0;
      intLineStartY = 0;
    }
  }
}