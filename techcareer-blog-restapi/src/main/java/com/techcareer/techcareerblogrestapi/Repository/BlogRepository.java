package com.techcareer.techcareerblogrestapi.Repository;

import com.techcareer.techcareerblogrestapi.Entity.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BlogRepository extends JpaRepository<Blog,Long> {
    @Query("select b from Blog b where b.blogStatus=1 and b.category.categoryId=:categoryId")
    List<Blog> getBlogsByCategoryId(@Param("categoryId") long categoryId);
}
