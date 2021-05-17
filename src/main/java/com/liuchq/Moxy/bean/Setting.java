package com.liuchq.Moxy.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Setting {
    private String settingId;

    private String settingKey;

    private String settingValue;

    private Date settingCreatetime;

    private String settingDescription;

    public String getSettingId() {
        return settingId;
    }

    public void setSettingId(String settingId) {
        this.settingId = settingId == null ? null : settingId.trim();
    }

    public String getSettingKey() {
        return settingKey;
    }

    public void setSettingKey(String settingKey) {
        this.settingKey = settingKey == null ? null : settingKey.trim();
    }

    public String getSettingValue() {
        return settingValue;
    }

    public void setSettingValue(String settingValue) {
        this.settingValue = settingValue == null ? null : settingValue.trim();
    }

    public Date getSettingCreatetime() {
        return settingCreatetime;
    }

    public void setSettingCreatetime(Date settingCreatetime) {
        this.settingCreatetime = settingCreatetime;
    }

    public String getSettingDescription() {
        return settingDescription;
    }

    public void setSettingDescription(String settingDescription) {
        this.settingDescription = settingDescription == null ? null : settingDescription.trim();
    }
}