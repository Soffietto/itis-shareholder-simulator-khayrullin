package ru.kpfu.itis.shareholdersimulator.config;

import com.opentable.db.postgres.embedded.EmbeddedPostgreSQL;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;
import java.io.IOException;

@Configuration
@Profile("test")
public class EmbeddedPostgresConfig {

    @Bean
    public DataSource dataSource() throws IOException {
        return EmbeddedPostgreSQL.start().getPostgresDatabase();
    }
}
