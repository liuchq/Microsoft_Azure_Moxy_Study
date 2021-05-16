package com.liuchq.Moxy.bean;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Test {
    private Integer testId;

    private String testName;

    private Integer testAge;

    public Integer getTestId() {
        return testId;
    }

    public void setTestId(Integer testId) {
        this.testId = testId;
    }

    public String getTestName() {
        return testName;
    }

    public void setTestName(String testName) {
        this.testName = testName == null ? null : testName.trim();
    }

    public Integer getTestAge() {
        return testAge;
    }

    public void setTestAge(Integer testAge) {
        this.testAge = testAge;
    }
}