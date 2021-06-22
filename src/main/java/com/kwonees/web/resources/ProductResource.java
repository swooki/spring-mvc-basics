package com.kwonees.web.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.kwonees.dao.DaoException;
import com.kwonees.dao.ProductDao;
import com.kwonees.entity.ErrorResponse;
import com.kwonees.entity.Product;
import com.kwonees.entity.ProductList;

@RequestMapping("/api/products")
@RestController
public class ProductResource {

	@Autowired
	ProductDao htDao;

	@RequestMapping(method = RequestMethod.GET, 
			produces= {"application/json", "application/xml"})
	public ResponseEntity<ProductList> getAllProducts() throws DaoException {
		ProductList pl = new ProductList();
		pl.setProducts(htDao.getAllProducts());
		return ResponseEntity.ok(pl);
	}

	@RequestMapping(path = "/{id}", method = RequestMethod.GET, 
			produces= {"application/json", "application/xml"})
	public ResponseEntity<?> getProductById(@PathVariable("id") Integer id) throws DaoException {
		Product pr = htDao.getProduct(id);
		if (pr == null) {
			ErrorResponse er = new ErrorResponse();
			er.setMessage("No product found!");
			er.setData(id);
			return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
		}
		return ResponseEntity.ok(pr);
	}

	@RequestMapping(method = RequestMethod.POST,
			produces= {"application/json", "application/xml"},
			consumes= {"application/json", "application/xml"})
	public ResponseEntity<?> addProduct(@RequestBody Product pr) {
		try {
			htDao.addProduct(pr);
			pr = htDao.getProduct(pr.getProductId());
			return ResponseEntity.ok(pr);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ErrorResponse er = new ErrorResponse();
			er.setMessage(e.getMessage());
			er.setData( pr );
			return new ResponseEntity<>(pr, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}",
			produces= {"application/json", "application/xml"},
			consumes= {"application/json", "application/xml"})
	public ResponseEntity<?> updateProduct(@PathVariable("id") Integer id, @RequestBody Product pr) {
		try {
			pr.setProductId(id);
			htDao.updateProduct(pr);
			return ResponseEntity.ok(pr);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ErrorResponse er = new ErrorResponse();
			er.setMessage(e.getMessage());
			er.setData( pr );
			return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}",
			produces= {"application/json", "application/xml"})
	public ResponseEntity<?> deleteProduct(@PathVariable("id") Integer id) {
		try {
			Product pr = htDao.getProduct(id);
			if (pr == null) {
				ErrorResponse er = new ErrorResponse();
				er.setMessage("No product found!");
				er.setData( id );
				return new ResponseEntity<>(er, HttpStatus.NOT_FOUND);
			}

			htDao.deleteProduct(id);
			pr = htDao.getProduct(id);
			return ResponseEntity.ok(pr);
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			ErrorResponse er = new ErrorResponse();
			er.setMessage(e.getMessage());
			er.setData( id );
			return new ResponseEntity<>(er, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
