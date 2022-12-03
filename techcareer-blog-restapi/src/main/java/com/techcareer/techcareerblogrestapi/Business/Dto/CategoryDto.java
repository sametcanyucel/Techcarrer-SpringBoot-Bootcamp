package com.techcareer.techcareerblogrestapi.Business.Dto;

import com.techcareer.techcareerblogrestapi.Entity.Blog;
import lombok.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class CategoryDto {
    private long categoryId;
    private String categoryName;
    private byte categoryStatus;

}
