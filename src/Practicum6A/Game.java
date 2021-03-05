package Practicum6A;

import java.time.LocalDate;

public class Game {

    private String naam;
    private int releaseJaar;
    private double nieuwprijs;

    public Game(String nm, int rj, double nwpr){
        this.naam = nm;
        this.releaseJaar = rj ;
        this.nieuwprijs = nwpr;
    }

    public String getNaam(){
        return naam;
    }

    public double huidigeWaarde(){
        int aantalJaar = LocalDate.now().getYear() - this.releaseJaar;
        double huidigeprijs = nieuwprijs;
        int i = 0;
        while (i < aantalJaar) {
            i++;
            huidigeprijs = huidigeprijs * 0.70;
        }
        return huidigeprijs;}

    public boolean equals(Object andereObject){
        boolean gelijkeObjecten = false;

        if (andereObject instanceof Game) {
            Game andereGame = (Game) andereObject;

            if (this.naam.equals(andereGame.naam) && this.releaseJaar == andereGame.releaseJaar){
                gelijkeObjecten = true;
            }

        }

        return gelijkeObjecten;
    }

    public String toString(){
        return  naam + ", uitgegeven in " + releaseJaar + "; nieuwprijs: €" + String.format("%.2f", nieuwprijs)+ " nu voor: €" + String.format("%.2f", huidigeWaarde());
    }
}
