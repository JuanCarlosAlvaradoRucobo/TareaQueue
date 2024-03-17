/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.mycompany.simulaciontienda;

import java.util.Comparator;


public class OrdenComparator implements Comparator<Orden> {
    public int compare(Orden orden1, Orden orden2) {
        boolean esJesusaOBetania1 = orden1.getName().equals("Jesús de Nazaret") || orden1.getName().equals("María de Betania");
        boolean esJesusaOBetania2 = orden2.getName().equals("Jesús de Nazaret") || orden2.getName().equals("María de Betania");

        if (esJesusaOBetania1 && esJesusaOBetania2) {
            // Si ambos son "Jesús de Nazaret" o "María de Betania", comparar por cantidad
            return Integer.compare(orden1.getCantidad(), orden2.getCantidad());
        } else if (esJesusaOBetania1) {
            // Si solo orden1 es "Jesús de Nazaret" o "María de Betania", priorizarlo
            return -1;
        } else if (esJesusaOBetania2) {
            // Si solo orden2 es "Jesús de Nazaret" o "María de Betania", priorizarlo
            return 1;
        } else {
            // Si ninguno es "Jesús de Nazaret" o "María de Betania", mover hacia abajo en la cola
            return 0;
        }
    }
}

