package in.reqres.tests;

import in.reqres.models.BodyUserModel;
import in.reqres.models.PutResponseUserModel;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specs.request;
import static in.reqres.specs.Specs.responseSpecWithStatusCode200;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class UpdateUserDataTest {
    @Test
    @Owner("Horuzhaya Marina")
    @DisplayName("Update data of user")
    void putUserTest() {
        BodyUserModel updateBody = new BodyUserModel();
        updateBody.setName("Horuzhaya-Marina");
        updateBody.setJob("Middle-QA");
        PutResponseUserModel responseUpdateUser = step("Update name and job", () ->
                given(request)
                        .body(updateBody)
                        .put("/users/2/")
                        .then()
                        .spec(responseSpecWithStatusCode200)
                        .extract().as(PutResponseUserModel.class));

        step("Check changes", () -> {
            assertThat("Horuzhaya-Marina").isEqualTo(responseUpdateUser.getName());
            assertThat("Middle-QA").isEqualTo(responseUpdateUser.getJob());
            assertThat(responseUpdateUser.getUpdatedAt()).isNotNull();
        });
    }
}
