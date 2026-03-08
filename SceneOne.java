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

  // other methods...
    public void playMusic() {
    double[] music = SoundLoader.read("-bg.wav");
    playSound(music);
  }
  
    public void drawTitleScreen () {
    clear ("teal");
    setTextHeight(50);
    setTextColor("black");
    setTextStyle(Font.SANS, FontStyle.BOLD);
    drawText("Personal", 95, 170);
    drawText("Experiences", 50, 230);
    pause(2.0);
  }

  public void drawFilterOne () {
    for (int r = 0; r < experience.length; r++) {
      for (int c = 0; c < experience.length; c++) {
      clear("white");
      drawImage(experience[0][0], 0, 0, 400, 400, 0);
      pause(1);
      experience[r][c].makeNegative();
      drawImage(experience[0][0], 0, 0, 400, 400, 0);
      pause(1);
    }
   }
 }
  public void drawFilterTwo() {
    for (int r = 0; r < experience.length; r++) {
      for (int c = 0; c < experience.length; c++) {
      clear ("white");
      drawImage(experience[0][1], 0, 0, 400, 400, 0);
      pause(1);
      experience[r][c].pixelate(5);
      pause (1);
    }
   }
 }

  public void drawFilterThree() {
    for (int r = 0; r < experience.length; r++) {
      for (int c = 0; c < experience.length; c++) {
      clear ("white");
      drawImage(experience[1][0], 0, 0, 400, 400, 0);
      pause(1);
      experience[r][c].applyBlur();
      pause (1);
    }
   }
 }

  public void drawFilterFour() {
    for (int r = 0; r < experience.length; r++) {
      for (int c = 0; c < experience.length; c++) {
      clear ("white");
      drawImage(experience[1][1], 0, 0, 400, 400, 0);
      pause(1);
      experience[r][c].saturate(10);
      pause (1);
    }
   }
 }
}