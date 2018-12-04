package tests;

import com.github.javafaker.Faker;

public class DataFaker {
    private Faker faker;

    public DataFaker() {
        faker = new Faker();
    }

    public String getFakeFirstName(){ return faker.name().firstName(); }

    public String getFakeLastName(){ return faker.name().lastName(); }

    public String getFakeCity(){ return faker.address().cityName(); }

    public String getFakeStreet(){ return faker.address().streetName(); }

    public String getFakeZipCode() { return faker.address().zipCode(); }

    public String getFakeEmail(){ return faker.internet().emailAddress(); }

    public String getFakePassword(){ return faker.internet().password(); }

    public String getFakeMobilePhone() { return faker.phoneNumber().cellPhone(); }

}
