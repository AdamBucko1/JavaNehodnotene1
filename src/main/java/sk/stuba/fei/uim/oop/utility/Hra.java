package sk.stuba.fei.uim.oop.utility;
import java.util.Random;

public class Hra {
    private Random NahodnyVyber=new Random();
    public int UkoncenieHry=0;
    public int[][] PoleHracejPlochy;
    public int SizeOfBoard;
    public int Obtiaznost;
    public int BlockComparisonValue=0;
    public void VytvoreniePlochy(int velkost){
        Obtiaznost=ZKlavesnice.readInt("Zadaj obtiaznost od 1 do 100 (sto znamena ze takmer kazde policko je mina)");
        PoleHracejPlochy=new int[velkost][velkost];
        SizeOfBoard=velkost;


        for(int stlpec=0;stlpec<velkost;stlpec++){
            for(int riadok=0;riadok<velkost;riadok++){
                int BlockComparisonValueVCykle=NahodnyVyber.nextInt(100);
                BlockComparisonValue=BlockComparisonValueVCykle;
                PoleHracejPlochy[stlpec][riadok]=VyberPolicka();


            }

        }
    VykreslenieHracejPlochy();
    }
    public void HladaniePoli(int CurrentY, int CurrentX){
        if(PoleHracejPlochy[CurrentY][CurrentX]==0) {
            int HodnotaPola=2;

            if(CurrentX<SizeOfBoard-1){
            if(PoleHracejPlochy[CurrentY][CurrentX+1]==1){
                HodnotaPola=HodnotaPola+1;
            }}
            if(CurrentX>0){
            if(PoleHracejPlochy[CurrentY][CurrentX-1]==1){
                HodnotaPola=HodnotaPola+1;
            }}
            if(CurrentY<SizeOfBoard-1 && CurrentX<SizeOfBoard-1){
            if(PoleHracejPlochy[CurrentY+1][CurrentX+1]==1){
                HodnotaPola=HodnotaPola+1;
            }}
            if(CurrentY<SizeOfBoard-1 && CurrentX>0){
            if(PoleHracejPlochy[CurrentY+1][CurrentX-1]==1){
                HodnotaPola=HodnotaPola+1;
            }}
            if(CurrentX>0 && CurrentY>0){
            if(PoleHracejPlochy[CurrentY-1][CurrentX-1]==1){
                HodnotaPola=HodnotaPola+1;
            }}
            if(CurrentX<SizeOfBoard-1 && CurrentY>0){
            if(PoleHracejPlochy[CurrentY-1][CurrentX+1]==1){
                HodnotaPola=HodnotaPola+1;
            }}
            if(CurrentY>0){
            if(PoleHracejPlochy[CurrentY-1][CurrentX]==1){
                HodnotaPola=HodnotaPola+1;
            }}
            if(CurrentY<SizeOfBoard-1){
            if(PoleHracejPlochy[CurrentY+1][CurrentX]==1){
                HodnotaPola=HodnotaPola+1;
            }}
            PoleHracejPlochy[CurrentY][CurrentX]=HodnotaPola;
            if(HodnotaPola==2) {
                if (CurrentY < SizeOfBoard - 1) {
                    HladaniePoli(CurrentY + 1, CurrentX);
                }
                if (CurrentY > 0) {
                    HladaniePoli(CurrentY - 1, CurrentX);
                }
                if (CurrentX < SizeOfBoard - 1) {
                    HladaniePoli(CurrentY, CurrentX + 1);
                }
                if (CurrentX > 0) {
                    HladaniePoli(CurrentY, CurrentX - 1);
                }
            }

        }

    }

    public void VykreslenieHracejPlochy(){
        int VykreslenieY=0;
        int VykreslenieX=0;
        int Cyklus1=0;
        for (Cyklus1=0;Cyklus1<SizeOfBoard;Cyklus1++){
            if (Cyklus1==0){
                System.out.print(" ");
            }
            if (Cyklus1<9){
                System.out.print(" ");
            }
            System.out.print(" "+(Cyklus1+1));
            if (Cyklus1==SizeOfBoard-1){
                System.out.println("");
            }
        }
        for (VykreslenieY=0;VykreslenieY<SizeOfBoard;VykreslenieY++){
            if (VykreslenieY<9){
                System.out.print(" ");
            }
            System.out.print(VykreslenieY+1);
            for (VykreslenieX=0;VykreslenieX<SizeOfBoard;VykreslenieX++){
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==0){
                    char VypisnaPremenna1=240;
                    System.out.print(" ■ ");}
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==1){
                    char VypisnaPremenna2=240;
                    System.out.print(" ■ ");}
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==2){
                    System.out.print("   ");}
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==3){
                    System.out.print(" 1 ");}
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==4){
                    System.out.print(" 2 ");}
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==5){
                    System.out.print(" 3 ");}
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==6){
                    System.out.print(" 4 ");}
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==7){
                    System.out.print(" 5 ");}
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==8){
                    System.out.print(" 6 ");}
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==9){
                    System.out.print(" 7 ");}
                if (PoleHracejPlochy[VykreslenieY][VykreslenieX]==10){
                    System.out.print(" 8 ");}
            }
            System.out.println("");
        }

    }
        private int VyberPolicka(){
        int MineBlock;
        MineBlock=BlockGenerator();

        if(MineBlock==1){
            return 0;
        }
        else{
            return 1;
        }

        }

        private int BlockGenerator(){
        if (Obtiaznost>BlockComparisonValue){
            return 0;
        }
        else{
            return 1;
        }



        }

    public Random getNahodnyVyber() {
        return NahodnyVyber;
    }

    public void setNahodnyVyber(Random nahodnyVyber) {
        NahodnyVyber = nahodnyVyber;
    }

    public int getBlockComparisonValue() {
        return BlockComparisonValue;
    }

    public void setBlockComparisonValue(int blockComparisonValue) {
        BlockComparisonValue = blockComparisonValue;
    }

    public int getObtiaznost() {
        return Obtiaznost;
    }

    public void setObtiaznost(int obtiaznost) {
        Obtiaznost = obtiaznost;
    }
}
