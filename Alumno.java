/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testalumno;

/**
 *
 * @author arturv
 */
public class Alumno {
    private String nombre;
    private String apellido;
    private int edad;
    private double[] notas;
    final int modulos = 4;

    public String getnombre()
    {
        return nombre;
    }
    
    public void setnombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    public String getapellido()
    {
        return apellido;
    }
    
    public void setapellido(String apellido)
    {
        this.apellido = apellido;
    }
    
    public int getedad()
    {
        return edad;
    }
    
    public void setedad(int edad)
    {
        this.edad = edad;
    }
    
    //Muestra las cuatro notas de los 4 módulos del alumno.
    public void showNotas()
    {
        for(int cont=0;cont<notas.length;cont++)
        {
            System.out.println("Módulo " + (cont+1) + " " + notas[cont]);
        }
    }
    
    //Calcula la nota media del alumno
    public double getNotaMedia()
    {
        double total=0;
        for(int cont=0;cont<notas.length;cont++)
        {
            total += notas[cont];
        }
        return total/notas.length;    
    }
    
    //Modifica una nota
    public void setNota(double nota, int modulo)
    {
        notas[modulo-1] = nota;
    }
    
    //Constructor por defecto
    public Alumno()
    {
        notas = new double[modulos];
    }
    
    //Constructor que introduce todos los datos del alumno
    public Alumno(String nombre, String apellido, int edad, double notaa, double notab, double notac, double notad)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        notas = new double[modulos];
        notas[0]=notaa;
        notas[1]=notab;
        notas[2]=notac;
        notas[3]=notad;
    }  
}
