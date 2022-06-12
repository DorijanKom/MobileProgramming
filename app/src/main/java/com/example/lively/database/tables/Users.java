package com.example.lively.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class Users{
    private String gender;
    @PrimaryKey(autoGenerate = true)
    private long Userid;
    private String userName;
    private String email;
    private String password;
    private Double height;
    private Double weight;
    private int age;
    private Double bmi;
    private int eatenCalories;
    private int neededCalories;
    private int nextMeal;
    private int waterInterval;
    private int exerciseTime;
    private int nextExercise;
    private Double avgExercise;
    private int sleptFor;
    private int setSleeptime;
    private int sleepIn;
    private Double avgSleep;

    public Users(String gender, Double height, Double weight, int age) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.eatenCalories=0;
        this.bmi=0.0;
        this.eatenCalories=0;
        this.nextMeal=0;
        this.waterInterval=0;
        this.exerciseTime=0;
        this.nextExercise=0;
        this.avgExercise=0.0;
        this.sleptFor=0;
        this.setSleeptime=0;
        this.sleepIn=0;
        this.avgSleep=0.0;
    }
    public Users(){

    }

    public Users(String userName, String email,String password){
        this.userName=userName;
        this.email=email;
        this.password=password;
    }

    public long getUserid() {
        return Userid;
    }

    public void setUserid(long userid) {
        Userid = userid;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public Double getHeight() {
        return height;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Double getBmi() {
        return calcBMI(this.height,this.weight);
    }

    public void setBmi(Double bmi){
        this.bmi=bmi;
    }

    public int getEatenCalories() {
        return eatenCalories;
    }

    public void setEatenCalories(int eatenCalories) {
        this.eatenCalories = eatenCalories;
    }

    public int getNeededCalories() {
        return calcCalories(this.weight,this.height,this.age,this.gender);
    }

    public void setNeededCalories(int neededCalories){
        this.neededCalories = neededCalories;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getNextMeal() {
        return nextMeal;
    }

    public void setNextMeal(int nextMeal) {
        this.nextMeal = nextMeal;
    }

    public int getWaterInterval() {
        return waterInterval;
    }

    public void setWaterInterval(int waterInterval) {
        this.waterInterval = waterInterval;
    }

    public int getExerciseTime() {
        return exerciseTime;
    }

    public void setExerciseTime(int exerciseTime) {
        this.exerciseTime = exerciseTime;
    }

    public int getNextExercise() {
        return nextExercise;
    }

    public void setNextExercise(int nextExercise) {
        this.nextExercise = nextExercise;
    }

    public Double getAvgExercise() {
        return avgExercise;
    }

    public void setAvgExercise(Double avgExercise) {
        this.avgExercise = avgExercise;
    }

    public int getSleptFor() {
        return sleptFor;
    }

    public void setSleptFor(int sleptFor) {
        this.sleptFor = sleptFor;
    }

    public int getSetSleeptime() {
        return setSleeptime;
    }

    public void setSetSleeptime(int setSleeptime) {
        this.setSleeptime = setSleeptime;
    }

    public int getSleepIn() {
        return sleepIn;
    }

    public void setSleepIn(int sleepIn) {
        this.sleepIn = sleepIn;
    }

    public Double getAvgSleep() {
        return avgSleep;
    }

    public void setAvgSleep(Double avgSleep) {
        this.avgSleep = avgSleep;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private Double calcBMI(Double height, Double weight){
        height = getHeight();
        weight = getWeight();
        Double bmi = weight / (height*height);
        return bmi;
    }

    private int calcCalories(Double weight, Double height, int age, String gender){
        int calories;
        switch (gender){
            case "MALE":
                calories = (int)(10*weight + 6.25*height - 5*age + 5);
                break;
            case "FEMALE":
                calories = (int)(10*weight + 6.25*height - 5*age + 161);
                break;
            default:
                calories = -1;
                break;
        }
        return calories;
    }
}