package model;

import java.util.ArrayList;

public class Hero{
    private String name;
    private int age;
    private int id;
    public String power;
    public String weakness;

    private static ArrayList<Hero> instances = new ArrayList<Hero>();

    public Hero(String name, int age, String power, String weakness){
        this.name = name;
        this.age = age;
        this.power = power;
        this.weakness = weakness;
        id = instances.size();
        instances.add(this);
    }

    public static ArrayList<Hero> all(){
        return instances;
    }

    public static void clear(){
        instances.clear();
    }

    public String getName(){
        return name;
    }

    public int getAge(){
        return age;
    }

    public String getPower(){
        return power;
    }

    public String getWeakness(){
        return weakness;
    }

    public static ArrayList<Hero>getAll() {
        return instances;
    }

    public int getId(){
        return id;
    }

    public static Hero search(int id){
        return instances.get(id-1);
    }

//    public void update(String name, String age, String power, String weakness) {
//        Name = name;
//        Age = age;
//        Power = power;
//        Weakness = weakness;
//        Id = instances.size();
//        instances.add(this);
//    }
}