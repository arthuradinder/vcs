package com.arthurprojects.vcs.service;

import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.List;

@Service
public class DiffService {
    public List<String> calculateDiff(Path file1, Path file2) {
        // Implement diff calculation logic
        return null;
    }

    public boolean hasConflicts(String branch1, String branch2) {
        // Implement conflict detection logic
        return false;
    }
}
