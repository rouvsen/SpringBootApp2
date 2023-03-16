package com.rouvsen.tutorials.controller;

import com.rouvsen.tutorials.dto.ProductDto;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ThymeleafController {

    @GetMapping("/thymeleaf1")
//    @ResponseBody
    public String getThymeleaf1() {
        return "thymeleaf1";
    }

    @GetMapping("/thymeleaf2")
    public String getThymeleaf2() {
        return "thymeleaf2";
    }

    @GetMapping("thymeleaf3")
    public String getThymeleaf3(Model model) {
        model.addAttribute("key_model1", "Ben Modelden geldim 1");
        model.addAttribute("key_model2", "Ben Modelden geldim 2");
        return "thymeleaf_file/thymeleaf3";
    }

    //Model Value gondermek
    @GetMapping("thymeleaf4")
    public String getThymeleaf4(Model model) {
        model.addAttribute("key_model1", "Ben Modelden geldim 1");
        model.addAttribute("key_model2", "Ben Modelden geldim 2");
        return "thymeleaf4";
    }

    //Model Object gondermek
    @GetMapping("thymeleaf5")
    public String getThymeleaf5ModelObject(Model model) {

        model.addAttribute("key_model1", "text");

        ProductDto product1 = ProductDto
                .builder()
                .productId(1L)
                .productName("Product Name 1")
                .productPrice(2500)
                .build();

        model.addAttribute("key_model2", product1);

        return "thymeleaf5";
    }

    //Model List gondermek
    @GetMapping("thymeleaf6")
    public String getThymeleaf6ModelObjectList(Model model) {

        model.addAttribute("key_model1", "text");

        List<ProductDto> productList = new ArrayList<>();
        productList.add(ProductDto.builder().productId(1L).productName("Product Name 1").productPrice(1500).build());
        productList.add(ProductDto.builder().productId(2L).productName("Product Name 2").productPrice(2500).build());
        productList.add(ProductDto.builder().productId(3L).productName("Product Name 3").productPrice(3500).build());
        productList.add(ProductDto.builder().productId(4L).productName("Product Name 4").productPrice(4500).build());

        model.addAttribute("productList", productList);

        return "thymeleaf6";
    }

    @GetMapping({"/", "/index"})
    public String getThymeleafIndex(Model model) {
            model.addAttribute("key_model1", "index Sayfamiz");
        return "index";
    }

    //PathVariable(name=""), optional {"/","/index"}, PathVariable ==> default olaraq 'required=true'
    @GetMapping({"/thymeleaf7", "/thymeleaf7/{id}"})
    public String getThymeleaf7ModelObject(Model model, @PathVariable(name = "id", required = false) Long id) {
        if (id != null)
            model.addAttribute("key_model1", "id: " + id);
        else
            model.addAttribute("key_model1", "id bulunamadi");
        return "thymeleaf7";
    }

    @GetMapping({"/thymeleaf77", "/thymeleaf77/{id}/{name}"})
    public String getThymeleaf7ModelObject2(Model model,
                                           @PathVariable(name = "id", required = false) Long id,
                                           @PathVariable(name = "name", required = false) String name) {
        if (id != null)
            model.addAttribute("key_model1", "id: " + id + ", name: " + name);
        else
            model.addAttribute("key_model1", "id bulunamadi");
        return "thymeleaf7";
    }

    //RequestParam(name=""), optional {"/","/index"}, RequestParam ==> default olaraq 'required=true'
    @GetMapping("/thymeleaf8")
    public String getThymeleaf8ModelObject(Model model,
                                           @RequestParam(name = "id", required = false, defaultValue = "0") Long id,
                                           @RequestParam(name = "name", required = false, defaultValue = "(Default Name)") String name
    ) {
        if (Integer.parseInt(String.valueOf(id)) == 0 && name ==null)
            model.addAttribute("key_model1", "You didn't enter id, however default id: " + id + ", Name Didn't entered: Default name");
        else if (Integer.parseInt(String.valueOf(id)) == 0 && name !=null)
            model.addAttribute("key_model1", "You didn't enter id, however default id: " + id + ", name: " + name);
        else if (Integer.parseInt(String.valueOf(id)) != 0 && name ==null)
            model.addAttribute("key_model1", "your entered id: " + id + ", Name Didn't entered: Default name");
        else
            model.addAttribute("key_model1", "your entered id: " + id + ", name: " + name);
        return "thymeleaf8";
    }

}