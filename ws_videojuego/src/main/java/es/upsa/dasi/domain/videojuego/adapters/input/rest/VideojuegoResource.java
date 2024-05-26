package es.upsa.dasi.domain.videojuego.adapters.input.rest;

import es.upsa.dasi.domain.videojuego.adapters.input.rest.dtos.VideojuegoDto;
import es.upsa.dasi.domain.videojuego.application.*;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

@Path("/videojuego")
public class VideojuegoResource {

    @Context
    UriInfo uriInfo;

    @Inject
    FindAllVideojuegosUseCase findAllVideojuegosUseCase;

    @Inject
    FindVideojuegoByIdUseCase findVideojuegoByIdUseCase;

    @Inject
    DeleteVideojuegoByIdUseCase deleteVideojuegoByIdUseCase;

    @Inject
    InsertVideojuegoUseCase insertVideojuegoUseCase;

    @Inject
    UpdateVideojuegosByIdUseCase updateVideojuegosByIdUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllVideojuegos() throws AppException{
        return  Response.ok()
                .entity(findAllVideojuegosUseCase.execute())
                .build();
    }

    @Path("{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findVideojuegoById(@PathParam("id")int id) throws AppException{
        return Response.ok()
                .entity(findVideojuegoByIdUseCase.execute(id))
                .build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteVideojuegoById(@PathParam("id")int id) throws AppException{
        deleteVideojuegoByIdUseCase.execute(id);
        return Response.noContent().build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addVideojuego(VideojuegoDto videojuegoDto) throws AppException{
        Videojuego videojuego = Videojuego.builder()
                                            .withId(videojuegoDto.getId())
                                            .withNombre(videojuegoDto.getNombre())
                                            .withGenero(videojuegoDto.getGenero())
                                            .withEstreno(videojuegoDto.getEstreno())
                                            .withPortada(videojuegoDto.getPortada())
                                            .withDuracion(videojuegoDto.getDuracion())
                                            .withTamanio(videojuegoDto.getTamanio())
                                            .withVentas(videojuegoDto.getVentas())
                                            .withDesarrollador(videojuegoDto.getDesarrollador())
                                            .withNota(videojuegoDto.getNota())
                                            .build();

        Videojuego newVideojuego = insertVideojuegoUseCase.execute(videojuego);
        URI newVideojuegoURI = uriInfo.getAbsolutePathBuilder()
                .path("{id}")
                .resolveTemplate("id", newVideojuego.id())
                .build();

        return Response.created(newVideojuegoURI)
                .entity(newVideojuego)
                .build();
    }


    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateVideojuego(@PathParam("id")int id, VideojuegoDto videojuegoDto) throws AppException{
        Videojuego videojuego = Videojuego.builder()
                                            .withId(id)
                                            .withNombre(videojuegoDto.getNombre())
                                            .withGenero(videojuegoDto.getGenero())
                                            .withEstreno(videojuegoDto.getEstreno())
                                            .withPortada(videojuegoDto.getPortada())
                                            .withDuracion(videojuegoDto.getDuracion())
                                            .withTamanio(videojuegoDto.getTamanio())
                                            .withVentas(videojuegoDto.getVentas())
                                            .withDesarrollador(videojuegoDto.getDesarrollador())
                                            .withNota(videojuegoDto.getNota())
                                            .build();
        Videojuego updatedVideojuego = updateVideojuegosByIdUseCase.execute(videojuego);

        return Response.ok()
                .entity(updatedVideojuego)
                .build();
    }
}
