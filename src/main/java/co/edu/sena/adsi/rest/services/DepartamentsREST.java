/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Departaments;
import co.edu.sena.adsi.jpa.sessions.DepartamentsFacade;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author adsi1261718
 */
@Path("departaments")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DepartamentsREST {
     @EJB
    private DepartamentsFacade departamentsEJB;
    
    @GET
    public List<Departaments> findAll(){
        return departamentsEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Departaments findBye(
    @PathParam("nombre")String nombre){
        return departamentsEJB.find(nombre);
    }
    @POST
    public void create(Departaments departaments){
        departamentsEJB.create(departaments);
    }
    @GET
    @Path("find")
    public List<Departaments> findByNombre(
            @QueryParam("nombre") String nombreCiudad,
            @QueryParam("idCountry") Integer idCountry) {
        return departamentsEJB.findDepartamentByNombre(nombreCiudad, idCountry);
    }
}
