import org.code.theater.*;
import org.code.media.*;

public class SceneTwo extends Scene {

  private ImageFilter [][] interest;
  
  /** Constructor */
  public SceneTwo(ImageFilter [][] interest) {
    this.interest = interest;
  }

  /**
   * Top-level drawScene method which will draw the whole animation
   */
  public void drawScene() {
    playMusic();
    drawNextScreen();
    drawFilterOne();
    drawFilterTwo();
    drawFilterThree();
    drawFilterFour();
  }

  /**
   * This method is what allows for the music to play while the program runs
   * Precondition: music file has to exist
   * Postcondition: the background music begins when the program starts
   */
    public void playMusic() {
    double[] music = SoundLoader.read("-bg.wav");
    playSound(music);
  }
  
  /**
   * This method draws the next screen after the images from the
   * experiences 2D array are played
   * Precondition: called in the program
   * Postcondition: the next screen will display a teal
   * background and have Personal Interests written
   */
    public void drawNextScreen () {
    clear ("teal");
    setTextHeight(50);
    setTextColor("black");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    drawText("Personal", 95, 170);
    drawText("Interests", 98, 230);
    pause(2.0);
  }

  /**
   * This method prints out the first image for the
   * negative filter to be used
   * Precondition: image must be downloaded in the program,
   * image format has to be correct
   * Postcondition: the program will print out the image with 
   * the negative filter
   */
  public void drawFilterOne () {
    //goes through the images in the 2D array
    for (int r = 0; r < interest.length; r++) {
      for (int c = 0; c < interest.length; c++) {
      clear("white");
      drawImage(interest[0][0], 0, 0, 400, 400, 0);
      pause(1);
      //adds the negative filter
      interest[r][c].makeNegative();
      drawImage(interest[0][0], 0, 0, 400, 400, 0);
      pause(1);
    }
   }
 }

  /**
   * This method gets the second image in the 2D array about
   * my interests and puts the pixelate filter on it.
   * Precondition: image format has to be correct
   * Postcondition: the program will print out the image with 
   * the pixelate filter
   */
  public void drawFilterTwo() {
    for (int r = 0; r < interest.length; r++) {
      for (int c = 0; c < interest.length; c++) {
      clear ("white");
      //draws the image on the screen
      drawImage(interest[0][1], 0, 0, 400, 400, 0);
      pause(1);
      //adds the pixelate on the image
      interest[r][c].pixelate(5);
      pause (1);
    }
   }
 }

  /**
   * This method gets the third image in the 2D array about 
   * interests and adds the blurring filter to it.
   * Precondition: image must be downloaded in the program
   * Postcondition: the image will become blurred
   */
  public void drawFilterThree() {
    for (int r = 0; r < interest.length; r++) {
      for (int c = 0; c < interest.length; c++) {
      clear ("white");
      //draws the image to be shown in the program
      drawImage(interest[1][0], 0, 0, 400, 400, 0);
      pause(1);
      //adds the blurring effect
      interest[r][c].applyBlur();
      pause (1);
    }
   }
 }

   /**
   * This method gets the fourth image in the 2D array and
   * puts the saturate filter on it.
   * Precondition: the photo [1][1] (row, column) needs to be in the 
   * program file
   * Postcondition: the image will have an increased color saturation 
   */ 
  public void drawFilterFour() {
    //goes through the images in the interest 2D array
    for (int r = 0; r < interest.length; r++) {
      for (int c = 0; c < interest.length; c++) {
      clear ("white");
      drawImage(interest[1][1], 0, 0, 400, 400, 0);
      pause(1);
      //applies the saturate filter
      interest[r][c].saturate(10);
      pause (1);
    }
   }
 }
}