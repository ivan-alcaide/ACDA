package boletin4;

import java.sql.*;
import java.util.Scanner;

public class Ej_1 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "ivan";
        String password = "jodete12";
        String cons="SELECT * FROM libros WHERE anio_publicacion > ?";

        try (Connection conexion= DriverManager.getConnection(url,usuario,password);
             PreparedStatement ps = conexion.prepareStatement(cons)){

            System.out.println("Introduzca un año, y se mostraran solo libros despues de tal año: ");
            int anio=sc.nextInt();
            ps.setInt(1,anio);

            try (ResultSet rs=ps.executeQuery()){



                if (!rs.next()) {

                    System.out.println("No se encontraron resultados para la búsqueda.");
                } else {
                    do {
                        System.out.printf("\nTitulo: %s\nAño publicacion: %d\n",rs.getString("titulo"),rs.getInt("anio_publicacion"));
                    } while (rs.next());
                }




            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
