package com.nullxdeadbeef.Log;

import com.nullxdeadbeef.Fly;
import com.nullxdeadbeef.Lufthavnspersonale.Lufthavnspersonale;
import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class IOSkriver {

    // To get the current date
    long millis=System.currentTimeMillis();
    java.sql.Date date=new java.sql.Date(millis);

    int num=1;

    // Saetter filnavn til Log-tidspunkt.txt
    // Eks. Log-2020-05-26.txt
    String filnavn = "Log-"+date+".txt";

    // Hvis et fly skal skrive til fil
    public boolean skrivTilFil(Fly fly, LocalTime tidspunkt, String besked) {
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
//            printWriter.print("Fly "+fly.getFlyRejse().getRuteNr()+": ");

            // Skriver beskeden som er sendt over fra parameterne
            printWriter.println(besked);

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
    public boolean skrivTilFil(Lufthavnspersonale lufthavnspersonale, LocalTime tidspunkt, String besked){
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

            // Udskriver personalegruppen.
            printWriter.print(lufthavnspersonale.getClass().getSimpleName()+": ");

            // Skriver beskeden som er sendt over fra parameterne
            printWriter.println(besked);

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
    public boolean skrivTilFil(LocalTime tidspunkt, String besked){
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

            // Udskriver Kontroltaarn:.
            printWriter.print("Kontroltårn: ");

            // Skriver beskeden som er sendt over fra parameterne
            printWriter.println(besked);

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