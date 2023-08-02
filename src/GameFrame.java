import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
//import java.awt.Container;

import static java.awt.Color.*;

/*import javax.swing.JFrame;*/
public class GameFrame extends JFrame  {
    ScoreBoard score;
    GamePanel gameBase;
    taskbar task;
    GameFrame() {
        score = new ScoreBoard();
        gameBase = new GamePanel();
        task=new taskbar();
        setResizable(false);
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        setSize((int) screenSize.getWidth(), (int) screenSize.getHeight());
        this.getContentPane().setBackground(new Color(151,217,164));
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets= new Insets(10,10,10,10);
        gbc.fill = GridBagConstraints.BOTH;
        gbc.weightx =1;
        gbc.weighty=1;
        gbc.gridwidth =3;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(score,gbc);
        gbc.gridwidth=1;
        gbc.gridheight =2;
        gbc.ipady=500;
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(task, gbc);
        gbc.ipady=500;
        gbc.ipadx=800;
        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.gridwidth=2;
        gbc.gridheight =2;
        add(gameBase, gbc);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        gameBase.getStart(taskbar.isStart());
    }

}