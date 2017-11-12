package com.runachaqui.runachaqui.models;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.runachaqui.runachaqui.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan Aliaga on 12/11/2017.
 */

public class CapsAdministrator {
    public static List<CapsModel> getAllCaps(Context context) {
        List<CapsModel> capsModelList = new ArrayList<>();
        Bitmap bm = BitmapFactory.decodeResource(context.getResources(), R.drawable.round_image);
        capsModelList.add(new CapsModel(1, 1, "En este capítulo aprenderá a " +
                "conocer sus características principales", bm));
        capsModelList.add(new CapsModel(2, 2, "En este capítulo aprenderá a " +
                "conocer sus características principales", bm));
        return capsModelList;
    }

}
