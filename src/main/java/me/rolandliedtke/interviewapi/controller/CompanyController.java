package me.rolandliedtke.interviewapi.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.rolandliedtke.interviewapi.model.Company;
import me.rolandliedtke.interviewapi.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Tag(name = "InterviewAPI", description = "API do obsługi danych związanych z rekrutacją")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    // Simply CRUD
    // Create One
    @Operation(summary = "Add new company to database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company was added to database"),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping("/companies")
    public ResponseEntity<Company> createCompany(@RequestBody Company company) {
        return ResponseEntity.ok(companyService.createCompany(company));
    }

    // Read One
    @Operation(summary = "Gets company by id from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company was returned"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Company not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/companies/{id}")
    public ResponseEntity<Company> readCompanyById(@PathVariable Long id) {
        return ResponseEntity.ok(companyService.readCompanyById(id));
    }

    // Update One
    @Operation(summary = "Update company from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company was updated"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Company not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PutMapping("/companies/{id}")
    public ResponseEntity<Company> updateCompanyOnId(@PathVariable Long id, @RequestBody Company updatedCompany) {
        return ResponseEntity.ok(companyService.updateCompanyOnId(id, updatedCompany));
    }

    // Delete One
    @Operation(summary = "Delete company from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Company was deleted"),
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied", content = @Content),
            @ApiResponse(responseCode = "404", description = "Company not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @DeleteMapping("/companies/{id}")
    public ResponseEntity<Void> deleteCompany(@PathVariable Long id) {
        companyService.deleteCompany(id);
        return ResponseEntity.noContent().build();
    }

    // Read All
    @Operation(summary = "List all companies from database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Companies List was returned"),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = @Content),
            @ApiResponse(responseCode = "404", description = "Companies list not found", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping("/companies")
    public ResponseEntity<List<Company>> getAllCompanies() {
        return ResponseEntity.ok(companyService.getCompanyList());
    }
}
