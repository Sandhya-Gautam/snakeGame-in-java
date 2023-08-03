import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class login extends JFrame {
    JTextField username, password,message;
    JButton login;
    boolean sign;
    BufferedImage background;
    Dimension screenSize;
    public login(){
        username=new JTextField();
        password= new JTextField();
        message= new JTextField();
        login=new JButton();
        sign=false;
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize(screenSize);
        try{
            background= ImageIO.read(new File("src/nyokaback.png"));
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
        setVisible(true);
    }
    public void paintComponent(Graphics g){
        super.paintComponents(g);
        if (background != null) {
            g.drawImage(background, 0, 0,(int) screenSize.getWidth(),(int) screenSize.getHeight(), this);
        }
    }
    public static void main(String args[]){
        new login();
    }
}
