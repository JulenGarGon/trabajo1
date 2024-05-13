package es.upsa.dasi.domain.videojuego.infraestructure.persistence;

import es.upsa.dasi.domain.videojuego.adapters.output.daos.DatabaseDao;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajo1.domain.exceptions.EntityNotFoundException;
import es.upsa.dasi.trabajo1.domain.exceptions.NonControledSQLException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class DatabaseDaoImpl implements DatabaseDao {

    @Inject
    DataSource dataSource;

    @Override
    public List<Videojuego> findAllVideojuegos() throws AppException {
        List<Videojuego> videojuegos = new ArrayList<>();
        final String SQL =  """
                            SELECT v.id, v.nombre, v.genero, v.estreno, v.portada, v.duracion, v.tamanio, v.ventas, v.desarrollador, v.nota
                                FROM videojuego v
                            """;

        try (Connection connection = dataSource.getConnection();
             Statement statement = connection.createStatement();
             ResultSet rs = statement.executeQuery(SQL))
        {
            while (rs.next()){
                videojuegos.add(Videojuego.builder()
                                            .withId(rs.getInt(1))
                                            .withNombre(rs.getString(2))
                                            .withGenero(rs.getString(3))
                                            .withEstreno(rs.getDate(4))
                                            .withPortada(rs.getString(5))
                                            .withDuracion(rs.getFloat(6))
                                            .withTamanio(rs.getFloat(7))
                                            .withVentas(rs.getInt(8))
                                            .withDesarrollador(rs.getInt(9))
                                            .withNota(rs.getInt(10))
                                            .build());
            }
        } catch (SQLException sqlException){
            throw managerSqlExceptions(sqlException);
        }

        return videojuegos;
    }

    @Override
    public List<Videojuego> findVideojuegosByIdDesarrollador(int id) throws AppException {
        List<Videojuego> videojuegos = new ArrayList<>();
        final String SQL = """
                           SELECT v.id, v.nombre, v.genero, v.estreno, v.portada, v.duracion, v.tamanio, v.ventas, v.desarrollador, v.nota
                            FROM videojuego v
                           WHERE v.desarrollador = ?
                           """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL))
        {
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()){

                while (rs.next()){
                    videojuegos.add(Videojuego.builder()
                            .withId(rs.getInt(1))
                            .withNombre(rs.getString(2))
                            .withGenero(rs.getString(3))
                            .withEstreno(rs.getDate(4))
                            .withPortada(rs.getString(5))
                            .withDuracion(rs.getFloat(6))
                            .withTamanio(rs.getFloat(7))
                            .withVentas(rs.getInt(8))
                            .withDesarrollador(rs.getInt(9))
                            .withNota(rs.getInt(10))
                            .build());
                }

            }
            return videojuegos;
        } catch (SQLException sqlException){
            throw  managerSqlExceptions(sqlException);
        }

    }

    @Override
    public void deleteVideojuegoById(int id) throws AppException {
        final String SQL =  """
                            DELETE
                                FROM videojuego
                            WHERE id = ?
                            """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL))
        {
            preparedStatement.setInt(1, id);
            int count = preparedStatement.executeUpdate();
            if (count == 0) throw new EntityNotFoundException("No existe el videojuego con identificador " +id);
        } catch (SQLException sqlException){
            throw managerSqlExceptions(sqlException);
        }
    }

    private AppException managerSqlExceptions(SQLException sqlException) {
        return new NonControledSQLException(sqlException);
    }
}
