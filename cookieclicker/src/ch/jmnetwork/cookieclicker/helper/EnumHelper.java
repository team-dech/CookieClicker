package ch.jmnetwork.cookieclicker.helper;

import java.util.ArrayList;

import static ch.jmnetwork.cookieclicker.util.NumberHelper.addApostropheToNumber;

public enum EnumHelper {
    CLICKER(0.1F, 15, 0, "Pointer"),
    GRANDMA(0.5F, 100, 1, "Grandma"),
    FARM(2F, 500, 2, "Farm"),
    FACTORY(10F, 3000, 3, "Factory"),
    MINE(40F, 10000, 4, "Mine"),
    SHIPMENT(100F, 40000, 5, "Shipment"),
    ALCHEMYLAB(400F, 200000, 6, "Alchemy Lab"),
    PORTAL(6666F, 1666666, 7, "Portal"),
    TIMEMACHINE(98765F, 123456789L, 8, "Time Machine"),
    CONDENSER(999999F, 3999999999L, 9, "Condenser");

    public final long price;
    public final float prodictivity;
    public final int id;
    public final String name;

    private static ArrayList<String[]> helpersStringArrayThing = null;

    private EnumHelper(float prodictivity, long price, int ID, String name) {
        this.prodictivity = prodictivity;
        this.price = price;
        this.id = ID;
        this.name = name;
    }

    public static ArrayList<String[]> getAllHelpersAsStringArray() {
        if (helpersStringArrayThing != null) return helpersStringArrayThing;
        ArrayList<String[]> r_list = new ArrayList<>();

        r_list.add(new String[]{"ID", "Name", "Productivity", "Price"});
        for (EnumHelper e : values()) {
            r_list.add(new String[]{e.id + "", e.name, (e.prodictivity + "").substring((e.prodictivity + "").indexOf(".")).equals(".0") ? addApostropheToNumber(Long.parseLong((e.prodictivity + "").substring(0, (e.prodictivity + "").indexOf(".")))) : (e.prodictivity + ""), addApostropheToNumber(e.price) + ""});
        }

        helpersStringArrayThing = r_list;
        return r_list;
    }
}
