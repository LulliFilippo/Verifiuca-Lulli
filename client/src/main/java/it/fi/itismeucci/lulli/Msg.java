package it.fi.itismeucci.lulli;

import java.util.ArrayList;

public class Msg {
    ArrayList<Biglietto> buy = new ArrayList<Biglietto>();
    
    public Msg(){
    }

    public ArrayList<Biglietto> getBuy() {
        return this.buy;
    }

    public void setBuy(ArrayList<Biglietto> buy) {
        this.buy = buy;
    }

}
