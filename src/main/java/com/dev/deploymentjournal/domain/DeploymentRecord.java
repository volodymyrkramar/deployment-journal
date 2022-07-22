package com.dev.deploymentjournal.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
public class DeploymentRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "Please provide a project")
    private String project;

    @NotBlank(message = "Please provide an environment")
    private String environment;

    @NotNull(message = "Please provide a deployment date")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date deploymentDate;

    private String coreBranch;

    private String coreCommit;

    private String ilBranch;

    private String ilCommit;

    private String notes;

    @Column(updatable = false)
    private String createdBy;

    @Column(updatable = false)
    private Date createdDate;

    private String updatedBy;

    private Date updatedDate;

    private boolean deleted;

    public DeploymentRecord() {
    }

    @PrePersist
    protected void onCreate() {
        createdDate = new Date();
        deleted = false;
    }

    @PreUpdate
    protected void onUpdate() {
        updatedDate = new Date();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getProject() {
        return project;
    }

    public void setProject(String project) {
        this.project = project;
    }

    public String getCoreBranch() {
        return coreBranch;
    }

    public void setCoreBranch(String coreBranch) {
        this.coreBranch = coreBranch;
    }

    public String getCoreCommit() {
        return coreCommit;
    }

    public void setCoreCommit(String coreCommit) {
        this.coreCommit = coreCommit;
    }

    public String getIlBranch() {
        return ilBranch;
    }

    public void setIlBranch(String ilBranch) {
        this.ilBranch = ilBranch;
    }

    public String getIlCommit() {
        return ilCommit;
    }

    public void setIlCommit(String ilCommit) {
        this.ilCommit = ilCommit;
    }

    public Date getDeploymentDate() {
        return deploymentDate;
    }

    public void setDeploymentDate(Date deploymentDate) {
        this.deploymentDate = deploymentDate;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public String getEnvironment() {
        return environment;
    }

    public void setEnvironment(String environment) {
        this.environment = environment;
    }
}
