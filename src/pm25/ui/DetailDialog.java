package pm25.ui;

import pm25.model.CityGrid;

import javax.swing.*;

public class DetailDialog extends JFrame {

    public DetailDialog(CityGrid cityGrid, int i, int j) {
        setTitle("Details");
        setSize(560, 380);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JTextArea ta = new JTextArea();
        ta.setEditable(false);
        ta.setText(String.valueOf(cityGrid.pm25[i][j]) + "\n");

        add(ta);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}