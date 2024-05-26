package es.upsa.dasi.domain.desarrollador.infraestructure.persistence;

import es.upsa.dasi.domain.desarrollador.adapters.output.daos.DatabaseDao;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
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
    public List<Desarrollador> findAllDesarrolladores() throws AppException {
        List<Desarrollador> desarrolladores = new ArrayList<>();
        final String SQL =  """
                            SELECT d.id, d.nombre, d.fundacion, d.fundador, d.sitioweb, d.empleados, d.sede, d.sitioweb, d.logo
                                FROM desarrollador d
                            """;
        try (   Connection connection = dataSource.getConnection();
                Statement statement = connection.createStatement();
                ResultSet rs = statement.executeQuery(SQL)
             )
        {
            while (rs.next()){
                desarrolladores.add(Desarrollador.builder()
                                                .withId(rs.getInt(1))
                                                .withNombre(rs.getString(2))
                                                .withFundacion(rs.getDate(3).toLocalDate())
                                                .withFundador(rs.getString(4))
                                                .withSitioWeb(rs.getString(5))
                                                .withEmpleados(rs.getInt(6))
                                                .withSede(rs.getString(7))
                                                .withSitioWeb(rs.getString(8))
                                                .withLogo(rs.getString(9))
                                                .build()
                                    );
            }
        } catch (SQLException sqlException){
            throw managerSqlExceptions(sqlException);
        }

        return desarrolladores;
    }

    @Override
    public Optional<Desarrollador> findDesarrolladorById(int id) throws AppException {
        final String SQL =  """
                            SELECT d.id, d.nombre, d.fundacion, d.fundador, d.sitioweb, d.empleados, d.sede, d.sitioweb, d.logo
                                FROM desarrollador d
                            WHERE d.id = ?
                            """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
            )
        {
            preparedStatement.setInt(1, id);
            try (ResultSet rs = preparedStatement.executeQuery()){
                if (!rs.next()) return Optional.empty();
                return Optional.of(Desarrollador.builder()
                                                .withId(rs.getInt(1))
                                                .withNombre(rs.getString(2))
                                                .withFundacion(rs.getDate(3).toLocalDate())
                                                .withFundador(rs.getString(4))
                                                .withSitioWeb(rs.getString(5))
                                                .withEmpleados(rs.getInt(6))
                                                .withSede(rs.getString(7))
                                                .withSitioWeb(rs.getString(8))
                                                .withLogo(rs.getString(9))
                                                .build()
                                    );
            }

        } catch (SQLException sqlException){
            throw managerSqlExceptions(sqlException);
        }
    }

    @Override
    public Optional<Desarrollador> findDesarrolladorByNombre(String nombre) throws AppException {
        final String SQL =  """
                            SELECT d.id, d.nombre, d.fundacion, d.fundador, d.sitioweb, d.empleados, d.sede, d.sitioweb, d.logo
                                FROM desarrollador d
                            WHERE d.nombre = ?
                            """;

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SQL);
        )
        {
            preparedStatement.setString(1, nombre);
            try (ResultSet rs = preparedStatement.executeQuery()){
                if (!rs.next()) return Optional.empty();
                return Optional.of(Desarrollador.builder()
                                                .withId(rs.getInt(1))
                                                .withNombre(rs.getString(2))
                                                .withFundacion(rs.getDate(3).toLocalDate())
                                                .withFundador(rs.getString(4))
                                                .withSitioWeb(rs.getString(5))
                                                .withEmpleados(rs.getInt(6))
                                                .withSede(rs.getString(7))
                                                .withSitioWeb(rs.getString(8))
                                                .withLogo(rs.getString(9))
                                                .build()
                                );
            }

        } catch (SQLException sqlException){
            throw managerSqlExceptions(sqlException);
        }
    }

    @Override
    public Desarrollador insertDesarrollador(Desarrollador desarrollador) throws AppException {
        final String SQL =  """
                            INSERT INTO DESARROLLADOR (ID, NOMBRE, FUNDACION, FUNDADOR, EMPLEADOS, SEDE, SITIOWEB, LOGO)
                            VALUES (nextval('seq_desarrollador'), ?, ?,         ?,      ?,          ?,      ?,      ?);
                            """;
        String[] columns = {"id"};
        try(Connection connection = dataSource.getConnection();
           PreparedStatement ps = connection.prepareStatement(SQL, columns)){

            ps.setString(1, desarrollador.nombre());
            ps.setDate(2, Date.valueOf(desarrollador.fundacion()));
            ps.setString(3, desarrollador.fundador());
            ps.setInt(4, desarrollador.empleados());
            ps.setString(5, desarrollador.sede());
            ps.setString(6, desarrollador.sitioWeb());
            ps.setString(7, desarrollador.logo());

            ps.executeUpdate();

            try (ResultSet gk = ps.getGeneratedKeys()){
                gk.next();
                return desarrollador.withId(gk.getInt(1));
            }

        }catch (SQLException sqlException){
            throw managerSqlExceptions(sqlException);
        }
    }

    @Override
    public void deleteDesarrolladorById(int id) throws AppException {
        final String SQL =  """
                            DELETE
                                FROM desarrollador
                            WHERE id = ?
                            """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL))
        {
            ps.setInt(1, id);
            int count = ps.executeUpdate();
            if (count == 0) throw new EntityNotFoundException("No existe un desarrollador con identificador " +id);
        } catch (SQLException sqlException){
            throw managerSqlExceptions(sqlException);
        }
    }

    @Override
    public Desarrollador updateDesarrollador(Desarrollador desarrollador) throws AppException {
        final String SQL =  """
                            UPDATE desarrollador
                                SET nombre = ?,
                                fundacion = ?,
                                fundador = ?,
                                empleados = ?,
                                sede = ?,
                                sitioWeb = ?,
                                logo = ?
                            WHERE id = ?
                            """;

        try(Connection connection = dataSource.getConnection();
            PreparedStatement ps = connection.prepareStatement(SQL))
        {
            ps.setString(1, desarrollador.nombre());
            ps.setDate(2, Date.valueOf(desarrollador.fundacion()));
            ps.setString(3, desarrollador.fundador());
            ps.setInt(4, desarrollador.empleados());
            ps.setString(5, desarrollador.sede());
            ps.setString(6, desarrollador.sitioWeb());
            ps.setString(7, desarrollador.logo());
            ps.setInt(8, desarrollador.id());

            int count = ps.executeUpdate();

            if (count == 0) throw new EntityNotFoundException("No existe el desarrollador con el identificador " + desarrollador.id());
            return desarrollador;
        } catch (SQLException sqlException){
            throw managerSqlExceptions(sqlException);
        }
    }

    private AppException managerSqlExceptions(SQLException sqlException) {
        String message = sqlException.getMessage();

        if (message.contains("NN_DESARROLLADOR.NOMBRE")) return new ConstraintViolationException("El desarrollador debe tener un nombre.");
        else if (message.contains("NN_DESARROLLADOR.FUNDACION")) return new ConstraintViolationException("El desarrollador debe tener una fecha de fundación.");
        else if (message.contains("NN_DESARROLLADOR.FUNDADOR")) return new ConstraintViolationException("El desarrollador debe tener un fundador.");
        else if (message.contains("NN_DESARROLLADOR.EMPLEADOS")) return new ConstraintViolationException("El desarrollador debe tener empleados.");
        else if (message.contains("NN_DESARROLLADOR.SEDE")) return new ConstraintViolationException("El desarrollador debe tener una sede.");
        else if (message.contains("NN_DESARROLLADOR.SITIOWEB")) return new ConstraintViolationException("El desarrollador debe tener un sitioweb.");
        else if (message.contains("NN_DESARROLLADOR.LOGO")) return new ConstraintViolationException("El desarrollador debe tener un logo.");

        return new NonControledSQLException(sqlException);
    }
}
