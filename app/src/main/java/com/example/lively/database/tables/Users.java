package com.example.lively.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "users")
public class Users{
    private String gender="";
    @PrimaryKey(autoGenerate = true)
    private long Userid;
    private String userName="";
    private String email="";
    private String password="";
    private Double height=0.0;
    private Double weight=0.0;
    private int age=0;
    private Double bmi=0.0;
    private int eatenCalories=0;
    private int neededCalories=0;
    private int nextMeal=0;
    private int waterInterval=0;
    private int exerciseTime=0;
    private long nextExercise=0;
    private Double avgExercise=0.0;
    private int sleptFor=0;
    private int setSleeptime=79200;
    private int sleepIn=0;
    private Double avgSleep=0.0;

    public Users(String gender, Double height, Double weight, int age) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;

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

    public long getNextExercise() {
        return nextExercise;
    }

    public void setNextExercise(long nextExercise) {
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