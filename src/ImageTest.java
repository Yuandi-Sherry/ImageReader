import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.FileNotFoundException;
import java.io.FileInputStream;
import java.awt.image.BufferedImage;
import java.awt.Image;

import javax.imageio.ImageIO;

import java.awt.Toolkit;
import java.awt.image.MemoryImageSource;
import imagereader.IImageIO;
import java.io.File;

public class ImageTest{
    @Before
    public void setUp() throws Exception {
    }
    /*
     * test first red image
     */
    @Test
    public void testRed1()
    {

        ImplementImageIO imageioer = new ImplementImageIO();  
        ImplementImageProcesser processor = new ImplementImageProcesser();  
 
        Image red1 =  imageioer.myRead("./ori/1.bmp");
        Image ans = processor.showChanelR(red1);
        Image tar = imageioer.myRead("./goal/1_red_goal.bmp");
        imageioer.myWrite(ans, "./ans/1_red_ans.bmp");
        int width1 = ans.getWidth(null);
        int height1 = ans.getHeight(null);
        int width2 = tar.getWidth(null);
        int height2 = tar.getHeight(null);
        assertEquals(width1, width2);
        assertEquals(height1, height2);

        int numOfZero = 0;
        if(width1*3%4 != 0) {
            numOfZero = 4 - width1*3%4;
        }

        try {
            FileInputStream ansFis = new FileInputStream("./ans/1_red_ans.bmp");
            FileInputStream tarFis = new FileInputStream("./goal/1_red_goal.bmp");
            byte bytes1[] = new byte[54];
            ansFis.read(bytes1, 0, 54);
            byte bytes2[] = new byte[54];
            tarFis.read(bytes2, 0, 54);
            int imageSize1 = byteChangeToInt(bytes1[37], bytes1[36], bytes1[35], bytes1[34]);
            int imageSize2 = byteChangeToInt(bytes2[37], bytes2[36], bytes2[35], bytes2[34]);
            assertEquals(imageSize1, imageSize2);

            byte rgb1[] = new byte[imageSize1];
            byte rgb2[] = new byte[imageSize2];
            ansFis.read(rgb1, 0 , imageSize1);
            tarFis.read(rgb2, 0 , imageSize2);

            for(int i = 0; i < imageSize1; i++) {
                assertEquals(rgb1[i], rgb2[i]);
            }

        }
        catch(FileNotFoundException ex) { }
        catch(IOException ex) { }
    }

    @Test
    public void testRed2()
    {

        ImplementImageIO imageioer = new ImplementImageIO();  
        ImplementImageProcesser processor = new ImplementImageProcesser();  
 
        Image red1 =  imageioer.myRead("./ori/2.bmp");
        Image ans = processor.showChanelR(red1);
        Image tar = imageioer.myRead("./goal/2_red_goal.bmp");
        imageioer.myWrite(ans, "./ans/2_red_ans.bmp");
        int width1 = ans.getWidth(null);
        int height1 = ans.getHeight(null);
        int width2 = tar.getWidth(null);
        int height2 = tar.getHeight(null);
        assertEquals(width1, width2);
        assertEquals(height1, height2);

        int numOfZero = 0;
        if(width1*3%4 != 0) {
            numOfZero = 4 - width1*3%4;
        }

        try {
            FileInputStream ansFis = new FileInputStream("./ans/2_red_ans.bmp");
            FileInputStream tarFis = new FileInputStream("./goal/2_red_goal.bmp");
            byte bytes1[] = new byte[54];
            ansFis.read(bytes1, 0, 54);
            byte bytes2[] = new byte[54];
            tarFis.read(bytes2, 0, 54);
            int imageSize1 = byteChangeToInt(bytes1[37], bytes1[36], bytes1[35], bytes1[34]);
            int imageSize2 = byteChangeToInt(bytes2[37], bytes2[36], bytes2[35], bytes2[34]);
            assertEquals(imageSize1, imageSize2);

            byte rgb1[] = new byte[imageSize1];
            byte rgb2[] = new byte[imageSize2];
            ansFis.read(rgb1, 0 , imageSize1);
            tarFis.read(rgb2, 0 , imageSize2);

            for(int i = 0; i < imageSize1; i++) {
                assertEquals(rgb1[i], rgb2[i]);
            }

        }
        catch(FileNotFoundException ex) { }
        catch(IOException ex) { }
    }

