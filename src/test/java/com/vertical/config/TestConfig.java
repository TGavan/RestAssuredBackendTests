package com.vertical.config;

import io.restassured.builder.RequestSpecBuilder;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.BeforeClass;

import static com.vertical.utils.Properties.TEST_BASEURI;
import static com.vertical.utils.PropertiesUtils.getProperty;

public class TestConfig {


    public static RequestSpecification RetrieveUsersRequestSpecificationWithoutAuth;

    @BeforeClass
    public void setUp() {

        RetrieveUsersRequestSpecificationWithoutAuth = new RequestSpecBuilder()
                .setBaseUri(getProperty(TEST_BASEURI))
                .setContentType("multipart/form-data")
                .build();

    }
}

