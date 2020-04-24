package com.nullxdeadbeef.Service;

import com.nullxdeadbeef.FlyRejse;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class FlyRejseDAOTest {

    @Test
    void selectAll() {
        ArrayList<FlyRejse> alleRejser = new ArrayList<>();
        alleRejser.addAll(FlyRejseDAO.selectAll());

        for (FlyRejse flyrejse :
                alleRejser) {
            flyrejse.toString();
        }
    }
}