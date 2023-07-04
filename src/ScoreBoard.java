import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class  ScoreBoard extends JPanel{
    String user_Name, labelString;
    private BufferedImage backgroundImage;
    JPanel data,logo;
    JLabel score,time,level, uN;
    ScoreBoard(){
        user_Name="sandhya";
        labelString="Level:4";
        data= new JPanel();
        logo= new JPanel();
        level= new JLabel(labelString);
        setBackground(new Color(121,198,136));
        data.setBackground(new Color(121,198,136));
        uN = new JLabel(user_Name);
        score=new JLabel("Score");
        time= new JLabel("Time");
        this.setFont(new Font("Rust",Font.BOLD,100));
        this.setVisible(true);
        GridLayout layout=new GridLayout();
        setLayout(layout);
        data.setLayout(new BoxLayout(data,BoxLayout.PAGE_AXIS));
        data.add(score); data.add(time);
         add(logo);add(level); add(uN);
        add(data);
        try {
            backgroundImage = ImageIO.read(new File("src/logo.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, logo.getX(), logo.getY(), logo.getWidth(), logo.getHeight(), logo);
        }
    }

}