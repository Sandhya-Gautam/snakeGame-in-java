import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

public class taskbar extends JPanel{

    JButton home , newgame, pause, help;
    taskbar() {
        home = new JButton("Home");
        newgame = new JButton("New Game");
        pause = new JButton("Pause");
        help = new JButton("Help");
        home.setFont(new Font("Rust",Font.BOLD,20));
        newgame.setFont(new Font("Rust",Font.BOLD,20));
        pause.setFont(new Font("Rust",Font.BOLD,20));
        help.setFont(new Font("Rust",Font.BOLD,20));
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
        home.setPreferredSize(buttonSize);
        newgame.setPreferredSize(buttonSize);
        pause.setPreferredSize(buttonSize);
        help.setPreferredSize(buttonSize);
        home.setBackground(new Color(47, 196, 112));
        newgame.setBackground(new Color(47, 196, 112));
        pause.setBackground(new Color(47, 196, 112));
        help.setBackground(new Color(47, 196, 112));
    }
}
