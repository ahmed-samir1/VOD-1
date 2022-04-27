package Vod_API;

import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import org.hamcrest.Matchers;
import org.testng.*;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.concurrent.TimeUnit;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.*;

public class Vod_API {
    @Test
    public void getUser_Id(Method method) {
        Response response = given().when().get("https://jsonplaceholder.typicode.com/users?id=1")
                .then().assertThat().statusCode(200).extract().response();
        String responseInString = response.asString();
        System.out.println(responseInString);

        // we need to get the email address from the response to user id= 1
        JsonPath jsonPath = new JsonPath(responseInString);
        String emailAddress = jsonPath.getString("email");
        System.out.println(emailAddress);

        long responseTimeInSeconds = response.getTimeIn(TimeUnit.SECONDS);
        System.out.println("Response time in seconds using getTimeIn():" + responseTimeInSeconds);
        System.out.println("Response Time : " + response.getTime());
        // Getting ValidatableResponse type
        ValidatableResponse valRes = response.then();
        // Asserting response time is less than 5000 milliseconds
        // L just represent long. It is in millisecond by default.
        valRes.time(Matchers.lessThan(25000L));
    }

    @Test
    public void userPost(Method method) {
        Response response = given().contentType(ContentType.JSON).when().get("https://jsonplaceholder.typicode.com/posts?userId=1")
                .then().assertThat().statusCode(200).extract().response();
        String responseInString = response.asString();
        System.out.println(responseInString);

        // Using the userID =1 , get the user’s associated posts
        JsonPath jsonPath = new JsonPath(responseInString);
        String userPosts_title = jsonPath.getString("title");
        String userpost_body = jsonPath.getString("body");
        if( !userPosts_title.isEmpty()&& !userpost_body.isEmpty()){
        // verify the Posts contain valid Post IDs (an Integer between 1 and 100).
            response.then().assertThat().body("id", everyItem(allOf(greaterThanOrEqualTo(1), lessThanOrEqualTo(100))));
        }
        System.out.println("Print for Userbody and title\n"+ userPosts_title +"and ---|||---\n"+ userpost_body);

    }

}
