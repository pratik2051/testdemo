package config;

import io.swagger.v3.jaxrs2.integration.resources.OpenApiResource;
import io.swagger.v3.oas.integration.SwaggerConfiguration;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/api")
public class SwaggerConfig extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        return Set.of(OpenApiResource.class);
    }
    public OpenAPI openAPI() {
        return new OpenAPI()
                .info(new Info().title("Book Management API")
                        .description("API to manage books in a library")
                        .version("1.0.0"));
    }
    public SwaggerConfig() {
        OpenAPI openAPI = new OpenAPI()
                .info(new Info()
                        .title("Book API")
                        .version("1.0.0")
                        .description("API documentation for Book Management Servlet"));

        SwaggerConfiguration oasConfig = new SwaggerConfiguration()
                .openAPI(openAPI)
                .prettyPrint(true)
                .resourcePackages(Set.of("web")); // Package where your servlet resides

        OpenApiResource openApiResource = new OpenApiResource();
        openApiResource.setOpenApiConfiguration(oasConfig);
    }

}
