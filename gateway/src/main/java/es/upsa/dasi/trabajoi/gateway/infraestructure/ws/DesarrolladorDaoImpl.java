package es.upsa.dasi.trabajoi.gateway.infraestructure.ws;

import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajo1.domain.exceptions.EntityNotFoundException;
import es.upsa.dasi.trabajoi.gateway.adapters.output.daos.DesarrolladorDao;
import es.upsa.dasi.trabajoi.gateway.application.dtos.DesarrolladorDto;
import es.upsa.dasi.trabajoi.gateway.application.dtos.ErrorDto;
import es.upsa.dasi.trabajoi.gateway.application.mappers.Mappers;
import es.upsa.dasi.trabajoi.gateway.infraestructure.ws.utils.ResourceUris;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.ClientBuilder;
import jakarta.ws.rs.client.Entity;
import jakarta.ws.rs.core.GenericType;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DesarrolladorDaoImpl implements DesarrolladorDao {

    @Inject
    Mappers mappers;

    @Override
    public List<Desarrollador> findAllDesarrolladores() throws AppException {
        try (Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_DESARROLLADORES)
                    .path("/desarrollador")
                    .request(MediaType.APPLICATION_JSON)
                    .get();

            switch (response.getStatusInfo())
            {
                case Response.Status.OK:
                    List<Desarrollador> data = response.readEntity(new GenericType<List<Desarrollador>>() {});
                    return data;
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public Optional<Desarrollador> findDesarrolladorById(int id) throws AppException {
        try(Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_DESARROLLADORES)
                    .path("/desarrollador/{id}")
                    .resolveTemplate("id", id)
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            switch (response.getStatusInfo()){
                case Response.Status.OK:
                    Desarrollador data = response.readEntity(Desarrollador.class);
                    return Optional.of(data);
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public Optional<Desarrollador> findDesarrolladorByNombre(String nombre) throws AppException {
        try(Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_DESARROLLADORES)
                    .path("/desarrollador/n{nombre}")
                    .resolveTemplate("nombre", nombre)
                    .request(MediaType.APPLICATION_JSON)
                    .get();
            switch (response.getStatusInfo()){
                case Response.Status.OK:
                    Desarrollador data = response.readEntity(Desarrollador.class);
                    return Optional.of(data);
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public Desarrollador saveDesarrollador(Desarrollador desarrollador) throws AppException {
        DesarrolladorDto desarrolladorDto = mappers.mapToDesarrolladorDto.apply(desarrollador);
        try (Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_DESARROLLADORES)
                    .path("/desarrollador")
                    .request(MediaType.APPLICATION_JSON)
                    .post(Entity.json(desarrolladorDto));

            switch (response.getStatusInfo()){
                case Response.Status.CREATED:
                    Desarrollador data = response.readEntity(Desarrollador.class);
                    String location = response.getHeaderString(HttpHeaders.LOCATION);
                    return data;
                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }

    @Override
    public void deleteDesarrolladorById(int id) throws AppException {
        try (Client client = ClientBuilder.newClient()){
            Response response = client.target(ResourceUris.URI_DESARROLLADORES)
                    .path("/desarrollador/{id}")
                    .resolveTemplate("id", id)
                    .request(MediaType.APPLICATION_JSON)
                    .delete();

            switch (response.getStatusInfo()){
                case Response.Status.NO_CONTENT: return;

                case Response.Status.NOT_FOUND:
                    ErrorDto errorNotFound = response.readEntity(ErrorDto.class);
                    throw new EntityNotFoundException(errorNotFound.getMessage());

                default:
                    ErrorDto error = response.readEntity(ErrorDto.class);
                    throw new AppException(error.getMessage());
            }
        }
    }
}
