package com.nullxdeadbeef.Log;

import com.nullxdeadbeef.Fly;
import com.nullxdeadbeef.FlyRejse;
import com.nullxdeadbeef.Lufthavnspersonale.Lufthavnspersonale;
import java.io.*;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class IOSkriver {

    // To get the current date
    static long millis=System.currentTimeMillis();
    static java.sql.Date date=new java.sql.Date(millis);

    static int num=1;

    // Saetter filnavn til Log-tidspunkt.txt
    // Eks. Log-2020-05-26.txt
    static String filnavn = "Log-"+date+".txt";

    // Hvis et fly skal skrive til fil
    public static boolean logKommunikation(FlyRejse flyRejse, LocalTime tidspunkt, String besked) {
        try {
            File file = new File("Data/"+filnavn);

            // Saetter append til true, saa vi ikke overskriver filen naar vi prover at skrive til den igen
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Udskriver Tidspunkt som det forste
            printWriter.print("["+tidspunkt.getHour()+":"+tidspunkt.getMinute()+":"+tidspunkt.getSecond()+"] ");

            // Udeskriver Log-num, og laegger 1 til num
            printWriter.print("Log-"+num+" ");

            // Udskriver flyets rutenr.
            printWriter.print("Fly "+flyRejse.getRuteNr()+": ");

            // Skriver beskeden som er sendt over fra parameterne
            printWriter.println(besked);

            System.out.println("["+tidspunkt.getHour()+":"+tidspunkt.getMinute()+":"+tidspunkt.getSecond()+"] "+
                    "Log-"+num+" "+flyRejse.getRuteNr()+": "+besked);

            num++;
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
    public static boolean logKommunikation(Lufthavnspersonale lhp, LocalTime tidspunkt, String besked){
        try {
            File file = new File("Data/"+filnavn);

            // Saetter append til true, saa vi ikke overskriver filen naar vi prover at skrive til den igen
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Udskriver Tidspunkt som det forste
            printWriter.print("["+tidspunkt.getHour()+":"+tidspunkt.getMinute()+":"+tidspunkt.getSecond()+"] ");

            // Udeskriver Log-num, og laegger 1 til num
            printWriter.print("Log-"+num+" ");

            // Udskriver personalegruppen.
            printWriter.print(lhp.getClass().getSimpleName()+": ");

            // Skriver beskeden som er sendt over fra parameterne
            printWriter.println(besked);

            System.out.println("["+tidspunkt.getHour()+":"+tidspunkt.getMinute()+":"+tidspunkt.getSecond()+"] "+
                    "Log-"+num+" "+lhp.getClass().getSimpleName()+": "+besked);
            num++;

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
    public static boolean logKommunikation(LocalTime tidspunkt, String besked){
        try {
            File file = new File("Data/"+filnavn);

            // Saetter append til true, saa vi ikke overskriver filen naar vi prover at skrive til den igen
            FileWriter fileWriter = new FileWriter(file, true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            // Udskriver Tidspunkt som det forste
            printWriter.print("["+tidspunkt.getHour()+":"+tidspunkt.getMinute()+":"+tidspunkt.getSecond()+"] ");

            // Udeskriver Log-num, og laegger 1 til num
            printWriter.print("Log-"+num+" ");

            // Udskriver Kontroltaarn:
            printWriter.print("Kontroltårn: ");

            // Skriver beskeden som er sendt over fra parameterne
            printWriter.println(besked);

            System.out.println("["+tidspunkt.getHour()+":"+tidspunkt.getMinute()+":"+tidspunkt.getSecond()+"] "+
                    "Log-"+num+" "+"Kontroltårn: "+besked);
            num++;
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