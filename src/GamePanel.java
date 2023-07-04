import java.awt.*;
import javax.swing.*;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class GamePanel extends JPanel {
    private BufferedImage backgroundImage;
    GamePanel(){
        setVisible(true);
//        setBackground(new Color(18,218,59));
        setBorder(BorderFactory.createLineBorder(new Color(15,179,31),10));
        try {
            backgroundImage = ImageIO.read(new File("src/background.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 0, 0, getWidth(), getHeight(), this);
        }
    }





}
