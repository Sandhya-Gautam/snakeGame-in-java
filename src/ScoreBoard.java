import javax.swing.*;
import java.awt.*;

public class  ScoreBoard extends JPanel{
    String user_Name, labelString;

    JPanel data;
    JLabel score,time,level, uN;
    ScoreBoard(){
        user_Name="sandhya";
        labelString="Level:4";
        data= new JPanel();
        level= new JLabel(labelString);
        uN = new JLabel(user_Name);
        score=new JLabel("Score");
        time= new JLabel("Time");
        this.setFont(new Font("Rust",Font.BOLD,100));
        this.setVisible(true);
        GridLayout layout=new GridLayout();
        setLayout(layout);
        data.setLayout(new BoxLayout(data,BoxLayout.PAGE_AXIS));
        data.add(score); data.add(time);
        add(level); add(uN);
        add(data);





    }
}