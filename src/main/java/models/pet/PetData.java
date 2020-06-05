package models.pet;

import lombok.Getter;

import java.math.BigInteger;
import java.util.List;

@Getter
public class PetData {
    private BigInteger id;

    private CategoryData category;
    
    private String name;

    private List<String> photoUrls;

    private List<TagsData> tags;

    private String status;

    public PetData setId(BigInteger id) {
        this.id = id;
        return this;
    }

    public PetData setCategory(CategoryData category) {
        this.category = category;
        return this;
    }

    public PetData setName(String name) {
        this.name = name;
        return this;
    }

    public PetData setPhotoUrls(List<String> photoUrls) {
        this.photoUrls = photoUrls;
        return this;
    }

    public PetData setTags(List<TagsData> tags) {
        this.tags = tags;
        return this;
    }

    public PetData setStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [photoUrls = "+photoUrls+"," +
                " name = "+ name +"," +
                " id = "+id+"," +
                " tags = "+ tags +"," +
                " status = "+status+
                "," + " category = "+category+"]";
    }
}
