package com.arthurprojects.vcs;

import com.arthurprojects.vcs.util.HashUtil;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
public class HashUtilTest {
    private HashUtil hashUtil;

    @TempDir
    Path tempDir;

    @BeforeEach
    void setUp() {
        hashUtil = new HashUtil();
    }

    @Test
    void testCalculateFileHash_WithSimpleFile() throws IOException {
        // Create a test file with known content
        Path testFile = tempDir.resolve("test.txt");
        String content = "Hello, World!";
        Files.write(testFile, content.getBytes(StandardCharsets.UTF_8));

        // Calculate hash
        String hash = hashUtil.calculateFileHash(testFile);

        // Expected SHA-1 hash for "Hello, World!"
        String expectedHash = "0a0a9f2a6772942557ab5355d76af442f8f65e01";
        assertEquals(expectedHash, hash);
    }

    @Test
    void testCalculateFileHash_WithEmptyFile() throws IOException {
        // Create empty file
        Path emptyFile = tempDir.resolve("empty.txt");
        Files.createFile(emptyFile);

        // Calculate hash
        String hash = hashUtil.calculateFileHash(emptyFile);

        // Expected SHA-1 hash for empty file
        String expectedHash = "da39a3ee5e6b4b0d3255bfef95601890afd80709";
        assertEquals(expectedHash, hash);
    }

    @Test
    void testCalculateFileHash_WithLargeFile() throws IOException {
        // Create a larger file (1MB)
        Path largeFile = tempDir.resolve("large.txt");
        StringBuilder content = new StringBuilder();
        for (int i = 0; i < 1024 * 1024; i++) {
            content.append('a');
        }
        Files.write(largeFile, content.toString().getBytes(StandardCharsets.UTF_8));

        // Calculate hash
        String hash = hashUtil.calculateFileHash(largeFile);

        // Verify hash is not null and has correct length (40 characters for SHA-1)
        assertNotNull(hash);
        assertEquals(40, hash.length());
    }

    @Test
    void testCalculateFileHash_WithNonExistentFile() {
        Path nonExistentFile = tempDir.resolve("nonexistent.txt");

        // Test for IOException
        assertThrows(IOException.class, () ->
                hashUtil.calculateFileHash(nonExistentFile)
        );
    }

    @Test
    void testCalculateFileHash_WithNullPath() {
        // Test for IllegalArgumentException
        assertThrows(IllegalArgumentException.class, () ->
                hashUtil.calculateFileHash(null)
        );
    }

    @Test
    void testCalculateFileHash_WithBinaryContent() throws IOException {
        // Create a file with binary content
        Path binaryFile = tempDir.resolve("binary.dat");
        byte[] binaryContent = new byte[] {0x00, 0x01, 0x02, 0x03, 0x04};
        Files.write(binaryFile, binaryContent);

        // Calculate hash
        String hash = hashUtil.calculateFileHash(binaryFile);

        // Verify hash is not null and has correct length
        assertNotNull(hash);
        assertEquals(40, hash.length());
    }

    @Test
    void testCalculateFileHash_ConsistentResults() throws IOException {
        // Create a test file
        Path testFile = tempDir.resolve("consistent.txt");
        String content = "Test content for consistency";
        Files.write(testFile, content.getBytes(StandardCharsets.UTF_8));

        // Calculate hash multiple times
        String hash1 = hashUtil.calculateFileHash(testFile);
        String hash2 = hashUtil.calculateFileHash(testFile);
        String hash3 = hashUtil.calculateFileHash(testFile);

        // Verify all hashes are identical
        assertEquals(hash1, hash2);
        assertEquals(hash2, hash3);
    }

    @Test
    void testCalculateFileHash_DifferentContents() throws IOException {
        // Create two files with different content
        Path file1 = tempDir.resolve("file1.txt");
        Path file2 = tempDir.resolve("file2.txt");

        Files.write(file1, "Content 1".getBytes(StandardCharsets.UTF_8));
        Files.write(file2, "Content 2".getBytes(StandardCharsets.UTF_8));

        // Calculate hashes
        String hash1 = hashUtil.calculateFileHash(file1);
        String hash2 = hashUtil.calculateFileHash(file2);

        // Verify hashes are different
        assertNotEquals(hash1, hash2);
    }
}
