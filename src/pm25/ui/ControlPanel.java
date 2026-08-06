package pm25.ui;

import java.awt.Dimension;
import javax.swing.*;

import pm25.model.CityGrid;

public class ControlPanel{
    ControlPanel(GridPanel gridPanel, CityGrid cityGrid){
        SetPeopleDialog setPeopleDialog = new SetPeopleDialog();
        NatureRainDialog natureRainDialog = new NatureRainDialog();

        JButton setPeople = new JButton("Set People");
        setPeople.setPreferredSize(new Dimension(100, 25));

        setPeople.addActionListener(e -> {
            setPeopleDialog.choiceDialog(cityGrid);
        });

        JButton nature = new JButton("Nature Rain");
        nature.setPreferredSize(new Dimension(100, 25));

        nature.addActionListener(e -> {
            natureRainDialog.natureDialog(cityGrid, gridPanel);
        });

        gridPanel.data.add(setPeople);
        gridPanel.data.add(nature);
    }



}