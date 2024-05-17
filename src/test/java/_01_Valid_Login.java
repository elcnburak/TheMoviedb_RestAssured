import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _01_Valid_Login {

    RequestSpecification reqSpec;

    @Test
    public void _01_Valid_Login_Test() {
        baseURI = "https://api.themoviedb.org";

        reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .log(LogDetail.URI)
                .build();

        ResponseSpecification responseSpec = new ResponseSpecBuilder()
                .expectStatusCode(200)
                .log(LogDetail.BODY)
                .expectContentType(ContentType.JSON)
                .build();

        given()
                .spec(reqSpec)
                .header("Authorization", "Bearer eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2NmY3NjY2ZWI1ZjRlNWMyYTVjNjk0NjQ5ZmNmMmM1NCIsInN1YiI6IjY2MzYyN2YzNjYxMWI0MDEyYTY3ZDdiNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.BbnpQ7WOmRb1D73I4Ua7jgVSIePyPV3qT7uOGoxB3Ik")
                .contentType(ContentType.JSON)
                .when()
                .get("/3/authentication")
                .then()
                .log().all()
                .spec(responseSpec)

        ;




    }
}
