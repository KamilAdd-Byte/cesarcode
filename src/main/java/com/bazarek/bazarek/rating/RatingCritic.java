package com.bazarek.bazarek.rating;

import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Getter
public class RatingCritic extends Rating{

    private double criticRate;

    public RatingCritic(String description, boolean isWatch, double criticRate) {
        super(description, isWatch);
        this.criticRate = criticRate;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " critic opinion";
    }

    @Override
    public double addRating(double rating) {
        if (rating <= 10){
            criticRate += rating;
            return criticRate;
        }else {
            System.out.println("Opnia musi być mniejsza lub równa 10");
            return 0.0;
        }
    }

    @Override
    public String toString() {
        return "Critic rate: " + criticRate +
                " " + super.toString();
    }
}
