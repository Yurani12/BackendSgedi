/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Packages;
import co.edu.sena.adsi.jpa.sessions.PackagesFacade;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1261718
 */
@Path("packages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class PackagesREST {
    @EJB
    private PackagesFacade packagesEJB;
    
    
    
    @GET
    public List<Packages> findAll(){
        return packagesEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Packages findBye(
    @PathParam("nombre")String nombre){
        return packagesEJB.find(nombre);
    }
    
    @POST
    public void create(Packages packages){
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.create();
        
        try {
            Packages newPackages = new Packages();         
        }catch (Exception e){
            System.out.println("Error="+ e);
        }
    }
    public static void menuVentas(ArrayList<Packages> productos){
        Packages newPackages = new Packages();
        Scanner teclado = new Scanner (System.in);
        int opcion;
        
        String respuesta;
        do {
            System.out.println("--Menu de ventas de paquetes--");
            System.out.println("");
            
            for(int i = 1;i>=2; i++){
                System.out.println("Pulse" + i + " Para comprar" + productos.get(i).getPackageName() + "cuyo precio es de"+ newPackages.getPrice());
                System.out.println("Recuerda que solo puedes comprar un paquete, luego debes esperar a que termine el paquete activo para comprar otro");
            }
            opcion= teclado.nextInt();
            System.out.println("Ha elegido comprar" +  productos.get(opcion).getPackageName());
            System.out.println("Gracias por tu compra, te notificaremos cuando se termine tu paquete");
            respuesta = teclado.next();
        }while(respuesta.equalsIgnoreCase("si"));
        System.out.println("El total de su compra es:" + productos.get(opcion).getPrice());
    }
    
}
