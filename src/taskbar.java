import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class taskbar extends JPanel {

    JButton home, newgame, pause, help;
    static boolean start=false,pauseGame=false,manual=false;

    taskbar() {
        home = new JButton("Level");
        newgame = new JButton("New Game");
        pause = new JButton("Pause");
        help = new JButton("Help");
        setVisible(true);
        setBackground(new Color(121, 198, 136));
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        setLayout(layout);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(home, gbc);
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(newgame, gbc);
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(pause, gbc);
        gbc.gridx = 0;
        gbc.gridy = 4;
        add(help, gbc);
        Dimension buttonSize = new Dimension(this.getWidth(), 100);
        Component[] components = this.getComponents();
        for (Component component : components) {
            if (component instanceof JButton) {
                JButton buttonComponent = (JButton) component;
                buttonComponent.setBackground(new Color(47, 196, 112));
                buttonComponent.setPreferredSize(buttonSize);
                buttonComponent.setFont(new Font("Rust", Font.BOLD, 20));
                buttonComponent.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        if(e.getSource()=="newgame"){
                            if(start==false) {
                                start = true;
                            }
                        }
                        else if(e.getSource()=="pause"){
                            if(pauseGame==false) {
                                pauseGame = true;
                                pause.setText("Play");
                            }
                            if(pauseGame==true){
                                pauseGame=false;
                                pause.setText("Pause");
                            }
                        }
                        else if(e.getSource()=="help"){
                            if(manual==false){
                                manual=true;
                            }
                        }
                    }
                });
            }
        }
    }

    public static boolean isStart() {
        return start;
    }

    public static boolean isManual() {
        return manual;
    }

    public static boolean isPauseGame() {
        return pauseGame;
    }
}
