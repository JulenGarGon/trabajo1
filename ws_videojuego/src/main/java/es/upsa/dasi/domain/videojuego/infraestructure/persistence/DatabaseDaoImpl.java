package es.upsa.dasi.domain.videojuego.infraestructure.persistence;

import es.upsa.dasi.domain.videojuego.adapters.output.daos.DatabaseDao;
import es.upsa.dasi.trabajo1.domain.entities.Videojuego;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
import es.upsa.dasi.trabajo1.domain.exceptions.ConstraintViolationException;
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
                                            .withEstreno(rs.getDate(4).toLocalDate())
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
                            .withEstreno(rs.getDate(4).toLocalDate())
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
    public Optional findVideojuegoById(int id) throws AppException {
        final String SQL =  """
                            SELECT v.id, v.nombre, v.genero, v.estreno, v.portada, v.duracion, v.tamanio, v.ventas, v.desarrollador, v.nota
                                FROM videojuego v
                            WHERE v.id = ?
                            """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL)
            ){
            preparedStatement.setInt(1, id);

            try (ResultSet rs = preparedStatement.executeQuery()){
                if (!rs.next()) return Optional.empty();
                return Optional.of( Videojuego.builder()
                                .withId(rs.getInt(1))
                                .withNombre(rs.getString(2))
                                .withGenero(rs.getString(3))
                                .withEstreno(rs.getDate(4).toLocalDate())
                                .withPortada(rs.getString(5))
                                .withDuracion(rs.getFloat(6))
                                .withTamanio(rs.getFloat(7))
                                .withVentas(rs.getInt(8))
                                .withDesarrollador(rs.getInt(9))
                                .withNota(rs.getInt(10))
                                .build()
                        );
            }

        } catch (SQLException sqlException) {
            throw managerSqlExceptions(sqlException);
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

    @Override
    public Videojuego save(Videojuego videojuego) throws AppException {
        final String SQL =  """
                INSERT INTO VIDEOJUEGO (ID, NOMBRE, GENERO, ESTRENO, PORTADA, DURACION, TAMANIO, VENTAS, DESARROLLADOR, NOTA)
                VALUES (nextval('seq_juegos'), ?, ?, ?, ?, ? ,?, ?, ? ,?)
                            """;

        String[] columns = {"id"};
        try (Connection connection = dataSource.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SQL, columns)){

            preparedStatement.setString(1,videojuego.nombre());
            preparedStatement.setString(2,videojuego.genero());
            preparedStatement.setDate(3, (videojuego.estreno()!=null)? Date.valueOf(videojuego.estreno()) : null);
            preparedStatement.setString(4,videojuego.portada());
            preparedStatement.setFloat(5,videojuego.duracion());
            preparedStatement.setFloat(6,videojuego.tamanio());
            preparedStatement.setInt(7,videojuego.ventas());
            preparedStatement.setInt(8,videojuego.desarrollador());
            preparedStatement.setFloat(9,videojuego.nota());

            preparedStatement.executeUpdate();

            try (ResultSet gk = preparedStatement.getGeneratedKeys()){
                gk.next();
                return videojuego.withId(gk.getInt(1));
            }

        } catch (SQLException sqlException){
            throw managerSqlExceptions(sqlException);
        }

    }

    @Override
    public Videojuego updateVideojuego(Videojuego videojuego) throws AppException {
        final String SQL =  """
                            UPDATE videojuego
                                SET nombre = ?,
                                    genero = ?,
                                    estreno = ?,
                                    portada = ?,
                                    duracion = ?,
                                    tamanio = ?,
                                    ventas = ?,
                                    desarrollador = ?,
                                    nota = ?
                            WHERE id = ?
                            """;

        try (Connection connection = dataSource.getConnection();
        PreparedStatement ps = connection.prepareStatement(SQL)){
            ps.setString(1, videojuego.nombre());
            ps.setString(2, videojuego.genero());
            ps.setDate(3, Date.valueOf(videojuego.estreno()));
            ps.setString(4, videojuego.portada());
            ps.setFloat(5, videojuego.duracion());
            ps.setFloat(6, videojuego.tamanio());
            ps.setInt(7, videojuego.ventas());
            ps.setInt(8, videojuego.desarrollador());
            ps.setFloat(9, videojuego.nota());
            ps.setInt(10, videojuego.id());

            int count = ps.executeUpdate();
            if (count == 0) throw new EntityNotFoundException("No existe el videojuego con el identificador "+ videojuego.id());
            return videojuego;
            
        } catch (SQLException sqlException){
            throw managerSqlExceptions(sqlException);
        }
    }


    private AppException managerSqlExceptions(SQLException sqlException) {

        String message = sqlException.getMessage();

        if (message.contains("NN_VIDEOJUEGO.NOMBRE")) return new ConstraintViolationException("El videojuego debe tener un nombre.");
        else if (message.contains("NN_VIDEOJUEGO.GENERO")) return new ConstraintViolationException("El videojuego debe tener un genero.");
        else if (message.contains("NN_VIDEOJUEGO.ESTRENO")) return new ConstraintViolationException("El videojuego debe tener una fecha de estreno.");
        else if (message.contains("NN_VIDEOJUEGO.PORTADA")) return new ConstraintViolationException("El videojuego debe tener una foto de portada.");
        else if (message.contains("NN_VIDEOJUEGO.DURACION")) return new ConstraintViolationException("El videojuego debe tener alguna duración.");
        else if (message.contains("NN_VIDEOJUEGO.TAMANIO")) return new ConstraintViolationException("El videojuego debe tener un tamaño.");
        else if (message.contains("NN_VIDEOJUEGO.VENTAS")) return new ConstraintViolationException("El videojuego debe tener un número de ventas.");
        else if (message.contains("NN_VIDEOJUEGO.DESARROLLADOR")) return new ConstraintViolationException("El videojuego debe tener un desarrollador.");
        else if (message.contains("NN_VIDEOJUEGO.NOTA")) return new ConstraintViolationException("El videojuego debe tener una nota.");
        else if (message.contains("CH_VIDEOJUEGO.NOTA")) return new ConstraintViolationException("El videojuego debe tener una nota comprendida entre 0 y 10.");


        return new NonControledSQLException(sqlException);
    }
}
