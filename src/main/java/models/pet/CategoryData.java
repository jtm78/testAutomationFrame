package models.pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CategoryData {
    private int id;
    private String name;

    @Override
    public String toString()
    {
        return "name = "+name+", id = "+id;
    }
}
