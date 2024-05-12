import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _01_Valid_Login {

    RequestSpecification reqSpec;

    @Test
    public void _01_Valid_Login_Test() {
        baseURI = "https://www.themoviedb.org";

        // Your bearer token
        String bearerToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2NmY3NjY2ZWI1ZjRlNWMyYTVjNjk0NjQ5ZmNmMmM1NCIsInN1YiI6IjY2MzYyN2YzNjYxMWI0MDEyYTY3ZDdiNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.BbnpQ7WOmRb1D73I4Ua7jgVSIePyPV3qT7uOGoxB3Ik";

        reqSpec = new RequestSpecBuilder()
                .addHeader("Authorization", "Bearer " + bearerToken)
                .setContentType(ContentType.JSON)
                .build();

        given()
                .spec(reqSpec)
                .get("/login")
                .then()
                .statusCode(200);

    }
}
