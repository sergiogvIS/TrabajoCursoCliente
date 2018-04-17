/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabajodecursocliente;

import com.google.gson.Gson;
import org.json.JSONArray;
import org.json.JSONObject;

/**
 *
 * @author entrar
 */
public class TrabajoDeCursoCliente {
    static InvetarioBD inv = new InvetarioBD();
    public static void main(String[] args) throws Exception {             
        mostrarDatosTodos();
        System.out.println("-----Prueba con Datos Individuales-------");
        System.out.println("-----------------------------------------");
        mostrarDatos("1");
        mostrarDatos("2");
        mostrarId("3");
        mostrarNombre("3");
        mostrarContraseña("3");
        mostrarDept("3");
        mostrarSueldo("3");
        InvetarioBD inv = new InvetarioBD();
      /**  System.out.println(inv.find_JSON(String.class, "1"));
        String q = "{\"cantidad\":"+ 500 +",\"id\":1,\"nombre\":\"tarjeta Gráfica\",\"precio\":799.0}";
        inv.edit_JSON(q, "1");
        System.out.println(inv.find_JSON(String.class, "1"));
        System.out.println(inv.findAll_JSON(String.class));
        q = "{\"cantidad\":10,\"id\":1,\"nombre\":\"tarjeta Gráfica\",\"precio\":699.0}";
        inv.edit_JSON(q, "1");*/
        //inv.remove("1");
        insertar(1,"Tarjeta Grafica",10,699.99);
        modificar(1,"Pantalla",10,699.99);
        System.out.println(inv.find_JSON(String.class, "1"));
        System.out.println(inv.findAll_JSON(String.class));
        eliminar(1);
        System.out.println(inv.findAll_JSON(String.class));
        
        
    }
    public static void insertar(int id, String nombre, int cantidad, double precio){
        String q = "{\"cantidad\":"+cantidad+",\"id\":"+id+",\"nombre\":\""+nombre+"\",\"precio\":"+precio+"}";
        inv.create_JSON(q);
    }
    public static void modificar(int id, String nombre, int cantidad, double precio){
        String q = "{\"cantidad\":"+cantidad+",\"id\":"+id+",\"nombre\":\""+nombre+"\",\"precio\":"+precio+"}";
        inv.edit_JSON(q,String.valueOf(id));
    }
    public static void eliminar(int id){
        inv.remove(String.valueOf(id));
    }    
    public static void mostrarDatos(String id){
        BaseDeDatos BDD = new BaseDeDatos();      
        String res = BDD.buscarPorID(String.class,id);
        JSONObject obj = new JSONObject(res);
        System.out.println("Id: "+ obj.getInt("id"));
        System.out.println("Nombre: "+ obj.getString("nombre"));
        System.out.println("Contraseña: "+ obj.getString("contraseña"));
        System.out.println("Departamento: "+ obj.getString("dept"));
        System.out.println("Sueldo: "+ obj.getDouble("sueldo"));
        System.out.println("-----------------------------------------");
    }
        public static void mostrarContraseña(String id){
        BaseDeDatos BDD = new BaseDeDatos();      
        String res = BDD.buscarPorID(String.class,id);
        JSONObject obj = new JSONObject(res);
        System.out.println("Contraseña: "+ obj.getString("contraseña"));
        System.out.println("-----------------------------------------");
    }
        public static void mostrarId(String id){
        BaseDeDatos BDD = new BaseDeDatos();      
        String res = BDD.buscarPorID(String.class,id);
        JSONObject obj = new JSONObject(res);
        System.out.println("Id: "+ obj.getInt("id"));
        System.out.println("-----------------------------------------");
    }
        public static void mostrarNombre(String id){
        BaseDeDatos BDD = new BaseDeDatos();      
        String res = BDD.buscarPorID(String.class,id);
        JSONObject obj = new JSONObject(res);
        System.out.println("Nombre: "+ obj.getString("nombre"));
        System.out.println("-----------------------------------------");
    }
        public static void mostrarDept(String id){
        BaseDeDatos BDD = new BaseDeDatos();      
        String res = BDD.buscarPorID(String.class,id);
        JSONObject obj = new JSONObject(res);
        System.out.println("Departamento: "+ obj.getString("dept"));
        System.out.println("-----------------------------------------");
    }
        public static void mostrarSueldo(String id){
        BaseDeDatos BDD = new BaseDeDatos();      
        String res = BDD.buscarPorID(String.class,id);
        JSONObject obj = new JSONObject(res);
        System.out.println("Sueldo: "+ obj.getDouble("sueldo"));
        System.out.println("-----------------------------------------");
    }        
        
    
    
    
    public static void mostrarDatosTodos(){
        BaseDeDatos BDD = new BaseDeDatos();      
        String res = BDD.MostrarTodosLosEmpleados(String.class);    
        JSONArray arr = new JSONArray(res);
        for(int i=0; i<arr.length();i++){
        JSONObject obj = arr.getJSONObject(i);
        System.out.println("Id: "+ obj.getInt("id"));
        System.out.println("Nombre: "+ obj.getString("nombre"));
        System.out.println("Contraseña: "+ obj.getString("contraseña"));
        System.out.println("Departamento: "+ obj.getString("dept"));
        System.out.println("Sueldo: "+ obj.getDouble("sueldo"));
        System.out.println("-----------------------------------------");       
        }
        
    }
    
}
