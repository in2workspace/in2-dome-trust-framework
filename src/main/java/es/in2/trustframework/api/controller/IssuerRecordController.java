package es.in2.trustframework.api.controller;

import es.in2.trustframework.api.model.dto.IssuerRecordRequest;
import es.in2.trustframework.api.model.dto.IssuerRecordResponse;
import es.in2.trustframework.api.service.IssuerRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/trusted-issuers-registry/v5/issuers/")
@RequiredArgsConstructor
public class IssuerRecordController {

    private final IssuerRecordService issuerRecordService;

    @PostMapping
    public ResponseEntity<Void> registerIssuerRecord(@Valid @RequestBody IssuerRecordRequest issuerRecordRequest) {
        issuerRecordService.registerIssuerRecord(issuerRecordRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{did}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<IssuerRecordResponse> getIssuerRecord(@PathVariable String did) {
        return ResponseEntity.status(HttpStatus.OK).body(issuerRecordService.getIssuerByDid(did));
    }

}
