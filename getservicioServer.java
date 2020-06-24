/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import CheckApp.servicio;
import org.omg.CosNaming.*;
import org.omg.CosNaming.NamingContextPackage.*;
import org.omg.CORBA.*;
import org.omg.PortableServer.*;
/**
 *
 * @author Sergio
 */
public class getservicioServer {
    //static String[]argsz={"ORBInitialPort 3700","-ORBInitialHost localhost"};
    
    public static void main(String[]args)
    {
        try
        {
            // initialize the ORB
          //  org.omg.CORBA.ORB orb = org.omg.CORBA.ORB.init(args,null);
            ORB orb = ORB.init(args,null);
            // initialize the BOA/POA
            POA rootPOA = POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
            rootPOA.the_POAManager().activate();

            
            getservicio checador = new getservicio();
            checador.setORB(orb);
            
            org.omg.CORBA.Object ref = rootPOA.servant_to_reference(checador);
            servicio h_ref = CheckApp.servicioHelper.narrow(ref);
            
            org.omg.CORBA.Object objRef =orb.resolve_initial_references("NameService");
            NamingContextExt ncRef = NamingContextExtHelper.narrow(objRef);
           
            String name = "Checador";
            NameComponent path[] = ncRef.to_name(name);
            ncRef.rebind(path,h_ref);

            System.out.println("Checador ready and waiting....");
            orb.run();


        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
    }
}