    @Test
    public void testGreen1()
    {

        ImplementImageIO imageioer = new ImplementImageIO();  
        ImplementImageProcesser processor = new ImplementImageProcesser();  
 
        Image green1 =  imageioer.myRead("./ori/1.bmp");
        Image ans = processor.showChanelG(green1);
        Image tar = imageioer.myRead("./goal/1_green_goal.bmp");
        imageioer.myWrite(ans, "./ans/1_green_ans.bmp");
        int width1 = ans.getWidth(null);
        int height1 = ans.getHeight(null);
        int width2 = tar.getWidth(null);
        int height2 = tar.getHeight(null);
        assertEquals(width1, width2);
        assertEquals(height1, height2);

        int numOfZero = 0;
        if(width1*3%4 != 0) {
            numOfZero = 4 - width1*3%4;
        }

        try {
            FileInputStream ansFis = new FileInputStream("./ans/1_green_ans.bmp");
            FileInputStream tarFis = new FileInputStream("./goal/1_green_goal.bmp");
            byte bytes1[] = new byte[54];
            ansFis.read(bytes1, 0, 54);
            byte bytes2[] = new byte[54];
            tarFis.read(bytes2, 0, 54);
            int imageSize1 = byteChangeToInt(bytes1[37], bytes1[36], bytes1[35], bytes1[34]);
            int imageSize2 = byteChangeToInt(bytes2[37], bytes2[36], bytes2[35], bytes2[34]);
            assertEquals(imageSize1, imageSize2);

            byte rgb1[] = new byte[imageSize1];
            byte rgb2[] = new byte[imageSize2];
            ansFis.read(rgb1, 0 , imageSize1);
            tarFis.read(rgb2, 0 , imageSize2);

            for(int i = 0; i < imageSize1; i++) {
                assertEquals(rgb1[i], rgb2[i]);
            }

        }
        catch(FileNotFoundException ex) { }
        catch(IOException ex) { }
    }

    @Test
    public void testGreen2()
    {

        ImplementImageIO imageioer = new ImplementImageIO();  
        ImplementImageProcesser processor = new ImplementImageProcesser();  
 
        Image green2 =  imageioer.myRead("./ori/2.bmp");
        Image ans = processor.showChanelG(green2);
        Image tar = imageioer.myRead("./goal/2_green_goal.bmp");
        imageioer.myWrite(ans, "./ans/2_green_ans.bmp");
        int width1 = ans.getWidth(null);
        int height1 = ans.getHeight(null);
        int width2 = tar.getWidth(null);
        int height2 = tar.getHeight(null);
        assertEquals(width1, width2);
        assertEquals(height1, height2);

        int numOfZero = 0;
        if(width1*3%4 != 0) {
            numOfZero = 4 - width1*3%4;
        }

        try {
            FileInputStream ansFis = new FileInputStream("./ans/2_green_ans.bmp");
            FileInputStream tarFis = new FileInputStream("./goal/2_green_goal.bmp");
            byte bytes1[] = new byte[54];
            ansFis.read(bytes1, 0, 54);
            byte bytes2[] = new byte[54];
            tarFis.read(bytes2, 0, 54);
            int imageSize1 = byteChangeToInt(bytes1[37], bytes1[36], bytes1[35], bytes1[34]);
            int imageSize2 = byteChangeToInt(bytes2[37], bytes2[36], bytes2[35], bytes2[34]);
            assertEquals(imageSize1, imageSize2);

            byte rgb1[] = new byte[imageSize1];
            byte rgb2[] = new byte[imageSize2];
            ansFis.read(rgb1, 0 , imageSize1);
            tarFis.read(rgb2, 0 , imageSize2);

            for(int i = 0; i < imageSize1; i++) {
                assertEquals(rgb1[i], rgb2[i]);
            }

        }
        catch(FileNotFoundException ex) { }
        catch(IOException ex) { }
    }

