package com.nullxdeadbeef.Service;

import com.nullxdeadbeef.FlyRejse;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
            ps.setTime(4, flyRejse.getKlokkeslæt());
            ps.setString(5,flyRejse.getOrigin_destination());

        } catch (Exception e) {
            System.out.println("Error" + e);
            e.printStackTrace();
        }
    }

    public ArrayList<FlyRejse> selectAll() {
        ArrayList<FlyRejse> flyRejser = new ArrayList<>();
        String sql = "SELECT * FROM flights";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                FlyRejse flyRejse = new FlyRejse();
                flyRejse.setDato(rs.getDate("date"));
                flyRejse.setAnkomst(rs.getBoolean("arrival"));
                flyRejse.setRuteNr(rs.getString("route_nr"));
                flyRejse.setKlokkeslæt(rs.getTime("STA/STD"));
                flyRejse.setOrigin_destination(rs.getString("origin/destination"));
                flyRejser.add(flyRejse);
            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        } return flyRejser;

    }
}
