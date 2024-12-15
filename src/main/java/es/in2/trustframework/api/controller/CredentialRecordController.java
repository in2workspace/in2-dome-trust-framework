package es.in2.trustframework.api.controller;

import es.in2.trustframework.api.model.dto.CredentialRecordRequest;
import es.in2.trustframework.api.model.dto.CredentialRecordResponse;
import es.in2.trustframework.api.service.CredentialRecordService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/credentials")
@RequiredArgsConstructor
public class CredentialRecordController {

    private final CredentialRecordService credentialRecordService;

    @PostMapping
    public ResponseEntity<Void> registerCredentialRecord(@Valid @RequestBody CredentialRecordRequest credentialRecordRequest) {
        credentialRecordService.registerCredentialRecord(credentialRecordRequest);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CredentialRecordResponse> getCredentialRecord(@PathVariable String id) {
        return ResponseEntity.status(HttpStatus.OK).body(credentialRecordService.getCredentialRecord(id));
    }

}
