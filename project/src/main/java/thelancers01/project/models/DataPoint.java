package thelancers01.project.models;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class DataPoint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private double mileTime;
    private int benchPress;
    private int squat;
    private int maxPushUps;
    private int maxSitUps;
    private int caloriesBurned;


   @ManyToOne
   private User user;
   public DataPoint() {}

    // In DataPoint entity
    @ManyToOne
    @JoinColumn(name = "record_id")
    private Record record;

    public DataPoint(double mileTime, int benchPress, int squat, int maxPushUps, int maxSitUps, int caloriesBurned) {
        this.mileTime = mileTime;
        this.benchPress = benchPress;
        this.squat = squat;
        this.maxPushUps = maxPushUps;
        this.maxSitUps = maxSitUps;
        this.caloriesBurned = caloriesBurned;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public double getMileTime() {return mileTime;}

    public void setMileTime(double mileTime) {
        this.mileTime = mileTime;
    }

    public int getBenchPress() {
        return benchPress;
    }

    public void setBenchPress(int benchPress) {
        this.benchPress = benchPress;
    }

    public int getSquat() {
        return squat;
    }

    public void setSquat(int squat) {
        this.squat = squat;
    }

    public int getMaxPushUps() {
        return maxPushUps;
    }

    public void setMaxPushUps(int maxPushUps) {
        this.maxPushUps = maxPushUps;
    }

    public int getMaxSitUps() {
        return maxSitUps;
    }

    public void setMaxSitUps(int maxSitUps) {
        this.maxSitUps = maxSitUps;
    }

    public int getCaloriesBurned() {
        return caloriesBurned;
    }

    public void setCaloriesBurned(int caloriesBurned) {
        this.caloriesBurned = caloriesBurned;
    }

    public void updateFields(DataPoint newData) {
        this.mileTime = newData.getMileTime();
        this.benchPress = newData.getBenchPress();
        this.squat = newData.getSquat();
        this.maxPushUps = newData.getMaxPushUps();
        this.maxSitUps = newData.getMaxSitUps();
        this.caloriesBurned = newData.getCaloriesBurned();
    }
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}



