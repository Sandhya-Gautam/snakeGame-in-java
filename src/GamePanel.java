import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Random;


public class GamePanel extends JPanel {
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    GamePanel(){
        setVisible(true);
        setBackground(new Color(138, 169, 14));
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int)(screenSize.getWidth()*0.50),(int)(screenSize.getHeight()*0.50));
        double size=screenSize.getWidth()-screenSize.getWidth()*0.3;
        setPreferredSize(new Dimension((int)size,(int)size));
        }
    public void paint (Graphics g){
        g.setColor(new Color(128, 70, 27));
        g.fillRect(0,0,(int)screenSize.getWidth(),10);

        g.setColor(new Color(128, 70, 27));
        g.fillRect(0,0,10,(int)screenSize.getHeight());

        g.setColor(new Color(128, 70, 27));
        g.fillRect(0,(int)screenSize.getHeight(),(int)screenSize.getWidth(),10);

        g.setColor(new Color(128, 70, 27));
        g.fillRect((int)screenSize.getWidth(),0,10,(int)screenSize.getHeight());

    }


}
