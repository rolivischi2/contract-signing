package com.contractsigning.contractsigner.module.service;

import com.contractsigning.contractsigner.module.service.signer.DocumentSignatureInserter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class SignatureService {

    private final DocumentSignatureInserter documentSignatureInserter;

    public void insertSignature(String contractId, MultipartFile multipartFile) throws IOException {
        String dest = String.format("src/main/resources/signed/%s-%d.pdf", contractId, System.currentTimeMillis());
        String src = "src/main/resources/templates/dummy.pdf";
        documentSignatureInserter.addSignatureImageToDocument(dest, src, multipartFile.getBytes());
    }

}
