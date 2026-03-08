import org.code.theater.*;
import org.code.media.*;

public class ImageFilter extends ImagePlus {

  /** Instance Variables */
  private Pixel [][] pixels;
  
  /** Constructor */
  public ImageFilter(String fileName) {
    super(fileName);
  }

  public void makeNegative() {
        Pixel[][] pixels = getImagePixels();

        for (int row = 0; row < pixels.length; row++) {
            for (int col = 0; col < pixels[0].length; col++) {
                Pixel p = pixels[row][col];

                // Invert each color channel
                int newRed = 255 - p.getRed();
                int newGreen = 255 - p.getGreen();
                int newBlue = 255 - p.getBlue();

                p.setRed(newRed);
                p.setGreen(newGreen);
                p.setBlue(newBlue);
            }
        }
    }

  
    public void pixelate(int gridSize) {
    Pixel[][] pixels = getImagePixels();

    // traverse in scaled to the gridSize (row increases by gridSize)
    for (int row = 0; row < pixels.length; row += gridSize) {
      // traverse in scaled to the gridSize (col increases by gridSize)
      for (int col = 0; col < pixels[0].length; col += gridSize) {
        // determine ending row / col using the min
        int endRow = Math.min(row + gridSize, pixels.length);
        int endCol = Math.min(col + gridSize, pixels[0].length);

        // variables to total RGB values in region
        int totalRed = 0;
        int totalGreen = 0;
        int totalBlue = 0;

        // traverse the region bounded by the gridSize to total RGB values
        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            totalRed += pixels[regionRow][regionCol].getRed();
            totalGreen += pixels[regionRow][regionCol].getGreen();
            totalBlue += pixels[regionRow][regionCol].getBlue();
          }
        }

        // calculate avg RBG values in region
        int totalPixelsInRegion = (endRow - row) * (endCol - col);
        int avgRed = totalRed / totalPixelsInRegion;
        int avgGreen = totalGreen / totalPixelsInRegion;
        int avgBlue = totalBlue / totalPixelsInRegion;
       
        // traverse the region bounded by the gridSize to set RBG to average
        for (int regionRow = row; regionRow < endRow; regionRow++) {
          for (int regionCol = col; regionCol < endCol; regionCol++) {
            pixels[regionRow][regionCol].setRed(avgRed);
            pixels[regionRow][regionCol].setGreen(avgGreen);
            pixels[regionRow][regionCol].setBlue(avgBlue);
          }
        }
      }
    }
   
  }


  public void applyBlur() {
    Pixel[][] pixels = getImagePixels();
    // traverse starting at (1,1) bc using pixel to the top left
    // need to stop one less so - 1 in for loop condition
    for (int row = 1; row < pixels.length - 1; row++) {
      for (int col = 1; col < pixels[0].length - 1; col++) {
        // call methods to calculate RBG weights
        int weightedRed = calcWeightedRed(pixels, row, col);
        int weightedGreen = calcWeightedGreen(pixels, row, col);
        int weightedBlue = calcWeightedBlue(pixels, row, col);

        // update the RBG with weighted values
        Pixel currentPixel = pixels[row][col];
        currentPixel.setRed(weightedRed);
        currentPixel.setGreen(weightedGreen);
        currentPixel.setBlue(weightedBlue);
      }
    }
  }

  /*
   * Returns a weighted red average of the pixels around the specified row and col
   */
  public int calcWeightedRed(Pixel[][] pixels, int row, int col) {
    int avgRed = (pixels[row-1][col-1].getRed() + pixels[row-1][col].getRed() + pixels[row-1][col+1].getRed() +
                  pixels[row][col-1].getRed() + pixels[row][col].getRed() + pixels[row][col+1].getRed() +
                  pixels[row+1][col-1].getRed() + pixels[row+1][col].getRed() + pixels[row+1][col+1].getRed()) / 9;
    return avgRed;
  }

  /*
   * Returns a weighted green average of the pixels around the specified row and col 
   */
  public int calcWeightedGreen(Pixel[][] pixels, int row, int col) {
    int avgGreen = (pixels[row-1][col-1].getGreen() + pixels[row-1][col].getGreen() + pixels[row-1][col+1].getGreen() +
                    pixels[row][col-1].getGreen() + pixels[row][col].getGreen() + pixels[row][col+1].getGreen() +
                    pixels[row+1][col-1].getGreen() + pixels[row+1][col].getGreen() + pixels[row+1][col+1].getGreen()) / 9;
    return avgGreen;
  }

  /*
   * Returns a weighted blue average of the pixels around the specified row and col
   */
  public int calcWeightedBlue(Pixel[][] pixels, int row, int col) {
    int avgBlue = (pixels[row-1][col-1].getBlue() + pixels[row-1][col].getBlue() + pixels[row-1][col+1].getBlue() +
                   pixels[row][col-1].getBlue() + pixels[row][col].getBlue() + pixels[row][col+1].getBlue() +
                   pixels[row+1][col-1].getBlue() + pixels[row+1][col].getBlue() + pixels[row+1][col+1].getBlue()) / 9;
    return avgBlue;
  }


  public void saturate(int factor) {
    Pixel[][] pixels = getImagePixels();
    for(int r = 0; r < pixels.length; r++){
      for(int c = 0; c < pixels[0].length; c++){
        Pixel currentPixel = pixels [r][c];
        int grayValue = currentPixel.getRed() + currentPixel.getGreen() + currentPixel.getBlue();
        grayValue /= 3;
        int newGrayValue = (grayValue + factor * (grayValue - 255));

        int redValue = 2 * newGrayValue - currentPixel.getRed();
        int greenValue = 2 * newGrayValue - currentPixel.getGreen();
        int blueValue = 2 * newGrayValue - currentPixel.getBlue();

        if (redValue > 255) {
          redValue = 255;
        }
        if (greenValue > 255) {
          greenValue = 255;
        }
        if (blueValue > 255) {
          blueValue = 255;
        }
        currentPixel.setRed (redValue);
        currentPixel.setGreen(greenValue);
        currentPixel.setBlue(blueValue);
       }
    }
  }


  
}