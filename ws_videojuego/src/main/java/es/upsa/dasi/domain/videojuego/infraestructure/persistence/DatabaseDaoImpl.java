package es.upsa.dasi.domain.videojuego.infraestructure.persistence;

import es.upsa.dasi.domain.videojuego.adapters.output.daos.DatabaseDao;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajo1.domain.exceptions.NonControledSQLException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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

    private AppException managerSqlExceptions(SQLException sqlException) {
        return new NonControledSQLException(sqlException);
    }
}