package com.mycompany.simulaciontienda;

import java.util.AbstractQueue;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Random;

public class Comprar extends AbstractQueue<Orden> {
    private PriorityQueue<Orden> colaCompras;
    private String[] clientes;
    private int DURACION_SIMULACION_SEGUNDOS = 120;
    private int INTERVALO_ORDENES_SEGUNDOS = 2;
    private int TIEMPO_ATENCION_PRODUCTO_MILISEGUNDOS = 500;

    public Comprar() {
        clientes = new String[]{"jesus de nazareth", "maria de betania", "jorge el curioso", "sum trejo", "laulo pondra", "andres tortamantes", "adrian alba", "kevin cortez", "marta camargo"};
        colaCompras = new PriorityQueue<>(new OrdenComparator());
    }

    public Iterator<Orden> iterator() {
        return colaCompras.iterator();
    }

    @Override
    public int size() {
        return colaCompras.size();
    }

    public boolean offer(Orden cliente) {
        // Agregar la orden a la cola con el comparador OrdenComparator
        return colaCompras.offer(cliente);
    }

    @Override
    public Orden poll() {
        return colaCompras.poll();
    }

    @Override
    public Orden peek() {
        return colaCompras.peek();
    }

    public void Run() {
        System.out.println("-----------------------------------------------------------------------------");
        System.out.println("                           Tienda Amazonas           ");
        int i = 0;
        int tiempoActualMilisegundos = 50;
        int tiempoSimulacionMilisegundos = DURACION_SIMULACION_SEGUNDOS * 1000;

        System.out.println("Iniciando simulación de recepción de órdenes de compra...");

        while (tiempoActualMilisegundos < tiempoSimulacionMilisegundos) {
            System.out.println("No. Orden" + i);
            String name = nombreAleatorio();
            int cant = cantidadAleatoria();
            Orden nuevaOrden = new Orden(name, cant);
            // Agregar la orden a la cola con el comparador OrdenComparator
            colaCompras.offer(nuevaOrden);
            System.out.println("Nueva orden recibida: Cliente: " + name + ", Cantidad de productos: " + cant);
            try {
                Thread.sleep(INTERVALO_ORDENES_SEGUNDOS * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            tiempoActualMilisegundos += INTERVALO_ORDENES_SEGUNDOS * 1000;
            i++;
        }
        System.out.println("Todas las órdenes han sido recibidas. Comenzando el procesamiento...");

        while (!colaCompras.isEmpty()) {
            Orden orden = colaCompras.poll();
            System.out.println(orden.toString());
            int tiempoAtencion = orden.getCantidad() * TIEMPO_ATENCION_PRODUCTO_MILISEGUNDOS;
            System.out.println("Procesando orden: Cliente: " + orden.getName() + ", Cantidad de productos: " + orden.getCantidad());

            try {
                Thread.sleep(tiempoAtencion);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("Orden procesada: Cliente: " + orden.getName() + ", Cantidad de productos: " + orden.getCantidad() + ". Tiempo de procesamiento: " + tiempoAtencion + "ms");
        }
    }

    public String nombreAleatorio() {
        Random rmd = new Random();
        String nombre = clientes[rmd.nextInt(clientes.length)];
        return nombre;
    }

    public int cantidadAleatoria() {
        Random rmd = new Random();
        int cant = rmd.nextInt(100) + 1;
        return cant;
    }
}
