import javax.swing.*;
import java.awt.*;

public class Main extends JFrame{


    public static void main(String[] args) throws Exception {
        try {

            Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
            JFrame frame = new JFrame("Nyoka");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(new login());
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
            frame.setSize(screenSize);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }catch (NullPointerException e){
            System.out.println(e.getMessage());
        }
    }
}



