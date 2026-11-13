package boletin3;

import boletin2.Libro;

import java.sql.*;
import java.util.ArrayList;

public class Ej_1 {

    public static void main(String[] args){
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "ivan";
        String password = "jodete12";

        String consulta_orden="SELECT * FROM libros ORDER BY id_libro ASC";
        try (Connection conexion= DriverManager.getConnection(url,usuario,password);
             Statement st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

             ResultSet rs= st.executeQuery(consulta_orden)){

            if (rs.first()){

                System.out.printf("\nEl titulo del primer libro es %s",rs.getString("titulo"));
            }

            if (rs.last()){
                System.out.printf("\nEl titulo del ultimo libro es %s",rs.getString("titulo"));
            }

            if (rs.absolute(5)){
                System.out.printf("\nEl titulo del quinto libro es %s",rs.getString("titulo"));
            }

            if (rs.relative(-2)){
                System.out.printf("\nEl libro actual tras retroceder dos posiciones es %s",rs.getString("titulo"));
            }

            System.out.printf("\nActualmente estamos en la fila %d",rs.getRow());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
