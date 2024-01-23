package com.example.demo.controllers;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.service.PartService;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 *
 *
 *
 *
 */

@Controller
public class MainScreenControllerr {
   // private final PartRepository partRepository;
   // private final ProductRepository productRepository;'

    private PartService partService;
    private ProductService productService;

    private List<Part> theParts;
    private List<Product> theProducts;

 /*   public MainScreenControllerr(PartRepository partRepository, ProductRepository productRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
    }*/

    public MainScreenControllerr(PartService partService,ProductService productService){
        this.partService=partService;
        this.productService=productService;
    }
    @GetMapping("/mainscreen")
    public String listPartsandProducts(Model theModel, @Param("partkeyword") String partkeyword, @Param("productkeyword") String productkeyword){
        //add to the sprig model
        List<Part> partList=partService.listAll(partkeyword);
        List<Product> productList=productService.listAll(productkeyword);

        //add sample parts and products inventory if list is empty
        if(partList.size()==0 && productList.size()==0){
            long samplePartID1 = addInhouseSamplePart("sample Sedan body", 35000, 50, 1,0,100);
            long samplePartID2 = addInhouseSamplePart("sample SUV body", 45000, 30, 2,0,100);
            long samplePartID3 = addInhouseSamplePart("sample battery", 10000, 100, 3,0,100);
            long samplePartID4 = addOutsourcedSamplePart("sample basic interior", 10000, 80, "sample Hyundai",0,100);
            long samplePartID5 = addOutsourcedSamplePart("sample premium interior", 25000, 40, "sample Lucid",0,100);

            long sampleProduct1 = addSampleProduct("sample Model 3",57000, 20,samplePartID1,samplePartID3,samplePartID4);
            long sampleProduct2 = addSampleProduct("sample Model S",73000, 10,samplePartID1,samplePartID3,samplePartID5);
            long sampleProduct3 = addSampleProduct("sample Model Y",67000, 15,samplePartID2,samplePartID3,samplePartID4);
            long sampleProduct4 = addSampleProduct("sample Model X",83000, 5,samplePartID2,samplePartID3,samplePartID5);
            long sampleProduct5 = addSampleProduct("sample Model 3 no battery",47000, 10,samplePartID1,0,samplePartID4);
        }

        partList=partService.listAll(partkeyword);
        theModel.addAttribute("parts",partList);
        theModel.addAttribute("partkeyword",partkeyword);
    //    theModel.addAttribute("products",productService.findAll());
        productList=productService.listAll(productkeyword);
        theModel.addAttribute("products", productList);
        theModel.addAttribute("productkeyword",productkeyword);

        return "mainscreen";
    }
    public long addInhouseSamplePart(String name, double price, int inv, int partID,int min,int max){
        InhousePart samplePart = new InhousePart();
        samplePart.setName(name);
        samplePart.setPrice(price);
        samplePart.setInv(inv);
        samplePart.setPartId(partID);
        samplePart.setMin(min);
        samplePart.setMax(max);
        partService.save(samplePart);
        return samplePart.getId();
    }

    public long addOutsourcedSamplePart(String name, double price, int inv, String company, int min, int max){
        OutsourcedPart samplePart = new OutsourcedPart();
        samplePart.setName(name);
        samplePart.setPrice(price);
        samplePart.setInv(inv);
        samplePart.setCompanyName(company);
        samplePart.setMin(min);
        samplePart.setMax(max);
        partService.save(samplePart);
        return samplePart.getId();
    }

    public long addSampleProduct(String name, double price, int inv, long part1, long part2, long part3){
        Product sampleProduct = new Product(name,price,inv);

        if(part1!=0)sampleProduct.getParts().add(partService.findById((int) part1));
        if(part2!=0)sampleProduct.getParts().add(partService.findById((int) part2));
        if(part3!=0)sampleProduct.getParts().add(partService.findById((int) part3));
        productService.save(sampleProduct);

        for (Part p : sampleProduct.getParts()){
            p.getProducts().add(productService.findById((int)sampleProduct.getId()));
            int pInv = p.getInv();
            p.setInv(pInv - sampleProduct.getInv());
            partService.save(p);
        }
        return sampleProduct.getId();
    }
}
