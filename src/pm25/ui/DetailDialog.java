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
        if (cityGrid.people.get(i).get(j) == 0) {
            ta.setText(String.valueOf("Please set people first."));
        } else {
            ta.setText(String.valueOf("PM2.5 Value: " + cityGrid.pm25.get(i).get(j)) + "\n");
            ta.append(String.valueOf("People In City: " + cityGrid.people.get(i).get(j) + "\n"));
            ta.append(String.valueOf("Sick Percent In City: " + cityGrid.sickP.get(i).get(j)) + "\n");
        }

        add(ta);
        setLocationRelativeTo(this);
        setVisible(true);
    }
}
