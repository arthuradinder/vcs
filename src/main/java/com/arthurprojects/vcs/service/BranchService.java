package com.arthurprojects.vcs.service;

import com.arthurprojects.vcs.model.Branch;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class BranchService {
    public Branch createBranch(String name) throws IOException {
        // Implement branch creation logic
        return null;
    }

    public void mergeBranches(String source, String target) throws IOException {
        // Implement branch merging logic
    }
}
