package boletin4;

import java.sql.*;
import java.util.Scanner;

public class Ej_3 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "ivan";
        String password = "jodete12";

        String sql="UPDATE biblioteca.libros SET ejemplares_disponibles = ? WHERE id_libro = ?";

        String cons="SELECT * FROM libros WHERE id_libro = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             PreparedStatement ps = conexion.prepareStatement(sql);
             PreparedStatement ps2=conexion.prepareStatement(cons)){


            System.out.println("Introduzca el id del libro para actualizar: ");
            int id=sc.nextInt();
            ps2.setInt(1,id);

            ResultSet rs1=ps2.executeQuery();


            if (!rs1.next()){
                System.out.println("No existe ningun libro con el id proporcionado");
                System.exit(1);
            }

            System.out.println("Ahora introduzca la nueva cantidad de ejemplares disponibles: ");
            int ejD=sc.nextInt();

            if (ejD<0 || ejD>rs1.getInt("ejemplares_totales")){
                System.out.println("La nueva cantidad no puede ser ni negativa, ni mayor que los ejemplares totales");
                System.exit(1);
            }


            ps.setInt(2,id);
            ps.setInt(1,ejD);

            int rs2=ps.executeUpdate();

            System.out.printf("\nSe han modificado %d fila(s)",rs2);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
