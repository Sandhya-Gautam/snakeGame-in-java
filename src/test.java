import javax.swing.*;
import java.awt.*;

class test extends JFrame{
    test(){
//        JButton p1=new JButton();
//        JButton p2=new JButton();
//        JButton p3=new JButton();
//        setSize(500,500);
//        p1.setBackground(Color.cyan);
//        p2.setBackground(Color.black);
//        p3.setBackground(Color.BLUE);
//        setVisible(true);
//        GridBagLayout layout=new GridBagLayout();
//        setLayout(layout);
//        GridBagConstraints gbc= new GridBagConstraints();
//        gbc.weightx=1;
//        gbc.weighty=1;
//        gbc.gridx=0;
//        gbc.gridy=0;
//        gbc.gridwidth=2;
//        gbc.fill=GridBagConstraints.HORIZONTAL;
//        add(p1,gbc);
//        gbc.gridx=1;
//        gbc.gridy=1;
//        gbc.gridheight=2;
//        gbc.fill=GridBagConstraints.VERTICAL;
//        add(p1,gbc);
//        gbc.gridx=1;
//        gbc.gridy=2;
//        gbc.gridheight=2;
//        gbc.fill=GridBagConstraints.VERTICAL;
//        add(p3,gbc);
//
                setSize(200,200);
                setTitle("Assessement");
                JPanel one = new JPanel();
                JPanel two = new JPanel();
                JPanel three = new JPanel();
                one.setBackground(Color.BLUE);
                two.setBackground(Color.cyan);
                three.setBackground(Color.BLACK);
                setLayout(new GridBagLayout());
// Create an object of GridBagConstraint
                GridBagConstraints gbc = new GridBagConstraints();
// components should expand to fill the available space
// so set the fill contraint to BOTH
                gbc.fill = GridBagConstraints.BOTH;
// set the weight of x and y to non zero value
                gbc.weightx =1;
                gbc.weighty=1;

// Since the height of the button one is twice compared to others
// set the constraint height to 2
                gbc.gridwidth = 2;
// this button has x and y =0
                gbc.gridx = 0;
                gbc.gridy = 0;
// add the first button
                add(one,gbc);
// set the height back to one
                gbc.gridwidth=1;
                gbc.gridheight = 2;

// button two is at x =1 and y =0
                gbc.gridx = 0;
                gbc.gridy = 1;
                add(two, gbc);
// button four has the double width and its x =1 and y=1
                gbc.gridx = 1;
                gbc.gridy = 1;
                add(three, gbc);
                setVisible(true);
                setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            }
    public static void main(String args[]){
        new test();
    }
}
