package pm25.ui;

import java.awt.Dimension;
import javax.swing.*;

import pm25.model.CityGrid;

public class ControlPanel{
    ControlPanel(GridPanel gridPanel, CityGrid cityGrid){
        SetPeopleDialog setPeopleDialog = new SetPeopleDialog();
        NatureRainDialog natureRainDialog = new NatureRainDialog();

        JButton setPeople = new JButton("Set People");
        setPeople.setPreferredSize(new Dimension(110, 25));

        setPeople.addActionListener(e -> {
            setPeopleDialog.choiceDialog(cityGrid);
        });

        JButton nature = new JButton("Nature Rain");
        nature.setPreferredSize(new Dimension(110, 25));

        nature.addActionListener(e -> {
            natureRainDialog.natureDialog(cityGrid, gridPanel);
        });

        JButton pseudo = new JButton("Pseudo rain");
        pseudo.setPreferredSize(new Dimension(110, 25));

        pseudo.addActionListener(e -> {
            
        });

        JButton load = new JButton("Loader File");
        load.setPreferredSize(new Dimension(110, 25));

        load.addActionListener(e -> {
            
        });

        gridPanel.data.add(setPeople);
        gridPanel.data.add(pseudo);
        gridPanel.data.add(nature);
        gridPanel.data.add(load);

    }



}