/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.pmp.estudiantes;

import java.util.Scanner;

/**
 *
 * @author PC
 */
public class Utilidades {
    public static void separador(){
        System.out.println(new String(new char[80]).replace("\0", "-"));
    }
    public static void print(String text){
        System.out.println(text);
    }
    public static void encabezado(String text){
        separador();
        print(text);
        separador();
    }
    public static void menu(){
        String menu = "L\tLista | N\tNuevo | A\tActualizar | E\tEliminar | S\tSalir";
        print(menu);
        separador();
    }
    public static String capturarCampo(Scanner entradaTeclado, String leyenda, String valorPredeterminado){
        print(leyenda + "(" + valorPredeterminado+")");
        String input = entradaTeclado.nextLine();
        if(input.isEmpty()){
            return valorPredeterminado;
        }
        return input;
        
        
    }
    public static void printEncabezadoTabla(){
        separador();
        print(String.format("%s\t|%s\t\t|%s\t\t|%s\t|%s\t | %s", "ID", "CUENTA","NOMBRE", "GRADO", "TELÉFONO","EDAD"));
        separador();
    }
}
