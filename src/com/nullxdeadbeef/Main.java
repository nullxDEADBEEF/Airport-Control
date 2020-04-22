package com.nullxdeadbeef;

import com.nullxdeadbeef.Service.StandpladsDAO;

public class Main {

    public static void main(String[] args) {
	    StandpladsDAO st = new StandpladsDAO();
        System.out.println(st.selectAll());
        st.update(true, 1);
        System.out.println(st.selectAll());
    }
}
