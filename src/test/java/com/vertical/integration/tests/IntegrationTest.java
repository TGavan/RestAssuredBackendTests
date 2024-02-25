package com.vertical.integration.tests;

import com.vertical.config.EndPoints;
import com.vertical.config.TestConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static io.restassured.RestAssured.given;

public class IntegrationTest extends TestConfig {

    private static Logger Log = LogManager.getLogger(IntegrationTest.class.getName());
    private String dayMonthYear;


    @BeforeTest
    public void setup() {
        SimpleDateFormat sDFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        dayMonthYear = sDFormat.format(date);

    }

    @Test
    public void verifyResponseCodeForGETUsersRequest() {
        Log.info("Verify the Response code for the Get Users request");
        given()
                .spec(RetrieveUsersRequestSpecificationWithoutAuth)
                .log()
                .ifValidationFails()
                .when().get(EndPoints.GET_REQUEST)
                .then()
                .assertThat()
                .statusCode(200)
                .log()
                .all();
    }

    @Test
    public void verifyResponseBodyForUsersNameGETRequest() {
        Log.info("Verify the Response body for the Get Users request for the names");
        Response response = given()
                .spec(RetrieveUsersRequestSpecificationWithoutAuth)
                .log()
                .ifValidationFails()
                .when().get(EndPoints.GET_REQUEST)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();

        List<String> namelist = JsonPath.with(response.asInputStream()).get("name");
        Assert.assertEquals(namelist.get(0).toString(), "Leanne Graham");
        Assert.assertEquals(namelist.get(1).toString(), "Ervin Howell");
        Assert.assertEquals(namelist.get(2).toString(), "Clementine Bauch");


    }

    @Test
    public void verifyResponseBodyForUsersComplayNameGETRequest() {
        Log.info("Verify the Response body for the Get Users request for the street in the address");
        Response response = given()
                .spec(RetrieveUsersRequestSpecificationWithoutAuth)
                .log()
                .ifValidationFails()
                .when().get(EndPoints.GET_REQUEST)
                .then()
                .contentType(ContentType.JSON)
                .extract()
                .response();


        List<String> addressStreetList = JsonPath.with(response.asInputStream()).get("address.street");
        Assert.assertEquals(addressStreetList.get(0).toString(), "Kulas Light");
        Assert.assertEquals(addressStreetList.get(1).toString(), "Victor Plains");

    }

}