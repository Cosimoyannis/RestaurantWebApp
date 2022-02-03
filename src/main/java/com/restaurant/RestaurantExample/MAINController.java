package com.restaurant.RestaurantExample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.security.oauth2.core.oidc.user.OidcUser;
import org.springframework.security.web.bind.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.List;


@Controller
public class MAINController {


    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductService productService;
    @Autowired
    private ProductServiceImpl productServiceImpl;



    @RequestMapping (
            method = RequestMethod.GET,
            path = "/products",
            produces = MediaType.APPLICATION_JSON_VALUE
    )



/*
    @GetMapping("/products")
    public List<Product> allProducts() {
        List<Product> myList = new ArrayList<>();
        productRepository.findAll().forEach(myList::add);
        return myList;

    }

 */



    @GetMapping("/products")
    public List<com.restaurant.RestaurantExample.Product> allProducts() {
        return productRepository.findAll();
    }


    @GetMapping("/listproducts")
    public String productsTable(@AuthenticationPrincipal OidcUser user, Model model) {
        List<com.restaurant.RestaurantExample.Product> products = productServiceImpl.findAll(user.getEmail());
        model.addAttribute("products", products);
        return "productstable";
    }

    @GetMapping("/createproduct")
    public String productForm(Model model) {
        model.addAttribute("product", new com.restaurant.RestaurantExample.Product());
        return "productcreation";
    }


    @GetMapping("/products/count")
    public Long count() {
        return productRepository.count();
    }


    @PostMapping("/products")
    public com.restaurant.RestaurantExample.Product createProduct(@RequestBody com.restaurant.RestaurantExample.Product product) {
        return productServiceImpl.save(product);
    }

    @PostMapping("/createproduct")
    public String productSubmit(@AuthenticationPrincipal OidcUser user, @ModelAttribute com.restaurant.RestaurantExample.Product product, Model model) {
        product.setOwner(user.getEmail());
        product.setCount(1);
        productServiceImpl.save(product);
        model.addAttribute("product", product);
        return "productresult";
    }

    @PostMapping("/products/{id}")
    public RedirectView delete(@PathVariable int id) {
        productServiceImpl.deleteById(id);
        return new RedirectView("/listproducts");
    }
}

