import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;


public class  ScoreBoard extends JPanel {
    String user_Name, labelString;
    BufferedImage backgroundImage;
    JPanel data,logo;
    JLabel score,time,level, uN;
    ScoreBoard(){
        user_Name="Username:";
        labelString="Level:";
        data= new JPanel();
        logo= new JPanel();
        level= new JLabel(labelString);
        setBackground(new Color(121,198,136));
        setForeground(Color.green);
        data.setBackground(new Color(121,198,136));
        logo.setBackground(new Color(121,198,136));
        uN = new JLabel(user_Name);
        score=new JLabel("Score:");
        time= new JLabel("Time:");
        data.setFont(new Font("Rust",Font.BOLD,20));
        score.setFont(new Font("Rust",Font.BOLD,20));
        time.setFont(new Font("Rust",Font.BOLD,20));
        uN.setFont(new Font("Rust",Font.BOLD,20));
        level.setFont(new Font("Rust",Font.BOLD,20));
        this.setVisible(true);
        setLayout(new GridLayout());
        data.setLayout(new BoxLayout(data,BoxLayout.PAGE_AXIS));
        data.add(score); data.add(time);
         add(logo);add(level); add(uN);
        add(data);
        try {
            backgroundImage = ImageIO.read(new File("src/logo.png"));
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (backgroundImage != null) {
            g.drawImage(backgroundImage, 10, 20, 50, 34, logo);
        }
    }

}