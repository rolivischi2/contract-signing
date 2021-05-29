package com.contractsigning.contractsigner.module.api;

import com.contractsigning.contractsigner.module.service.SignatureService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


@RestController
@RequestMapping("/signature")
@RequiredArgsConstructor
public class SignatureController {

    private final SignatureService signatureService;

    @PostMapping
    public ResponseEntity<String> signContract(@RequestParam String contractId, @RequestParam MultipartFile file) {
        try {
            signatureService.insertSignature(contractId, file);
            String message = String.format("Contract: %s signed on %s", contractId, LocalDateTime.now().format(DateTimeFormatter.ISO_LOCAL_DATE_TIME));
            return ResponseEntity.status(HttpStatus.OK).body(message);
        } catch (Exception e) {
            String message = String.format("Could not sign: %s", contractId);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(message);
        }
    }

}
