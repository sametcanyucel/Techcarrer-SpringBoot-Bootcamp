package com.techcareer.techcareerblogrestapi.Entity;
import lombok.*;
import javax.persistence.*;

@Data
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Blog {
@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long blogId;
    private String blogWriter;
    private String blogDate;
    private String blogTittle;
    private String blogLongTittle;

    private String blogContent;
    private String blogImages;
    private byte blogStatus;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}


