import UserModel.Address;
import UserModel.Company;
import UserModel.Geo;
import UserModel.User;
import Utils.*;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class GetUserTest {
    User user = new User();
    String url = DataManager.getTestData("Global.base_url") + Enums.EndPoints.USERS.get() +
            DataManager.getTestData("GetUserTest.user_number");
    @Test
    public void getUser() {
        ApiUtils.get(url);

        Assert.assertEquals(ApiUtils.getStatusCode(), Enums.StatusCodes.OK.get(), "Unexpected status code\n");
        Assert.assertEquals(JsonUtils.convertToJson(ApiUtils.getResponseBody()),
                            JsonUtils.convertToJson(JsonUtils.serialize(user)), "Unexpected response body\n");
    }
    @BeforeTest
    private void fillUserInfo() {
        user.setId(5);
        user.setName("Chelsey Dietrich");
        user.setUsername("Kamren");
        user.setPhone("(254)954-1289");

        Address address = new Address();
        address.setStreet("Skiles Walks");
        address.setSuite("Suite 351");
        address.setCity("Roscoeview");
        address.setZipcode("33263");

        Geo geo = new Geo();
        geo.setLat("-31.8129");
        geo.setLng("62.5342");

        address.setGeo(geo);
        user.setAddress(address);

        user.setEmail("Lucio_Hettinger@annie.ca");
        user.setWebsite("demarco.info");

        Company company = new Company();
        company.setName("Keebler LLC");
        company.setCatchPhrase("User-centric fault-tolerant solution");
        company.setBs("revolutionize end-to-end systems");

        user.setCompany(company);
    }
}
