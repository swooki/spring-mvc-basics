package com.kwonees.web.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kwonees.dao.DaoException;
import com.kwonees.dao.ProductDao;
import com.kwonees.entity.Category;
import com.kwonees.entity.Product;
import com.kwonees.entity.Supplier;
import com.kwonees.validators.ProductValidator;

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
		Product product = new Product();
		model.addAttribute("product", product);
		model.addAttribute("categories", htDao.getAllCategories());
		model.addAttribute("suppliers", htDao.getAllSuppliers());
		model.addAttribute("pageTitle", "Add New Product");

		return "product-form";
	}

	@ModelAttribute("categories")
	public List<Category> getCategoryList() throws DaoException {
		return htDao.getAllCategories();
	}

	@ModelAttribute("suppliers")
	public List<Supplier> getSupplyList() throws DaoException {
		return htDao.getAllSuppliers();
	}

	@RequestMapping(method = RequestMethod.POST, path = "/save-product")
	public String saveProduct(@ModelAttribute("product") Product product, BindingResult errors) throws DaoException {

		ProductValidator pv = new ProductValidator();
		pv.validate(product, errors);
		
		
		if (errors.hasErrors()) {
			return "product-form";
		}

		htDao.addProduct(product);
		return "redirect:product-details?id=" + product.getProductId();
	}
}
