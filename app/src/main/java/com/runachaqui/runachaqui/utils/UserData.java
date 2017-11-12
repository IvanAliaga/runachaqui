package com.runachaqui.runachaqui.utils;

import com.pixplicity.easyprefs.library.Prefs;

/**
 * Created by PC USER on 01/11/2017.
 */

public class UserData {
    public static final String ANIMAL = "ANIMAL";


    public static void setDataCore(String animal){
        Prefs.putString(ANIMAL, animal);
    }

}
