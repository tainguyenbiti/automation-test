package com.acblogictics.databaseabclogictics.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TestResultDetail {
    private String testStatus;
    private String method;
    private String reason;
    private long start;
    private long end;
    private String parentName;
}
