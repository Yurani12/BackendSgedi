/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Cities;
import co.edu.sena.adsi.jpa.sessions.CitiesFacade;
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
@Path("cities")
@Consumes (MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class CitiesREST {
    @EJB
    private CitiesFacade citiesEJB;
    
    
    
    @GET
    public List<Cities> findAll(){
        return citiesEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Cities findBye(
    @PathParam("nombre")String nombre){
        return citiesEJB.find(nombre);
    }
    @POST
    public void create(Cities cities){
        citiesEJB.create(cities);
    }
    @GET
    @Path("find")
    public List<Cities> findByNombre(
            @QueryParam("nombre") String nombreCiudad,
            @QueryParam("idDepartamento") Integer idDepartament) {
        return citiesEJB.findCiudadByNombre(nombreCiudad, idDepartament);
    }
}
