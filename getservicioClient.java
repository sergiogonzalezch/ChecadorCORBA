/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import CheckApp.*;
import org.omg.CosNaming.*;
import org.omg.CORBA.*;
//import java.lang.String;
import java.util.Date;
import java.util.Scanner;
//import savetxt; 

public class getservicioClient {
    static servicio servicioImpl; 
    public static void main(String args[])
    {
        
        savetxt st = new savetxt();  
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
            
            long clientTime; 
            long serverTime; 
            if(nombre != null){
            
                if (pass != null) {
                    
                    if (id !=0) {
                        Date dt=new Date();
                        clientTime=dt.getTime();
                        System.out.println("Client Date and Time="+dt);
                        
                        String serverDate=(String)servicioImpl.get_date();
                        
                        serverTime=(long) servicioImpl.get_time();
                        System.out.println("Server Date and Time="+serverDate);
                        
                        boolean v = st.findfile(); 
                        
                        if(v ==false){
                            st.createFile(nombre,id,dt); 
                        }else{
                            st.updateFile(nombre, id, dt);
                        }
                        
                        
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
