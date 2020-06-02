<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>Liquor Store - Free Bootstrap 4 Template by Colorlib</title>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link
	href="https://fonts.googleapis.com/css2?family=Spectral:ital,wght@0,200;0,300;0,400;0,500;0,700;0,800;1,200;1,300;1,400;1,500;1,700&display=swap"
	rel="stylesheet">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

<link rel="stylesheet" href="css/animate.css">

<link rel="stylesheet" href="css/owl.carousel.min.css">
<link rel="stylesheet" href="css/owl.theme.default.min.css">
<link rel="stylesheet" href="css/magnific-popup.css">

<link rel="stylesheet" href="css/flaticon.css">
<link rel="stylesheet" href="css/style.css">
</head>
<body>

	<div class="wrap">
		<div class="container">
			<div class="row">
				<div class="col-md-6 d-flex align-items-center">
					<p class="mb-0 phone pl-md-2">
						<a href="#" class="mr-2"><span class="fa fa-phone mr-1"></span>
							+00 1234 567</a> <a href="#"><span class="fa fa-paper-plane mr-1"></span>
							youremail@email.com</a>
					</p>
				</div>
				<div class="col-md-6 d-flex justify-content-md-end">
					<div class="social-media mr-4">
						<p class="mb-0 d-flex">
							<a href="#"
								class="d-flex align-items-center justify-content-center"><span
								class="fa fa-facebook"><i class="sr-only">Facebook</i></span></a> <a
								href="#"
								class="d-flex align-items-center justify-content-center"><span
								class="fa fa-twitter"><i class="sr-only">Twitter</i></span></a> <a
								href="#"
								class="d-flex align-items-center justify-content-center"><span
								class="fa fa-instagram"><i class="sr-only">Instagram</i></span></a>
							<a href="#"
								class="d-flex align-items-center justify-content-center"><span
								class="fa fa-dribbble"><i class="sr-only">Dribbble</i></span></a>
						</p>
					</div>
					<c:choose>
						<c:when test="${nowuser!=null }">
							<!-- 로그인이완료가되면 -->
							<div class="reg">
								<p class="mb-0">
									<span class="mr-2">${nowuser} 님</span> <a
										href="MemberServlet.do?command=Logout">Log out</a>
								</p>
							</div>
						</c:when>
						<c:otherwise>
							<div class="reg">
								<p class="mb-0">
									<a href="MemberServlet.do?command=useradd_view" class="mr-2">Sign
										Up</a> <a href="MemberServlet.do?command=Login_view">Log In</a>
								</p>
							</div>
						</c:otherwise>
					</c:choose>
				</div>
			</div>
		</div>
	</div>

	<nav
		class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light"
		id="ftco-navbar">
		<div class="container">
			<a class="navbar-brand" href="MemberServlet.do?command=main_view">Liquor <span>store</span></a>


			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#ftco-nav" aria-controls="ftco-nav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="oi oi-menu"></span> Menu
			</button>

			<div class="collapse navbar-collapse" id="ftco-nav">
				<ul class="navbar-nav ml-auto">
					<li class="nav-item active"><a href="MemberServlet.do?command=main_view"
						class="nav-link">Home</a></li>
					<li class="nav-item"><a href="about.jsp" class="nav-link">소개</a></li>
					<li class="nav-item dropdown"><a
						class="nav-link dropdown-toggle" href="#" id="dropdown04"
						data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">상품정보</a>
						<div class="dropdown-menu" aria-labelledby="dropdown04">
							<a class="dropdown-item" href="ShopingServlet.do?command=liquor_list">상품리스트</a> <a
								class="dropdown-item" href="ShopingServlet.do?command=liquor_cartView">장바구니</a> <a
								class="dropdown-item" href="ShopingServlet.do?command=liquor_buyView">주문</a>
						</div></li>
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

	<section class="hero-wrap hero-wrap-2"
		style="background-image: url('./images/bg_2.jpg');"
		data-stellar-background-ratio="0.5">
		<div class="overlay"></div>
		<div class="container">
			<div
				class="row no-gutters slider-text align-items-end justify-content-center">
				<div class="col-md-9 ftco-animate mb-5 text-center">
					<p class="breadcrumbs mb-0">
						<span class="mr-2"><a href="MemberServlet.do?command=main_view">Home <i
								class="fa fa-chevron-right"></i></a></span> <span>Contact Us <i
							class="fa fa-chevron-right"></i></span>
					</p>
					<h2 class="mb-0 bread">상품 등록</h2>
				</div>
			</div>
		</div>
	</section>

	<section class="ftco-section bg-light">
		<div class="container">
			<div class="row justify-content-center">
				<div class="col-md-12">
					<div class="wrapper px-md-4">
						<div class="row no-gutters">
							<div class="col-md-7">
								<div class="contact-wrap w-100 p-md-5 p-4">
									<h3 class="mb-4">Contact Us</h3>
									 				<!--enctype  파일을전송할때는 반드시 지정해야함
													이거사용시 겟이나 포스트로 전송이 불가능하다.(enctype방식으로 전송이되는듯
													다안돼지만 액션에 ?붙여서 가는건 된다.. 왤까? -->
									<form method="POST" action="ShopingServlet.do?command=liquor_add" enctype="multipart/form-data" name="contactForm"
										class="contactForm">
										<div class="row">
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="subject">물건명</label> <input
														type="text" class="form-control" name="title"
														placeholder="Subject">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" >가격</label> <input
														type="text" class="form-control" name="price"
														placeholder="price">
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="name">물건종류</label> <select
														name="typeof" class="form-control">
														<option value="01" selected="selected">종류를 선택하세요</option>
														<option value="Brandy">Brandy</option>
														<option value="Gin">Gin</option>
														<option value="Rum">Rum</option>
														<option value="Tequila">Tequila</option>
														<option value="Vodka">Vodka</option>
														<option value="Whiskey">Whiskey</option>
														<option value="Wine">Wine</option>
													</select>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" >수 량</label> <input
														type="text" class="form-control" name="quantity" id="quantity"
														placeholder="quantity">
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<label class="label">상품상세설명</label>
													<textarea name="content" class="form-control" id="content"
														cols="30" rows="4" placeholder="Content"></textarea>
												</div>
											</div>
											<div class="col-md-6">
												<div class="form-group">
													<label class="label" for="email">사진 업로드</label> <input
														type="file" class="form-control" name="picture">
												</div>
											</div>
											<div class="col-md-12">
												<div class="form-group">
													<input type="submit" value="add liquor"
														class="btn btn-primary">
													<div class="submitting"></div>
												</div>
											</div>
										</div>
									</form>
								</div>
							</div>
							<!-- <div class="col-md-5 order-md-first d-flex align-items-stretch">
									<div id="map" class="map"></div>
								</div> 상황봐서 사진올리는거로 바꿀수있으면쓰자 -->
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

	<footer class="ftco-footer">
		<div class="container">
			<div class="row mb-5">
				<div class="col-sm-12 col-md">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2 logo">
							<a href="#">Liquor <span>Store</span></a>
						</h2>
						<p>Far far away, behind the word mountains, far from the
							countries.</p>
						<ul class="ftco-footer-social list-unstyled mt-2">
							<li class="ftco-animate"><a href="#"><span
									class="fa fa-twitter"></span></a></li>
							<li class="ftco-animate"><a href="#"><span
									class="fa fa-facebook"></span></a></li>
							<li class="ftco-animate"><a href="#"><span
									class="fa fa-instagram"></span></a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-12 col-md">
					<div class="ftco-footer-widget mb-4 ml-md-4">
						<h2 class="ftco-heading-2">My Accounts</h2>
						<ul class="list-unstyled">
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>My
									Account</a></li>
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Register</a></li>
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Log
									In</a></li>
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>My
									Order</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-12 col-md">
					<div class="ftco-footer-widget mb-4 ml-md-4">
						<h2 class="ftco-heading-2">Information</h2>
						<ul class="list-unstyled">
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>About
									us</a></li>
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Catalog</a></li>
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Contact
									us</a></li>
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Term
									&amp; Conditions</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-12 col-md">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">Quick Link</h2>
						<ul class="list-unstyled">
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>New
									User</a></li>
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Help
									Center</a></li>
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Report
									Spam</a></li>
							<li><a href="#"><span class="fa fa-chevron-right mr-2"></span>Faq's</a></li>
						</ul>
					</div>
				</div>
				<div class="col-sm-12 col-md">
					<div class="ftco-footer-widget mb-4">
						<h2 class="ftco-heading-2">Have a Questions?</h2>
						<div class="block-23 mb-3">
							<ul>
								<li><span class="icon fa fa-map marker"></span><span
									class="text">203 Fake St. Mountain View, San Francisco,
										California, USA</span></li>
								<li><a href="#"><span class="icon fa fa-phone"></span><span
										class="text">+2 392 3929 210</span></a></li>
								<li><a href="#"><span
										class="icon fa fa-paper-plane pr-4"></span><span class="text">info@yourdomain.com</span></a></li>
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

						<p class="mb-0" style="color: rgba(255, 255, 255, .5);">
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
							Copyright &copy;
							<script>
								document.write(new Date().getFullYear());
							</script>
							All rights reserved | This template is made with <i
								class="fa fa-heart color-danger" aria-hidden="true"></i> by <a
								href="https://colorlib.com" target="_blank">Colorlib.com</a>
							<!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
					</div>
				</div>
			</div>
		</div>
	</footer>



	<!-- loader -->
	<div id="ftco-loader" class="show fullscreen">
		<svg class="circular" width="48px" height="48px">
			<circle class="path-bg" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke="#eeeeee" />
			<circle class="path" cx="24" cy="24" r="22" fill="none"
				stroke-width="4" stroke-miterlimit="10" stroke="#F96D00" /></svg>
	</div>


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
	<script
		src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
	<script src="js/google-map.js"></script>
	<script src="js/main.js"></script>

</body>
</html>