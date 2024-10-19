/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package baseDeDatos;

/**
 *
 * @author wcume
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;
public class ConexionBD {
    private static final String URL = "jdbc:mysql://localhost:3306/BDBecksport";
    private static final String USER = "root";
    private static final String PASSWORD = "6584";

    public static Connection conectar() {
        Connection conexion = null;
        try {
            conexion = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (SQLException e) {
            System.out.println("Error al conectar: " + e.getMessage());
        }
        return conexion;
    }// fin conectar()
    
    public static void insertarProducto(String codigo,String nombre, double precio, int cantidad, String fecha) {
    String query = "INSERT INTO producto (codigoProducto, nombreProducto, precioUnitario, cantidadProducto, fechaVencimiento) VALUES (?,?, ?, ?, ?)";
    try (Connection con = ConexionBD.conectar(); PreparedStatement pst = con.prepareStatement(query)) {
        pst.setString(1, codigo);
        pst.setString(2, nombre);
        pst.setDouble(3, precio);
        pst.setInt(4, cantidad);
        pst.setDate(5, java.sql.Date.valueOf(fecha));
        pst.executeUpdate();
        System.out.println("Producto insertado correctamente");
    } catch (SQLException e) {
    }
}// fin insertarProducto()
    public static void listarProductos() {
    String query = "select * from producto;";  
    try (Connection con = ConexionBD.conectar(); Statement st = con.createStatement(); ResultSet rs = st.executeQuery(query)) {
        boolean hayResultados = false;
        while (rs.next()) {
            hayResultados = true; 
            System.out.println("Código: " + rs.getString("codigoProducto"));
            System.out.println("Nombre: " + rs.getString("nombreProducto"));
            System.out.println("Precio: " + rs.getDouble("precioUnitario"));
            System.out.println("Cantidad: " + rs.getInt("cantidadProducto"));
            System.out.println("Fecha de Vencimiento: " + rs.getDate("fechaVencimiento"));     
            System.out.println("");
        }
        if (!hayResultados) {
            System.out.println("No hay productos disponibles.");
        }//fin if
     
    } catch (SQLException e) {
        
    }//fin catch
}// fin listarProductos()
    
    public static void buscarProductos(String codigoProducto) {
    String query = "select * from producto WHERE codigoProducto = ?";  
    try (Connection con = ConexionBD.conectar(); PreparedStatement pst = con.prepareStatement(query);) {
        
        pst.setString(1, codigoProducto);
        
        ResultSet rs = pst.executeQuery();
        
        boolean hayResultados = false;
        while (rs.next()) {
            
            
            hayResultados = true; 
            
            System.out.println("Código: " + rs.getString("codigoProducto"));
            System.out.println("Nombre: " + rs.getString("nombreProducto"));
            System.out.println("Precio: " + rs.getDouble("precioUnitario"));
            System.out.println("Cantidad: " + rs.getInt("cantidadProducto"));
            System.out.println("Fecha de Vencimiento: " + rs.getDate("fechaVencimiento"));     
            System.out.println("");
        }
        if (!hayResultados) {
            System.out.println("No hay productos disponibles.");
        }//fin if
     
    } catch (SQLException e) {
        
    }//fin catch
}// fin buscar()
    
    public static void actualizarProducto(String codigoProducto,String nombre, double precio, int cantidad, String fecha) {
    String query = "UPDATE producto SET nombreProducto = ?, precioUnitario = ?,cantidadProducto=?, fechaVencimiento = ? WHERE codigoProducto = ?";
    try (Connection con = ConexionBD.conectar(); PreparedStatement pst = con.prepareStatement(query)) {
        
        pst.setString(1, nombre);
        pst.setDouble(2, precio);
        pst.setInt(3, cantidad);
        pst.setDate(4, java.sql.Date.valueOf(fecha));
        pst.setString(5, codigoProducto);
        pst.executeUpdate();
        System.out.println("Producto actualizado correctamente");
    } catch (SQLException e) {
    }
}// fin actualizarProducto
    
public static void eliminarProducto(String codigoProducto) {
    String query = "DELETE FROM producto WHERE codigoProducto = ?";
    try (Connection con = ConexionBD.conectar(); PreparedStatement pst = con.prepareStatement(query)) {
        
        pst.setString(1, codigoProducto);
        pst.executeUpdate();
        System.out.println("Producto eliminado correctamente");
    } catch (SQLException e) {
        //e.printStackTrace();
    }
}// fin eliminarProducto

    public static void main(String[] args) {
  
        Scanner entrada = new Scanner(System.in); 
        Scanner insertar = new Scanner(System.in); 
        int opcion;
   
        do {
        
        System.out.println("**************************");
        System.out.println("******Menu principal******");
        System.out.println("**************************");
        System.out.println("1.Ingresar productos------");
        System.out.println("2.Mostrar productos-------");
        System.out.println("3.Buscar producto---------");
        System.out.println("4.Modificar producto------");
        System.out.println("5.Eliminar producto-------");
        System.out.println("6.Salir-------------------");
        System.out.println("Seleccione una opcion:");
        opcion = entrada.nextInt();
        
        switch (opcion) {
                case 1:
                    System.out.println("**************************");
                    System.out.println("Ingresar Productos");
                    System.out.println("**************************");
                    
                    System.out.println("código: ");
                    String codigo = insertar.nextLine();
                    System.out.println("Nombre:");
                    String nombre = insertar.nextLine();
                    System.out.println("precio del producto: ");
                    double precio = insertar.nextDouble();
                    System.out.println("cantidad del producto: ");
                    int cantidad = insertar.nextInt();
                    System.out.println("Fecha de Vencimiento (AAAA-MM-DD): ");
                    String fechaVencimiento = insertar.next();
                    
                    insertarProducto(codigo, nombre, cantidad, (int) precio, fechaVencimiento);
                    break;
                case 2:
                    listarProductos();
                    break;
                
                case 3:
                    System.out.println("**************************");
                    System.out.println("Buscar Productos");
                    System.out.println("**************************");
                    System.out.println("código: ");
                    codigo = insertar.nextLine();
                    
                    buscarProductos(codigo);
                    break;
                    
                case 4:
                    System.out.println("**************************");
                    System.out.println("Actualizar Productos");
                    System.out.println("**************************");
                    System.out.println("código: ");
                    codigo = insertar.nextLine();
                    System.out.println("");
                    System.out.println("Nombre:");
                    nombre = insertar.nextLine();
                    System.out.println("Precio del producto: ");
                    precio = insertar.nextDouble();
                    System.out.println("cantidad del producto: ");
                    cantidad = insertar.nextInt();
                    System.out.println("Fecha de Vencimiento (AAAA-MM-DD): ");
                    fechaVencimiento= insertar.next();
                    
                    actualizarProducto(codigo,  nombre, precio,cantidad, fechaVencimiento);
                    break; 
                    
                case 5:
                    
                    
                    System.out.println("**************************");
                    System.out.println("Eliminar producto");
                    System.out.println("**************************");
                    System.out.println("código del producto a eleminar: ");
                    codigo = insertar.nextLine();
                    
                    
                    eliminarProducto(codigo);
                    break;
                    
                case 6:
                    System.out.println("*******************************");
                    System.out.println("PROGRAMA CERRADO correctamente.");
                    break;
                default:
                    System.out.println("Opción inválida, por favor intente de nuevo.");
            }
            System.out.println();
        
        } while (opcion!=6);
        
        
   
        
        
        
    
        
        
        
        
        
    }
}// fin main







