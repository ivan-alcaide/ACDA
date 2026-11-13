package boletin3;

import java.sql.*;
import java.util.Scanner;

public class Ej_3 {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);

        String url = "jdbc:mysql://localhost:3306/biblioteca";
        String usuario = "ivan";
        String password = "jodete12";

        try (Connection conexion= DriverManager.getConnection(url,usuario,password);
             Statement st=conexion.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);

             ResultSet rs= st.executeQuery("SELECT * FROM libros")){

            int opcion;

            do {
                System.out.println("===== NAVEGADOR DE LIBROS =====\n" +
                        "\n" +
                        "1. Mostrar primer libro\n" +
                        "2. Mostrar último libro\n" +
                        "3. Mostrar siguiente libro\n" +
                        "4. Mostrar libro anterior\n" +
                        "5. Ir a una posición concreta\n" +
                        "6. Mostrar posición actual\n" +
                        "0. Salir\n" +
                        "\n" +
                        "Selecciona una opción: ");

                opcion=sc.nextInt();

                switch (opcion){
                    case 0:
                        System.out.println("Adios miloki");
                        break;

                    case 1:

                        if (rs.first()){
                            System.out.printf("\nPrimer libro\n----------\nIdentificador: %d\nTitulo: %s\nFecha: %d\n\n",rs.getInt("id_libro"),rs.getString("titulo"),rs.getInt("anio_publicacion"));
                        }

                }
            }while (opcion!=0);



        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
