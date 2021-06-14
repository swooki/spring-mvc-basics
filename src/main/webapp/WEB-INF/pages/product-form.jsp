<%@ include file="./header.jspf"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="sf"%>

<h2>${pageTitle}</h2>

<div class="row">
	<div class="col">
		<sf:form modelAttribute="product" action="save-product">
			<div class="form-group row">
				<label class="col-md-4" for="productName"> Product Name</label>
				<div class="col-md-8">
					<sf:input path="productName" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="categoryId"> Category</label>
				<div class="col-md-8">
					<sf:input path="categoryId" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="supplierId"> Supplier</label>
				<div class="col-md-8">
					<sf:input path="supplierId" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="unitPrice"> Unit Price</label>
				<div class="col-md-8">
					<sf:input path="unitPrice" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="quantityPerUnit"> Quantity Per
					Unit</label>
				<div class="col-md-8">
					<sf:input path="quantityPerUnit" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="unitsInStock"> Units in stock</label>
				<div class="col-md-8">
					<sf:input path="unitsInStock" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="unitsOnOrder"> Units on order</label>
				<div class="col-md-8">
					<sf:input path="unitsOnOrder" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="reorderLevel"> Reorder Level</label>
				<div class="col-md-8">
					<sf:input path="reorderLevel" cssClass="form-control" />
				</div>
			</div>
			<div class="form-group row">
				<label class="col-md-4" for="discontinued"> Discontinued</label>
				<div class="col-md-8">
					<label> <sf:radiobutton path="discontinued" value="1"/> Yes</label>
					<label> <sf:radiobutton path="discontinued" value="0"/> No</label>
				</div>
			</div>
			<div class="form-group row">
				<div class="col-md-4"></div>
				<div class="col-md-8">
					<sf:button class="btn btn-primary">Submit Changes</sf:button>
				</div>
			</div>
		</sf:form>
	</div>
	<div class="col"></div>
</div>
<%@ include file="./footer.jspf"%>
