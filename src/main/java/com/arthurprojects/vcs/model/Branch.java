package com.arthurprojects.vcs.model;

public class Branch {
    private String name;
    private String headCommitId;

    public Branch(String headCommitId, String name) {
        this.headCommitId = headCommitId;
        this.name = name;
    }

    public String getHeadCommitId() {
        return headCommitId;
    }

    public void setHeadCommitId(String headCommitId) {
        this.headCommitId = headCommitId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
