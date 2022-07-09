import javax.swing.JOptionPane;
import java.util.GregorianCalendar;

public class Arranque
{
    static Viaje v;
    
    public static void main(String [] args)
    {
        int opcion;
        do
        {
            String menu = "MENU PRINCIPAL\n" +
                          "1) Crear viaje \n" +
                          "2) Añadir pasajeros al viaje \n" +
                          "3) Mostrar viaje y pasajeros del viaje \n" +
                          "4) Buscar pasajeros dentro del viaje \n" +
                          "5) Asignar bus \n" +
                          "0) Salir";
            opcion = Integer.parseInt(JOptionPane.showInputDialog(null, menu));
            switch(opcion)
            {
                case 1:
                    crearViaje();                   
                    break;
                case 2:
                    anadirPasajero();
                    break;
                case 3:
                    mostrarViajeYPasajeros();
                    break;
                case 4:
                    buscarPasajeros();
                    break;
                case 5:
                    
                    break;
                case 0:
                    JOptionPane.showMessageDialog(null, "Gracias");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
            }
        }
        while(opcion != 0);    
    }
    
    public static GregorianCalendar preguntarFecha(String mensaje)
    {
        String fechaS = JOptionPane.showInputDialog(null, "Ingrese fecha "+mensaje+" (dd-mm-yyyy)");
        String [] arrFecha = fechaS.split("-");
        int dia = Integer.parseInt(arrFecha[0]);
        int mes = Integer.parseInt(arrFecha[1])-1;
        int anio = Integer.parseInt(arrFecha[2]);
        
        String horaS = JOptionPane.showInputDialog(null, "Ingrese hora "+mensaje+" (hh:mm)");
        String [] arrHora = horaS.split(":");
        int hora = Integer.parseInt(arrHora[0]);
        int min = Integer.parseInt(arrHora[1]);
        GregorianCalendar fechaSalida = new GregorianCalendar(anio, mes, dia, hora, min);
        return fechaSalida;
    }
    
    public static void crearViaje()
    {
        String origen = JOptionPane.showInputDialog(null, "Ingrese origen del viaje");
        String destino = JOptionPane.showInputDialog(null, "Ingrese destino del viaje");
        GregorianCalendar fechaSalida = preguntarFecha("de salida del viaje");
        GregorianCalendar fechaLlegada = preguntarFecha("de llegada del viaje");
        int capacidad = Integer.parseInt(JOptionPane.showInputDialog(null, "Ingrese capacidad maxima del viaje"));
        v = new Viaje(origen, destino, fechaSalida, fechaLlegada, capacidad);
        JOptionPane.showMessageDialog(null, "Viaje creado: \n"+v.toString());
    }
    
    public static void anadirPasajero()
    {
        if (v==null)
        {
            JOptionPane.showMessageDialog(null, "debe crear el viaje primero");
        }
        else
        {
            Pasajero p = preguntarPasajero();
            v.anadirPasajero(p);
        }        
    }
           
    public static void mostrarViajeYPasajeros()
    {
        JOptionPane.showMessageDialog(null, v.toString());
        for (int i=0; i<v.getCont(); i++)
        {
            JOptionPane.showMessageDialog(null, v.getPasajeros()[i].toString());
        }
        
    }
    
    public static void buscarPasajeros()
    {
        String datoABuscar = JOptionPane.showInputDialog(null,"Ingrese dato a buscar: ");
        String resultado = v.buscarPasajeros(datoABuscar);
        JOptionPane.showMessageDialog(null, resultado);
    }
    
    public static void crearBus()
    {
        
    }
       
    public static Pasajero preguntarPasajero()
    {
        String nombre = JOptionPane.showInputDialog(null, "Nombre de pasajero");
        String apellido = JOptionPane.showInputDialog(null, "Apellido de pasajero");
        int numDocumento = Integer.parseInt(JOptionPane.showInputDialog(null, "Numero de documento"));
        String [] equipajes = new String[3];
        
        for (int i=0; i<3; i++)
        {
            equipajes[i] = JOptionPane.showInputDialog(null, "Equipaje "+(i+1)+" de pasajero");
        }
        
        Pasajero pas = new Pasajero(nombre, apellido, numDocumento, equipajes);        
        
        return pas;
    }
}
