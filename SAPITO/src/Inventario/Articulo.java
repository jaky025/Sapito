/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventario;

/**
 *
 * @author daniel
 */
public class Articulo {
    /// La clase articulo solo va a tener los metodos los setters y getters
    
    
    private int id;                   //id es el identificador del producto 
    private String descripcion;       //En la descripción van datos como el nombre o caracteriztics
    private String unidad;            //Unidad es la unidad con la que se miden los productos (pzs, cajas, etc...
    private int existencia; //existencia se refiere a la cantidad de articulos con los que se cuenta en el almacen
    private String detalles; //
    private int maximo;    //Es el maximo de articulos con los que debe contar el almacen (es decir no se puede comprar mas de lo que cabe en la bodega)
    private int minimo;    //Es el minimo de articulos con los que  debe contar  el almacen
    private double precio;    //precio se refiere al valor $$$ en que esta a la venta el producto
    private double costo;   //costo es el valor  $$$ en que se compro  el producto

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getUnidad() {
        return unidad;
    }

    public void setUnidad(String unidad) {
        this.unidad = unidad;
    }

    public int getExistencia() {
        return existencia;
    }

    public void setExistencia(int existencia) {
        this.existencia = existencia;
    }

    public String getDetalles() {
        return detalles;
    }

    public void setDetalles(String detalles) {
        this.detalles = detalles;
    }

    public int getMaximo() {
        return maximo;
    }

    public void setMaximo(int maximo) {
        this.maximo = maximo;
    }

    public int getMinimo() {
        return minimo;
    }

    public void setMinimo(int minimo) {
        this.minimo = minimo;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
    
    
}
