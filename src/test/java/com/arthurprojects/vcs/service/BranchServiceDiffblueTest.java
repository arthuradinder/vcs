package com.arthurprojects.vcs.service;

import static org.junit.jupiter.api.Assertions.assertNull;

import java.io.IOException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {BranchService.class})
@ExtendWith(SpringExtension.class)
class BranchServiceDiffblueTest {
    @Autowired
    private BranchService branchService;

    /**
     * Test {@link BranchService#createBranch(String)}.
     * <p>
     * Method under test: {@link BranchService#createBranch(String)}
     */
    @Test
    @DisplayName("Test createBranch(String)")
    void testCreateBranch() throws IOException {
        // Arrange, Act and Assert
        assertNull(branchService.createBranch("Name"));
    }

    /**
     * Test {@link BranchService#mergeBranches(String, String)}.
     * <p>
     * Method under test: {@link BranchService#mergeBranches(String, String)}
     */
    @Test
    @DisplayName("Test mergeBranches(String, String)")
    void testMergeBranches() throws IOException {
        // TODO: Diffblue Cover was only able to create a partial test for this method:
        //   Reason: Missing observers.
        //   Diffblue Cover was unable to create an assertion.
        //   There are no fields that could be asserted on.

        // Arrange and Act
        (new BranchService()).mergeBranches("Source", "Target");
    }
}
