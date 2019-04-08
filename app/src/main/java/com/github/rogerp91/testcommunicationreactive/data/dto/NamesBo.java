package com.github.rogerp91.testcommunicationreactive.data.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by rpatino on mar/2019
 * Copyright (c) 2019, MercadoLibre S.R.L. All rights reserved.
 */
public class NamesBo {

 @SerializedName("name")
 private String name;
 @SerializedName("surname")
 private String surname;
 @SerializedName("gender")
 private String gender;
 @SerializedName("region")
 private String region;
 @SerializedName("age")
 private Integer age;
 @SerializedName("title")
 private String title;
 @SerializedName("phone")
 private String phone;
 @SerializedName("birthday")
 private BirthdayBo birthdayDto;
 @SerializedName("email")
 private String email;
 @SerializedName("password")
 private String password;
 @SerializedName("credit_card")
 private CreditCardBo creditCard;
 @SerializedName("photo")

 private String photo;

 public String getName() {
  return name;
 }

 public void setName(String name) {
  this.name = name;
 }

 public String getSurname() {
  return surname;
 }

 public void setSurname(String surname) {
  this.surname = surname;
 }

 public String getGender() {
  return gender;
 }

 public void setGender(String gender) {
  this.gender = gender;
 }

 public String getRegion() {
  return region;
 }

 public void setRegion(String region) {
  this.region = region;
 }

 public Integer getAge() {
  return age;
 }

 public void setAge(Integer age) {
  this.age = age;
 }

 public String getTitle() {
  return title;
 }

 public void setTitle(String title) {
  this.title = title;
 }

 public String getPhone() {
  return phone;
 }

 public void setPhone(String phone) {
  this.phone = phone;
 }

 public BirthdayBo getBirthday() {
  return birthdayDto;
 }

 public void setBirthday(BirthdayBo birthdayDto) {
  this.birthdayDto = birthdayDto;
 }

 public String getEmail() {
  return email;
 }

 public void setEmail(String email) {
  this.email = email;
 }

 public String getPassword() {
  return password;
 }

 public void setPassword(String password) {
  this.password = password;
 }

 public CreditCardBo getCreditCard() {
  return creditCard;
 }

 public void setCreditCard(CreditCardBo creditCard) {
  this.creditCard = creditCard;
 }

 public String getPhoto() {
  return photo;
 }

 public void setPhoto(String photo) {
  this.photo = photo;
 }
}
