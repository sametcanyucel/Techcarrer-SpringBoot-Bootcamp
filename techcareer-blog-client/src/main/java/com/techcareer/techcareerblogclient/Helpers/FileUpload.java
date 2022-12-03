package com.techcareer.techcareerblogclient.Helpers;

import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class FileUpload {

    public static String SaveFile(String FileName, String FilePath, MultipartFile files) {
        Path upload = Paths.get(FilePath);
        if (!Files.exists(upload)) {
            try {
                Files.createDirectories(upload);
            } catch (IOException e) {
            }
        }
        try (InputStream stream = files.getInputStream()) {
            Path filePath = upload.resolve(FileName);

            Files.copy(stream, filePath, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {

        }
        return FileName;
    }
}
