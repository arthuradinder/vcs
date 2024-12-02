package com.arthurprojects.vcs.service;

import com.arthurprojects.vcs.model.Commit;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

@Service
public class CommitService {
    public void stageFile(String path) throws IOException {
        // Implement file staging logic
    }

    public String createCommit(String message, String author) throws IOException {
        // Implement commit creation logic
        return null;
    }

    public List<Commit> getCommitHistory() {
        // Implement commit history retrieval
        return null;
    }
}
