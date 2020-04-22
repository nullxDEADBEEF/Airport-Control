package com.nullxdeadbeef.Service;

import com.nullxdeadbeef.FlyRejse;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class FlyRejseDAO {

    public void insert(FlyRejse flyRejse) {
        String sql = "INSERT INTO flights (date, arrival, route_nr, `STA/STD`, `origin/destination`) " +
                "VALUES (?,?,?,?,?)";

        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, flyRejse.getDato().toString());
            ps.setBoolean(2, flyRejse.getArrival());
            ps.setString(3, flyRejse.getRuteNr());
            ps.setTime(4, flyRejse.getScheduledTime());
            ps.setString(5,flyRejse.getOrigin_destination());

        } catch (Exception e) {
            System.out.println("Error" + e);
            e.printStackTrace();
        }
    }
}
