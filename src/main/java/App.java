import spark.ModelAndView;
import spark.template.handlebars.HandlebarsTemplateEngine;

import java.util.ArrayList;
import java.util.Map;

import java.util.HashMap;
import model.Hero;
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
                    model.put("weakness",newHero.getWeakness());
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

//        get: show an individual hero
                get("/hero/:id", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    int idOfHeroToFind = Integer.parseInt(req.params("id")); //pull id - must match route segment
                    model.Hero foundHero = Hero.search(idOfHeroToFind); //use it to find hero
                    model.put("Hero", foundHero); //add it to model for template to display
                    return new ModelAndView(model, "detail.hbs"); //individual post page.
                }, new HandlebarsTemplateEngine());

                //get: show a form to update a post
                get("/hero/:id/update", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    int idOfHeroToEdit = Integer.parseInt(req.params("id"));
                    model.Hero editHero = Hero.search(idOfHeroToEdit);
                    model.put("editHero", editHero);
                    return new ModelAndView(model, "templates/form.hbs");
                }, new HandlebarsTemplateEngine());

                //post: process a form to update a post
//                post("/hero/:id/update", (req, res) -> { //URL to make new post on POST route
//                    Map<String, Object> model = new HashMap<>();
//                    String name = req.queryParams("name");
//                    String age=req.params("age");
//                    String power = req.queryParams("power");
//                    String weakness = req.queryParams("weakness");
//                    int idOfHeroToEdit = Integer.parseInt(req.params("id"));
//                    model.Hero editHero = Hero.search(idOfHeroToEdit);
//                    editHero.update( name, age, power, weakness);
//                    return new ModelAndView(model, "success.hbs");
//                }, new HandlebarsTemplateEngine());

                //get: delete an individual post
                get("/hero/:id/delete", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    int idOfHeroToDelete = Integer.parseInt(req.params("id")); //pull id - must match route segment
                    model.Hero deleteHero = Hero.search(idOfHeroToDelete); //use it to find post
                    deleteHero.clear();
                    return new ModelAndView(model, "success.hbs");
                }, new HandlebarsTemplateEngine());

                //get: delete all posts
                get("/hero/delete", (req, res) -> {
                    Map<String, Object> model = new HashMap<>();
                    Hero.clear();
                    return new ModelAndView(model, "success.hbs");
                }, new HandlebarsTemplateEngine());
            }
        }
