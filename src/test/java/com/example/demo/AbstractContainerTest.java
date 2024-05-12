package com.example.demo;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.apache.http.HttpHeaders;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.boot.testcontainers.service.connection.ServiceConnection;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.lifecycle.Startables;
import org.testcontainers.utility.DockerImageName;


@SpringBootTest(
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@Testcontainers
@Import(TestContainerConfiguration.class)
public abstract class AbstractContainerTest {
//    @Container
//    @ServiceConnection
//    static MSSQLServerContainer<?> sqlServerContainer = new MSSQLServerContainer<>
//            (DockerImageName.parse("mcr.microsoft.com/mssql/server:2022-latest"));

//    @DynamicPropertySource
//    static void init(DynamicPropertyRegistry registry){
//        Startables.deepStart(sqlServerContainer).join();
//
//        registry.add("spring.datasource.url", sqlServerContainer::getJdbcUrl);
//        registry.add("spring.datasource.username", sqlServerContainer::getUsername);
//        registry.add("spring.datasource.password", sqlServerContainer::getPassword);
//    }

    @LocalServerPort
    int port;

    protected RequestSpecification requestSpecification;
    @BeforeEach
    void setup(){
        requestSpecification = new RequestSpecBuilder()
                .setPort(port)
                .addHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
                .build();
    }
}
