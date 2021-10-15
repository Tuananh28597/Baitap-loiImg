package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final IProductService productService = new ProductService();

    @Value("${file-upload}")
    private String fileUpload;

    @GetMapping("")
    public String index(Model model){
        List<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "/index";
    }

    @GetMapping("/create")
    public String create(Model model){
        model.addAttribute("productForm", new ProductForm());
        return "/create";
    }

    @PostMapping("/save")
    public ModelAndView createProduct(@ModelAttribute ProductForm productForm){
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(productForm.getImage().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product(productForm.getId(),productForm.getName(),
                productForm.getColor(),productForm.getPrice(),fileName);
        productService.save(product);
        ModelAndView modelAndView = new ModelAndView("/create");
        modelAndView.addObject("productForm",productForm);
        modelAndView.addObject("message", "Create new product successfully !");
        return modelAndView;

    }


    @GetMapping("/{id}/edit")
    public String edit(@PathVariable int id, Model model){
        model.addAttribute("product",productService.findById(id));
        return "edit";
    }

    @PostMapping("/update")
    public String update(Product product){
        productService.update(product.getId(), product);
        return "redirect:/product";
    }


    @GetMapping("/{id}/delete")
    public String delete(@PathVariable int id){
        productService.remove(id);
        return "redirect:/product";
    }


    @GetMapping("/{id}/view")
    public String view(@PathVariable int id,Model model){
        model.addAttribute("product",productService.findById(id));
        return "view";
    }










}
