package apitest;

import com.github.javafaker.Faker;
import entities.User;
import io.qameta.allure.Description;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.testng.annotations.Test;
import services.UserApi;

import static org.testng.Assert.*;

public class UserApiTest {
    private String userId;
    private UserApi userApi;
    private User createUser;
    private User updaterUser;

    @Test
    @Description("Создаем произвольного пользователя и получаем его id")
    public void createUserTest() {
        userApi = new UserApi();
        createUser = getFakerUserData(null);
        userId = userApi.createUser(createUser);
        assertTrue(userId != "0", "Был создан пользователь c id:" + userId);
    }

    @Test(dependsOnMethods = {"createUserTest"})
    @Description("Изменяем данные пользователя по имени и проверяем, что данные изменились")
    public void updateUserTest() {
        updaterUser = getFakerUserData(userId);
        String updaterUserId = userApi.updateUser(createUser.getUsername(), updaterUser);
        assertEquals(userId, updaterUserId,
                "После обновления не совпадают id пользователей, ожидалось: " + userId + ", фактически: " + updaterUserId);
    }

    @Test(dependsOnMethods = {"updateUserTest"})
    @Description("Получаем информацию по пользователю по username ")
    public void getUserByUserNameTest() {
        assertTrue(EqualsBuilder.reflectionEquals(
                updaterUser,
                userApi.getUserByName(updaterUser.getUsername()).as(User.class),
                "После добавления, данные полученные по " + updaterUser.getUsername() + ", не соответствуют ожидаемому значению!\n"));
    }

    @Test(dependsOnMethods = {"getUserByUserNameTest"})
    @Description("Удаляем пользователя по userName")
    public void deleteUserByUserName() {
       userApi
               .deleteUserByName(updaterUser.getUsername());

       assertEquals(userApi.getUserByName(
               updaterUser
                       .getUsername())
                       .jsonPath()
                       .get("message"),
               "User not found",
                "Пользователь не был удален");
    }

    private User getFakerUserData(String userId) {
        Faker faker = new Faker();
        return User.builder()
                .id(userId)
                .username(faker.name().username())
                .email(faker.internet().emailAddress())
                .lastName(faker.name().lastName())
                .firstName(faker.name().firstName())
                .phone(faker.phoneNumber().phoneNumber())
                .build();
    }
}
