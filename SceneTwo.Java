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
  // other methods...
    public void playMusic() {
    double[] music = SoundLoader.read("-bg.wav");
    playSound(music);
  }
  
    public void drawNextScreen () {
    clear ("teal");
    setTextHeight(50);
    setTextColor("black");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    drawText("Personal", 95, 170);
    drawText("Interests", 98, 230);
    pause(2.0);
  }

  public void drawFilterOne () {
    for (int r = 0; r < interest.length; r++) {
      for (int c = 0; c < interest.length; c++) {
      clear("white");
      drawImage(interest[0][0], 0, 0, 400, 400, 0);
      pause(1);
      interest[r][c].makeNegative();
      drawImage(interest[0][0], 0, 0, 400, 400, 0);
      pause(1);
    }
   }
 }
  public void drawFilterTwo() {
    for (int r = 0; r < interest.length; r++) {
      for (int c = 0; c < interest.length; c++) {
      clear ("white");
      drawImage(interest[0][1], 0, 0, 400, 400, 0);
      pause(1);
      interest[r][c].pixelate(5);
      pause (1);
    }
   }
 }

  public void drawFilterThree() {
    for (int r = 0; r < interest.length; r++) {
      for (int c = 0; c < interest.length; c++) {
      clear ("white");
      drawImage(interest[1][0], 0, 0, 400, 400, 0);
      pause(1);
      interest[r][c].applyBlur();
      pause (1);
    }
   }
 }

  public void drawFilterFour() {
    for (int r = 0; r < interest.length; r++) {
      for (int c = 0; c < interest.length; c++) {
      clear ("white");
      drawImage(interest[1][1], 0, 0, 400, 400, 0);
      pause(1);
      interest[r][c].saturate(10);
      pause (1);
    }
   }
 }
}