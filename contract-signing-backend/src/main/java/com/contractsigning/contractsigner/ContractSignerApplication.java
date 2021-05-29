package com.contractsigning.contractsigner;

import com.contractsigning.contractsigner.module.service.signer.DocumentSignatureInserter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@SpringBootApplication
public class ContractSignerApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ContractSignerApplication.class, args);
		DocumentSignatureInserter inserter = new DocumentSignatureInserter();
		String dest = "src/main/resources/signed/signed-contract.pdf";
		String src = "src/main/resources/templates/dummy.pdf";
		String imageFile = "src/main/resources/static/signatures/sig.png";

		inserter.addSignatureImageToDocument(dest, src, imageFile);
	}

}
