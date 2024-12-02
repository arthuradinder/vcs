package com.arthurprojects.vcs.util;

import org.springframework.stereotype.Component;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;


@Component
public class HashUtil {
    public String calculateFileHash(Path file) throws IOException {
        if (file == null) {
            throw new IllegalArgumentException("File path cannot be null");
        }

        if (!Files.exists(file)) {
            throw new IOException("File does not exist: " + file);
        }

        try {
            byte[] content = Files.readAllBytes(file);
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            byte[] hash = digest.digest(content);

            // Convert byte array to hex string
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = String.format("%02x", b);
                hexString.append(hex);
            }
            return hexString.toString();

        } catch (OutOfMemoryError e) {
            throw new IOException("File is too large to read into memory: " + file, e);
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("SHA-1 algorithm not available", e);
        }
    }
}
