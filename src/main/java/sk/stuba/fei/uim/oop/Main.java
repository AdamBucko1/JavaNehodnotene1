package sk.stuba.fei.uim.oop;

import sk.stuba.fei.uim.oop.utility.Hra;
import sk.stuba.fei.uim.oop.utility.ZKlavesnice;


public class Main {
    public static void main(String[] args) {
        int testVlajky=0;
        Hra objektHra= new Hra();
        objektHra.VypisLoga();

    objektHra.VytvoreniePlochy(ZKlavesnice.readInt("Zadaj velkost hernej plochy"));
    while (true) {
        System.out.println("Pre ukoncenie hry napis 666");
        System.out.println("Pre vlozenie vlajky napis 888");
        int YPozicia = ZKlavesnice.readInt("Y:");
        if (YPozicia == 666) {
            break;
        }
        if (YPozicia==888){
            do {
            int YpoziciaVlajky=ZKlavesnice.readInt("Y suradnica vlajky:");
            int XpoziciaVlajky=ZKlavesnice.readInt("X suradnica vlajky:");
            YpoziciaVlajky=YpoziciaVlajky-1;
            XpoziciaVlajky=XpoziciaVlajky-1;

               testVlajky=objektHra.VyberVlajky(YpoziciaVlajky,XpoziciaVlajky);

           }while (testVlajky==0);
            objektHra.VykreslenieHracejPlochy();
            continue;
        }
        int XPozicia = ZKlavesnice.readInt("X:");
        YPozicia = YPozicia - 1;
        XPozicia = XPozicia - 1;
        if (objektHra.DidILose(YPozicia, XPozicia)==1){
            objektHra.VypisPrehry();
            break;
        }
        objektHra.HladaniePoli(YPozicia, XPozicia);
        objektHra.VykreslenieHracejPlochy();
    }}}