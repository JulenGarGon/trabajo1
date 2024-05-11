package es.upsa.dasi.domain.desarrollador.adapters.input.rest;

import es.upsa.dasi.domain.desarrollador.application.FindAllDesarrolladoresUseCase;
import es.upsa.dasi.domain.desarrollador.application.FindDesarrolladorByIdUseCase;
import es.upsa.dasi.domain.desarrollador.application.FindDesarrolladorByNombreUseCase;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/desarrollador")
public class DesarrolladorResource {

    @Inject
    FindAllDesarrolladoresUseCase findAllDesarrolladoresUseCase;

    @Inject
    FindDesarrolladorByIdUseCase findDesarrolladorByIdUseCase;

    @Inject
    FindDesarrolladorByNombreUseCase findDesarrolladorByNombreUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllDesarrolladores() throws AppException {


        return Response.ok()
                .entity(findAllDesarrolladoresUseCase.execute())
                .build();
    }

    @Path("/id/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDesarrolladorById(@PathParam("id") int id) throws AppException{

        return findDesarrolladorByIdUseCase.execute(id)
                .map( desarrollador ->  Response.ok()
                                                .entity(desarrollador)
                                                .build()
                     )
                .orElse( Response.status(Response.Status.NOT_FOUND).build()
                );
    }

    //Así no hay posibildad de que confunda id con nombre
    @Path("/nombre/{nombre}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findDesarrolladorByNombre(@PathParam("nombre") String nombre) throws AppException{

        return findDesarrolladorByNombreUseCase.execute(nombre)
                .map( desarrollador -> Response.ok()
                                                .entity(desarrollador)
                                                .build()
                    )
                .orElse( Response.status(Response.Status.NOT_FOUND).build()
                );
    }
}