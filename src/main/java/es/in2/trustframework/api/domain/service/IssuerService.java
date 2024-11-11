package es.in2.trustframework.api.domain.service;

import es.in2.trustframework.api.domain.model.entity.Issuer;

import java.util.List;

public interface IssuerService {
    void saveIssuer(Issuer issuer);
    List<Issuer> getIssuers();
    Issuer getIssuerByDid(String did);
    void updateIssuer(String did, Issuer issuer);
}
