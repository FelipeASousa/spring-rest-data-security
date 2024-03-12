package br.edu.fatecsjc.lgnspringapi.resource;

import br.edu.fatecsjc.lgnspringapi.dto.GroupDTO;
import br.edu.fatecsjc.lgnspringapi.service.GroupService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/group")
@PreAuthorize("hasRole('ADMIN')")
@Tag(name = "Group and Members")
@SecurityRequirement(name = "bearerAuth")
public class GroupResource {
    @Autowired
    private GroupService groupService;

    @GetMapping
    @Operation(
            description = "Get all groups and members",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized/Invalid token", responseCode = "403"),
                    @ApiResponse(description = "Unknown error", responseCode = "400"),
            }
    )
    public ResponseEntity<List<GroupDTO>> getAllGroups() {
        return ResponseEntity.ok(groupService.getAll());
    }

    @GetMapping("/{id}")
    @Operation(
            description = "Get a group and members by group ID",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "200"),
                    @ApiResponse(description = "Unauthorized/Invalid token", responseCode = "403"),
                    @ApiResponse(description = "Unknown error", responseCode = "400"),
            }
    )
    public ResponseEntity<GroupDTO> getGroupById(@PathVariable Long id) {
        return ResponseEntity.ok(groupService.findById(id));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasAuthority('admin:update')")
    @Operation(
            description = "Update a group and members by group ID",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "201"),
                    @ApiResponse(description = "Unauthorized/Invalid token", responseCode = "403"),
                    @ApiResponse(description = "Unknown error", responseCode = "400"),
            }
    )
    public ResponseEntity<GroupDTO> update(@PathVariable Long id, @RequestBody GroupDTO body) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(groupService.save(id, body));
    }

    @PostMapping
    @PreAuthorize("hasAuthority('admin:create')")
    @Operation(
            description = "Register a new group and members",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "201"),
                    @ApiResponse(description = "Unauthorized/Invalid token", responseCode = "403"),
                    @ApiResponse(description = "Unknown error", responseCode = "400"),
            }
    )
    public ResponseEntity<GroupDTO> register(@RequestBody GroupDTO body) {
        return ResponseEntity.status(HttpStatusCode.valueOf(201))
                .body(groupService.save(body));
    }

    @DeleteMapping ("/{id}")
    @Operation(
            description = "Delete a group and members by group ID",
            responses = {
                    @ApiResponse(description = "Success", responseCode = "204"),
                    @ApiResponse(description = "Unauthorized/Invalid token", responseCode = "403"),
                    @ApiResponse(description = "Unknown error", responseCode = "400"),
            }
    )
    public ResponseEntity<Void> update(@PathVariable Long id) {
        groupService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
