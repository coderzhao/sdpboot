package com.anytec.sdproperty.util;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Iterator;

public class ImageUtil {

    public static BufferedImage cutImg(byte[] pic, String format,int x, int y, int width, int height) {

        ByteArrayInputStream in = null;
        BufferedImage imageHandle = null;
        try {

            in = new ByteArrayInputStream(pic);
            Iterator<ImageReader> readers = ImageIO.getImageReadersByFormatName(format);
            ImageReader reader = readers.next();
            ImageInputStream imageInputStream = ImageIO.createImageInputStream(in);
            reader.setInput(imageInputStream, true);
            ImageReadParam param = reader.getDefaultReadParam();
            if (x < 0) {
                width = width + x;
                x = 0;
            }
            if (y < 0) {
                height = height + y;
                y = 0;
            }
            Rectangle rect = new Rectangle(x, y, width, height);
            param.setSourceRegion(rect);
            imageHandle = reader.read(0, param);

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (in != null)
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
        }
        return imageHandle;
//        return bufferedImageToBytes(imageHandle,format);
    }


    public static byte[] bufferedImageToBytes(BufferedImage bImage, String format) {
        ByteArrayOutputStream out = new ByteArrayOutputStream();
        try {
            ImageIO.write(bImage, format, out);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return out.toByteArray();
    }

    public static byte[] drawFaceBox(byte[] pic,int x,int y,int width,int height){
        Image image = Toolkit.getDefaultToolkit().createImage(pic);
        // This code ensures that all the pixels in the image are loaded
        image = new ImageIcon(image).getImage();
        BufferedImage bimage = null;
        // Create a buffered image using the default color model
        int type = BufferedImage.TYPE_INT_RGB;
        bimage = new BufferedImage(image.getWidth(null),
                image.getHeight(null), type);
        // Copy image to buffered image
        Graphics g = bimage.getGraphics();
        Graphics2D g2d=(Graphics2D)g;
        // Paint the image onto the buffered image
        g2d.drawImage(image, 0, 0, null);
        Stroke stroke=new BasicStroke(10.0f);//设置线宽
        g2d.setStroke(stroke);
        g2d.setColor(Color.green);//画笔颜色
        g2d.drawRect(x, y, width, height);
        g2d.dispose();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {

            ImageIO.write(bimage,"jpeg", baos);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                baos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return baos.toByteArray();
    }


}
