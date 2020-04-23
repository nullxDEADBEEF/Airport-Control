package com.nullxdeadbeef.Log;

import com.nullxdeadbeef.Fly;
import com.nullxdeadbeef.Lufthavnspersonale.Lufthavnspersonale;

import java.io.*;
import java.time.LocalDateTime;

public class IOSkriver {

    // To get the current date
    long millis=System.currentTimeMillis();
    java.sql.Date date=new java.sql.Date(millis);

    int num=1;

    // Saetter filnavn til Log-tidspunkt.txt
    // Eks. Log-2020-05-26.txt
    String filnavn = "Log-"+date+".txt";

    // Hvis et fly skal skrive til fil
    public boolean skrivTilFil(Fly fly, LocalDateTime tidspunkt) {
        try {
            String filnavn = "Log-"+tidspunkt.getDayOfMonth()+"/"+tidspunkt.getMonth()+"/"+tidspunkt.getYear()+".txt";
            File file = new File("Data/"+filnavn);

            // Saetter append til false, saa vi ikke overskriver filen naar vi prover at skrive til den igen
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Udskriver Tidspunkt som det forste
            printWriter.print("["+tidspunkt.getHour()+":"+tidspunkt.getMinute()+":"+tidspunkt.getSecond()+"] ");

            // Udeskriver Log-num, og laegger 1 til num
            printWriter.print("Log-"+num+" ");
            num++;

            // Udskriver flyets rutenr.
            printWriter.print("Fly: "+fly.getFlyRejse().getRuteNr()+": ");

            // TODO: Her faa udskrevet flyets ordre eller handling
            printWriter.print(fly);

            printWriter.println();
            fileWriter.close();

            // Retuner at det gik godt
            return true;

        } catch(IOException IOe){
            IOe.printStackTrace();

            // Retuner at det ikke gik godt
            return false;
        }
    }

    // Hvis en personalegruppe skal skrive til en fil
    public boolean skrivTilFil(Lufthavnspersonale lufthavnspersonale, LocalDateTime tidspunkt){
        try {
            File file = new File("Data/"+filnavn);

            // Saetter append til false, saa vi ikke overskriver filen naar vi prover at skrive til den igen
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Udskriver Tidspunkt som det forste
            printWriter.print("["+tidspunkt.getHour()+":"+tidspunkt.getMinute()+":"+tidspunkt.getSecond()+"] ");

            // Udeskriver Log-num, og laegger 1 til num
            printWriter.print("Log-"+num+" ");
            num++;

            // Udskriver flyets rutenr.
            printWriter.print("Personalegruppe: "+lufthavnspersonale.getClass()+": ");

            // TODO: Her faa udskrevet personalegruppens ordre eller handling
            printWriter.print(lufthavnspersonale);

            printWriter.println();
            fileWriter.close();

            // Retuner at det gik godt
            return true;

        } catch(IOException IOe){
            IOe.printStackTrace();

            // Retuner at det ikke gik godt
            return false;
        }
    }

    // Hvis kontroltaarnet skal skrive til en fil
    public boolean skrivTilFil(LocalDateTime tidspunkt){
        try {
            File file = new File("Data/"+filnavn);

            // Saetter append til false, saa vi ikke overskriver filen naar vi prover at skrive til den igen
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Udskriver Tidspunkt som det forste
            printWriter.print("["+tidspunkt.getHour()+":"+tidspunkt.getMinute()+":"+tidspunkt.getSecond()+"] ");

            // Udeskriver Log-num, og laegger 1 til num
            printWriter.print("Log-"+num+" ");
            num++;

            // Udskriver flyets rutenr.
            printWriter.print("Kontroltårn: ");

            // TODO: Her faa udskrevet personalegruppens ordre eller handling
            //printWriter.print();

            printWriter.println();
            fileWriter.close();

            // Retuner at det gik godt
            return true;

        } catch(IOException IOe){
            IOe.printStackTrace();

            // Retuner at det ikke gik godt
            return false;
        }
    }
}