<%@page import="ufps.edu.co.dao.TiendaDAO"%>
<%@page import="ufps.edu.co.model.Tienda"%>
<%@page import="ufps.edu.co.dao.ServicioDAO"%>
<%@page import="java.util.List"%>
<%@page import="ufps.edu.co.model.Servicio"%>
<%
String tiendaid=request.getParameter("tiendaid");
TiendaDAO tdao=new TiendaDAO();
Tienda d=null;
for(Tienda tienda:tdao.list()){
	if(tienda.getId()==Integer.parseInt(tiendaid)){
	d=tienda;	
	}
}
List<Servicio> servicios=new ServicioDAO().list();
%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
	<title>Nuestra tienda virtual</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

	<link rel="stylesheet" type="text/css" href="css/card.css">
</head>
<body>

<section id="team" class="pb-5">
  <div class="container">
  <h5 class="section-title h1">SERVICIOS DE <%=d.getNombre()%></h5>


  <div class="row">
<%for(Servicio s:servicios){ 
	if(s.getTiendaBean().getId()==d.getId()){
%>
    <div class="col-lg-3 col-md-4 col-sm-6 mb-4">
      <div class="card h-100">
        <a href="#"><img class="card-img-top" src="http://placehold.it/700x400" alt=""></a>
        <div class="card-body">
          <h4 class="card-title">
            <a href="#"><%=s.getNombre()%></a>
          </h4>
          <p class="card-text"><%=s.getDescripcion()%></p>
        </div>
      </div>
    </div>
    <%}}%>
  </div>
  <!-- /.row -->

  <!-- Pagination -->
  <ul class="pagination justify-content-center">
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Previous">
            <span aria-hidden="true">&laquo;</span>
            <span class="sr-only">Anterior</span>
          </a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">1</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">2</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#">3</a>
    </li>
    <li class="page-item">
      <a class="page-link" href="#" aria-label="Next">
            <span aria-hidden="true">&raquo;</span>
            <span class="sr-only">Siguiente</span>
          </a>
    </li>
  </ul>

</div>
</section>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>