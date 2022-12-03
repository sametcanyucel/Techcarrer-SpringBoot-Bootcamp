package com.techcareer.techcareerblogrestapi.Business.Dto;


import lombok.*;


@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BlogDto {
    private long blogId;
    private String blogWriter;
    private String blogDate;
    private String blogTittle;
    private String blogLongTittle;
    private String blogContent;
    private String blogImages;
    private byte blogStatus;
    private long categoryId;
    private String categoryName;
}
