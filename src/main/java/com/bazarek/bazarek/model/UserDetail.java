package com.bazarek.bazarek.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof UserDetail)) return false;
        UserDetail that = (UserDetail) o;
        return id == that.id && Double.compare(that.height, height) == 0 && Objects.equals(colorEyes, that.colorEyes) && Objects.equals(colorHair, that.colorHair) && Objects.equals(specialCharacters, that.specialCharacters) && Objects.equals(user, that.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, colorEyes, colorHair, height, specialCharacters, user);
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
