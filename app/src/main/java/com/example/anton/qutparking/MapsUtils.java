package com.example.anton.qutparking;

/**
 * Created by anton on 13/02/18.
 */

public class MapsUtils {

    private static final String P_BLOCK_PARKING = "https://www.google.com/maps/place/P+Block+Parking/@-27.477908,153.0287572,20z/data=!4m12!1m6!3m5!1s0x0:0xd27486d3079aefd0!2squt+carpark!8m2!3d-27.4783932!4d153.0276498!3m4!1s0x6b915a11b287f429:0x384ff9525a4b1aab!8m2!3d-27.4781823!4d153.0286979?hl=en-GB";
    private static final String FREEWAY_BLOCK_PARKING = "https://www.google.com.au/maps/place/qut+carpark/@-27.478368,153.0278997,20z/data=!4m8!1m2!2m1!1squt+gardens+point+parking!3m4!1s0x0:0xd27486d3079aefd0!8m2!3d-27.478393!4d153.02765";
    private static final String S_Z_C_BLOCK_PARKING = "https://www.google.com/maps/place/Gardens+Point+Road,+Brisbane+City+QLD+4000/@-27.4767642,153.0272002,19z/data=!4m5!3m4!1s0x6b915a102797e4b5:0x5dd17de8406188e8!8m2!3d-27.4767764!4d153.0266205";
    private static final String KG_FBLOCK_PARKING = "https://www.google.com.au/maps/place/27%C2%B027'01.6%22S+153%C2%B000'56.1%22E/@-27.450451,153.0150228,19z/data=!3m1!4b1!4m13!1m6!3m5!1s0x6b9159e2fd64ce87:0x5f30ab85ad322b5e!2sQUT+Kelvin+Grove+-+Sports+Lane+Parking!8m2!3d-27.4492499!4d153.0177579!3m5!1s0x0:0x0!7e2!8m2!3d-27.4504506!4d153.0155704";
    private static final String KG_SPORTSLANE_PARKING = "https://www.google.com/maps/place/QUT+Kelvin+Grove+-+Sports+Lane+Parking/@-27.449582,153.0176908,19z/data=!4m5!3m4!1s0x6b9159e2fd64ce87:0x5f30ab85ad322b5e!8m2!3d-27.44925!4d153.0177578?hl=en-GB";


    public static String getpBlockParking() {
        return P_BLOCK_PARKING;
    }

    public static String getFreewayBlockParking() {
        return FREEWAY_BLOCK_PARKING;
    }

    public static String getKgFblockParking() {
        return KG_FBLOCK_PARKING;
    }

    public static String getKgSportslaneParking() {
        return KG_SPORTSLANE_PARKING;
    }

    public static String getsZCBlockParking() {
        return S_Z_C_BLOCK_PARKING;
    }
}
