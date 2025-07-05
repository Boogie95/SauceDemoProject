package test.data;

import org.testng.annotations.DataProvider;

public class TestData {
    @DataProvider(name = "validUsers")
    public Object[][] validUsers() {
        return new Object[][] {
                {"standard_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"visual_user", "secret_sauce"},
                {"error_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "logoutUsers")
    public Object[][] logoutUsers() {
        return new Object[][]{
                {"standard_user", "secret_sauce"},
                {"performance_glitch_user", "secret_sauce"},
                {"problem_user", "secret_sauce"},
                {"visual_user", "secret_sauce"},
                {"error_user", "secret_sauce"}
        };
    }

    @DataProvider(name = "sortOptionsWithUsers")
    public Object[][] sortOptionsWithUsers() {
        return new Object[][]{
                {"standard_user", "Price (high to low)"},
                {"standard_user", "Name (A to Z)"},
                {"standard_user", "Name (Z to A)"},
                {"performance_glitch_user","Price (low to high)"},
                {"performance_glitch_user", "Price (high to low)"},
                {"performance_glitch_user", "Name (A to Z)"},
                {"performance_glitch_user", "Name (Z to A)"}
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
    @DataProvider(name = "priceSortUsers")
    public Object[][] priceSortUsers() {
        return new Object[][] {
                {"standard_user", "Price (low to high)", true},
                {"problem_user", "Price (low to high)", false},
                {"visual_user", "Price (low to high)", false}
        };
    }
    @DataProvider(name = "usersAddTShirt")
    public Object[][] usersAddTShirt() {
        return new Object[][] {
                {"standard_user", true},
                {"performance_glitch_user", true},
                {"visual_user", true},
                {"problem_user", false},
                {"error_user", false}
        };
    }

}
