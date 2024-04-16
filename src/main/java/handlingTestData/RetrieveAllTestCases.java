package handlingTestData;

import com.fasterxml.jackson.databind.ObjectMapper;
import getDirectories.GetDirectories;
import org.apache.commons.io.IOUtils;
import org.json.JSONArray;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class RetrieveAllTestCases {
    public static TestCaseData[] retrieveAllTestCases() {
        try {
            InputStream inputStream = new FileInputStream(GetDirectories.getTestDataFilePath());
            String testDataJson = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
            JSONArray jsonArray = new JSONArray(testDataJson);
            ObjectMapper objectMapper = new ObjectMapper();
            TestCaseData[] testCases = new TestCaseData[jsonArray.length()];
            for (int i = 0; i < jsonArray.length(); i++) {
                testCases[i] = objectMapper.readValue(jsonArray.getJSONObject(i).getJSONObject("testCase").toString(), TestCaseData.class);
            }
            return testCases;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
