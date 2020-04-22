package com.nullxdeadbeef.Service;

import com.nullxdeadbeef.Terminal;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class TerminalDAO {

    public void insert(Terminal terminal) {
        String sql = "INSERT INTO terminals (idTerminals, airline) VALUES ()";

        try (Connection con =
                     DatabaseAdapter.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

}
