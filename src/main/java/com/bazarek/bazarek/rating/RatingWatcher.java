package com.bazarek.bazarek.rating;

import com.bazarek.bazarek.db.model.Movie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Getter
@Setter
public class RatingWatcher extends Rating {

    private double watcherRate;
    private Movie movie;

    public RatingWatcher(boolean isWatch, double watcherRate) {
        super(isWatch);
        this.watcherRate = watcherRate;
    }

    public RatingWatcher(String description, boolean isWatch, double watcherRate) {
        super(description, isWatch);
        this.watcherRate = watcherRate;
    }

    @Override
    public String getDescription() {
        return super.getDescription()  + " - watcher opinion";
    }

    @Override
    public String toString() {
        return "Watcher rate: " + watcherRate +
                " " + super.toString();
    }

    @Override
    public double addRating(double rating) {
        if (rating <= 10){
            watcherRate += rating;
            return watcherRate;
        }else {
            System.out.println("Opnia musi być mniejsza lub równa 10");
            return 0.0;
        }
    }
}
