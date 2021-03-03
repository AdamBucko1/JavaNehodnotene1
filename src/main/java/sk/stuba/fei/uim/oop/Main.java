package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.utility.Hra;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;


public class Main {
    public static void main(String[] args) {
        Hra objektHra= new Hra();
    objektHra.VytvoreniePlochy(ZKlavesnice.readInt("Zadaj velkost hernej plochy"));
    while (true) {
        System.out.println("Pre ukoncenie hry napis 666");
        int YPozicia = ZKlavesnice.readInt("Y:");
        if(YPozicia==666){
            break;
        }
        int XPozicia = ZKlavesnice.readInt("X:");
        YPozicia = YPozicia - 1;
        XPozicia = XPozicia - 1;
        objektHra.HladaniePoli(YPozicia, XPozicia);
        objektHra.VykreslenieHracejPlochy();
        if (objektHra.UkoncenieHry==1){
            System.out.println("Prehral si");
            break;
        }
    }

    }
}
