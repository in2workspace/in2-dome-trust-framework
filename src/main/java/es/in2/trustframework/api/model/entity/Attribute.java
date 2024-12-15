package es.in2.trustframework.api.model.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "attributes")
public class Attribute {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    // sha256 hash of the payload
    private String hash;

    // Base64 encoded content
    private String body;

    // RootTAO, TAO, TI, Revoked or Undefined
    private String issuerType;

    // Trusted Accredited Organization that accredited the insertion of the attribute
    private String tao;

    // Root chain of accreditations
    private String rootTao;

}
