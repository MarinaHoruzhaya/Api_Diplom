package in.reqres.tests;

import in.reqres.models.DataModel;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static in.reqres.specs.Specs.request;
import static in.reqres.specs.Specs.responseSpecWithStatusCode200;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetUserInfoTest {
    @Test
    @Owner("Horuzhaya Marina")
    @DisplayName("Check userName and ID")
    void getUserNameAndIdTest() {
        DataModel data = step("Get the user", () ->
                given(request)
                        .get("/users/2")
                        .then()
                        .spec(responseSpecWithStatusCode200)
                        .extract().as(DataModel.class));

        step("Check Id, First Name, Last Name", () -> {
            assertThat(2).isEqualTo(data.getUser().getId());
            assertThat("Janet").isEqualTo(data.getUser().getFirstName());
            assertThat("Weaver").isEqualTo(data.getUser().getLastName());
        });
    }
}
