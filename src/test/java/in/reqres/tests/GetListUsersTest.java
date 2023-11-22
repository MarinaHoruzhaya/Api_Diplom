package in.reqres.tests;

import in.reqres.models.GetListUsersModel;
import in.reqres.models.ListUsersDataResponseModel;
import io.qameta.allure.Owner;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static in.reqres.specs.Specs.request;
import static in.reqres.specs.Specs.responseSpecWithStatusCode200;
import static io.qameta.allure.Allure.step;
import static io.restassured.RestAssured.given;
import static org.assertj.core.api.Assertions.assertThat;

public class GetListUsersTest {
    @Test
    @Owner("Horuzhaya Marina")
    @DisplayName("Check user at list of users")
    void listUsersTest() {
        GetListUsersModel responseUsers = step("Get the users array", () ->
                given(request)
                        .get("/users?page=2")
                        .then()
                        .spec(responseSpecWithStatusCode200)
                        .extract().as(GetListUsersModel.class));

        step("Check the data", () -> {
            List<ListUsersDataResponseModel> data = responseUsers.getData();
            assertThat("Byron").isEqualTo(data.get(3).getFirstName());
            assertThat("Fields").isEqualTo(data.get(3).getLastName());
            assertThat(9).isEqualTo(responseUsers.getData().get(2).getId());
            assertThat("To keep ReqRes free, contributions towards server costs are appreciated!")
                    .isEqualTo(responseUsers.getSupport().getText());
            assertThat(6).isEqualTo(responseUsers.getPerPage());
        });

    }
}
