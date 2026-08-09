package pm25.ui;

import java.awt.*;
import javax.swing.*;

import pm25.io.dataFileLoader;
import pm25.model.CityGrid;

public class LoaderFileDialog extends JFrame{
    dataFileLoader file = new dataFileLoader();

    public void loaderFile(CityGrid cityGrid, GridPanel gridPanel){
        setTitle("Loader File");
        setSize(230, 100);
        setLayout(new FlowLayout());

        JButton yes = new JButton("Yes");
        JButton no = new JButton("No");

        yes.addActionListener(e -> {
            dispose();
            file.loaderFile(cityGrid);
            gridPanel.refreshPM25();
        });

        no.addActionListener(e -> {
            dispose();
        });
        add(new JLabel("Do u wanna reloader file?"));
        add(yes);
        add(no);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
