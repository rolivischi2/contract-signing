package com.contractsigning.contractsigner.module.service.signer;

import com.itextpdf.forms.PdfAcroForm;
import com.itextpdf.forms.fields.PdfFormField;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfArray;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class DocumentSignatureInserter {

    public void addSignatureImageToDocument(String dest, String src, byte[] img) throws IOException {
        PdfReader reader = new PdfReader(src);

        PdfWriter writer = new PdfWriter(dest);

        // Creating a PdfDocument
        PdfDocument pdfDoc = new PdfDocument(reader,writer);
        // Creating a Document
        Document document = new Document(pdfDoc);
        // Fetching the form
        PdfAcroForm form = PdfAcroForm.getAcroForm(pdfDoc, true);
        // Getting fields of interest
        List<PdfFormField> fieldsOfInterest = fetchFieldsOfInterest(form);
        // Creating images scaled and at their position
        List<Image> images = createImagesAtSignaturePosition(fieldsOfInterest, img);
        // Adding images to the document
        images.forEach(document::add);
        // Flattening all formFields
        form.flattenFields();
        // Closing doc
        document.close();
    }

    private List<PdfFormField> fetchFieldsOfInterest(PdfAcroForm form){
        return form.getFormFields().values()
                .stream()
                .filter(pdfFormField -> pdfFormField.getFormType().getValue().equalsIgnoreCase(SupportedFieldTypes.SIG.value))
                .collect(Collectors.toList());
    }

    private List<Image> createImagesAtSignaturePosition(List<PdfFormField> fields, byte[] image) throws MalformedURLException {
        ImageData imageData = ImageDataFactory.createPng(image);
        return fields.stream()
                .map(field -> {
                    Image img = new Image(imageData);
                    setImagePositionWithinField(field, img);
                    return img; })
                .collect(Collectors.toList());
    }

    private void setImagePositionWithinField(PdfFormField fieldPosition, Image image){
        PdfArray position = fieldPosition.getWidgets().get(0).getRectangle();
        float height = (float) (position.getAsNumber(3).getValue() - position.getAsNumber(1).getValue());
        float width = (float) (position.getAsNumber(2).getValue() - position.getAsNumber(0).getValue());
        image.setHeight(height);
        image.setWidth(width);
        image.setFixedPosition((float) position.getAsNumber(0).getValue(), (float) position.getAsNumber(1).getValue());
    }

}
