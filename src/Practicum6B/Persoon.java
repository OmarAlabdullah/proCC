package Practicum6B;

import java.util.ArrayList;

public class Persoon {

    private String naam;
    private double budget;
    private ArrayList<Game> games;

    public Persoon(String nm, double bud){
        this.naam = nm;
        this.budget = bud;
        this.games = new ArrayList<Game>();

    }

    public double getBudget(){
        return budget;
    }

    public boolean koop(Game g) {
        double huidW = g.huidigeWaarde();

        if (budget > huidW) {
            if (!games.contains(g)) {
                games.add(g);
                budget = budget - huidW;
            } else {
                return false;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean verkoop(Game g, Persoon koper) {
        double huidW = g.huidigeWaarde();

        if (games.contains(g)) {
            if (koper.koop(g)) {
                budget = budget + huidW;
                games.remove(g);
                return true;
            }
        }
        return false;
    }


    public String toString(){
        String s = naam + " heeft een budget van €" + String.format("%.2f", budget) + " en bezit de volgende games:" ;
         for (Game g : games)
            s = s + "\n"+g;
        return s;
    }

    public Game zoekGameOpNaam(String s) {

        for (Game g : games )
            if (g.getNaam().equals(s))
                return g;

            return null;
    }
}
