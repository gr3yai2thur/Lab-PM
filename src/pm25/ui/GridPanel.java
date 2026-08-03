package pm25.ui;

import pm25.model.CityGrid;

import javax.swing.*;
import java.awt.*;

public class GridPanel {

    public JPanel table = new JPanel(new GridLayout(20, 40));
    public JPanel data = new JPanel();

    CityGrid cityGrid;

    public GridPanel(CityGrid cityGrid) {
        this.cityGrid = cityGrid;
    }

    public void onClick(int i, int j) {

        JFrame popup = new JFrame();
        popup.setTitle("Details");
        popup.setSize(560, 380);
        popup.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        TextArea ta = new TextArea(12, 30);
        ta.setEditable(false);
        ta.setText(String.valueOf(cityGrid.pm25[i][j]) + "\n");

        popup.add(ta);
        popup.setVisible(true);
    }
}