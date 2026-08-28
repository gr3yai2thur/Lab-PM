package pm25.ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.*;

import pm25.model.CityGrid;

public class ControlPanel {
    ControlPanel(GridPanel gridPanel, CityGrid cityGrid) {
        SetPeopleDialog setPeopleDialog = new SetPeopleDialog();
        NatureRainDialog natureRainDialog = new NatureRainDialog();
        LoaderFileDialog loaderFileDialog = new LoaderFileDialog();

        JButton setPeople = new JButton("Set People");
        setPeople.setPreferredSize(new Dimension(140, 25));

        setPeople.addActionListener(e -> {
            setPeopleDialog.choiceDialog(cityGrid, gridPanel);
        });

        JButton nature = new JButton("Nature Rain");
        nature.setPreferredSize(new Dimension(140, 25));

        nature.addActionListener(e -> {
            natureRainDialog.natureDialog(cityGrid, gridPanel);
        });

        JButton pseudo = new JButton("Pseudo rain(off)");
        pseudo.setPreferredSize(new Dimension(140, 25));
        
        pseudo.addActionListener(e -> {
            if (!cityGrid.isPseudoOn) {
                cityGrid.isPseudoOn = true;
                pseudo.setText("Pseudo rain(on)");
                pseudo.setBackground(Color.decode("#00FF99"));
            } else {
                cityGrid.isPseudoOn = false;
                pseudo.setText("Pseudo rain(off)");
                pseudo.setBackground(UIManager.getColor("Button.background"));
            }
        });

        JButton load = new JButton("Loader File");
        load.setPreferredSize(new Dimension(140, 25));

        load.addActionListener(e -> {
            loaderFileDialog.loaderFile(cityGrid, gridPanel);
        });

        gridPanel.data.add(setPeople);
        gridPanel.data.add(pseudo);
        gridPanel.data.add(nature);
        gridPanel.data.add(load);
    }
}
