package pm25.ui;

import java.awt.Dimension;

import javax.swing.*;

import pm25.model.CityGrid;

public class ControlPanel{
    ControlPanel(GridPanel gridPanel, CityGrid cityGrid){
        SetPeopleDialog setPeopleDialog = new SetPeopleDialog();
        JButton setPeople = new JButton("Set People");
        setPeople.setPreferredSize(new Dimension(100, 25));

        setPeople.addActionListener(e -> {
            setPeopleDialog.choiceDialog(cityGrid);
        });

        gridPanel.data.add(setPeople);
    }



}