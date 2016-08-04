package com.wavemaker.notification.test;

/**
 * Created by tarund on 21/7/16.
 */
public class Team {

    private String teamId="teamId1";
    private String teamName="teamName1";
    private String entId="entId1";
    private String teamDesc="teamdesc1";
    private String createdBy="createdBy1";
    private long createdAt=1468911812598L;
    private String teamIcon="teamIcon1";

    public String getTeamId() {
        return teamId;
    }

    public void setTeamId(String teamId) {
        this.teamId = teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getTeamDesc() {
        return teamDesc;
    }

    public void setTeamDesc(String teamDesc) {
        this.teamDesc = teamDesc;
    }

    public long getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(long createdAt) {
        this.createdAt = createdAt;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getTeamIcon() {
        return teamIcon;
    }

    public void setTeamIcon(String teamIcon) {
        this.teamIcon = teamIcon;
    }

    public String getEntId() {
        return entId;
    }

    public void setEntId(String entId) {
        this.entId = entId;
    }
}
