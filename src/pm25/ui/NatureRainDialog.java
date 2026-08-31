package pm25.ui;

import java.awt.FlowLayout;
import javax.swing.*;
import pm25.model.CityGrid;

public class NatureRainDialog extends JFrame {
    public void natureDialog(CityGrid cityGrid, GridPanel gridPanel) {
        JFrame rain = new JFrame();
        rain.setTitle("Nature Rain");
        rain.setSize(250, 120);
        rain.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));

        RoundedButton yes = new RoundedButton("Yes");
        RoundedButton no = new RoundedButton("No");

        yes.addActionListener(e -> {
            rain.dispose();
            if(cityGrid.isPeopleSet()){
                cityGrid.natureRain(gridPanel);
                gridPanel.refreshPM25();
                cityGrid.setSickPercent();
                cityGrid.setSickPeople();
                cityGrid.setGoodPeople();
                gridPanel.refreshColor();
            }
            else{
                new PseudoAlert();
            }
        });

        no.addActionListener(e -> {
            rain.dispose();
        });
        
        rain.add(new JLabel("Do u wanna let nature rain start?"));
        rain.add(yes);
        rain.add(no);
        rain.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        rain.setLocationRelativeTo(this);
        rain.setVisible(true);
    }
}
