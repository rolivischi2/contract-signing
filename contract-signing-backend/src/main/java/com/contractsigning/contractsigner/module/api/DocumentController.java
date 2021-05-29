package com.contractsigning.contractsigner.module.api;

import com.contractsigning.contractsigner.module.service.DocumentRetriever;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.IOUtils;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.io.InputStream;

@RestController
@RequestMapping("/document")
@RequiredArgsConstructor
public class DocumentController {

    private final DocumentRetriever documentRetriever;

    @GetMapping(
            path = "/{documentName}",
            produces = MediaType.APPLICATION_OCTET_STREAM_VALUE
    )
    public @ResponseBody byte[] getFile(@RequestParam String documentName) throws IOException {
        InputStream in = getClass()
                .getResourceAsStream(documentName);
        return IOUtils.toByteArray(in);
    }

}
