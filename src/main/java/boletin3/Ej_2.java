package boletin3;

import java.sql.*;

public class Ej_2 {

    public static void main(String[] args){

        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "ivan";
        String password = "jodete12";

        String consulta="SELECT * FROM socios ORDER BY id_socio ASC";

        try(Connection conexion= DriverManager.getConnection(url,usuario,password);
            Statement st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
                    ResultSet.CONCUR_READ_ONLY);

            ResultSet rs= st.executeQuery(consulta)) {

            if (rs.last()){

                do {
                    System.out.printf("\nNombre de socio: %s\nApellidos: %s\nCorreo: %s\n",rs.getString("nombre"),rs.getString("apellidos"),rs.getString("email"));

                    if (rs.isFirst()){
                        System.out.print("Primer registro alcanzado");
                    }

                }while (rs.previous());

            }


        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}
