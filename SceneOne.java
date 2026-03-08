import org.code.theater.*;
import org.code.media.*;

public class SceneOne extends Scene {
  private ImageFilter [][] experience;
  
  /** Constructor */
  public SceneOne(ImageFilter [][] experience) {
    this.experience = experience;
  }

  /**
   * drawScene method which will draw the whole animation
   */
  public void drawScene() {
    playMusic();
    drawTitleScreen();
    drawFilterOne();
    drawFilterTwo();
    drawFilterThree();
    drawFilterFour();
  }

  /**
   * This method is what causes the background music to play
   * Precondition: music file has to exist
   * Postcondition: the background music begins when the program starts
   */
    public void playMusic() {
    double[] music = SoundLoader.read("-bg.wav");
    playSound(music);
  }

  /**
   * This method draws the start screen
   * Precondition: called in the program
   * Postcondition: the title screen will display a teal
   * background and have Personal Experiences written in the
   * middle of the screen
   */
    public void drawTitleScreen () {
    clear ("teal");
    setTextHeight(50);
    setTextColor("black");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    drawText("Personal", 95, 170);
    drawText("Experiences", 50, 230);
    pause(2.0);
  }

  /**
   * This method prints out the first image for the
   * negative filter to be used
   * Precondition: image must be downloaded in the program,
   * image format has to be correct
   * Postcondition:the program will print out the image with 
   * the negative filter
   */
  public void drawFilterOne () {
    for (int r = 0; r < experience.length; r++) {
      for (int c = 0; c < experience.length; c++) {
      clear("white");
      //draws the image
      drawImage(experience[0][0], 0, 0, 400, 400, 0);
      pause(1);
      //adds the negative filter
      experience[r][c].makeNegative();
      drawImage(experience[0][0], 0, 0, 400, 400, 0);
      pause(1);
    }
   }
 }

   /**
   * This method gets the second image in the 2D array and
   * puts the pixelate filter on it.
   * Precondition: image must be downloaded in the program,
   * image format has to be correct
   * Postcondition:the program will print out the image with 
   * the pixelate filter
   */
  public void drawFilterTwo() {
    for (int r = 0; r < experience.length; r++) {
      for (int c = 0; c < experience.length; c++) {
      clear ("white");
      //draws the image
      drawImage(experience[0][1], 0, 0, 400, 400, 0);
      pause(1);
      //applies the pixelate filter
      experience[r][c].pixelate(5);
      pause (1);
    }
   }
 }

   /**
   * This method gets the third image in the 2D array about 
   * experiences and puts the blurring filter on it.
   * Precondition: image must be downloaded in the program,
   * image format has to be correct
   * Postcondition: the image will become blurry
   */
  public void drawFilterThree() {
    for (int r = 0; r < experience.length; r++) {
      for (int c = 0; c < experience.length; c++) {
      clear ("white");
      //draws the image to be put on the screen
      drawImage(experience[1][0], 0, 0, 400, 400, 0);
      pause(1);
      //adds the blurring effect to the image
      experience[r][c].applyBlur();
      pause (1);
    }
   }
 }

   /**
   * This method gets the fourth image in the 2D array and
   * puts the saturate filter on it.
   * Precondition: the photo on [1][1] needs to be in the 
   * file and in the correct format
   * Postcondition: the image will show up in the program
   * and will have an increased color saturation 
   */ 
  public void drawFilterFour() {
    //goes through the array
    for (int r = 0; r < experience.length; r++) {
      for (int c = 0; c < experience.length; c++) {
      clear ("white");
      drawImage(experience[1][1], 0, 0, 400, 400, 0);
      pause(1);
      //adds the saturation filter
      experience[r][c].saturate(10);
      pause (1);
    }
   }
 }
}