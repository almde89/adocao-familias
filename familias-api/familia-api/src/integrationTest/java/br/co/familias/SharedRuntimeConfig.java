package br.co.familias;

import org.microshed.testing.SharedContainerConfiguration;
import org.microshed.testing.testcontainers.ApplicationContainer;
import org.testcontainers.containers.BindMode;
import org.testcontainers.containers.GenericContainer;
import org.testcontainers.containers.Network;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.utility.DockerImageName;

public class SharedRuntimeConfig implements SharedContainerConfiguration {
    static Network moa = Network.newNetwork();

    @Container
    public static GenericContainer<?> db =
            new GenericContainer<>(DockerImageName.parse("postgres:13.1"))
                    .withEnv("POSTGRES_PASSWORD", "postgres")
                    .withClasspathResourceMapping(
                            "init-db.sh", "/docker-entrypoint-initdb.d/init-db.sh", BindMode.READ_ONLY)
                    .withExposedPorts(5432)
                    .withNetwork(moa)
                    .withNetworkAliases("db");

    @Container
    public static ApplicationContainer app =
            new ApplicationContainer()
                    .withAppContextRoot("/api")
                    .withNetworkAliases("app")
                    .withExposedPorts(8080)
                    .withNetwork(moa)
                    .dependsOn(db);


}
