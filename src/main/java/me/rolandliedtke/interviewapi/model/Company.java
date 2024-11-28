package me.rolandliedtke.interviewapi.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Company {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "ID firmy", example = "1")
    @Id
    private Long id;

    @Schema(description = "Nazwa firmy", example = "Energa S.A.")
    private String name;

    @Schema(description = "Adres firmy", example = "ul. Otolińska 25, 09-407 Płock")
    private String address;

    @Schema(description = "Numer telefonu", example = "24 266-56-00")
    private String phoneNumber;

    @Schema(description = "Adres e-mail", example = "energa.logistyka@energa.pl")
    private String email;
}
