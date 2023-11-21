package in.reqres.tests;

import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specs.request;
import static in.reqres.specs.Specs.responseSpecWithStatusCode204;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;

public class DeleteUserTest {

    @Test
    @Owner("Horuzhaya Marina")
    @DisplayName("Delete user")
    void deleteUserTest() {
        step("Check that user was deleted", () -> {
            given(request)
                    .delete("/users/2")
                    .then()
                    .log().body()
                    .spec(responseSpecWithStatusCode204);
        });
    }
}
