package com.arthurprojects.vcs.util;

import org.springframework.stereotype.Component;

import java.nio.file.Path;
import java.util.Set;
import java.util.List;

@Component
public class FileUtil {
    public Set<String> getIgnoredPatterns(Path repoRoot) {
        // Read .vcsignore file and return patterns
        return null;
    }

    public boolean isFileIgnored(Path file, Set<String> ignoredPatterns) {
        // Check if file matches any ignored patterns
        return false;
    }
}
