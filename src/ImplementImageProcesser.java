import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.FilteredImageSource;
import imagereader.IImageProcessor;
import java.awt.image.RGBImageFilter;

public class ImplementImageProcesser implements IImageProcessor{
	public Image showChanelR(Image sourceImage) {
        System.out.println("What's wrong?");
		RedSwapFilter red = new RedSwapFilter(); 
        System.out.println("What's wrong?");
		return  Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(),red));
	}

	public Image showChanelG(Image sourceImage) {
		GreenSwapFilter green = new GreenSwapFilter(); 
		return  Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(),green));
	}

	public Image showChanelB(Image sourceImage) {
		BlueSwapFilter blue = new BlueSwapFilter(); 
		return  Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(),blue));
	}

	public Image showGray(Image sourceImage) {
		GraySwapFilter grey = new GraySwapFilter(); 
		return  Toolkit.getDefaultToolkit().createImage(new FilteredImageSource(sourceImage.getSource(),grey));
	}

    class RedSwapFilter extends RGBImageFilter {
        public RedSwapFilter() {
            // The filter's operation does not depend on the
            // pixel's location, so IndexColorModels can be
            // filtered directly.
            canFilterIndexColorModel = true;
        }

        public int filterRGB(int x, int y, int rgb) {
            return ((rgb & 0xffff0000));
        }
    }

    class GreenSwapFilter extends RGBImageFilter {
        public GreenSwapFilter() {
            // The filter's operation does not depend on the
            // pixel's location, so IndexColorModels can be
            // filtered directly.
            canFilterIndexColorModel = true;
        }

        public int filterRGB(int x, int y, int rgb) {
            return ((rgb & 0xff00ff00));
        }
    }


    class BlueSwapFilter extends RGBImageFilter {
        public BlueSwapFilter() {
            // The filter's operation does not depend on the
            // pixel's location, so IndexColorModels can be
            // filtered directly.
            canFilterIndexColorModel = true;
        }

        public int filterRGB(int x, int y, int rgb) {
            return ((rgb & 0xff0000ff));
        }
    }


    class GraySwapFilter extends RGBImageFilter {
        public GraySwapFilter() {
            // The filter's operation does not depend on the
            // pixel's location, so IndexColorModels can be
            // filtered directly.
            canFilterIndexColorModel = true;
        }

        public int filterRGB(int x, int y, int rgb) {
            int i = (int) (0.299 * ((rgb & 0x00ff0000) >> 16) + 0.587 * ((rgb & 0x0000ff00) >> 8) + 0.114 * (rgb & 0x000000ff));
            
            return  (int)((0xff000000 & rgb) +(i) + ((i << 8))+((i << 16)) );
        }
    }



}

