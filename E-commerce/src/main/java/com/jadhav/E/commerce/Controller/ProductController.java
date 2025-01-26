package com.jadhav.E.commerce.Controller;

import com.jadhav.E.commerce.Model.Product;
import com.jadhav.E.commerce.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class ProductController {

    @Autowired
    private ProductService productService;
    @GetMapping("/products")
    public ResponseEntity<List<Product> >getProducts() {
        //(data,httpcode)
        return  new ResponseEntity<>(productService.getAllProducts(), HttpStatus.OK);

    }

    @GetMapping("/product/{id}")
    public ResponseEntity<Product>getProductById(@PathVariable int id)
    {

        Product product=productService.getProductById(id);
        if(product!=null)
           return new ResponseEntity<>(product,HttpStatus.OK);
        else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("product/{productId}/image")

    public ResponseEntity<byte[]>getImageByProductId(@PathVariable int productId)
    {
         Product product=productService.getProductById(productId);
         return  new ResponseEntity<>(product.getImageData(),HttpStatus.OK);
    }


    //rather than craeting two diff method just create one in service and call two times for update and save
    @PostMapping("/product")
    public ResponseEntity<?> addProduct(@RequestPart Product product,@RequestPart MultipartFile  imageFile) throws IOException {
        Product savedProduct= null;
        try {
            savedProduct = productService.addorUpdateProduct(product,imageFile);
            return new ResponseEntity<>(savedProduct,HttpStatus.CREATED);
        } catch (IOException e) {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/product/{id}")
    public ResponseEntity<String> updateProduct(@PathVariable int id,@RequestPart Product product,@RequestPart MultipartFile  imageFile)
    {
        Product updatedProduct=null;
        try{
            updatedProduct=productService.addorUpdateProduct(product,imageFile);
            return new ResponseEntity<>("Updated",HttpStatus.OK);
        }
        catch (IOException e)
        {
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/product/{id}")

    public ResponseEntity<String>deleteProduct(@PathVariable int id )
    {
        Product product=productService.getProductById(id);
        if(product!=null)
        {
            productService.deleteProduct(id);
            return new ResponseEntity<>("Deleted",HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/products/search")

    public ResponseEntity<List<Product>> searchProduct(@RequestParam String keyword)
    {
        List<Product> products=productService.searchProducts(keyword);
        System.out.println("searching with " +keyword);
        return new ResponseEntity<>(products,HttpStatus.OK);
    }
}
