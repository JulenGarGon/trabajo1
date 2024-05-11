package es.upsa.dasi.domain.desarrollador.adapters.input.rest;

import es.upsa.dasi.domain.desarrollador.application.FindAllDesarrolladoresUseCase;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/desarrollador")
public class DesarrolladorResource {

    @Inject
    FindAllDesarrolladoresUseCase findAllDesarrolladoresUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllDesarrolladores() throws AppException {


        return Response.ok()
                .entity(findAllDesarrolladoresUseCase.execute())
                .build();
    }
}