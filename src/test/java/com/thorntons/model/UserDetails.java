package com.thorntons.model;


import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;
import java.util.Map;

public class UserDetails {

    public UserDetails generateUniqueUser(){
        setCountry("United Kingdom");
        setFirstName("John");
        setLastName("Smith");
        setAddress1("10 test road");
        setCity("London");
        setPostalCode("SE5 8LT");
        setPhone("07000000000");
        setEmail(String.format("test%s@testuser.com", System.nanoTime()));
        setPassword("password");
        return this;
    }

    @JsonProperty("country")
    private String country;
    @JsonProperty("first_name")
    private String firstName;
    @JsonProperty("last_name")
    private String lastName;
    @JsonProperty("address1")
    private String address1;
    @JsonProperty("city")
    private String city;
    @JsonProperty("postal_code")
    private String postalCode;
    @JsonProperty("phone")
    private String phone;
    @JsonProperty("email")
    private String email;
    @JsonProperty("billing")
    private String billing;
    @JsonProperty("gift")
    private String gift;
    private String password;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    /**
     *
     * @return
     * The country
     */
    @JsonProperty("country")
    public String getCountry() {
        return country;
    }

    /**
     *
     * @param country
     * The country
     */
    @JsonProperty("country")
    public void setCountry(String country) {
        this.country = country;
    }

    /**
     *
     * @return
     * The firstName
     */
    @JsonProperty("first_name")
    public String getFirstName() {
        return firstName;
    }

    /**
     *
     * @param firstName
     * The first_name
     */
    @JsonProperty("first_name")
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     *
     * @return
     * The lastName
     */
    @JsonProperty("last_name")
    public String getLastName() {
        return lastName;
    }

    /**
     *
     * @param lastName
     * The last_name
     */
    @JsonProperty("last_name")
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     *
     * @return
     * The address1
     */
    @JsonProperty("address1")
    public String getAddress1() {
        return address1;
    }

    /**
     *
     * @param address1
     * The address1
     */
    @JsonProperty("address1")
    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    /**
     *
     * @return
     * The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     *
     * @param city
     * The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     *
     * @return
     * The postalCode
     */
    @JsonProperty("postal_code")
    public String getPostalCode() {
        return postalCode;
    }

    /**
     *
     * @param postalCode
     * The postal_code
     */
    @JsonProperty("postal_code")
    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *
     * @return
     * The phone
     */
    @JsonProperty("phone")
    public String getPhone() {
        return phone;
    }

    /**
     *
     * @param phone
     * The phone
     */
    @JsonProperty("phone")
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     *
     * @return
     * The email
     */
    @JsonProperty("email")
    public String getEmail() {
        return email;
    }

    /**
     *
     * @param email
     * The email
     */
    @JsonProperty("email")
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     *
     * @return
     * The billing
     */
    @JsonProperty("billing")
    public String getBilling() {
        return billing;
    }

    /**
     *
     * @param billing
     * The billing
     */
    @JsonProperty("billing")
    public void setBilling(String billing) {
        this.billing = billing;
    }

    /**
     *
     * @return
     * The gift
     */
    @JsonProperty("gift")
    public String getGift() {
        return gift;
    }

    /**
     *
     * @param gift
     * The gift
     */
    @JsonProperty("gift")
    public void setGift(String gift) {
        this.gift = gift;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}