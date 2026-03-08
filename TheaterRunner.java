import org.code.theater.*;
import org.code.media.*;

public class TheaterRunner { 
  public static void main(String[] args) {

    // Create any 2D arrays & variables to be passed as parameters to constructor
    ImageFilter [][] experience = {
      {new ImageFilter ("plane.jpg"), new ImageFilter ("movie.jpg")},
      {new ImageFilter ("football.jpg"), new ImageFilter ("disney.jpg")},
    };

    ImageFilter [][] interest = {
      {new ImageFilter ("volunteer.jpg"), new ImageFilter ("law.jpg")},
      {new ImageFilter ("cooking.jpg"), new ImageFilter ("concert.jpeg")},
    };
    // Instantiate Scene subclass objects
    SceneOne scene1 = new SceneOne(experience);
    SceneTwo scene2 = new SceneTwo(interest);
    
    // Call drawScene methods in each subclass
    scene1.drawScene();
    scene2.drawScene();
     
    // Play scenes in Theater, in order of arguments
    Theater.playScenes(scene1, scene2);
    
  }
}