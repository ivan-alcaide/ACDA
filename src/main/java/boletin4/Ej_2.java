package boletin4;

import java.sql.*;
import java.util.Scanner;

public class Ej_2 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "ivan";
        String password = "jodete12";

        String sql = "SELECT * FROM socios WHERE apellidos LIKE ?";

        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            System.out.println("Introduzca a continuacion lo que tiene que conetener los apellidos que busca: ");
            String apellido=sc.nextLine();

            ps.setString(1, "%" + apellido + "%");

            try(ResultSet rs=ps.executeQuery()) {

                if (!rs.next()) {

                    System.out.println("No se encontraron resultados para la búsqueda.");
                } else {
                    do {
                        System.out.printf("\nNombre: %s\nApellidos: %s\nCorreo electrónico: %s\n",rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"));
                    } while (rs.next());
                }
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
}
