package cl.samueltoloza.challenge.controller;

import cl.samueltoloza.challenge.controller.hateoas.ProductModel;
import cl.samueltoloza.challenge.controller.hateoas.ProductModelAssembler;
import cl.samueltoloza.challenge.persistence.model.Product;
import cl.samueltoloza.challenge.persistence.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.PagedModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/products")
public class ProductController {

    @Autowired
    private IProductService service;
    @Autowired
    private ProductModelAssembler productModelAssembler;
    @Autowired
    private PagedResourcesAssembler<Product> pagedResourcesAssembler;

    @GetMapping("{sku}")
    public ResponseEntity<ProductModel> getProducBySku(@PathVariable("sku") String sku){
            return service.findBySku(sku)
                    .map(productModelAssembler::toModel)
                    .map(ResponseEntity::ok)
                    .orElse(ResponseEntity.notFound()
                    .build());
    }

    @GetMapping("/list")
    public ResponseEntity<PagedModel<ProductModel>> getAllProducts(Pageable pageable){
        Page<Product> productPage = service.findPaginated(pageable);
        PagedModel<ProductModel> pagedModel = pagedResourcesAssembler.toModel(productPage, productModelAssembler);
        return new ResponseEntity<>(pagedModel, HttpStatus.OK);
    }


    @GetMapping
    public ResponseEntity<CollectionModel<ProductModel>> getAllProducts(){
        List<Product> productsList = service.findAll();
        return new ResponseEntity<>(
                productModelAssembler.toCollectionModel(productsList),
                HttpStatus.OK
        );
    }
    @PostMapping
    public ResponseEntity<ProductModel> save(@RequestBody Product product){
        return new ResponseEntity<>(productModelAssembler.toModel(service.create(product)), HttpStatus.CREATED);
    }
    @PutMapping()
    public ResponseEntity<ProductModel> update(@RequestBody Product product){
        return new ResponseEntity<>(productModelAssembler.toModel(service.update(product)), HttpStatus.CREATED);
    }
    @DeleteMapping("{sku}")
    public ResponseEntity<?> delete(@PathVariable("sku") String sku){
        service.deleteBySku(sku);
        return  ResponseEntity.ok("Deleted");
    }

}
