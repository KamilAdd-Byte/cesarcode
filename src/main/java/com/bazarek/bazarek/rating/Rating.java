package com.bazarek.bazarek.rating;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public abstract class Rating implements RatingOperations{
    private String description;
    private boolean isWatch;

    public Rating(boolean isWatch) {
        this.isWatch = isWatch;
    }

    @Override
    public String toString() {
        return "Opinia '" + description
                + "', oglądał: " + isWatch;
    }
}
