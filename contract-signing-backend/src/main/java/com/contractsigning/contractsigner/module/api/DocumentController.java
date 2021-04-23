package com.contractsigning.contractsigner.module.api;

import com.contractsigning.contractsigner.module.document.DocumentRetriever;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentRetriever documentRetriever;

    @GetMapping(
            value = "/get-document",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public @ResponseBody byte[] getFile(@RequestParam String documentName) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream(documentName);
        return IOUtils.toByteArray(in);
    }

}
