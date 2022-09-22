

package controller;

import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
//import java.util.Date;
import java.util.List;

import com.google.gson.Gson;
import beans.Inmueble;
import connection.DBConnection;
import java.sql.Date;

public class InmuebleController implements IInmuebleController {

    @Override
    public String listar(boolean ordenar, String orden) {

        Gson gson = new Gson();

        DBConnection con = new DBConnection();
        String sql = "Select * from inmueble";

        if (ordenar == true) {
            sql += " order by genero " + orden;
        }

        List<String> inmuebles = new ArrayList<String>();

        try {

            Statement st = con.getConnection().createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {

                int idInmueble = rs.getInt("id_inmueble");
                String tipoInmueble = rs.getString("tipo_inmueble");
                String ciudadInmueble = rs.getString("ciudad_inmueble");
                String zonaInmueble = rs.getString("zona_inmueble");
                String descripcionInmueble = rs.getString("descripcion_inmueble");
                int precioInmueble = rs.getInt("precio_inmueble");
                boolean disponibleInmueble = rs.getBoolean("disponible_inmueble");
                Date reservaCita = rs.getDate("reserva_cita");

                Inmueble inmueble = new Inmueble(idInmueble, tipoInmueble, ciudadInmueble, zonaInmueble, descripcionInmueble, precioInmueble, disponibleInmueble, reservaCita);
                
                

                inmuebles.add(gson.toJson(inmueble));
                
                
                
            }
            
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        } finally {
            con.desconectar();
        }

        return gson.toJson(inmuebles);

    }

    


}
