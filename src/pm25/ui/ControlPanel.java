package pm25.ui;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.BorderFactory;
import pm25.model.CityGrid;

public class ControlPanel {

    //แผงควบคุมด้านล่าง
    ControlPanel(GridPanel gridPanel, CityGrid cityGrid) {
        SetPeopleDialog setPeopleDialog = new SetPeopleDialog();
        NatureRainDialog natureRainDialog = new NatureRainDialog();
        LoaderFileDialog loaderFileDialog = new LoaderFileDialog();

        RoundedButton setPeople = new RoundedButton("Set People");
        setPeople.setPreferredSize(new Dimension(140, 25));
        setPeople.setBackground(Color.decode("#FFFFFF"));

        setPeople.addActionListener(e -> {
            setPeopleDialog.choiceDialog(cityGrid, gridPanel);
        });

        RoundedButton nature = new RoundedButton("Nature Rain");
        nature.setPreferredSize(new Dimension(140, 25));
        nature.setBackground(Color.decode("#FFFFFF"));

        nature.addActionListener(e -> {
            natureRainDialog.natureDialog(cityGrid, gridPanel);
        });

        RoundedButton pseudo = new RoundedButton("Pseudo rain(off)");
        pseudo.setPreferredSize(new Dimension(140, 25));
        pseudo.setBackground(Color.decode("#FFFFFF"));
        gridPanel.setPseudoButton(pseudo);

        pseudo.addActionListener(e -> {
            if (!cityGrid.isPseudoOn()) {
                cityGrid.setPseudoOn(true);
                pseudo.setText("Pseudo rain(on)");
                pseudo.setBackground(Color.decode("#00FF99"));
            } else {
                cityGrid.setPseudoOn(false);
                pseudo.setText("Pseudo rain(off)");
                pseudo.setBackground(Color.decode("#FFFFFF"));
            }
        });

        RoundedButton load = new RoundedButton("Open File");
        load.setPreferredSize(new Dimension(140, 25));
        load.setBackground(Color.decode("#FFFFFF"));

        load.addActionListener(e -> {
            loaderFileDialog.loaderFile(cityGrid, gridPanel);
        });

        setPeople.setBorder(BorderFactory.createLineBorder(Color.decode("#CBD5E1"), 1));
        nature.setBorder(BorderFactory.createLineBorder(Color.decode("#CBD5E1"), 1));
        pseudo.setBorder(BorderFactory.createLineBorder(Color.decode("#CBD5E1"), 1));
        load.setBorder(BorderFactory.createLineBorder(Color.decode("#CBD5E1"), 1));

        gridPanel.getData().add(setPeople);
        gridPanel.getData().add(pseudo);
        gridPanel.getData().add(nature);
        gridPanel.getData().add(load);
    }
}
