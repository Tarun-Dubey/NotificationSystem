package com.wavemaker.notification.entity;

/**
 * Created by tarund on 12/7/16.
 */
public class User {

    private String userId="userId1";
    private String displayName="displayName1";
    private String firstName="firstName1";
    private String lastName="lastName1";
    private String enterpriseId="enterpriseId1";
    private String email="emailId1";
    private String designation="designation1";
    private long createdAt=1468911812598L;
    private boolean isActive=true;
    private int maxApps=10;
    private UserAccountExtension userAccountExtension= new UserAccountExtension();

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEnterpriseId() {
        return enterpriseId;
    }

    public void setEnterpriseId(String enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public int getMaxApps() {
        return maxApps;
    }

    public void setMaxApps(int maxApps) {
        this.maxApps = maxApps;
    }

    public UserAccountExtension getUserAccountExtension() {
        return userAccountExtension;
    }

    public void setUserAccountExtension(UserAccountExtension userAccountExtension) {
        this.userAccountExtension = userAccountExtension;
    }
}
