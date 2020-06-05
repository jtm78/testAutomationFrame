package models.pet;

import lombok.Getter;
import lombok.Setter;

import java.math.BigInteger;

@Getter
@Setter
public class CategoryData {
    private BigInteger id;
    private String name;

    @Override
    public String toString()
    {
        return "name = "+name+", id = "+id;
    }
}
