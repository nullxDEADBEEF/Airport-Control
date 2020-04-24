package com.nullxdeadbeef.Service;

import com.nullxdeadbeef.Fly;
import com.nullxdeadbeef.FlyRejse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class FlyRejseDAO {

    public void insert(FlyRejse flyRejse) {
        String sql = "INSERT INTO flights (date, arrival, route_nr, `STA/STD`, `origin/destination`) " +
                "VALUES (?,?,?,?,?)";

        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, flyRejse.getDato().toString());
            ps.setBoolean(2, flyRejse.getAnkomst());
            ps.setString(3, flyRejse.getRuteNr());
            ps.setTime(4, Time.valueOf(flyRejse.getKlokkeslæt()));
            ps.setString(5,flyRejse.getOrigin_destination());

        } catch (Exception e) {
            System.out.println("Error" + e);
            e.printStackTrace();
        }
    }

/*    public static FlyRejse select(int id) {
        String sql = "SELECT * FROM flights WHERE ";
        FlyRejse flyRejse = new FlyRejse();
        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                flyRejse.setDato(rs.getDate("date").toLocalDate());
                flyRejse.setAnkomst(rs.getBoolean("arrival"));
                flyRejse.setRuteNr(rs.getString("route_nr"));
                flyRejse.setKlokkeslæt(rs.getTime("STA/STD").toLocalTime());
                flyRejse.setOrigin_destination(rs.getString("origin/destination"));
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
        return flyRejse;
    }*/


    public ArrayList<FlyRejse> selectAll() {
        ArrayList<FlyRejse> flyRejser = new ArrayList<>();
        String sql = "SELECT * FROM fly_rejse";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                FlyRejse flyRejse = new FlyRejse();
                flyRejse.setDato(LocalDate.parse(rs.getString("dato")));
                if (rs.getString("ankomst_afgang").equals("A")){
                    flyRejse.setAnkomst(true);
                } else{
                    flyRejse.setAnkomst(false);
                }
                flyRejse.setRuteNr(rs.getString("rutenr"));
                flyRejse.setKlokkeslæt(LocalTime.parse(rs.getString("klokkeslæt")));
                flyRejse.setOrigin_destination(rs.getString("origin/destination"));
                Fly fly = new Fly();
                fly.setaC(rs.getString("aC"));
                flyRejse.setFly(fly);
                flyRejser.add(flyRejse);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        } return flyRejser;

    }
}
