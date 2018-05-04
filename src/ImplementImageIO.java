import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import imagereader.IImageIO;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.imageio.ImageIO;

public class ImplementImageIO implements IImageIO{
    public Image myRead(String filePath){
    	try {
	    	// read file to the file stream
	        FileInputStream fis = new FileInputStream(filePath);

	        // store binary stream of bmp data
	        byte bytes[] = new byte[54];
	        fis.read(bytes, 0, 54);

	        // read the width #18-21 and the height #22-25 of the bmp
	        int width = byteChangeToInt(bytes[21], bytes[20], bytes[19], bytes[18]);
	        int height = byteChangeToInt(bytes[25], bytes[24], bytes[23], bytes[22]);
	        System.out.println(width+"  "+height); 

	        int imageSize = byteChangeToInt(bytes[37], bytes[36], bytes[35], bytes[34]);

	        // to keep the multiple of four
	        int numOfZero = 0;
	        if(width*3%4 != 0) {
	        	numOfZero = 4 - width*3%4;
	        }

	        int data[] = new int [height*width];
	        byte rgb[] = new byte[imageSize];

	        fis.read(rgb, 0 , imageSize);

	        int index = 0;
	        for(int i = 0; i < height; i++) {
	        	for(int j = 0; j < width; j++) {
	        		int r = fis.read();
	        		int g = fis.read();
	        		int b = fis.read();
	        		data[(height - i - 1)*width + j] = byteChangeToInt((byte) 255, rgb[index + 2],rgb[index + 1], rgb[index]);
	        		index += 3;
	        	}
	        	index += numOfZero;
	        }

	        Image targetImage = Toolkit.getDefaultToolkit().createImage(new MemoryImageSource(  
	        	width, height, data, 0, width));

	        fis.close();

	        return targetImage;

	    }
	    catch(FileNotFoundException ex) {

	    }
	    catch (IOException ex) {

	    }
	    return null;
    }

    
	public Image myWrite(Image image, String filePath) {
		
		try {
            
            int width = image.getWidth(null);
            int height = image.getHeight(null);
            File outFile = new File(filePath);
            BufferedImage bufImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_BGR);
            bufImage.getGraphics().drawImage(image, 0, 0, width, height, null);
            ImageIO.write(bufImage, "bmp", outFile);
            return image;
            
            
        } catch (Exception ex) {
        }
        
        return null;

	}

	private int byteChangeToInt (byte byte1, byte byte2, byte byte3, byte byte4) {
		int value1 = ((int)byte1 & 0xff) << 24;
		int value2 = ((int)byte2 & 0xff) << 16;
		int value3 = ((int)byte3 & 0xff) << 8;
		int value4 = (int)byte4 & 0xff;
		return value1 | value2 | value3 | value4;
	}
}