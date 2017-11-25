/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.sena.adsi.rest.services;

import co.edu.sena.adsi.jpa.entities.Documents;
import co.edu.sena.adsi.jpa.sessions.DocumentsFacade;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.util.List;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 *
 * @author adsi1261718
 */
@Path("documents")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)

public class DocumentsREST {
    private static final String UPLOAD_FOLDER_D = "/home/adsi1261718/Documentos/SPRINT 8/FRONTEND SGEDI/client/assets/documentos/";
    
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
    @Path("documentsUpload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadDocumentFile(
            @FormDataParam("file") InputStream in,
            @FormDataParam("file") FormDataContentDisposition info,
            @FormDataParam("idUsuario") Integer idDocuments) throws IOException {
        
        System.out.println("ID "+idDocuments);
        File upload = new File(UPLOAD_FOLDER_D.concat(info.getFileName()));
        Documents document = documentsEJB.find(1);

        try {
            if (upload.exists()) {
                String message = "file: " + upload.getName() + " already exists";
                return Response.status(Response.Status.CONFLICT).entity(message).build();
            } else {
                
                Files.copy(in, upload.toPath());
                Documents documents = documentsEJB.find(idDocuments);
                document.setFile(upload.getName());
                documentsEJB.edit(document); 
                return Response.status(Response.Status.OK).build();
            }
        } catch (IOException e) {
            return Response.status(Response.Status.CONFLICT).entity(e).build();
        }

}
}
