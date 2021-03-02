package sk.stuba.fei.uim.oop.utility;
import java.util.Random;

public class Hra {
    private Random NahodnyVyber=new Random();
    private int BlockComparisonValue=NahodnyVyber.nextInt(100);
    public int Obtiaznost;

    public void VytvoreniePlochy(int velkost){

        for(int riadok=0;riadok<velkost;riadok++){
            for(int stlpec=0;stlpec<velkost;stlpec++){
                VyberPolicka();
            }
            System.out.println("");
        }

    }

        private void VyberPolicka(){
        int SafeBlock;
        SafeBlock=BlockGenerator(Obtiaznost);

        if(SafeBlock==1){
            System.out.print("o");
        }
        else{
            System.out.print("x");
        }

        }

        private int BlockGenerator(int Obtiaznost){
        if (Obtiaznost>BlockComparisonValue){
            return 0;
        }
        else{
            return 1;
        }



        }
}
