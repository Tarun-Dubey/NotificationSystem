package com.wavemaker.notification.entity;

/**
 * Created by tarund on 21/7/16.
 */
public class UserAccountExtension {

    private String accountId="accountId1";
    private int maxApps=5;
    private long lastAccessedTime=1468849941626L;
    private long lastCleanUpTime=1468849941124L;

    public UserAccountExtension() {

    }

    public UserAccountExtension(String accountId) {
        this.accountId = accountId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public long getLastAccessedTime() {
        return lastAccessedTime;
    }

    public void setLastAccessedTime(long lastAccessedTime) {
        this.lastAccessedTime = lastAccessedTime;
    }

    public long getLastCleanUpTime() {
        return lastCleanUpTime;
    }

    public void setLastCleanUpTime(long lastCleanUpTime) {
        this.lastCleanUpTime = lastCleanUpTime;
    }

    public int getMaxApps() {
        return maxApps;
    }

    public void setMaxApps(int maxApps) {
        this.maxApps = maxApps;
    }

}
