/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import CheckApp.servicioPOA;
import java.lang.String;
import java.util.Date;
import org.omg.CORBA.ORB;

/**
 *
 * @author Sergio
 */
public class getservicio extends servicioPOA{
    private ORB orb; 
    Date dt = new Date(); 
    
    public void setORB(ORB orb_val){
        orb = orb_val; 
    }
     getservicio()
    {
        
    }
    
    @Override
    public String get_date() {
       String time=dt.toString();
        return (time);
    }

    @Override
    public int get_time() {
         return(dt.getTimezoneOffset()); 
    }

    @Override
    public void shutdown() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String get_pass(String pass) {
        String password = pass; 
        return pass; 
    }

    @Override
    public String get_name(String name) {
        String n = name; 
        return name; 
    }

    @Override
    public int get_id(int id) {
         int ID = id; 
         return ID; 
    }
    
}