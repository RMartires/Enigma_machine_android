package com.example.rohit.enigmamachine;

/**
 * Created by ROHIT on 12/29/2018.
 */

public class Machine {

    private static Rotor r1 = new Rotor();
    private static Rotor r2 = new Rotor();
    private static Rotor r3 = new Rotor();

    private static int keycount1=0;
    private static int keycount2=0;
    private static int keycount3=0;


    public static char rotorbox(char a){

        int anum=getnumberforchar(a);
        anum=anum+keycount1;
        a=getCharForNumber(anum).charAt(0);

        char i=r1.getRotorForward(a);

        int inum=getnumberforchar(i);
        inum=inum+keycount2;
        i=getCharForNumber(inum).charAt(0);


        char j=r2.getRotorForward(i);

        int jnum=getnumberforchar(j);
        jnum=jnum+keycount3;
        j=getCharForNumber(jnum).charAt(0);

        char k=r3.getRotorForward(j);

        j=r3.getRotorForward(k);
        i=r2.getRotorForward(j);
        k=r1.getRotorForward(i);

        return k;
    }



    public static void keycountcheck(){
        keycount1++;
        if(keycount1>=25){
            keycount2++;
            keycount1=0;
        }
        if(keycount2>=25){
            keycount3++;
            keycount2=0;
        }
        if(keycount3>=25)
            keycount3=0;

        System.out.println(keycount1+" "+keycount2+" "+keycount3);

    }


    private static String getCharForNumber(int i) {
        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        if (i >= 25) {
            i=i-25;
        }
        return Character.toString(alphabet[i]);
    }

    public static int getnumberforchar(char i){

        char[] alphabet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
        int bingo=10;
        for(int j=0;j<26;j++){
            if(alphabet[j]==i ||alphabet[j]==Character.toUpperCase(i) )
                bingo=j;
        }
        return bingo;
    }



}
