<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>Liquor Store - Free Bootstrap 4 Template by Colorlib</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap" rel="stylesheet">

    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/css/bootstrap-select.min.css">
    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/style.css">
  </head>
  <body>

  	<div class="wrap">
			<div class="container">
				<div class="row">
					<div class="col-md-6 d-flex align-items-center">
						<p class="mb-0 phone pl-md-2">
							<a href="#" class="mr-2"><span class="fa fa-phone mr-1"></span> +00 1234 567</a> 
							<a href="#"><span class="fa fa-paper-plane mr-1"></span> youremail@email.com</a>
						</p>
					</div>
					<div class="col-md-6 d-flex justify-content-md-end">
						<div class="social-media mr-4">
			    		<p class="mb-0 d-flex">
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-facebook"><i class="sr-only">Facebook</i></span></a>
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-twitter"><i class="sr-only">Twitter</i></span></a>
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-instagram"><i class="sr-only">Instagram</i></span></a>
			    			<a href="#" class="d-flex align-items-center justify-content-center"><span class="fa fa-dribbble"><i class="sr-only">Dribbble</i></span></a>
			    		</p>
		        </div>
		       <c:choose>
		        <c:when test="${nowuser!=null }"><!-- 로그인이완료가되면 -->
		        <div class="reg">
		        	<p class="mb-0"><span class="mr-2">${nowuser} 님</span> <a href="MemberServlet.do?command=Logout">Log out</a></p>
		        </div>
		        </c:when>
		        <c:otherwise>
		        <div class="reg">
		        	<p class="mb-0"><a href="MemberServlet.do?command=useradd_view" class="mr-2">Sign Up</a> <a href="MemberServlet.do?command=Login_view">Log In</a></p>
		        </div>
		        </c:otherwise>
		        </c:choose>
					</div>
				</div>
			</div>
		</div>
    
	  <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a class="navbar-brand" href="MemberServlet.do?command=main_view">Liquor <span>store</span></a>
	      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#ftco-nav" aria-controls="ftco-nav" aria-expanded="false" aria-label="Toggle navigation">
	        <span class="oi oi-menu"></span> Menu
	      </button>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">
	          <li class="nav-item active"><a href="MemberServlet.do?command=main_view" class="nav-link">Home</a></li>
	          <li class="nav-item"><a href="about.jsp" class="nav-link">소개</a></li>
	          <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">상품정보</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04">
              	<a class="dropdown-item" href="ShopingServlet.do?command=liquor_list">상품리스트</a>
                <a class="dropdown-item" href="ShopingServlet.do?command=liquor_cartView">장바구니</a>
                <a class="dropdown-item" href="ShopingServlet.do?command=liquor_buyView">주문</a>
              </div>
            </li>
             <li class="nav-item dropdown">
              <a class="nav-link dropdown-toggle" href="#" id="dropdown04" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">리뷰</a>
              <div class="dropdown-menu" aria-labelledby="dropdown04">
                <a class="dropdown-item" href="BoardServlet.do?command=blog_AddView">리뷰쓰기</a>
                <a class="dropdown-item" href="BoardServlet.do?command=blog_List">리뷰목록</a>
              </div>
            </li>
	          <c:if test="${nowuser != null }">
	          <c:if test="${nowuser eq 'master' }">
	          <li class="nav-item"><a href="ShopingServlet.do?command=liquorAdd_view" class="nav-link">상품등록</a></li>
	          </c:if>
	          </c:if>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
    
    <section class="hero-wrap hero-wrap-2" style="background-image: url('images/bg_2.jpg');" data-stellar-background-ratio="0.5">
      <div class="overlay"></div>
      <div class="container">
        <div class="row no-gutters slider-text align-items-end justify-content-center">
          <div class="col-md-9 ftco-animate mb-5 text-center">
          	<p class="breadcrumbs mb-0"><span class="mr-2"><a href="MemberServlet.do?command=main_view.jsp">Home <i class="fa fa-chevron-right"></i></a></span> <span>Checkout <i class="fa fa-chevron-right"></i></span></p>
            <h2 class="mb-0 bread">Checkout</h2>
          </div>
        </div>
      </div>
    </section>

    <section class="ftco-section">
    <form action="MemberServlet.do" method="post">
    	<div class="container">
    		<div class="row justify-content-center">
          <div class="col-xl-10 ftco-animate">
							<h3 class="mb-4 billing-heading">Billing Details</h3>
	          	<div class="row align-items-end">
	          		<div class="col-md-6">
	                <div class="form-group">
	                	<label for="firstname">주문자 id</label>
	                  <input type="text" class="form-control" value="${nowuser}">
	                </div>
	              </div>
	              <div class="col-md-6">
	                <div class="form-group">
	                	<label for="lastname">주문자 이름</label>
	                	<c:choose>
	                	<c:when test="${sessionScope.buyList[0]!=null }">
	                  <input type="text" class="form-control" value="${sessionScope.buyList[0].name }">
	                	</c:when>
	                	<c:otherwise>
	                	 <input type="text" class="form-control" value="주문내역이 없습니다">
	                	</c:otherwise>
	                	</c:choose>
	                </div>
                </div>
                <div class="w-100"></div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                	<label for="streetaddress">주문자 주소</label>
	                	<c:choose>
	                	<c:when test="${sessionScope.buyList[0]!=null }">
	                  <input type="text" class="form-control" value="${sessionScope.buyList[0].addr }" >
	                	</c:when>
	                	<c:otherwise>
	                	 <input type="text" class="form-control" value="주문내역이 없습니다">
	                	</c:otherwise>
	                	</c:choose>
	                </div>
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                  <input type="text" class="form-control" >
	                </div>
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
	                <div class="form-group">
	                	<label for="phone">물건이름</label>
	                	<c:choose>
	                	<c:when test="${sessionScope.buyList[0]!=null }">
	                  <input type="text" class="form-control" value="${sessionScope.buyList[0].title }외 00">
	                	</c:when>
	                	<c:otherwise>
	                	 <input type="text" class="form-control" value="주문내역이 없습니다">
	                	</c:otherwise>
	                	</c:choose>
	                </div>
	              </div>
                <div class="col-md-6">
	                <div class="form-group">
	                	<label for="emailaddress">토탈금액</label>
	                	<c:choose>
	                	<c:when test="${sessionScope.buyList[0]!=null }">
	                  <input type="text" class="form-control"value="${sessionScope.buyList[0].lasttotal }">
	                	</c:when>
	                	<c:otherwise>
	                	 <input type="text" class="form-control" value="주문내역이 없습니다">
	                	</c:otherwise>
	                	</c:choose>
	                </div>
                </div>
                <div class="w-100"></div>
                <div class="col-md-12">
                	<div class="form-group mt-4">
										<div class="radio">
										  <label class="mr-3"><input type="radio" name="optradio"> Create an Account? </label>
										  <label><input type="radio" name="optradio"> Ship to different address</label>
										</div>
									</div>
                </div>
	            </div>
	          <!-- END -->



	          <div class="row mt-5 pt-3 d-flex">
	          	<div class="col-md-6">
	          		<div class="cart-detail p-3 p-md-4">
	          			 <input type="hidden" name ="command" value="main_view">
					  <p><input type="submit"class="btn btn-primary py-3 px-4">메인으로</p>
					</div>
	          	</div>
	          </div>
          </div> <!-- .col-md-8 -->
        </div>
    	</div>
    	</form>
    </section>

    <footer class="ftco-footer">
      <div class="container">
        <div class="row mb-5">
          <div class="col-sm-12 col-md">
            <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2 logo"><a href="#">Liquor <span>Store</span></a></h2>
              <p>Far far away, behind the word mountains, far from the countries.</p>
              <ul class="ftco-footer-social list-unstyled mt-2">
                <li class="ftco-animate"><a href="#"><span class="fa fa-twitter"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="fa fa-facebook"></span></a></li>
                <li class="ftco-animate"><a href="#"><span class="fa fa-instagram"></span></a></li>
              </ul>
            </div>
          </div>
          <div class="col-sm-12 col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
              <h2 class="ftco-heading-2">My Accounts</h2>
              <ul class="list-unstyled">
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>My Account</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Register</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Log In</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>My Order</a></li>
              </ul>
            </div>
          </div>
          <div class="col-sm-12 col-md">
            <div class="ftco-footer-widget mb-4 ml-md-4">
              <h2 class="ftco-heading-2">Information</h2>
              <ul class="list-unstyled">
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>About us</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Catalog</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Contact us</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Term &amp; Conditions</a></li>
              </ul>
            </div>
          </div>
          <div class="col-sm-12 col-md">
             <div class="ftco-footer-widget mb-4">
              <h2 class="ftco-heading-2">Quick Link</h2>
              <ul class="list-unstyled">
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>New User</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Help Center</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Report Spam</a></li>
                <li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Faq's</a></li>
              </ul>
            </div>
          </div>
          <div class="col-sm-12 col-md">
            <div class="ftco-footer-widget mb-4">
            	<h2 class="ftco-heading-2">Have a Questions?</h2>
            	<div class="block-23 mb-3">
	              <ul>
	                <li><span class="icon fa fa-map marker"></span><span class="text">203 Fake St. Mountain View, San Francisco, California, USA</span></li>
	                <li><a href="#"><span class="icon fa fa-phone"></span><span class="text">+2 392 3929 210</span></a></li>
	                <li><a href="#"><span class="icon fa fa-paper-plane pr-4"></span><span class="text">info@yourdomain.com</span></a></li>
	              </ul>
	            </div>
            </div>
          </div>
        </div>
      </div>
      <div class="container-fluid px-0 py-5 bg-black">
      	<div class="container">
      		<div class="row">
	          <div class="col-md-12">
		
	            <p class="mb-0" style="color: rgba(255,255,255,.5);"><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
	  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="fa fa-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib.com</a>
	  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. --></p>
	          </div>
	        </div>
      	</div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-select/1.13.1/js/bootstrap-select.min.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>