package com.techcareer.techcareerblogclient.Controller;


import com.techcareer.techcareerblogclient.Model.CategoryModel;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Controller
public class CategoryController {
    @GetMapping("/categories")
    public String index(Model model) {
        RestTemplate templete = new RestTemplate();
        ResponseEntity<List> categoryresponse = templete.getForEntity("http://localhost:8080/api/category/", List.class);
        List<CategoryModel> categoryModels = categoryresponse.getBody();
        model.addAttribute("categories", categoryModels);
        return "categorieslist";
    }

    @GetMapping("/setpasive/{id}")
    public String delete(@PathVariable("id") long categoryID) {
        RestTemplate templete = new RestTemplate();
        ResponseEntity<String> Response = templete.exchange("http://localhost:8080/api/categorysetfalse/" + categoryID, HttpMethod.PUT, null, String.class);
        System.out.println(Response.getBody());
        return "redirect:/categories";
    }
    @GetMapping("/setactive/{id}")
    public String setActive(@PathVariable("id") long categoryID) {
        RestTemplate templete = new RestTemplate();
        ResponseEntity<String> Response = templete.exchange("http://localhost:8080/api/category/" + categoryID, HttpMethod.PUT, null, String.class);
        System.out.println(Response.getBody());
        return "redirect:/categories";
    }
    @GetMapping("/deletecategory/{id}")
    public String deleteCategory(@PathVariable("id") long categoryID) {
        RestTemplate templete = new RestTemplate();
        ResponseEntity<String> Response = templete.exchange("http://localhost:8080/api/category/" + categoryID, HttpMethod.DELETE, null, String.class);
        System.out.println(Response.getBody());
        return "redirect:/categories";
    }

    @GetMapping("/category/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new CategoryModel());
        return "categoryadd";
    }

    @PostMapping("/category/add")
    public String addCategory(@ModelAttribute("category") CategoryModel categoryModel) {
        HttpEntity<CategoryModel> request = new HttpEntity<CategoryModel>(categoryModel);
        RestTemplate templete = new RestTemplate();
        String Response = templete.postForObject("http://localhost:8080/api/category/add", request, String.class);


        return "redirect:/categories";
    }

}
