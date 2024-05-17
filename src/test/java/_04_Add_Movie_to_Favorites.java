import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import java.util.HashMap;
import java.util.Map;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _04_Add_Movie_to_Favorites {

    @Test(dependsOnMethods = "_03_Get_Account_Details._03_Get_Account_Details_Test")
    public void _04_Add_Movie_to_Favorites_Test() {
        baseURI = "https://api.themoviedb.org/3";

        String bearerToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2NmY3NjY2ZWI1ZjRlNWMyYTVjNjk0NjQ5ZmNmMmM1NCIsInN1YiI6IjY2MzYyN2YzNjYxMWI0MDEyYTY3ZDdiNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.BbnpQ7WOmRb1D73I4Ua7jgVSIePyPV3qT7uOGoxB3Ik";

        Map<String, Object> jsonBody = new HashMap<>();
        jsonBody.put("media_type", "movie");
        jsonBody.put("media_id", 560);
        jsonBody.put("favorite", true);

        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + bearerToken)
                .build();

        Response response = given()
                .spec(reqSpec)
                .body(jsonBody)
                .post("/account/21251242/favorite");


        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
        System.out.println("Status Code: " + response.getStatusCode());
    }
}
