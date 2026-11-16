package boletin4;

import javax.xml.transform.sax.SAXSource;
import java.sql.*;
import java.util.Scanner;

public class Ej_3_rocio {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "ivan";
        String password = "jodete12";

        String sql="UPDATE libros SET ejemplares_disponibles = ? WHERE id_libro = ?";

        String cons="SELECT * FROM libros WHERE id_libro = ?";
        try (Connection conexion = DriverManager.getConnection(url, usuario, password);
             PreparedStatement ps = conexion.prepareStatement(sql);
             PreparedStatement ps2=conexion.prepareStatement(cons)){


            System.out.println("Introduzca el id del libro para actualizar: ");
            int id=sc.nextInt();
            System.out.println("Ahora introduzca la nueva cantidad de ejemplares disponibles: ");
            int ejD=sc.nextInt();



            ps.setInt(1,ejD);

            ps.setInt(2,id);

            int rs2=ps.executeUpdate();

            System.out.printf("\nSe han modificado %d fila(s)",rs2);

            ps2.setInt(1,id);

            ResultSet rs1=ps2.executeQuery();

            if(rs1.next()){
                System.out.println("id: "+ rs1.getString(1)+"  dispo: " + rs1.getString("ejemplares_disponibles"));
            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
