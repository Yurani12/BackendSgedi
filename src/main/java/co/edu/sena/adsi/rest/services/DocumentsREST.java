/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.sessions.DocumentsFacade;
import java.util.List;
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
@Path("documents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class DocumentsREST {
     @EJB
    private DocumentsFacade documentsEJB;
    
    @GET
    public List<Documents> findAll(){
        return documentsEJB.findAll();
    }
    @GET
    @Path("{id}")
    public Documents findBye(
    @PathParam("nombre")String nombre){
        return documentsEJB.find(nombre);
    }
    @POST
    public void create(Documents documents){
        documentsEJB.create(documents);
    }
}
