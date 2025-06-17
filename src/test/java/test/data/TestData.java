package test.data;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name="testPodaciValid")
    public Object[][] loginDataValid(){
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"error_user","secret_sauce"},
                {"visual_user","secret_sauce"}
        };
    }
    @DataProvider(name="testOptionSort")
    public Object[][] sortingASCDESC(){
        return new Object[][]{
                {"Price (low to high)"},
                {"Price (high to low)"},
                {"Name (A to Z)"},
                {"Name (Z to A)"}
        };
    }
    @DataProvider(name="testInvalidFillForm")
    public Object[][] formDataInvalid(){
        return new Object[][]{
                {"", "", "", "Error: First Name is required"},
                {"", "Bundalo", "19300", "Error: First Name is required"},
                {"Jovan", "", "19300", "Error: Last Name is required"},
                {"Jovan", "Bundalo", "", "Error: Postal Code is required"}
        };
    }

}
