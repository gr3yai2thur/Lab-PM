package pm25.ui;

import pm25.model.CityGrid;

import javax.swing.*;
import java.awt.*;

public class DetailDialog extends JFrame {

    public DetailDialog(CityGrid cityGrid, int i, int j) {

        setTitle("Details");
        setSize(560, 380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        TextArea ta = new TextArea(12, 30);
        ta.setEditable(false);
        ta.setText(String.valueOf(cityGrid.pm25[i][j]) + "\n");

        add(ta);
        setVisible(true);
    }
}