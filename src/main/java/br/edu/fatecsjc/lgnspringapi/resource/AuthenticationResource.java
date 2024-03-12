package br.edu.fatecsjc.lgnspringapi.resource;

import br.edu.fatecsjc.lgnspringapi.dto.AuthenticationRequestDTO;
import br.edu.fatecsjc.lgnspringapi.dto.AuthenticationResponseDTO;
import br.edu.fatecsjc.lgnspringapi.dto.RegisterRequestDTO;
import br.edu.fatecsjc.lgnspringapi.service.AuthenticationService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@Tag(name = "Authentication and Token Operations")
public class AuthenticationResource {

    private final AuthenticationService service;

    @PostMapping("/register")
    @Operation(
            description = "Register a new system user",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "201"),
                    @ApiResponse(description = "Unknown error", responseCode = "400"),
            }
    )
    public ResponseEntity<AuthenticationResponseDTO> register(@RequestBody RegisterRequestDTO request) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(service.register(request));
    }
    @PostMapping("/authenticate")
    @Operation(
            description = "Authenticate to get access and refresh tokens",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "201"),
                    @ApiResponse(description = "Unknown error", responseCode = "400"),
            }
    )
    public ResponseEntity<AuthenticationResponseDTO> authenticate(@RequestBody AuthenticationRequestDTO request) {
        return ResponseEntity.ok(service.authenticate(request));
    }

    @PostMapping("/refresh-token")
    @Operation(
            description = "Update access and refresh tokens",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unknown error", responseCode = "400"),
            }
    )
    @SecurityRequirement(name = "bearerAuth")
    public ResponseEntity<Void> refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        service.refreshToken(request, response);
        return ResponseEntity.ok().build();
    }
}
