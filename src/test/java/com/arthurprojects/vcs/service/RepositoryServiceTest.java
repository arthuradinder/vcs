package com.arthurprojects.vcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class RepositoryServiceTest {
    @TempDir
    Path tempDir;

    private RepositoryService repositoryService;

    @BeforeEach
    void setUp() {
        repositoryService = new RepositoryService();
    }

    @Test
    void testInitRepository() throws IOException {
        // Test repository initialization
        repositoryService.initRepository(tempDir);

        // Verify .vcs directory exists
        Path vcsDir = tempDir.resolve(".vcs");
        assertTrue(Files.exists(vcsDir));

        // Verify required subdirectories exist
        assertTrue(Files.exists(vcsDir.resolve("objects")));
        assertTrue(Files.exists(vcsDir.resolve("refs")));
        assertTrue(Files.exists(vcsDir.resolve("HEAD")));
    }
}
