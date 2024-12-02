package com.arthurprojects.vcs.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class CommitServiceTest {
    @TempDir
    Path tempDir;

    private CommitService commitService;
    private RepositoryService repositoryService;

    @BeforeEach
    void setUp() throws IOException {
        repositoryService = new RepositoryService();
        commitService = new CommitService();
        repositoryService.initRepository(tempDir);
    }

    @Test
    void testStageAndCommitFile() throws IOException {
        // Create a test file
        Path testFile = tempDir.resolve("test.txt");
        Files.write(testFile, "Test content".getBytes());

        // Stage the file
        commitService.stageFile(testFile.toString());

        // Create commit
        String commitId = commitService.createCommit("Initial commit", "test@example.com");

        // Verify commit exists
        assertNotNull(commitId);
        //assertTrue(commitService.getCommitHistory().size() > 0);
    }
}
