package es.in2.trustframework.api.domain.service.impl;

import es.in2.trustframework.api.domain.model.entity.Attribute;
import es.in2.trustframework.api.domain.model.entity.Issuer;
import es.in2.trustframework.api.domain.service.IssuerService;
import es.in2.trustframework.api.infrastructure.repository.IssuerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class IssuerServiceImpl implements IssuerService {

    private final IssuerRepository issuerRepository;

    @Override
    public void saveIssuer(Issuer did) {
        // Receive a did from an elegible issuer

        // sha256 hash of the payload



        // Build Issuer Attributes
        List<Attribute> attributes = List.of(
//                Attribute.builder()
//                        .hash()
//                        .body()
//                        .issuerType()
//                        .tao()
//                        .rootTao()
//                        .build()
        );

        // Build Issuer
//        Issuer newIssuer = Issuer.builder()
//                .did(did)
//                .attributes(List.of())
//                .build();

        issuerRepository.save(did);
    }

    @Override
    public List<Issuer> getIssuers() {
        return issuerRepository.findAll();
    }

    @Override
    public Issuer getIssuerByDid(String did) {
        return issuerRepository.findByDid(did).orElse(null);
    }

    @Override
    public void updateIssuer(String did, Issuer issuer) {
//        Issuer issuerToUpdate = issuerRepository.findByDid(did).orElse(null);
//        if (issuerToUpdate != null) {
//            issuerToUpdate.setAttributes(issuer.getAttributes());
//            issuerRepository.save(issuerToUpdate);
//        }
    }

}
