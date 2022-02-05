
package com.pmp.dao;


public class Alumno {


    public int getId() {
        return _id;
    }
    
    public void setId(int _id) {
        this._id = _id;
    }

    public String getCuenta() {
        return _cuenta;
    }

    public void setCuenta(String _cuenta) {
        this._cuenta = _cuenta;
    }

    public String getNombre() {
        return _nombre;
    }

    public void setNombre(String _nombre) {
        this._nombre = _nombre;
    }

    public int getGrado() {
        return _grado;
    }

    public void setGrado(int _grado) {
        this._grado = _grado;
    }

    public double getTelefono() {
        return _telefono;
    }

    public void setTelefono(double _telefono) {
        this._telefono = _telefono;
    }

    public int getEdad() {
        return _edad;
    }

    public void setEdad(int _edad) {
        this._edad = _edad;
    }

    public String getRow(){
        return String.format("%x\t|%s\t|%s\t| %s\t| %.0f\t | %s", _id, _cuenta, _nombre, _grado, _telefono, _edad);
    }
    
    private int _id; 
    private String _cuenta;
    private String _nombre;
    private int _grado;
    private double _telefono;
    private int _edad;    
}
