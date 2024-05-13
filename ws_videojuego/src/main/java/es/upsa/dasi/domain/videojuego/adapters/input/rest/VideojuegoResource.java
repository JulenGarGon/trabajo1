package es.upsa.dasi.domain.videojuego.adapters.input.rest;

import es.upsa.dasi.domain.videojuego.application.DeleteVideojuegoById;
import es.upsa.dasi.domain.videojuego.application.FindAllVideojuegosUseCase;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/videojuego")
public class VideojuegoResource {

    @Inject
    FindAllVideojuegosUseCase findAllVideojuegosUseCase;

    @Inject
    DeleteVideojuegoById deleteVideojuegoById;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllVideojuegos() throws AppException{
        return  Response.ok()
                .entity(findAllVideojuegosUseCase.execute())
                .build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteVideojuegoById(@PathParam("id")int id) throws AppException{
        deleteVideojuegoById.execute(id);
        return Response.noContent().build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVideojuego(Videojuego videojuego) throws AppException{

        return Response.accepted().build();
    }
}
