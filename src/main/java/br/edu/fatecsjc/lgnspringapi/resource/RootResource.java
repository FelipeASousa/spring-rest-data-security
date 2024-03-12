package br.edu.fatecsjc.lgnspringapi.resource;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static java.lang.String.format;

@RestController
@RequestMapping("/")
@Tag(name = "Root")
public class RootResource {
    @Value("${server.port}")
    private String port;
    @GetMapping
    public ResponseEntity<String> validateRestResource() {
        String message = new StringBuilder()
                .append("Bem-vindo, APIs operacionais. ")
                .append(format("Acesse: <a href=\"http://localhost:%s/swagger-ui/index.html\">", port))
                .append(format("http://localhost:%s/swagger-ui/index.html</a>", port))
                .toString();

        return ResponseEntity.ok(message);
    }
}
