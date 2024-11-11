package es.in2.trustframework.api.infrastructure.controller;

import es.in2.trustframework.api.domain.model.entity.Issuer;
import es.in2.trustframework.api.domain.service.IssuerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/trusted-issuers-registry/v5/issuers/")
@RequiredArgsConstructor
public class IssuerController {

    private final IssuerService issuerService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void saveIssuer(@RequestBody Issuer issuer) {
        issuerService.saveIssuer(issuer);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Issuer> getIssuers() {
        return issuerService.getIssuers();
    }

    @GetMapping("/{did}")
    @ResponseStatus(HttpStatus.OK)
    public Issuer getIssuerByDid(@PathVariable String did) {
        return issuerService.getIssuerByDid(did);
    }

    @PatchMapping("/{did}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void updateIssuer(@PathVariable String did, @RequestBody Issuer issuer) {
        issuerService.updateIssuer(did, issuer);
    }

}
