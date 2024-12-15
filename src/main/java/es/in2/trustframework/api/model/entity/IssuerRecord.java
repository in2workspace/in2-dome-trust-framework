package es.in2.trustframework.api.model.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Table(name = "trusted_issuer_list", schema = "trust-framework-dome")
@DynamicInsert
@DynamicUpdate
public class IssuerRecord {

    @Id @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String did;

    // Array of attributes
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "issuer_id")
    private List<Attribute> attributes;

}
