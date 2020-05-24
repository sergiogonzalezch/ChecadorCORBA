/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import CheckApp.*;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import java.io.*;
import java.lang.String;
import static java.lang.System.in;
import java.util.Date;
import java.util.Scanner;


public class getservicioClient {
    static servicio servicioImpl; 
    public static void main(String args[])
    {
        try
        {
            // initialize the ORB
           ORB orb = ORB.init(args,null);

            org.omg.CORBA.Object objRef = 
                    orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
            
            String name = "Checador";
            servicioImpl = servicioHelper.narrow(ncRef.resolve_str(name));

            Scanner in; 
            in = new Scanner(System.in);
            
            System.out.println("Ingrese su nombre");
            String nombre = in.nextLine(); 
             System.out.println("Ingrese su contraseña");
            String pass = in.nextLine(); 
             System.out.println("Ingrese su Id");
            int id = in.nextInt(); 
            
            if(nombre != null){
            
                if (pass != null) {
                    
                    if (id !=0) {
                        Date dt=new Date();
                        long clientTime=dt.getTime();
                        System.out.println("Client Date and Time="+dt);
                        
                        String serverDate=(String)servicioImpl.get_date();
                        
                        long serverTime=(long) servicioImpl.get_time();
                        System.out.println("Server Date and Time="+serverDate);
                    }
                }
            }
                        
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}
