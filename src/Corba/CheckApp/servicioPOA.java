package CheckApp;


/**
* CheckApp/servicioPOA.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from time.idl
* s�bado 23 de mayo de 2020 09:49:26 PM CDT
*/

public abstract class servicioPOA extends org.omg.PortableServer.Servant
 implements CheckApp.servicioOperations, org.omg.CORBA.portable.InvokeHandler
{

  // Constructors

  private static java.util.Hashtable _methods = new java.util.Hashtable ();
  static
  {
    _methods.put ("get_id", new java.lang.Integer (0));
    _methods.put ("get_pass", new java.lang.Integer (1));
    _methods.put ("get_name", new java.lang.Integer (2));
    _methods.put ("get_date", new java.lang.Integer (3));
    _methods.put ("get_time", new java.lang.Integer (4));
    _methods.put ("shutdown", new java.lang.Integer (5));
  }

  public org.omg.CORBA.portable.OutputStream _invoke (String $method,
                                org.omg.CORBA.portable.InputStream in,
                                org.omg.CORBA.portable.ResponseHandler $rh)
  {
    org.omg.CORBA.portable.OutputStream out = null;
    java.lang.Integer __method = (java.lang.Integer)_methods.get ($method);
    if (__method == null)
      throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);

    switch (__method.intValue ())
    {
       case 0:  // CheckApp/servicio/get_id
       {
         int id = in.read_long ();
         int $result = (int)0;
         $result = this.get_id (id);
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 1:  // CheckApp/servicio/get_pass
       {
         String pass = in.read_string ();
         String $result = null;
         $result = this.get_pass (pass);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 2:  // CheckApp/servicio/get_name
       {
         String name = in.read_string ();
         String $result = null;
         $result = this.get_name (name);
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 3:  // CheckApp/servicio/get_date
       {
         String $result = null;
         $result = this.get_date ();
         out = $rh.createReply();
         out.write_string ($result);
         break;
       }

       case 4:  // CheckApp/servicio/get_time
       {
         int $result = (int)0;
         $result = this.get_time ();
         out = $rh.createReply();
         out.write_long ($result);
         break;
       }

       case 5:  // CheckApp/servicio/shutdown
       {
         this.shutdown ();
         out = $rh.createReply();
         break;
       }

       default:
         throw new org.omg.CORBA.BAD_OPERATION (0, org.omg.CORBA.CompletionStatus.COMPLETED_MAYBE);
    }

    return out;
  } // _invoke

  // Type-specific CORBA::Object operations
  private static String[] __ids = {
    "IDL:CheckApp/servicio:1.0"};

  public String[] _all_interfaces (org.omg.PortableServer.POA poa, byte[] objectId)
  {
    return (String[])__ids.clone ();
  }

  public servicio _this() 
  {
    return servicioHelper.narrow(
    super._this_object());
  }

  public servicio _this(org.omg.CORBA.ORB orb) 
  {
    return servicioHelper.narrow(
    super._this_object(orb));
  }


} // class servicioPOA