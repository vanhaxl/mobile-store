<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <title>Mobile store</title>
    <link rel="shortcut icon" type="image/png" href="images/favorite.png"/>

    <!-- Bootstrap core CSS -->
    <link href="js/bootstrap/css/bootstrap.css" rel="stylesheet">
	<link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="css/shop-homepage.css" rel="stylesheet">
	<script src="js/jquery/jquery.min.js"></script>
    <script src="js/app/home.js"></script>
  </head>

  <body>

    <jsp:include page="WEB-INF/jsp/component/header.jsp"></jsp:include>
    <!-- Page Content -->
    <div class="container">

      <div class="row">

        <div class="col-lg-3 my-4">
			<div class="list-group" id="categories">
			</div>
			<form id="searchForm">
				<div class="input-group mb-3 search-panel">
				  <input type="text" class="form-control" placeholder="Search" aria-label="Recipient's username" aria-describedby="basic-addon2" id="search">
				  <div class="input-group-append">
				    <button class="btn btn-outline-secondary" type="submit" id="btnSearch"><span class="fa fa-search"></span></button>
				  </div>
				</div>
			</form>
        </div>
        <!-- /.col-lg-3 -->

        <div class="col-lg-9">

          <div id="carouselExampleIndicators" class="carousel slide my-4" data-ride="carousel">
            <div class="carousel-inner" role="listbox" id="categoryCover">
            </div>
            <a class="carousel-control-prev" href="#carouselExampleIndicators" role="button" data-slide="prev">
              <span class="carousel-control-prev-icon" aria-hidden="true"></span>
              <span class="sr-only">Previous</span>
            </a>
            <a class="carousel-control-next" href="#carouselExampleIndicators" role="button" data-slide="next">
              <span class="carousel-control-next-icon" aria-hidden="true"></span>
              <span class="sr-only">Next</span>
            </a>
          </div>

          <div class="row" id="products">
          </div>
          <!-- /.row -->

        </div>
        <!-- /.col-lg-9 -->

      </div>
      <!-- /.row -->

    </div>
    <!-- /.container -->

    <jsp:include page="WEB-INF/jsp/component/footer.jsp"></jsp:include>
    
  </body>
</html>
