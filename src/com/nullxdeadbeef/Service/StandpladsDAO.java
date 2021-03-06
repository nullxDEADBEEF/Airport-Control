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

                Standplads standplads = new Standplads();
                standplads.setStandpladsNr(rs.getInt("idBooth"));
                String enums = rs.getString("booth_type");
                Standplads.Type realEnums = Standplads.Type.valueOf(enums);
                standplads.setType(realEnums);
                standplads.setLedig(rs.getBoolean("available"));
                standpladser.add(standplads);
            }


        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
        return standpladser;
    }

    public void update(Boolean updateValue, int boothNr) {
        String sql = "UPDATE booth SET available = ? WHERE idBooth = ?";

        try (Connection con = DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setBoolean(1, updateValue);
            ps.setInt(2,boothNr);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
