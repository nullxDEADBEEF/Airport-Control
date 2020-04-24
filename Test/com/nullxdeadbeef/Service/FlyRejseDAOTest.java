package com.nullxdeadbeef.Service;

import com.nullxdeadbeef.FlyRejse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FlyRejseDAOTest {

    @Test
    void selectAll() {
        for (FlyRejse flyrejse :
                FlyRejseDAO.selectAll()) {
            System.out.println(flyrejse.toString());
        }
    }
}