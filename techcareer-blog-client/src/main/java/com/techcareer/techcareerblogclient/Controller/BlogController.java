package com.techcareer.techcareerblogclient.Controller;

import com.techcareer.techcareerblogclient.Helpers.FileUpload;
import com.techcareer.techcareerblogclient.Model.BlogModel;
import com.techcareer.techcareerblogclient.Model.CategoryModel;
import com.techcareer.techcareerblogclient.Model.FormModel.BlogFormModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Controller
public class BlogController {
    List<String> Uzantilar = new ArrayList<>();
    @GetMapping("/")
    public String index(Model model) {
        RestTemplate templete = new RestTemplate();
        ResponseEntity<List> blogresponse = templete.getForEntity("http://localhost:8080/api/blogs/active", List.class);
        List<BlogModel> blogModels = blogresponse.getBody();
        ResponseEntity<List> categoryresponse = templete.getForEntity("http://localhost:8080/api/categorybystatus/", List.class);
        List<CategoryModel> categoryModels = categoryresponse.getBody();

        model.addAttribute("blogs", blogModels);
        model.addAttribute("categories", categoryModels);
        return "index";
    }
    @GetMapping("/bloglist")
    public String blogList(Model model) {
        RestTemplate templete = new RestTemplate();
        ResponseEntity<List> blogresponse = templete.getForEntity("http://localhost:8080/api/blogs/", List.class);
        List<BlogModel> blogModels = blogresponse.getBody();
        ResponseEntity<List> categoryresponse = templete.getForEntity("http://localhost:8080/api/categorybystatus/", List.class);
        List<CategoryModel> categoryModels = categoryresponse.getBody();

        model.addAttribute("blogs", blogModels);
        model.addAttribute("categories", categoryModels);
        return "bloglist";
    }
    @GetMapping("/blog/{id}")
    public String getBlog(Model model, @PathVariable("id")long blogId) {
        RestTemplate templete = new RestTemplate();
        ResponseEntity<BlogModel> blogresponse = templete.getForEntity("http://localhost:8080/api/blog/"+blogId, BlogModel.class);
         BlogModel blogModel = blogresponse.getBody();
        ResponseEntity<List> categoryresponse = templete.getForEntity("http://localhost:8080/api/categorybystatus/", List.class);
        List<CategoryModel> categoryModels = categoryresponse.getBody();

        model.addAttribute("blog", blogModel);
        model.addAttribute("categories", categoryModels);
        return "blogcontent";
    }
    @GetMapping("/blogs/{id}")
    public String getBlogsByCategoryId(Model model, @PathVariable("id")long categoryId) {
        RestTemplate templete = new RestTemplate();
        ResponseEntity<List> blogresponse = templete.getForEntity("http://localhost:8080/api/blogs/"+categoryId, List.class);
        List<BlogModel> blogModels = blogresponse.getBody();
        ResponseEntity<List> categoryresponse = templete.getForEntity("http://localhost:8080/api/categorybystatus/", List.class);
        List<CategoryModel> categoryModels = categoryresponse.getBody();

        model.addAttribute("blogs", blogModels);
        model.addAttribute("categories", categoryModels);
        return "index";
    }


    @GetMapping("/blog/add")
    public String addBlog(Model model) {
        RestTemplate templete = new RestTemplate();

        ResponseEntity<List> categoryresponse = templete.getForEntity("http://localhost:8080/api/categorybystatus/", List.class);
        List<CategoryModel> categoryModels = categoryresponse.getBody();
        model.addAttribute("categories", categoryModels);
        model.addAttribute("blog", new BlogFormModel());
        return "blogadd";
    }

    @PostMapping("/blog/add")
    public String addBlog(@Valid @ModelAttribute("blog") BlogFormModel blogFormModel, @RequestParam("blogImages") MultipartFile file, BindingResult bindingResult) {
        String FileContentType = file.getContentType();
        Uzantilar.add("image/jpeg");
        Uzantilar.add("image/jpg");
        Uzantilar.add("image/png");
        if(bindingResult.hasErrors()){return "blogadd";}
        else {
        if (Uzantilar.contains(FileContentType) == true) {
            String name = UUID.randomUUID() + "." + FileContentType.replace("image/", "");
            FileUpload.SaveFile(name, "src/main/resources/static/img", file);
            BlogModel blogModel = new BlogModel();
            blogModel.setBlogStatus((byte) 1);
            blogModel.setBlogContent(blogFormModel.getBlogContent());
            blogModel.setBlogTittle(blogFormModel.getBlogTittle());
            blogModel.setBlogWriter(blogFormModel.getBlogWriter());
            blogModel.setCategoryId(blogFormModel.getCategoryId());
            blogModel.setCategoryName(blogFormModel.getCategoryName());
            blogModel.setBlogDate(blogFormModel.getBlogDate());
            blogModel.setBlogLongTittle(blogFormModel.getBlogLongTittle());
            blogModel.setBlogImages(name);
            HttpEntity<BlogModel> request = new HttpEntity<BlogModel>(blogModel);
            RestTemplate templete = new RestTemplate();
            String Response = templete.postForObject("http://localhost:8080/api/blog/add", request, String.class);
        }
        }
        return "redirect:/";
    }
        @GetMapping("/setblogactive/{id}")
    public String setActive(@PathVariable("id") long blogId) {
        RestTemplate templete = new RestTemplate();
        ResponseEntity<String> Response = templete.exchange("http://localhost:8080/api/blogstatusactive/" + blogId, HttpMethod.PUT, null, String.class);
        System.out.println(Response.getBody());
        return "redirect:/bloglist";
    }
    @GetMapping("/setblogpassive/{id}")
    public String setPassive(@PathVariable("id") long blogId) {
        RestTemplate templete = new RestTemplate();
        ResponseEntity<String> Response = templete.exchange("http://localhost:8080/api/blogstatuspassive/" + blogId, HttpMethod.PUT, null, String.class);
        System.out.println(Response.getBody());
        return "redirect:/bloglist";
    }

}
