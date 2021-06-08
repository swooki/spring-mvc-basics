package com.kwonees.web.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kwonees.dao.DaoException;
import com.kwonees.dao.ProductDao;

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
		return "/WEB-INF/pages/show-products.jsp";
	}

}
