/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package testalumno;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author arturv
 */
public class TestAlumno {

    /**
     * @param args the command line arguments
     */
    //Listado de alumnos es una arraylist
    private static ArrayList<Alumno> alumnos;
    
    //Inserta dos alumnos predefinidos utilizando el contructor.
    private static void insertadosalumnos()
    {
        Alumno nuevo = new Alumno("Artur","Viader",35,9,8,7,8);
        alumnos.add(nuevo);
        nuevo = new Alumno("Pedro","Garcia",30,7,8,9,8);
        alumnos.add(nuevo);
    }
    
    //Muestra el menú principal
    private static void menuprincipal()
    {
        try
        {
            Scanner entrada=new Scanner(System.in);
            int opcion;
            do
            {
                System.out.println("1-Consultar alumno.");
                System.out.println("2-Modificar datos personales.");
                System.out.println("3-Modificar nota.");
                System.out.println("4-Salir");
                opcion=entrada.nextInt();
                switch(opcion)
                {
                    case 1:
                        consultaralumno();
                        break;
                    case 2:
                        modificardatospersonales();
                        break;
                    case 3:
                        modificarnota();
                        break;
                    default:
                }
            }while(opcion!=4);
            System.out.println("Adiós.");
        }
        catch(Exception ex)
        {
            System.out.println("Error");
        }
       
    }
    
    //Muestra de todos los alumnos su nombre y apellido.
    private static void mostraralumnos()
    {
        for(int cont=0;cont<alumnos.size();cont++)
        {
            System.out.println((cont+1) + " - " + alumnos.get(cont).getnombre() + " " + alumnos.get(cont).getapellido());
        }
    }
    
    //Elige un alumno de los que hay
    private static int eligealumno()
    {
        try
        {
            Scanner entrada=new Scanner(System.in);
            int cual;
            System.out.println("Selecciona un alumno.");
            mostraralumnos();
            cual = entrada.nextInt();
            if(cual>0 && cual<=alumnos.size())
            {
                return cual;
            }
            else
            {
                System.out.println("Introduce un valor válido.");
                return -1;
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error.");
            return -1;
        }  
    }
    
    //Muestra los datos de un alumno
    private static void muestraalumno(int pos)
    {
        System.out.println("Nombre - " + alumnos.get(pos).getnombre());
        System.out.println("Apellido - " + alumnos.get(pos).getapellido());
        System.out.println("Edad - " + alumnos.get(pos).getedad());
        alumnos.get(pos).showNotas();
        double notamedia = alumnos.get(pos).getNotaMedia();
        System.out.println("Nota media: " + notamedia);   
    }
    
    //Muestra los datos de un alumno seleccionado
    private static void consultaralumno()
    {
        int numalumno = eligealumno();
        if(numalumno!=-1)
        {
            muestraalumno(numalumno-1);
        }
    }
    
    //Modifica una nota de un alumno
    private static void modificarnota()
    {
        try
        {
            Scanner entrada=new Scanner(System.in);
            int quemodulo;
            double nuevanota;
            int numalumno = eligealumno();
            int opcion;
            if(numalumno!=-1)
            {
                muestraalumno(numalumno-1);
                System.out.println("¿Que nota deseas modificar? Módulo 1,2,3 o 4?");
                quemodulo = entrada.nextInt();
                if(quemodulo>0 && quemodulo<5)
                {
                    System.out.println("Introduce la nueva nota para el módulo " + quemodulo);
                    nuevanota = entrada.nextDouble();
                    alumnos.get(numalumno-1).setNota(nuevanota, quemodulo);
                    System.out.println("Nota cambiada.");
                }
                else
                {
                    System.out.println("Módulo incorrecto.");
                }      
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error.");
        }
               
    }
    
    //Modificar nombre, apellido o edad de un alumno
    private static void modificardatospersonales()
    {
        try
        {
            Scanner entrada=new Scanner(System.in);
            BufferedReader lector = new BufferedReader(new InputStreamReader(System.in));
            int numalumno = eligealumno();
            int opcion;
            if(numalumno!=-1)
            {
                System.out.println("Que dato deseas modificar?");
                System.out.println("1-Nombre.");
                System.out.println("2-Apellido.");
                System.out.println("3-Edad.");
                opcion = entrada.nextInt();
                if(opcion>0 && opcion<4)
                {
                    switch(opcion)
                    {
                        case 1:
                            System.out.println("Introduce el nuevo nombre.");
                            alumnos.get(numalumno-1).setnombre(lector.readLine());
                            System.out.println("Nombre cambiado.");
                            break;
                        case 2:
                            System.out.println("Introduce el nuevo apellido.");
                            alumnos.get(numalumno-1).setapellido(lector.readLine());
                            System.out.println("Nombre cambiado.");
                            break;
                        case 3:
                            System.out.println("Introduce la nueva edad.");
                            int edad = entrada.nextInt();
                            alumnos.get(numalumno-1).setedad(edad);
                            System.out.println("Edad cambiada.");
                            break;
                        default:
                    }
                }
                else
                {
                    System.out.println("Opción incorrecta.");
                }
            }
        }
        catch(Exception ex)
        {
            System.out.println("Error.");
        }
    }
    
    
    
    public static void main(String[] args) {
        // TODO code application logic here
        alumnos = new ArrayList<>();
        insertadosalumnos();
        menuprincipal();
    }
    
}
