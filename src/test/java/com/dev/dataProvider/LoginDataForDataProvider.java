package com.dev.dataProvider;

import org.testng.annotations.DataProvider;

public class LoginDataForDataProvider {
    @DataProvider(name = "logintest")
    public Object[][] loginData() {
        return new Object[][]{
                {"standard_user", "secret_sauce","Swag Labs"},
                {"locked_out_user", "secret_sauce","Swag Labs"},
                {"problem_user", "secret_sauce","Swag Labs"},
                {"performance_glitch_user", "secret_sauce","Swag Labs"}
        };
    }
}
