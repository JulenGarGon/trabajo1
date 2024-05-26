package es.upsa.dasi.domain.desarrollador.adapters.input.rest;

import es.upsa.dasi.domain.desarrollador.adapters.input.rest.dtos.DesarrolladorDto;
import es.upsa.dasi.domain.desarrollador.application.*;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;

import java.net.URI;

@Path("/desarrollador")
public class DesarrolladorResource {

    @Context
    UriInfo uriInfo;

    @Inject
    FindAllDesarrolladoresUseCase findAllDesarrolladoresUseCase;

    @Inject
    FindDesarrolladorByIdUseCase findDesarrolladorByIdUseCase;

    @Inject
    FindDesarrolladorByNombreUseCase findDesarrolladorByNombreUseCase;

    @Inject
    InsertDesarrolladorUseCase insertDesarrolladorUseCase;

    @Inject
    DeleteDesarrolladorByIdUseCase deleteDesarrolladorByIdUseCase;

    @Inject
    UpdateDesarrolladorByIdUseCase updateDesarrolladorByIdUseCase;

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response findAllDesarrolladores() throws AppException {


        return Response.ok()
                .entity(findAllDesarrolladoresUseCase.execute())
                .build();
    }

    @Path("/{id}")
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
    @Path("/n{nombre}")
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response insertDesarrollador(DesarrolladorDto desarrolladorDto) throws AppException{
        Desarrollador desarrollador = Desarrollador.builder()
                                                    .withId(desarrolladorDto.getId())
                                                    .withNombre(desarrolladorDto.getNombre())
                                                    .withFundacion(desarrolladorDto.getFundacion())
                                                    .withFundador(desarrolladorDto.getFundador())
                                                    .withEmpleados(desarrolladorDto.getEmpleados())
                                                    .withSede(desarrolladorDto.getSede())
                                                    .withSitioWeb(desarrolladorDto.getSitioWeb())
                                                    .withLogo(desarrolladorDto.getLogo())
                                                    .build();

        Desarrollador newDesarrollador = insertDesarrolladorUseCase.saveDesarrollador(desarrollador);
        URI newDesarrolladorURI = uriInfo.getAbsolutePathBuilder()
                                        .path("{id}")
                                        .resolveTemplate("id", newDesarrollador.id())
                                        .build();

        return Response.created(newDesarrolladorURI)
                                .entity(newDesarrollador)
                                .build();
    }

    @Path("{id}")
    @DELETE
    public Response deleteDesarrolladorById(@PathParam("id")int id) throws AppException{
        deleteDesarrolladorByIdUseCase.execute(id);
        return Response.noContent().build();
    }


    @Path("{id}")
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateDesarrollador(@PathParam("id")int id, DesarrolladorDto desarrolladorDto) throws AppException{
        Desarrollador desarrollador = Desarrollador.builder()
                .withId(id)
                .withNombre(desarrolladorDto.getNombre())
                .withFundacion(desarrolladorDto.getFundacion())
                .withFundador(desarrolladorDto.getFundador())
                .withEmpleados(desarrolladorDto.getEmpleados())
                .withSede(desarrolladorDto.getSede())
                .withSitioWeb(desarrolladorDto.getSitioWeb())
                .withLogo(desarrolladorDto.getLogo())
                .build();
        Desarrollador updatedDesarrollador = updateDesarrolladorByIdUseCase.execute(desarrollador);

        return Response.ok()
                .entity(updatedDesarrollador)
                .build();
    }
}