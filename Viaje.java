import java.util.GregorianCalendar;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

public class Viaje
{
    private String origen;
    private String destino;
    private GregorianCalendar horaSalida;
    private GregorianCalendar horaLlegada;  
    private Pasajero[] pasajeros;
    private ArrayList<Pasajero> listaPasajeros;    
    private int capacidad;
    private int cont;
    private Bus bus;
    private Buseta buseta;
    
    public Viaje() {}
    
    public Viaje(String origen, String destino, GregorianCalendar horaSalida, GregorianCalendar horaLlegada, int capacidad)
    {
        this.origen = origen;
        this.destino = destino;
        this.horaSalida = horaSalida;
        this.horaLlegada = horaLlegada;
        this.capacidad = capacidad;        
        this.pasajeros = new Pasajero[capacidad];
        this.listaPasajeros = new ArrayList<Pasajero>();                
        this.cont = 0;
        buseta = new Buseta();
        
    }
    
    public String getOrigen()
    {
        return this.origen;
    }//end method getOrigen

    public void setOrigen(String origen)
    {
        this.origen = origen;
    }//end method setOrigen
    
    public String getDestino()
    {
        return this.destino;
    }//end method getDestino

    public void setDestino(String destino)
    {
        this.destino = destino;
    }//end method setDestino

    
    public GregorianCalendar getHoraSalida()
    {
        return this.horaSalida;
    }//end method getHoraSalida

   
    public void setHoraSalida(GregorianCalendar horaSalida)
    {
        this.horaSalida = horaSalida;
    }//end method setHoraSalida

    
    public GregorianCalendar getHoraLlegada()
    {
        return this.horaLlegada;
    }//end method getHoraLlegada

    
    public void setHoraLlegada(GregorianCalendar horaLlegada)
    {
        this.horaLlegada = horaLlegada;
    }

    
    public Pasajero[] getPasajeros()
    {
        return this.pasajeros;
    }

    
    public void setPasajeros(Pasajero[] pasajeros)
    {
        this.pasajeros = pasajeros;
    }

    
    public Bus getBus()
    {
        return this.bus;
    }

    
    public void setBus(Bus bus)
    {
        this.bus = bus;
    }
    
    public int getCont()
    {
        return this.cont;
    }
    
    public void anadirPasajero(Pasajero p)
    {
        this.pasajeros[this.cont] = p;
        this.cont++;
        
        this.listaPasajeros.add(p);
    }
    
    public String buscarPasajeros(String busqueda)
    {
        String resultado = "";
        // Busqueda con arreglo
        for (int i=0; i<this.cont; i++)        
        {
            if (this.pasajeros[i].getNombre().equals(busqueda) || (this.pasajeros[i].getApellido().equals(busqueda) || (this.pasajeros[i].getNumDocumento()+"").equals(busqueda)))
            {
                resultado = resultado + this.pasajeros[i].toString() + "\n";
            }                
        }
        
        // Busqueda con lista
        for (int i=0; i<this.listaPasajeros.size(); i++)        
        {
            if (this.listaPasajeros.get(i).getNombre().equals(busqueda) || (this.listaPasajeros.get(i).getApellido().equals(busqueda) || (this.listaPasajeros.get(i).getNumDocumento()+"").equals(busqueda)))
            {
                resultado = resultado + this.listaPasajeros.get(i).toString() + "\n";
            }                
        }
        
        // Busqueda con lista 
        for (Pasajero p : this.listaPasajeros)
        {
            if (p.getNombre().equals(busqueda) || p.getApellido().equals(busqueda) || (p.getNumDocumento()+"").equals(busqueda))
            {
                resultado = resultado + p.toString() + "\n";
            }
        }        
        return resultado;
    }
    
    public String toString()
    {
        SimpleDateFormat formato = new SimpleDateFormat("EEE, d MMM yyyy HH:mm:ss");
        String mensaje = "Origen: "+this.origen+"\n"+
                         "Destino: "+this.destino+"\n"+
                         "Salida: "+formato.format(this.horaSalida.getTime())+"\n"+
                         "Llegada: "+formato.format(this.horaLlegada.getTime());
        return mensaje;
    }
}