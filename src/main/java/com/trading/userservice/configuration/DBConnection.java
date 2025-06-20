package com.trading.userservice.configuration;

import io.r2dbc.spi.ConnectionFactories;
import io.r2dbc.spi.ConnectionFactory;
import io.r2dbc.spi.ConnectionFactoryOptions;
import io.r2dbc.spi.Option;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.r2dbc.connection.R2dbcTransactionManager;
import org.springframework.transaction.ReactiveTransactionManager;
import org.springframework.transaction.reactive.TransactionalOperator;

import static io.r2dbc.spi.ConnectionFactoryOptions.*;

@Configuration
public class DBConnection {

    @Value("${db.userName}")
    private String user;

    @Value("${db.host}")
    private String host;

    @Value("${db.password}")
    private String password;

    @Value("${db.dbname}")
    private String dbName;


    @Bean
    public ConnectionFactory connectionFactory() {
        return ConnectionFactories.get(
                ConnectionFactoryOptions.builder()
                        .option(DRIVER, "postgresql")
                        .option(HOST, host)
                        .option(PORT, 5432) // default PostgreSQL port
                        .option(USER, user)
                        .option(PASSWORD, password)
                        .option(DATABASE, dbName)
                        .option(SSL, true)
                        .option(Option.valueOf("sslMode"), "require")
                        .build()
        );
    }


}
