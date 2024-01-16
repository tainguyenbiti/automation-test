    package com.acblogictics.databaseabclogictics.result;

    import java.util.HashMap;
    import java.util.Map;

    public class TestResults {
        private Map<String, Map<String, TestResultDetail>> testStatus; // Tên test và kết quả tương ứng
        private int passed;
        private int failed;
        private int skipped;

        public TestResults() {
            this.testStatus = new HashMap<>();
            this.passed = 0;
            this.failed = 0;
            this.skipped = 0;
        }

        public void addTestStatus(String testName, String status, Map<String, TestResultDetail> additionalProps) {
            Map<String, TestResultDetail> testEntry = new HashMap<>();
            testEntry.putAll(additionalProps);

            testStatus.put(testName, testEntry);
            updateCount(status);
        }

        public void updateCount(String status) {
            switch (status) {
                case "passed":
                    passed++;
                    break;
                case "failed":
                    failed++;
                    break;
                case "skipped":
                    skipped++;
                    break;
                default:
                   break;
            }
        }

        public Map<String, Map<String, TestResultDetail>> getTestStatus() {
            return testStatus;
        }

        public int getPassed() {
            return passed;
        }

        public int getFailed() {
            return failed;
        }

        public int getSkipped() {
            return skipped;
        }
    }
