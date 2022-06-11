package com.example.lively.database.tables;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

enum Gender{
    MALE,
    FEMALE
}
@Entity(tableName = "users")
public class Users {
    private Gender gender;
    @PrimaryKey(autoGenerate = true)
    private long Userid;
    private Double height;
    private Double weight;
    private int age;
    private Double bmi;
    private int eatenCalories;
    private int neededCalories;

    public Users(Gender gender, Double height, Double weight, int age) {
        this.gender = gender;
        this.height = height;
        this.weight = weight;
        this.age = age;
        this.eatenCalories=0;
    }

    public long getId() {
        return Userid;
    }

    public void setId(long id) {
        this.Userid = id;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
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

    public void setBmi(Double bmi) throws Exception {
        throw new Exception("You can't set the bmi");
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

    public void setNeededCalories(int neededCalories) throws Exception {
        throw new Exception("You can't set your calories manually!");
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    private Double calcBMI(Double height, Double weight){
        height = getHeight();
        weight = getWeight();
        Double bmi = weight / (height*height);
        return bmi;
    }

    private int calcCalories(Double weight, Double height, int age, Gender gender){
        int calories;
        switch (gender){
            case MALE:
                calories = (int)(10*weight + 6.25*height - 5*age + 5);
                break;
            case FEMALE:
                calories = (int)(10*weight + 6.25*height - 5*age + 161);
                break;
            default:
                calories = -1;
                break;
        }
        return calories;
    }
}
