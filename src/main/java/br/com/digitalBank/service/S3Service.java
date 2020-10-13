package br.com.digitalBank.service;

import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.net.URI;

public interface S3Service {

    public URI uploadFile(final MultipartFile multipartFile);

    public URI uploadFile(final InputStream inputStream, final String fileName, final String contentType);
}
