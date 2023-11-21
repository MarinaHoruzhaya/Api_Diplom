package in.reqres.tests;

import in.reqres.models.BodyUserModel;
import in.reqres.models.CreateResponseModel;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specs.request;
import static in.reqres.specs.Specs.responseSpecWithStatusCode201;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class CreateUserTest {
    @Test
    @Owner("Horuzhaya Marina")
    @DisplayName("Create new user")
    void createUserTest() {
        BodyUserModel body = new BodyUserModel();
        body.setName("Marina");
        body.setJob("QA-engineer");

        CreateResponseModel responseNewUser = step("Create user", () ->
                given(request)
                        .body(body)
                        .when()
                        .post("/users")
                        .then()
                        .spec(responseSpecWithStatusCode201)
                        .extract().as(CreateResponseModel.class));

        step("Check that user was created", () -> {
            assertThat("Marina").isEqualTo(responseNewUser.getName());
            assertThat("QA-engineer").isEqualTo(responseNewUser.getJob());
            assertThat(responseNewUser.getId()).isNotNull();
            assertThat(responseNewUser.getCreatedAt()).isNotNull();
        });
    }
}
