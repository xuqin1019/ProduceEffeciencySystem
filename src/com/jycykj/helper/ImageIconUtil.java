/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jycykj.helper;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author xuqin
 */
public class ImageIconUtil {
    public static ImageIcon getIcon(String path) {
        ImageIcon imageIconSource = new ImageIcon(path);
        Image image = imageIconSource.getImage();
        Image tempImage = image.getScaledInstance(25,25,Image.SCALE_DEFAULT);
        return  new ImageIcon(tempImage);
    }
}
