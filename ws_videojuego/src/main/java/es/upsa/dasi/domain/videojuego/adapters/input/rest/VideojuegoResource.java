package es.upsa.dasi.domain.videojuego.adapters.input.rest;

import es.upsa.dasi.domain.videojuego.application.FindAllVideojuegosUseCase;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/videojuego")
public class VideojuegoResource {

    @Inject
    FindAllVideojuegosUseCase findAllVideojuegosUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllVideojuegos() throws AppException{
        return  Response.ok()
                .entity(findAllVideojuegosUseCase.execute())
                .build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteVideojuegoById(@PathParam("id")int id){
        //Llamada al execute(id)
        return Response.noContent().build();
    }
}
