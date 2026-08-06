package pm25.model;

import java.util.Random;

public class CityGrid{
    public final int rows = 20;
    public final int cols = 40;

    public int[][] pm25   = new int[rows][cols];
    public int[][] people = new int[rows][cols];
    public int[][] sickP  = new int[rows][cols];
    public int[][] sickPP = new int[rows][cols];
    public int[][] goodPP = new int[rows][cols];

    public int[][] B4pm25   = new int[rows][cols];
    public int[][] B4people = new int[rows][cols];
    public int[][] B4sickP  = new int[rows][cols];
    public int[][] B4sickPP = new int[rows][cols];
    public int[][] B4goodPP = new int[rows][cols];

    public void setPeople(int amount){
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                people[i][j] = amount;
            }
        }
    }

    public void setPeople(int min, int max){
        Random rnd = new Random();
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                people[i][j] = rnd.nextInt(max - min + 1) + min;
            }
        }
    }

    public void natureRain(){
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                pm25[i][j] -= 50;
                if(pm25[i][j] <= 0){
                    pm25[i][j] = 0;
                }
            }
        }
    }
}
