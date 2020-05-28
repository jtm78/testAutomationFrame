package models.pet;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TagsData {
    private String name;

    private String id;

    @Override
    public String toString()
    {
        return "name = "+name+", id = "+id;
    }
}
