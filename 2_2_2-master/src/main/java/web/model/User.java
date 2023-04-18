package web.model;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull(message = "Name may not be null")
    @Size(min = 2, max = 20, message = "Name must be between 2 and 20 characters")
    private String model;

    @NotNull(message = "Name may not be null")
    @Digits(integer=2, message="Age should be a number with up to 3 digits", fraction=0)
    @Positive(message="Price must be positive")
    private int series;

    @NotNull(message = "Name may not be null")
    @Size(min = 2, max = 15, message = "Name must be between 2 and 15 characters")
    private String color;


    public User() {
    }

    public User(String model, int series, String color) {
        this.model = model;
        this.series = series;
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getSeries() {
        return series;
    }

    public void setSeries(int series) {
        this.series = series;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return getSeries() == user.getSeries() && Objects.equals(getModel(), user.getModel()) && Objects.equals(getColor(), user.getColor());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getModel(), getSeries(), getColor());
    }
}

