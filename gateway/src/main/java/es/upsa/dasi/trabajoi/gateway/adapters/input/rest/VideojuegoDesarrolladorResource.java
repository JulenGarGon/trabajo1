package es.upsa.dasi.trabajoi.gateway.adapters.input.rest;


import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajoi.gateway.application.usecases.videojuegos.FindVideojuegosByIdDesarrolladorUseCase;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/videojuegos")
public class VideojuegoDesarrolladorResource {

    @Inject
    FindVideojuegosByIdDesarrolladorUseCase findVideojuegosByIdDesarrolladorUseCase;

    @Path("/{idDesarrollador}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findVideojuegosByIdDesarrollador(@PathParam("idDesarrollador")int id) throws AppException {
        return Response.ok()
                .entity(findVideojuegosByIdDesarrolladorUseCase.execute(id))
                .build();
    }
}
