

import java.util.List;
import java.util.ArrayList;

public class Squad {
    private String name;
    private String cause;
    private int size;
    private static ArrayList<Squad> enter = new ArrayList<Squad>();
    private int Id;
    private List<Hero> Heroes;

    public Squad(String name, String cause,int size) {
        this.name = name;
        this.cause = cause;
        this.size= size;
        Id = enter.size();
        enter.add(this);
        Heroes = new ArrayList<Hero>();
    }
    public List<Hero> getHeroes(){
        return Heroes;
    }



    public String getName() {
        return name;
    }
    public String getCause() {
        return cause;
    }
    public int getsize() {
        return size;
    }

    public static ArrayList<Squad> all(){
        return enter;
    }




    public static void clearAllPosts(){
        enter.clear();
    }



    public static void clear(){
        enter.clear();
    }


    public int getId() {
        return Id;
    }

    public static Squad search(int id) {
        return enter.get(id - 1);
    }

    public void addHero(Hero hero) {
        if (Heroes.size() < 10) {
            Heroes.add(hero);
        }
    }
}