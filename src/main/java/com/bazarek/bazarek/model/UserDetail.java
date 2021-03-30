package com.bazarek.bazarek.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name = "user_detail")
@NoArgsConstructor
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user_detail")
    private long id;

    @Column(name = "color_eyes")
    private String colorEyes;

    @Column(name = "color_hair")
    private String colorHair;

    @Column(name = "height")
    private double height;

    @Column(name = "special_characters")
    private String specialCharacters;

    @OneToOne(mappedBy = "userDetail",cascade = CascadeType.ALL)
    private User user;

    public UserDetail(String colorEyes, String colorHair, double height, String specialCharacters) {
        this.colorEyes = colorEyes;
        this.colorHair = colorHair;
        this.height = height;
        this.specialCharacters = specialCharacters;
    }

    public String getColorEyes() {
        return colorEyes;
    }

    public void setColorEyes(String colorEyes) {
        this.colorEyes = colorEyes;
    }

    public String getColorHair() {
        return colorHair;
    }

    public void setColorHair(String colorHair) {
        this.colorHair = colorHair;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public String getSpecialCharacters() {
        return specialCharacters;
    }

    public void setSpecialCharacters(String specialCharacters) {
        this.specialCharacters = specialCharacters;
    }

    @Override
    public String toString() {
        String result = "Szczególowy opis osoby - ";
        result+= "color oczu: " + colorEyes;
        result+= "color włosów: " + colorHair;
        result+= "wzrost: " + height;
        result+= "znaki szczególne: " + specialCharacters;
        return result;
    }
}
