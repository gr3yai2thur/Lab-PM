package pm25.ui;

import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class PseudoAlert extends JFrame{
    public PseudoAlert(){
        setTitle("Alert!!");
        setSize(250, 100);
        setLayout(new FlowLayout());

        JLabel alert = new JLabel("Please set people first!!");
        alert.setFont(new Font("Tomaha", Font.BOLD, 16));
        alert.setHorizontalAlignment(SwingConstants.CENTER);
    
        JButton OK = new JButton("OK");
        
        OK.addActionListener(e -> {
            dispose();
        });

        add(alert);
        add(OK);
        setLocationRelativeTo(this);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    // public static void main(String[] args) {
    //     new PseudoAlert();
    // }
}
