package com.kwonees.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kwonees.dao.DaoException;
import com.kwonees.dao.ProductDao;
import com.kwonees.entity.Product;

@Controller
public class ProductController {
	@Autowired
	ProductDao htDao;

	public ProductController() {
		System.out.println("ProductController instantiated");
	}

	@RequestMapping(method = RequestMethod.GET, path = "/all-products")
	public String getAllProducts(Model model) throws DaoException {
		System.out.println("ProductController.getAllProducts() called");
		model.addAttribute("pageTitle", "All products");
		model.addAttribute("products", htDao.getAllProducts());
		return "show-products";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/products-by-price-range")
	public String getProductsByPriceRange(Model model, @RequestParam Double min, @RequestParam Double max)
			throws DaoException {
		System.out.println("getProductsByPriceRange() called");
		model.addAttribute("pageTitle", "Products priced between $" + min + " and $" + max);
		model.addAttribute("products", htDao.getProductsByPriceRange(min, max));
		return "show-products";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/product-details")
	public String getProductDetails(Model model, @RequestParam Integer id) throws DaoException {
		System.out.println("getProduct() called");
		model.addAttribute("product", htDao.getProduct(id));
		model.addAttribute("pageTitle", "Products Details - " + id);

		return "product-details";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/add-product")
	public String addProduct(Model model) throws DaoException {
		System.out.println("addProduct() called");
//		Product product = htDao.getProduct(66);
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("pageTitle", "Add New Product");

		return "product-form";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/save-product")
	public String saveProduct(Model model, Product product) throws DaoException {
		System.out.println("saveProduct() called");
		htDao.addProduct(product); 
		return "redirect:product-details?id=" + product.getProductId();
	}
}
