package boletin2;

import javax.management.Query;
import javax.print.DocFlavor;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;

public class GestionBiblioteca {

    public static void main(String[] args){

        ArrayList<Libro> libros=new ArrayList<>();

        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "ivan";
        String password = "jodete12";

        String consulta="select * from libros";
        String inser="insert into libros(titulo, isbn, anio_publicacion, id_editorial, ejemplares_totales, ejemplares_disponibles) values ('El principito', '9788478887194', 1943, NULL, 3, 3)";

        try (Connection conexion= DriverManager.getConnection(url,usuario,password);
             Statement st=conexion.createStatement()){

            System.out.println("Conexion establecida");
            System.out.println("Base de datos : " + conexion.getCatalog());

            ResultSet rs= st.executeQuery(consulta);

            while (rs.next()){
                libros.add(
                        new Libro(
                                rs.getInt("id_libro"),
                                rs.getString("titulo"),
                                rs.getString("isbn"),
                                rs.getInt("anio_publicacion"),
                                rs.getInt("id_editorial"),
                                rs.getInt("ejemplares_totales"),
                                rs.getInt("ejemplares_disponibles")
                        )
                );
            }


            for (Libro l : libros){

                if (l.getEjemplares_disponibles()>0) {

                    System.out.println(l.toStringRed());
                }
            }




        } catch (SQLException e) {
            throw new RuntimeException(e);
        }




    }



}
