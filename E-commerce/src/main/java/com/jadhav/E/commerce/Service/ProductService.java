package com.jadhav.E.commerce.Service;

import com.jadhav.E.commerce.Model.Product;
import com.jadhav.E.commerce.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepo productRepo;
    public List<Product> getAllProducts() {
      return productRepo.findAll();
    }


    public Product getProductById(int id) {
        return productRepo.findById(id).orElse(null);
    }

    //rather than craeting two diff method just create one in service and call two times for update and save
    public Product addorUpdateProduct(Product product, MultipartFile image) throws IOException {
        product.setImageName(image.getOriginalFilename());
        product.setImageType(image.getContentType());
        product.setImageData(image.getBytes());
        return productRepo.save(product);
    }


    public void deleteProduct(int id) {
         productRepo.deleteById(id);
    }

    public List<Product> searchProducts(String keyword) {

        return productRepo.searchProducts(keyword);

    }

}
