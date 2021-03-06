package proyecto.ramallo.java.jdbc;

import proyecto.ramallo.java.jdbc.modelo.Categoria;
import proyecto.ramallo.java.jdbc.modelo.Producto;
import proyecto.ramallo.java.jdbc.repositorio.ProductoRepositorioImpl;
import proyecto.ramallo.java.jdbc.repositorio.Repositorio;
import proyecto.ramallo.java.jdbc.util.ConexionBaseDatos;

import java.sql.*;
import java.util.Date;

public class EjemploJDBC {
    public static void main(String[] args) {

            Repositorio<Producto> repositorio = new ProductoRepositorioImpl();
            System.out.println("=============== listar ============================");
            repositorio.listar().forEach(System.out::println); //con referencia al metodo

            System.out.println("=============== obtener por id =======================");
            System.out.println(repositorio.porID(2L));
            System.out.println("===============insertar nuevo producto==================");

            Producto producto = new Producto();
            producto.setNombre("Nootbook Asus ROG");
            producto.setPrecio(180000);
            producto.setFecha_ingreso(new Date());
            Categoria categoria = new Categoria();
            categoria.setId_catg(4L);
            producto.setCategoria(categoria);
            repositorio.guardar(producto);
            System.out.println("Producto guardado con éxito");
            repositorio.listar().forEach(System.out::println); //con referencia al metodo

    }
}
