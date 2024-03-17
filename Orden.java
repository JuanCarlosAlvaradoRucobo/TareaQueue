/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.simulaciontienda;

/**
 *
 * @author ARCar
 */

public class Orden {
    private String name;
    private int cantidad;
    
    public Orden(String name, int cantidad) {
        this.name = name;
        this.cantidad = cantidad;
    }

    public Orden() {
        name = "";
        cantidad = 0;
    }
    
    
    public String getName() {
        return name;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Orden{" + "name=" + name + ", cantidad=" + cantidad + '}';
    }

   
    
   
    
}