     @Test
    public void testBlue1()
    {

        ImplementImageIO imageioer = new ImplementImageIO();  
        ImplementImageProcesser processor = new ImplementImageProcesser();  
 
        Image bue2 =  imageioer.myRead("./ori/1.bmp");
        Image ans = processor.showChanelB(bue2);
        Image tar = imageioer.myRead("./goal/1_blue_goal.bmp");
        imageioer.myWrite(ans, "./ans/1_blue_ans.bmp");
        int width1 = ans.getWidth(null);
        int height1 = ans.getHeight(null);
        int width2 = tar.getWidth(null);
        int height2 = tar.getHeight(null);
        assertEquals(width1, width2);
        assertEquals(height1, height2);

        int numOfZero = 0;
        if(width1*3%4 != 0) {
            numOfZero = 4 - width1*3%4;
        }

        try {
            FileInputStream ansFis = new FileInputStream("./ans/1_blue_ans.bmp");
            FileInputStream tarFis = new FileInputStream("./goal/1_blue_goal.bmp");
            byte bytes1[] = new byte[54];
            ansFis.read(bytes1, 0, 54);
            byte bytes2[] = new byte[54];
            tarFis.read(bytes2, 0, 54);
            int imageSize1 = byteChangeToInt(bytes1[37], bytes1[36], bytes1[35], bytes1[34]);
            int imageSize2 = byteChangeToInt(bytes2[37], bytes2[36], bytes2[35], bytes2[34]);
            assertEquals(imageSize1, imageSize2);

            byte rgb1[] = new byte[imageSize1];
            byte rgb2[] = new byte[imageSize2];
            ansFis.read(rgb1, 0 , imageSize1);
            tarFis.read(rgb2, 0 , imageSize2);

            for(int i = 0; i < imageSize1; i++) {
                assertEquals(rgb1[i], rgb2[i]);
            }

        }
        catch(FileNotFoundException ex) { }
        catch(IOException ex) { }
    }

    @Test
    public void testBlue2()
    {

        ImplementImageIO imageioer = new ImplementImageIO();  
        ImplementImageProcesser processor = new ImplementImageProcesser();  
 
        Image bue2 =  imageioer.myRead("./ori/2.bmp");
        Image ans = processor.showChanelB(bue2);
        Image tar = imageioer.myRead("./goal/2_blue_goal.bmp");
        imageioer.myWrite(ans, "./ans/2_blue_ans.bmp");
        int width1 = ans.getWidth(null);
        int height1 = ans.getHeight(null);
        int width2 = tar.getWidth(null);
        int height2 = tar.getHeight(null);
        assertEquals(width1, width2);
        assertEquals(height1, height2);

        int numOfZero = 0;
        if(width1*3%4 != 0) {
            numOfZero = 4 - width1*3%4;
        }

        try {
            FileInputStream ansFis = new FileInputStream("./ans/2_blue_ans.bmp");
            FileInputStream tarFis = new FileInputStream("./goal/2_blue_goal.bmp");
            byte bytes1[] = new byte[54];
            ansFis.read(bytes1, 0, 54);
            byte bytes2[] = new byte[54];
            tarFis.read(bytes2, 0, 54);
            int imageSize1 = byteChangeToInt(bytes1[37], bytes1[36], bytes1[35], bytes1[34]);
            int imageSize2 = byteChangeToInt(bytes2[37], bytes2[36], bytes2[35], bytes2[34]);
            assertEquals(imageSize1, imageSize2);

            byte rgb1[] = new byte[imageSize1];
            byte rgb2[] = new byte[imageSize2];
            ansFis.read(rgb1, 0 , imageSize1);
            tarFis.read(rgb2, 0 , imageSize2);

            for(int i = 0; i < imageSize1; i++) {
                assertEquals(rgb1[i], rgb2[i]);
            }

        }
        catch(FileNotFoundException ex) { }
        catch(IOException ex) { }
    }

