<%@ include file="./header.jspf"%>
<h2 class="text-danger">Oops! There was an error while processing
	your request</h2>
<p>
	Please retry after a while, and if the error persists, please write to
	<a href="mailto:helpdesk@kwonees.com">helpdesk@kwonees.com.</a></p>

	<button class="btn btn-link" onclick="showErrorDetails()">Show
		technical details</button>
<pre style="visibility: hidden" id="errDetails">
	<%
	Exception ex = (Exception) request.getAttribute("ex");
	ex.printStackTrace(new java.io.PrintWriter(out));
	%>
</pre>
<%@ include file="./footer.jspf"%>

<script>
	function showErrorDetails() {
		document.getElementById("errDetails").style.visibility = "visible";
	}
</script>