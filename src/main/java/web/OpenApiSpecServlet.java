package web;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

    public class OpenApiSpecServlet extends HttpServlet {

        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            // Generate OpenAPI Specification dynamically
            OpenAPI openAPI = generateOpenApiSpec();

            // Set response content type as JSON
            response.setContentType("application/json");

            // Convert OpenAPI object to JSON and write it to response
            response.getWriter().write(openAPI.toString());
        }

        private OpenAPI generateOpenApiSpec() {
            return new OpenAPI()
                    .info(new Info().title("Book Management API")
                            .description("API to manage books in a library")
                            .version("1.0.0"));
        }
    }


