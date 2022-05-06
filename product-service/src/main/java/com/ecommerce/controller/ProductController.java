package com.ecommerce.controller;

import com.ecommerce.error.ApiError;
import com.ecommerce.exception.ResourceNotFoundException;
import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/product")
public class ProductController {

    @Autowired
    ProductService productService;

    @Operation(summary = "Retrieve Product by Id", description = "Retrieve Product by Id", responses = {
            @ApiResponse(responseCode = "200", description = "Ok", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = Product.class)), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ApiError.class)), mediaType = "application/json") }),
            @ApiResponse(responseCode = "401", description = "Unathorized - Not Authorized", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ApiError.class)), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ApiError.class)), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ApiError.class)), mediaType = "application/json") }) })

    @GetMapping("/{productId}")
    ResponseEntity<Product> getProductById(@PathVariable("productId") Long productId) throws ResourceNotFoundException {
        log.info("Product Id : {}", productId);
        Product product = productService.getProductById(productId);
        return new ResponseEntity<Product>(product, new HttpHeaders(), HttpStatus.OK);
    }

    @Operation(summary = "Retrieve all Product", description = "Retrieve all Product", responses = {
            @ApiResponse(responseCode = "200", description = "Ok", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = Product.class)), mediaType = "application/json") }),
            @ApiResponse(responseCode = "400", description = "Bad Request", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ApiError.class)), mediaType = "application/json") }),
            @ApiResponse(responseCode = "401", description = "Unathorized - Not Authorized", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ApiError.class)), mediaType = "application/json") }),
            @ApiResponse(responseCode = "404", description = "Product not found", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ApiError.class)), mediaType = "application/json") }),
            @ApiResponse(responseCode = "500", description = "Internal Server Error", content = {
                    @Content(array = @ArraySchema(schema = @Schema(implementation = ApiError.class)), mediaType = "application/json") }) })

    @GetMapping("/")
    ResponseEntity<List<Product>> getAllProduct() throws ResourceNotFoundException {
        List<Product> productList = productService.getAllProducts();
        return new ResponseEntity<List<Product>>(productList, new HttpHeaders(), HttpStatus.OK);
    }
}
