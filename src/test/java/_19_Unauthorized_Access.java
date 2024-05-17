import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.baseURI;
import static io.restassured.RestAssured.given;

public class _19_Unauthorized_Access {
    @Test
    public void _19_Unauthorized_Access() {
        baseURI = "https://api.themoviedb.org/3";

        String bearerToken = "eyJhbGciOiJIUzI1NiJ9.eyJhdWQiOiI2NmY3NjY2ZWI1ZjRlNWMyYTVjNjk0NjQ5ZmNmMmM1NCIsInN1YiI6IjY2MzYyN2YzNjYxMWI0MDEyYTY3ZDdiNyIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.BbnpQ7WOmRb1D73I4Ua7jgVSIePyPV3qT7uOGoxB3Ik";

        // JSON verisi
        String jsonBody = "{\"value\": 8.5}";

        // RequestSpecification oluşturma
        RequestSpecification reqSpec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .addHeader("Authorization", "Bearer " + bearerToken)
                .build();

        // POST isteği gönderme ve JSON verisi gövdeye ekleme
        Response response = given()
                .spec(reqSpec)
                .body(jsonBody) // JSON verisi gövdeye ekleniyor
                .post("list/8299447/add_item");

        // Yanıtı yazdırma
        System.out.println("Response Body:");
        System.out.println(response.getBody().asString());
        System.out.println("Status Code: " + response.getStatusCode());
    }
}
