package es.upsa.dasi.trabajoi.gateway.infraestructure.ws;

import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajoi.gateway.adapters.output.daos.VideojuegosDao;
import es.upsa.dasi.trabajoi.gateway.application.dtos.ErrorDto;
import es.upsa.dasi.trabajoi.gateway.infraestructure.ws.utils.ResourceUris;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;

@ApplicationScoped
public class VideojuegoDaoImpl implements VideojuegosDao {
    @Override
    public List<Videojuego> findAllVideojuegos() throws AppException {
        try (Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_VIDEOJUEGOS)
                    .path("/videojuego")
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            switch (response.getStatusInfo())
            {
                //Se hace la petición y se comprueba si ha devuelto OK
                case Response.Status.OK:
                    List<Videojuego> data = response.readEntity( new GenericType<List<Videojuego>>() {});
                    return data;
                //Se ha devuelto un error 500
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException {
        try (Client client = ClientBuilder.newClient()){

            Response response = client.target(ResourceUris.URI_VIDEOJUEGOS)
                    .path("/videojuegos/{id}")
                    .resolveTemplate("id", id)
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            switch (response.getStatusInfo()){
                case Response.Status.OK:
                    List<Videojuego> data = response.readEntity( new GenericType<List<Videojuego>>(){});
                    return data;
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public void deleteVideojuegoById(int id) throws AppException {

    }

    @Override
    public Videojuego save(Videojuego videojuego) throws AppException {
        return null;
    }
}
