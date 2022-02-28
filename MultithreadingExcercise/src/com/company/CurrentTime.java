package com.company;

import java.text.SimpleDateFormat;
import java.util.Date;


public class CurrentTime {
    static SimpleDateFormat sdf;

    public static String getCurrentTime()
    {
        sdf=new SimpleDateFormat("HH:mm:ss:SS");
        return String.valueOf(sdf.format(new Date().getTime()));
    }
    
}
