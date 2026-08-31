package pm25.ui;

import java.awt.*;
import javax.swing.*;

import pm25.io.dataFileLoader;
import pm25.model.CityGrid;

public class LoaderFileDialog extends JFrame {
    private dataFileLoader file = new dataFileLoader();

    //Frame ที่จะเด้งตอนกด Loader File
    public void loaderFile(CityGrid cityGrid, GridPanel gridPanel) {
        getContentPane().removeAll();
        setTitle("Load");
        setSize(220, 100);
        setLayout(new FlowLayout());

        //ปุ่ม Yes/No
        RoundedButton yes = new RoundedButton("Yes");
        RoundedButton no = new RoundedButton("No");

        yes.addActionListener(e -> {
            dispose();
            if (file.loaderFile(cityGrid)) {
                gridPanel.buildTable();
            }
            gridPanel.resetPseudoButton();
        });

        no.addActionListener(e -> {
            dispose();
        });
        
        add(new JLabel("Do u wanna reloader file?"));
        add(yes);
        add(no);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(this);
        revalidate();
        repaint();
        setVisible(true);
    }
}
