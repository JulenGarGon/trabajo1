package es.upsa.dasi.domain.desarrollador.infraestructure.persistence;

import es.upsa.dasi.domain.desarrollador.adapters.output.daos.DatabaseDao;
import es.upsa.dasi.trabajo1.domain.entities.Desarrollador;
import es.upsa.dasi.trabajo1.domain.exceptions.AppException;
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
                                                .withFundacion(rs.getDate(3))
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
                                                .withFundacion(rs.getDate(3))
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
                                                .withFundacion(rs.getDate(3))
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

    private AppException managerSqlExceptions(SQLException sqlException) {
        return new NonControledSQLException(sqlException);
    }
}
