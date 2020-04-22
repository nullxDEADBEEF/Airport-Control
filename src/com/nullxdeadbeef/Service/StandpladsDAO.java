package com.nullxdeadbeef.Service;

import com.nullxdeadbeef.Standplads;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class StandpladsDAO {

    public ArrayList<Standplads> selectAll() {
        ArrayList<Standplads> standpladser = new ArrayList<>();
        String sql = "SELECT * FROM booth";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
                     ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                /*Standplads standplads = new Standplads();
                standplads.setStandpladsNr(rs.getInt("idBooth"));
                standplads.setType(rs.getString("type").);
                standplads.setLedig(rs.getBoolean("available")); */
            }

        } catch(Exception e) {
            System.out.println("Error: " + e);
        }
        return standpladser;
    }
}
