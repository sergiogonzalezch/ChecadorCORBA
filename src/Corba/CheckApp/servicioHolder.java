package CheckApp;

/**
* CheckApp/servicioHolder.java .
* Generated by the IDL-to-Java compiler (portable), version "3.2"
* from time.idl
* s�bado 23 de mayo de 2020 09:49:26 PM CDT
*/

public final class servicioHolder implements org.omg.CORBA.portable.Streamable
{
  public CheckApp.servicio value = null;

  public servicioHolder ()
  {
  }

  public servicioHolder (CheckApp.servicio initialValue)
  {
    value = initialValue;
  }

  public void _read (org.omg.CORBA.portable.InputStream i)
  {
    value = CheckApp.servicioHelper.read (i);
  }

  public void _write (org.omg.CORBA.portable.OutputStream o)
  {
    CheckApp.servicioHelper.write (o, value);
  }

  public org.omg.CORBA.TypeCode _type ()
  {
    return CheckApp.servicioHelper.type ();
  }

}
