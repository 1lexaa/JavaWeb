package step.learning.services.db;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.inject.Inject;
import com.google.inject.Singleton;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.sql.Connection;
import java.util.Objects;

@Singleton
public class PlanetDbProvider implements DbProvider
{
   private final Connection connection;

@Inject
    public PlanetDbProvider(Connection connection) {
        this.connection = connection;
    }


    @Override
    public Connection getConnection()
    {
        if(connection == null)

        {
            JsonObject dbConfig;
            try (
         Reader reader = new InputStreamReader(
                 Objects.requireNonNull(
                         this.getClass().getClassLoader()
                                 .getResourceAsStream("db_config.json")))
            )
            {
                dbConfig = JsonParser.parseReader(reader).getAsJsonObject();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            catch (NullPointerException ex) {
                throw new RuntimeException("res not found");
            }
        }
        return connection;
    }
}