<%@ include file="./header.jspf"%>
<h2>${pageTitle}</h2>
<a href="./edit-product?id=${product.productId}" class="btn btn-primary">Edit</a>
<div class="row">
	<div class="col">
		<table class="table table-bordered table-striped">
			<tbody>
				<tr>
					<td>Id</td>
					<td>${product.productId}</td>
				</tr>
				<tr>
					<td>Name</td> 
					<td>${product.productName}</td>
				</tr>
				<tr>
					<td>Category</td>
					<td>${product.category.categoryName}</td>
				</tr>
				<tr>
					<td>Supplier</td>
					<td>${product.supplier.companyName}</td>
				</tr>
				<tr>
					<td>Unit Price</td>
					<td>${product.unitPrice}</td>
				</tr>
				<tr>
					<td>Quantity</td>
					<td>${product.quantityPerUnit}</td>
				</tr>
				<tr>
					<td>Stock</td>
					<td>${product.unitsInStock}</td>
				</tr>
				<tr>
					<td>Ordered</td>
					<td>${product.unitsOnOrder}</td>
				</tr>
				<tr>
					<td>Reorder</td>
					<td>${product.reorderLevel}</td>
				</tr>
				<tr>
					<td>Discontinued?</td>
					<td>${product.discontinued == 1 ? "Yes" : "No"}</td>
				</tr>
			</tbody>
		</table>


	</div>
	<div class="col"></div>
</div>
<%@ include file="./footer.jspf"%>
