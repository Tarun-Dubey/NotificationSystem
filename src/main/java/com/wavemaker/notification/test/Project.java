package com.wavemaker.notification.test;

/**
 * Created by tarund on 21/7/16.
 */
public class Project {

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getCreatedByUserId() {
        return createdByUserId;
    }

    public void setCreatedByUserId(String createdByUserId) {
        this.createdByUserId = createdByUserId;
    }

    public String getLastModifiedByUserId() {
        return lastModifiedByUserId;
    }

    public void setLastModifiedByUserId(String lastModifiedByUserId) {
        this.lastModifiedByUserId = lastModifiedByUserId;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public long getLastModifiedAt() {
        return lastModifiedAt;
    }

    public void setLastModifiedAt(long lastModifiedAt) {
        this.lastModifiedAt = lastModifiedAt;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getSubscriptionState() {
        return subscriptionState;
    }

    public void setSubscriptionState(String subscriptionState) {
        this.subscriptionState = subscriptionState;
    }

    public boolean isAccessibility() {
        return accessibility;
    }

    public void setAccessibility(boolean accessibility) {
        this.accessibility = accessibility;
    }

    public String getPlatformType() {
        return platformType;
    }

    public void setPlatformType(String platformType) {
        this.platformType = platformType;
    }

    public String getProjectShellId() {
        return projectShellId;
    }

    public void setProjectShellId(String projectShellId) {
        this.projectShellId = projectShellId;
    }

    public boolean isSampleApp() {
        return isSampleApp;
    }

    public void setSampleApp(boolean sampleApp) {
        isSampleApp = sampleApp;
    }

    private String projectId="project_1";
    private String name="name1";
    private String displayName="displayName1";
    private String description="description1";
    private String icon="icon1";
    private String projectType="projectType1";
    private String enterpriseId="enterpriseId1";
    private String createdByUserId="createdByUserId1";
    private String lastModifiedByUserId="lastModifiedByUserId1";
    private long createdAt=1468911812598L;
    private long lastModifiedAt=1468911812598L;
    private String status="status1";
    private String subscriptionState="subscriptionState1";
    private boolean accessibility=true;
    private String platformType="WEB";
    private String projectShellId="shellid1";
    private boolean isSampleApp = false;
}
