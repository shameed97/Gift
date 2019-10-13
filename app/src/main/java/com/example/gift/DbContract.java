package com.example.gift;

public class DbContract {
    private DbContract()
    {

    }

    public static abstract class giftCon
    {
        public static final String TABLE_NAME = "gift_data";
        public static final String ID = "gift_id";
        public static final String NAME = "name";
        public static final String FAM_NAME = "fam_name";
        public static final String CITY = "city";
        public static final String PRESENTS = "presents";
    }
}
