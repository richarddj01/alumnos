package com.pmp.estudiantes;

import com.pmp.dao.Alumno;
import com.pmp.dao.AlumnosModel;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author PC
 */
public class Main {
    private static Scanner leer;
    private static AlumnosModel model = new AlumnosModel();
    
    public static void main(String[] args){
        leer = new Scanner(System.in);
        
        Utilidades.encabezado("Gestion de Alumnos");
        
        String op = "*";
        do{
            Utilidades.menu();
            op = leer.nextLine().toLowerCase();
            switch(op){
                case "l":
                    listar();
                    break;
                case "n":
                    insertar();
                    break;
                case "a":
                     actualizar();
                    break;
                case "e":
                    eliminar();
                    break;
                case "s":
                    op = "*";
                    break;
                default:
                    Utilidades.print("Opcion inválida");
            }
        }while(op != "*");
    }
    
    private static void listar(){
        Utilidades.printEncabezadoTabla();
        ArrayList<Alumno> alumnos = model.obtenerAlumnos();
        for(int i = 0; i< alumnos.size(); i++){
            Utilidades.print(alumnos.get(i).getRow());
            Utilidades.separador();
        }
    }
    
    private static void insertar(){
        Alumno alumn = new Alumno();
        alumn.setCuenta(Utilidades.capturarCampo(leer, "Cuenta","xxxx-xxxx-xxxxx"));        
        alumn.setNombre(Utilidades.capturarCampo(leer, "Nombre","xxxxxx"));
        alumn.setGrado(Integer.parseInt(Utilidades.capturarCampo(leer, "Grado","x")));
        alumn.setTelefono(Double.parseDouble(Utilidades.capturarCampo(leer, "Telefono","xxxxxxxx")));
        alumn.setEdad(Integer.parseInt(Utilidades.capturarCampo(leer, "Edad","xx")) );
        Utilidades.separador();
        int insertado = model.agregarAlumno(alumn);
        if (insertado> 0){
            Utilidades.print("Alumno agregado exitosamente");
        }
        Utilidades.separador();
    }
    private static void actualizar(){
        Alumno alumn = new Alumno();
        Utilidades.encabezado("Actualizacion de datos:");
        alumn.setId(Integer.parseInt(Utilidades.capturarCampo(leer, "ID", "")));
        alumn = model.obtenerAlumno(alumn.getId());
        alumn.setCuenta(Utilidades.capturarCampo(leer, "Cuenta", alumn.getCuenta()));
        alumn.setNombre(Utilidades.capturarCampo(leer, "Nombre", alumn.getNombre()));
        alumn.setGrado(Integer.parseInt(Utilidades.capturarCampo(leer, "Grado", Integer.toString(alumn.getGrado()))));
        alumn.setTelefono(Double.parseDouble(Utilidades.capturarCampo(leer, "Teléfono", String.format("%.0f",alumn.getTelefono()))));
        alumn.setEdad(Integer.parseInt(Utilidades.capturarCampo(leer, "Edad", Integer.toString(alumn.getEdad()))));
        int actualizar = model.actualizarAlumno(alumn);
        if(actualizar>0){
            Utilidades.print("Actualización de datos exitosa!");
        }
        Utilidades.separador();
    }
    private static void eliminar(){
        Alumno alumn = new Alumno();
        alumn.setId(Integer.parseInt(Utilidades.capturarCampo(leer, "ID", "")));
        alumn = model.obtenerAlumno(alumn.getId());
        if(alumn.getId()!= 0){String op = "[";
            Utilidades.separador();
            Utilidades.print("Realmente desea eliminar el alumno?\n S\tSI  |  N \tNo");
            op = leer.nextLine().toLowerCase();
            if(op.equals("s")){
                int eliminar = model.eliminarAlumno(alumn.getId());
                if(eliminar > 0){
                    Utilidades.print("Alumno eliminado exitosamente!");
                }else{
                    Utilidades.print("Alumno no encontrado");
                } 
            }
        }else{
            Utilidades.print("Alumno no encontrado");
            Utilidades.separador();
        }
    }
}