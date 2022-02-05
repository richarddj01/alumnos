
package com.pmp.dao;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class AlumnosModel {
    
    private Connection _cn = null;
    
    public AlumnosModel(){
        _cn = conexion.cn();
        String sql = "CREATE TABLE IF NOT EXISTS Alumnos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,"
                +" cuenta TEXT NOT NULL,"
                +" nombre TEXT NOT NULL,"
                +" grado NUMERIC NOT NULL,"
                +" telefono NUMERIC,"
                +" edad INT);";
        try{
            Statement comando = _cn.createStatement();
            int resultado = comando.executeUpdate(sql);
        }catch(Exception e){
            System.err.print(e.getMessage());
        }
    }
    public ArrayList<Alumno> obtenerAlumnos(){
        try{
            ArrayList alumnos = new ArrayList<Alumno>();
            Statement cmd = _cn.createStatement();
            ResultSet registroEnTabla = cmd.executeQuery("SELECT * FROM alumnos;");
            while(registroEnTabla.next()){
                Alumno alumn = new Alumno();
                alumn.setId(registroEnTabla.getInt("id"));
                alumn.setCuenta(registroEnTabla.getString("cuenta"));
                alumn.setNombre(registroEnTabla.getString("nombre"));     
                alumn.setGrado(registroEnTabla.getInt("grado"));
                alumn.setTelefono(registroEnTabla.getDouble("telefono"));
                alumn.setEdad(registroEnTabla.getInt("edad"));
                
                alumnos.add(alumn);
            }
            return alumnos;
        }
        catch(Exception e){
            System.err.println(e.getMessage());
            return new ArrayList<Alumno>();
        }
    }
    public int agregarAlumno(Alumno alumn){
        try{
            String sql = "INSERT INTO Alumnos (cuenta, nombre, grado, telefono, edad) VALUES (?,?,?,?,?);";
            PreparedStatement cmd = _cn.prepareStatement(sql);
            cmd.setString(1, alumn.getCuenta());
            cmd.setString(2, alumn.getNombre());
            cmd.setInt(3, alumn.getGrado());
            cmd.setDouble(4, alumn.getTelefono());
            cmd.setInt(5, alumn.getEdad());
            
            int RegistrosAfectados = cmd.executeUpdate();
            cmd.close();
            return RegistrosAfectados;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
    public Alumno obtenerAlumno(int id){
        try{
            PreparedStatement cmd = _cn.prepareStatement("SELECT * FROM alumnos WHERE id = ?;");
            cmd.setInt(1, id);
            ResultSet registro = cmd.executeQuery();
            Alumno alumn = new Alumno();
            while(registro.next()){
                alumn.setId(registro.getInt("id"));
                alumn.setCuenta(registro.getString("cuenta"));
                alumn.setNombre(registro.getString("nombre"));
                alumn.setGrado(registro.getInt("grado"));
                alumn.setTelefono(registro.getDouble("telefono"));
                alumn.setEdad(registro.getInt("edad"));
                break;
            }
            return alumn;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return null;
        }
    }
    public int actualizarAlumno(Alumno alumn){
        try{
            String sql = "UPDATE alumnos SET cuenta = ?, nombre = ?, grado = ?, telefono = ?, edad = ? WHERE id = ?";
            PreparedStatement cmd = _cn.prepareStatement(sql);
            cmd.setString(1, alumn.getCuenta());
            cmd.setString(2, alumn.getNombre());
            cmd.setInt(3, alumn.getGrado());
            cmd.setDouble(4, alumn.getTelefono());
            cmd.setInt(5, alumn.getEdad());
            cmd.setInt(6, alumn.getId());
            
            int regAfectados = cmd.executeUpdate();
            cmd.close();
            return regAfectados;
        }catch(Exception e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
    public int eliminarAlumno(int id){
        try{
            String sql = "DELETE FROM alumnos WHERE id=?";
            PreparedStatement cmd = _cn.prepareStatement(sql);
            cmd.setInt(1, id);
            int eliminado = cmd.executeUpdate();
            return eliminado; 
        }catch(Exception e){
            System.err.println(e.getMessage());
            return 0;
        }
    }
}
