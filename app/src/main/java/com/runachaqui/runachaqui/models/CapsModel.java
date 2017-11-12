package com.runachaqui.runachaqui.models;

import android.graphics.Bitmap;

/**
 * Created by Ivan Aliaga on 12/11/2017.
 */

public class CapsModel {
    private int id_capitulo;
    private int numero;
    private String descripcion;
    private Bitmap bitmap;

    public CapsModel() {
    }

    public CapsModel(int id_capitulo, int numero, String descripcion, Bitmap bitmap) {
        this.id_capitulo = id_capitulo;
        this.numero = numero;
        this.descripcion = descripcion;
        this.bitmap = bitmap;
    }

    public int getId_capitulo() {
        return id_capitulo;
    }

    public void setId_capitulo(int id_capitulo) {
        this.id_capitulo = id_capitulo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Bitmap getBitmap() {
        return bitmap;
    }

    public void setBitmap(Bitmap bitmap) {
        this.bitmap = bitmap;
    }


}
