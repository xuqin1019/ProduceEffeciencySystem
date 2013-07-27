/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author xuqin
 */
import java.awt.Button;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * @author chensiyu04 
 * @address www.blogjava.net/chensiyu04
 */
public class ImagePane extends JPanel {
    
    private Image image;
    
    public ImagePane() {
        try {
            image = ImageIO.read(new File("test.jpg"));
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(image, 0, 0, this);
    }
    

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        JPanel panel = new ImagePane();
        Button button = new Button("你好才当曹斗");
        panel.add(button);
        frame.getContentPane().add(panel);
        frame.setSize(800, 600);
        frame.setVisible(true);
    }
}
