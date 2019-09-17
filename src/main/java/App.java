import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.Map;

import java.util.HashMap;

import static spark.Spark.*;

public class App {
    public static void main(String[] args) {
        staticFileLocation("/public");


                get("/", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    return new ModelAndView(model, "form.hbs");
                }, new HandlebarsTemplateEngine());

                //post: process new hero form
                post("/hero/new", (req, res) -> { //URL to make new hero on POST route
                    Map<String, Object> model = new HashMap<>();

                    String name = req.queryParams("name");
                    int age=Integer.parseInt(req.queryParams("age"));
                    String power = req.queryParams("power");
                    String weakness = req.queryParams("weakness");
                    Hero newHero = new Hero(name, age, power, weakness);
                    model.put("name",newHero.getName());
                    model.put("age",newHero.getAge());
                    model.put("power",newHero.getPower());
                    model.put("weak",newHero.getWeakness());
                    System.out.println(newHero.getWeakness());
                    model.put("hero", newHero);
                    return new ModelAndView(model, "success.hbs");
                }, new HandlebarsTemplateEngine());

        get("/heroes/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Hero> heroes = Hero.all();
            model.put("heroes", heroes);
            return new ModelAndView(model, "details.hbs");
        }, new HandlebarsTemplateEngine());



            get("/squad", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    return new ModelAndView(model, "formtwo.hbs");
                }, new HandlebarsTemplateEngine());

        post("/squad/new", (req, res) -> { //URL to make new hero on POST route
            Map<String, Object> model = new HashMap<>();

            String name = req.queryParams("Name");
            String cause = req.queryParams("Cause");
            int size=Integer.parseInt(req.queryParams("size"));
            Squad newSquad = new Squad(name, cause, size);
            model.put("squad", newSquad);
            model.put("name",newSquad.getName());
            model.put("cause",newSquad.getCause());
            model.put("size",newSquad.getsize());
            System.out.println(newSquad.getName());
            return new ModelAndView(model, "successtwo.hbs");
        }, new HandlebarsTemplateEngine());
        get("/squades/new", (req, res) -> {
            Map<String, Object> model = new HashMap<>();
            ArrayList<Squad> squads = Squad.all();
            Object squades;
            model.put("squades", squads);
            return new ModelAndView(model, "details.hbs");
        }, new HandlebarsTemplateEngine());


//        int idOfHeroToEdit = 0;
//        get("/hero/:id/update", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            int idOfHeroToEdit = Integer.parseInt(req.params("id"));
//            Hero editHero = Hero.search(idOfHeroToEdit);
//            model.put("editPost", editHero);
//            return new ModelAndView(model, "newpost-form.hbs");
//        }, new HandlebarsTemplateEngine());
//
//        post("/posts/:id/update", (req, res) -> {
//            Map<String, Object> model = new HashMap<>();
//            String newContent = req.queryParams("name");
//           int idOfHeroToEdit = Integer.parseInt(req.params("id"));
//            Hero editHero = Hero.search(idOfHeroToEdit);
//            editHero.update(newContent); //don’t forget me
//            return new ModelAndView(model, "success.hbs");
//        }, new HandlebarsTemplateEngine());


            }
        }
