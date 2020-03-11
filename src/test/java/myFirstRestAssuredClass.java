

import java.util.ArrayList;

import static io.restassured.RestAssured.*;
import static java.util.concurrent.TimeUnit.MILLISECONDS;

public class myFirstRestAssuredClass {

    public static void main(String args[]) {

      getResponseBody();
      getResponseStatus();
      getResponseTime();
      getResponseHeaders();
      getResponseContentType();
      getSpecificPartOfResponseBody()
;    }

    //This will fetch the response body as is and log it. given and when are optional here
    public static void getResponseBody(){
        get("https://reqres.in/api/users?page=2").then().log()
       .body();
    }

    //This will fetch the response body as is and log it. given and when are optional here
    public static void getSpecificPartOfResponseBody(){


        ArrayList<Integer> id= given().when().get("https://reqres.in/api/users?page=2").
                then().extract().path("data.id");
        System.out.println("The first ID fetched is " + id.get(0));
     int page=   given().when().get("https://reqres.in/api/users?page=2").
                then().extract().path("page");
        System.out.println("The page fetched is " + page);

        get("https://reqres.in/api/users?page=2").then().log()
                .body();
    }

    //This will be a assert condition to ensure the status code for the request is a 200 OK
    public static void getResponseStatus(){
       int statusCode= get("https://reqres.in/api/users?page=2").getStatusCode();
        System.out.println("The response status is "+statusCode);
        when().get("https://reqres.in/api/users?page=2").then().assertThat().statusCode(200);
    }

    public static void getResponseTime(){
        System.out.println("The time taken to fetch the response "+get("https://reqres.in/api/users?page=2")
               .timeIn(MILLISECONDS));
    }

    public static void getResponseHeaders(){
        System.out.println("The headers in the response "+
                        get("https://reqres.in/api/users?page=2").then().extract()
                .headers());
    }
    public static void getResponseContentType(){
        System.out.println("The content type of response "+
                get("https://reqres.in/api/users?page=2").then().extract()
                   .contentType());
    }
}

