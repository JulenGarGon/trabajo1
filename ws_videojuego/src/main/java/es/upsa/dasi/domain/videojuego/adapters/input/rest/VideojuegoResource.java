package es.upsa.dasi.domain.videojuego.adapters.input.rest;

import es.upsa.dasi.domain.videojuego.application.FindAllVideojuegosUseCase;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
}