    @Test
    public void testGray1()
    {

        ImplementImageIO imageioer = new ImplementImageIO();  
        ImplementImageProcesser processor = new ImplementImageProcesser();  
 
        Image gray1 =  imageioer.myRead("./ori/1.bmp");
        Image ans = processor.showGray(gray1);
        Image tar = imageioer.myRead("./goal/1_gray_goal.bmp");
        imageioer.myWrite(ans, "./ans/1_gray_ans.bmp");
        int width1 = ans.getWidth(null);
        int height1 = ans.getHeight(null);
        int width2 = tar.getWidth(null);
        int height2 = tar.getHeight(null);
        assertEquals(width1, width2);
        assertEquals(height1, height2);

        int numOfZero = 0;
        if(width1*3%4 != 0) {
            numOfZero = 4 - width1*3%4;
        }

        try {
            FileInputStream ansFis = new FileInputStream("./ans/1_gray_ans.bmp");
            FileInputStream tarFis = new FileInputStream("./goal/1_gray_goal.bmp");
            byte bytes1[] = new byte[54];
            ansFis.read(bytes1, 0, 54);
            byte bytes2[] = new byte[54];
            tarFis.read(bytes2, 0, 54);
            int imageSize1 = byteChangeToInt(bytes1[37], bytes1[36], bytes1[35], bytes1[34]);
            int imageSize2 = byteChangeToInt(bytes2[37], bytes2[36], bytes2[35], bytes2[34]);
            assertEquals(imageSize1, imageSize2);

            byte rgb1[] = new byte[imageSize1];
            byte rgb2[] = new byte[imageSize2];
            ansFis.read(rgb1, 0 , imageSize1);
            tarFis.read(rgb2, 0 , imageSize2);

            for(int i = 0; i < imageSize1; i++) {
                assertEquals(rgb1[i] - rgb2[i] < 1 ? 0: 1, 0);
            }

        }
        catch(FileNotFoundException ex) { }
        catch(IOException ex) { }
    }

    @Test
    public void testGray2()
    {

        ImplementImageIO imageioer = new ImplementImageIO();  
        ImplementImageProcesser processor = new ImplementImageProcesser();  
 
        Image gray2 =  imageioer.myRead("./ori/2.bmp");
        Image ans = processor.showGray(gray2);
        Image tar = imageioer.myRead("./goal/2_gray_goal.bmp");
        imageioer.myWrite(ans, "./ans/2_gray_ans.bmp");
        int width1 = ans.getWidth(null);
        int height1 = ans.getHeight(null);
        int width2 = tar.getWidth(null);
        int height2 = tar.getHeight(null);
        assertEquals(width1, width2);
        assertEquals(height1, height2);

        int numOfZero = 0;
        if(width1*3%4 != 0) {
            numOfZero = 4 - width1*3%4;
        }

        try {
            FileInputStream ansFis = new FileInputStream("./ans/2_gray_ans.bmp");
            FileInputStream tarFis = new FileInputStream("./goal/2_gray_goal.bmp");
            byte bytes1[] = new byte[54];
            ansFis.read(bytes1, 0, 54);
            byte bytes2[] = new byte[54];
            tarFis.read(bytes2, 0, 54);
            int imageSize1 = byteChangeToInt(bytes1[37], bytes1[36], bytes1[35], bytes1[34]);
            int imageSize2 = byteChangeToInt(bytes2[37], bytes2[36], bytes2[35], bytes2[34]);
            assertEquals(imageSize1, imageSize2);

            byte rgb1[] = new byte[imageSize1];
            byte rgb2[] = new byte[imageSize2];
            ansFis.read(rgb1, 0 , imageSize1);
            tarFis.read(rgb2, 0 , imageSize2);

            for(int i = 0; i < imageSize1; i++) {
                assertEquals(rgb1[i], rgb2[i]);
            }

        }
        catch(FileNotFoundException ex) { }
        catch(IOException ex) { }
    }
    private int byteChangeToInt (byte byte1, byte byte2, byte byte3, byte byte4) {
        int value1 = ((int)byte1 & 0xff) << 24;
        int value2 = ((int)byte2 & 0xff) << 16;
        int value3 = ((int)byte3 & 0xff) << 8;
        int value4 = (int)byte4 & 0xff;
        return value1 | value2 | value3 | value4;
    }

}


