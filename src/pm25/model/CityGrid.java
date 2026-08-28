package pm25.model;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class CityGrid {
    public int rows;
    public int cols;

    public ArrayList<ArrayList<Integer>> pm25 = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> people = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> sickP = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> sickPP = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> goodPP = new ArrayList<>();

    public ArrayList<ArrayList<Integer>> B4pm25 = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> B4people = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> B4sickP = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> B4sickPP = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> B4goodPP = new ArrayList<>();

    public Color getPeopleColor(int row, int col) {
        int pmValue = pm25.get(row).get(col);

        if (pmValue >= 151) {
            return Color.decode("#E74C3C");
        }
        if (pmValue >= 101) {
            return Color.decode("#F39C12");
        }
        if (pmValue >= 51) {
            return Color.decode("#F7DC6F");
        }
        return Color.decode("#58D68D");
    }

    public void setPeople(int amount) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                people.get(i).set(j, amount);
                B4people.get(i).set(j, amount);
            }
        }
    }

    public void setPeople(int min, int max) {
        Random rnd = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int amount = rnd.nextInt(max - min + 1) + min;
                people.get(i).set(j, amount);
                B4people.get(i).set(j, amount);
            }
        }
    }

    public void natureRain() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                pm25.get(i).set(j, pm25.get(i).get(j) - 50);
                if (pm25.get(i).get(j) <= 0) {
                    pm25.get(i).set(j, 0);
                }
            }
        }
    }

    public void setSickPercent() {
        Random rnd = new Random();
        sickP.clear();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> sickPercent = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                if (pm25.get(i).get(j) >= 151) {
                    sickPercent.add(rnd.nextInt(50 - 30 + 1) + 30);
                } else if (pm25.get(i).get(j) >= 101) {
                    sickPercent.add(rnd.nextInt(29 - 20 + 1) + 20);
                } else if (pm25.get(i).get(j) >= 51) {
                    sickPercent.add(rnd.nextInt(19 - 10 + 1) + 10);
                } else {
                    sickPercent.add(rnd.nextInt(9 - 0 + 1) + 0);
                }
            }
            sickP.add(sickPercent);
        }
    }
}
