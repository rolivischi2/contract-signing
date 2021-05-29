package com.contractsigning.contractsigner.module.service;

import com.contractsigning.contractsigner.module.service.signer.DocumentSignatureInserter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
public class SignatureService {

    private final DocumentSignatureInserter documentSignatureInserter;

    public void insertSignature(String contractId, MultipartFile multipartFile){

    }

}
