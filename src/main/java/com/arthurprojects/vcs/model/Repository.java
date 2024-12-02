package com.arthurprojects.vcs.model;

import java.nio.file.Path;
import java.util.Map;

public class Repository {
    private Path rootPath;
    private Path vcsDir;
    private Branch currentBranch;
    private Map<String, Branch> branches;

    public Repository() {
        this.branches = branches;
        this.vcsDir = vcsDir;
        this.rootPath = rootPath;
        this.currentBranch = currentBranch;
    }

    public Map<String, Branch> getBranches() {
        return branches;
    }

    public void setBranches(Map<String, Branch> branches) {
        this.branches = branches;
    }

    public Path getVcsDir() {
        return vcsDir;
    }

    public void setVcsDir(Path vcsDir) {
        this.vcsDir = vcsDir;
    }

    public Path getRootPath() {
        return rootPath;
    }

    public void setRootPath(Path rootPath) {
        this.rootPath = rootPath;
    }

    public Branch getCurrentBranch() {
        return currentBranch;
    }

    public void setCurrentBranch(Branch currentBranch) {
        this.currentBranch = currentBranch;
    }
}
