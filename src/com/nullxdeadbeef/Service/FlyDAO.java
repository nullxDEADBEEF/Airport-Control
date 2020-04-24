package com.nullxdeadbeef.Service;

import com.nullxdeadbeef.Fly;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class FlyDAO {

    public void insert(Fly fly) {
    }


    public ArrayList<Fly> getAll() {
        ArrayList<Fly> alleFly = new ArrayList<>();

        String sql = "SELECT * FROM Fly";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Fly fly = new Fly();
                fly.setaC(rs.getString("A/C"));
                //fly.setStandplads(rs.getInt("id_booths"));
//                fly.setFlyRejse(rs.getInt("id_flights"));
                alleFly.add(fly);

            }
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return alleFly;
    }
}