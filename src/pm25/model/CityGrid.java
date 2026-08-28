package pm25.model;

import java.util.ArrayList;
import java.util.Random;
import java.awt.Color;

public class CityGrid {
    private int rows;
    private int cols;
    private boolean isPseudoOn = false;
    private boolean hasCopy = false;

    private ArrayList<ArrayList<Integer>> pm25 = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> people = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> sickP = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> sickPP = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> goodPP = new ArrayList<>();

    private ArrayList<ArrayList<Integer>> B4pm25 = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> B4people = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> B4sickP = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> B4sickPP = new ArrayList<>();
    private ArrayList<ArrayList<Integer>> B4goodPP = new ArrayList<>();


    //Setter and Getter
    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public boolean isPseudoOn() {
        return isPseudoOn;
    }

    public void setPseudoOn(boolean pseudoOn) {
        isPseudoOn = pseudoOn;
    }

    public int getPm25(int row, int col) {
        return pm25.get(row).get(col);
    }

    public int getPeople(int row, int col) {
        return people.get(row).get(col);
    }

    public int getSickPercent(int row, int col) {
        return sickP.get(row).get(col);
    }

    public int getSickPeople(int row, int col) {
        return sickPP.get(row).get(col);
    }

    public int getGoodPeople(int row, int col) {
        return goodPP.get(row).get(col);
    }

    public int getBeforePm25(int row, int col) {
        return B4pm25.get(row).get(col);
    }

    public int getBeforePeople(int row, int col) {
        return B4people.get(row).get(col);
    }

    public int getBeforeSickPercent(int row, int col) {
        return B4sickP.get(row).get(col);
    }

    public int getBeforeSickPeople(int row, int col) {
        return B4sickPP.get(row).get(col);
    }

    public int getBeforeGoodPeople(int row, int col) {
        return B4goodPP.get(row).get(col);
    }

    //โหลดข้อมูลลง pm55 และ set people เป็น 0
    public void loadDataRow(ArrayList<Integer> row) {
        pm25.add(new ArrayList<>(row));
        ArrayList<Integer> peopleRow = new ArrayList<>();
        for (int i = 0; i < row.size(); i++) {
            peopleRow.add(0);
        }
        people.add(peopleRow);
    }

    //ล้างข้อมูลใน Array ตอนโหลดไฟล์กันข้อมูลทับ
    public void clearLoadedData() {
        pm25.clear();
        people.clear();
        sickP.clear();
        sickPP.clear();
        goodPP.clear();
        resetCopyData();
    }

    //set ขนาดของ Array ตามขนาดไฟล์
    public void setGridSize(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
    }

    //เปลี่ยนสีตามจำนวนฝุ่น
    public Color getPeopleColor(int row, int col) {
        int pmValue = pm25.get(row).get(col);

        if (pmValue >= 151) return Color.RED;
        else if (pmValue >= 101) return Color.ORANGE;
        else if (pmValue >= 51)  return Color.YELLOW;
        else return Color.GREEN;
    }

    //set จำนวนคนแบบกำหนด
    public void setPeople(int amount) {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                people.get(i).set(j, amount);
            }
        }
    }

    //set จำนวนคนแบบสุ่ม
    public void setPeople(int min, int max) {
        Random rnd = new Random();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int amount = rnd.nextInt(max - min + 1) + min;
                people.get(i).set(j, amount);
            }
        }
    }

    //ฝนธรรมชาติ
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

    //set จำนวนเปอร์เซ็นต์ผู้ป่วย
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

    //set จำนวนผู้ป่วย
    public void setSickPeople(){
        sickPP.clear();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> sickPeople = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                int sPP = (int)(people.get(i).get(j) * (sickP.get(i).get(j) / 100.0));
                sickPeople.add(sPP);
            }
            sickPP.add(sickPeople);
        }
    }

    //set จำนวนคนสุขภาพดี
    public void setGoodPeople(){
        goodPP.clear();
        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> goodPeople = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                int gPP = people.get(i).get(j) - sickP.get(i).get(j);
                goodPeople.add(gPP);
            }
            goodPP.add(goodPeople);
        }
    }

    //Copy ข้อมูลลง Before เพื่อใช้เปรียบเทียบ
    public void copyData(){
        if (hasCopy) {
            return;
        }

        B4pm25.clear();
        B4people.clear();
        B4sickP.clear();
        B4sickPP.clear();
        B4goodPP.clear();

        for (int i = 0; i < rows; i++) {
            ArrayList<Integer> pm = new ArrayList<>();
            ArrayList<Integer> pp = new ArrayList<>();
            ArrayList<Integer> sp = new ArrayList<>();
            ArrayList<Integer> spp = new ArrayList<>();
            ArrayList<Integer> gpp = new ArrayList<>();
            for (int j = 0; j < cols; j++) {
                pm.add(pm25.get(i).get(j));
                pp.add(people.get(i).get(j));
                sp.add(sickP.get(i).get(j));
                spp.add(sickPP.get(i).get(j));
                gpp.add(goodPP.get(i).get(j));
            }
            B4pm25.add(pm);
            B4people.add(pp);
            B4sickP.add(sp);
            B4sickPP.add(spp);
            B4goodPP.add(gpp);
        }
        hasCopy = true;
    }

    //ล้างข้อมูล Copy ตอนโหลดไฟล์ใหม่กันข้อมูลทับ
    public void resetCopyData() {
        hasCopy = false;
        B4pm25.clear();
        B4people.clear();
        B4sickP.clear();
        B4sickPP.clear();
        B4goodPP.clear();
    }
}