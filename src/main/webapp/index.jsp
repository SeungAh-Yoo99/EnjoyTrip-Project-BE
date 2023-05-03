<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Enjoy Trip</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <%-- Favicons --%>
    <link href="assets/img/ssafy_logo.png" rel="icon">
    <link href="assets/img/ssafy_logo.png" rel="apple-touch-icon">

    <%-- Google Fonts --%>
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Roboto:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
          rel="stylesheet">

    <%-- Vendor CSS Files --%>
    <link href="assets/vendor/aos/aos.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
    <link href="assets/vendor/swiper/swiper-bundle.min.css" rel="stylesheet">

    <%-- Template Main CSS File --%>
    <link href="assets/css/style.css" rel="stylesheet">
    <script type="text/javascript" src="apikey.js">
    </script>
    <%-- =======================================================
    * Template Name: BizLand
    * Updated: Mar 10 2023 with Bootstrap v5.2.3
    * Template URL: https://bootstrapmade.com/bizland-bootstrap-business-template/
    * Author: BootstrapMade.com
    * License: https://bootstrapmade.com/license/
    ======================================================== --%>

</head>

<body>

<%-- ======= Header ======= --%>
<header id="header" class="d-flex align-items-center">
    <div class="container d-flex align-items-center justify-content-between">

        <h1 class="logo"><a href="index.jsp">Enjoy Trip<span>.</span></a></h1>
        <%-- Uncomment below if you prefer to use an image logo --%>
        <a href="index.jsp" class="logo"><img src="assets/img/ssafy_logo.png" alt=""></a>

        <nav id="navbar" class="navbar">

            <ul>
                <%-- 로그인 페이지 주소 수정 --%>
                <c:if test="${sessionScope.user==null}">
                    <li><a class="nav-link" href="loginForm">로그인</a></li>
                </c:if>
                <c:if test="${sessionScope.user!=null}">
                    <li><a class="nav-link" href="userInfo">${sessionScope.user.id}님 환영합니다!</a></li>
                </c:if>
                <li><a class="nav-link scrollto" href="#byRegion">지역 별 여행지</a></li>
                <li><a class="nav-link scrollto" href="#customPlan">나의 여행 계획</a></li>
                <li><a class="nav-link scrollto " href="#">핫플 자랑하기</a></li>
                <li><a class="nav-link scrollto" href="#">여행 정보 공유</a></li>
            </ul>
            <i class="bi bi-list mobile-nav-toggle"></i>
        </nav>
        <%-- .navbar --%>

    </div>
</header>
<%-- End Header --%>

<%-- ======= Home Section ======= --%>
<section id="home" class="d-flex align-items-center">
    <div class="container" data-aos="zoom-out" data-aos-delay="100">
        <h1>Enjoy!!!<span>Trip</span></h1>
        <h2>지금 Enjoy!!!Trip과 함께<br>우리 지역의 관광지를 알아보고<br>나만의 여행 계획을 만들어 보세요!!!</h2>
        <div class="d-flex">
            <a href="#customPlan" class="btn-get-started scrollto">일정 더보기</a>
        </div>
    </div>
</section>
<%-- End Login --%>

<main id="main">

    <%-- ======= ByRegion Section ======= --%>
    <section id="byRegion" class="byRegion section-bg">
        <div class="container" data-aos="fade-up">

            <div class="section-title">
                <h2>지역 별 여행지</h2>
                <h3>지역사랑! <span>우리지역 관광지.</span></h3>
                <p>우리지역의 숨어있는 아름다운 관광지를 알려드립니다.<br>관광지 주변의 맛집, 숙박업소와 여행코스, 지역 축제 등을 보실 수도 있습니다<br></br></p>
                <a href="searchAttraction" class="btn-more">관광지 찾아 보기...</a> <%-- maptest 주소 수정 (보류) --%>
            </div>

            <div class="row">
                <c:forEach items="${attractionList}" var="att">

                    <div class="col-lg-3 col-md-6 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="100">
                        <div class="member">
                            <div class="member-img">
                                <img src="${att.first_image }" class="img-responsive" alt="" style="height: 400px;">
                                <div class="social">
                                </div>
                            </div>
                            <div class="member-info">
                                <h4>${att.title }</h4>
                                <span>${att.addr1 }<br></span>
                            </div>
                        </div>
                    </div>

                </c:forEach>
            </div>

        </div>
    </section><!-- End Team Section -->

    <!-- ======= customPlan Section ======= -->
    <section id="customPlan" class="customPlan">
        <div class="container" data-aos="fade-up">

            <div class="section-title">
                <h2>나의 여행계획</h2>
                <h3>나만의 <span>여행 계획!!</span></h3>
                <p>여행 경로, 숙박, 관광지, 예상금액 등 나만의 멋진 계획을 세워 공유 해주세요!!!<br><br></p>
                <a href="#" class="btn-more">더 보기...</a>
            </div>

            <div class="row">
                <%--
                        <c:forEach items="" var="">
                            <div class="col-lg-3 col-md-6 d-flex align-items-stretch" data-aos="fade-up" data-aos-delay="100">
                                <div class="member">
                                  <div class="member-img">
                                    <img src="${ }" class="img-fluid" alt="">
                                    <div class="social">
                                      <a href="">자세히 보기...</a>
                                    </div>
                                  </div>
                                  <div class="member-info">
                                    <h4>${ }</h4>
                                    <span>${ }</span>
                                  </div>
                                </div>
                              </div>
                        </c:forEach>
                --%>
            </div>
    </section><!-- End Team Section -->


    </section><!-- End Services Section -->

</main><!-- End #main -->

<!-- ======= Footer ======= -->
<footer id="footer">

    <div class="footer-top">
        <div class="container">
            <div class="row">

                <div class="col-lg-3 col-md-6 footer-contact">
                    <h3>Enjoy Trip<span>.</span></h3>
                    <p>
                        SSAFY 9th <br>
                        서울특별시 강남구 역삼동 테헤란로 212<br>
                        <a href="https://lab.ssafy.com/kimsg64090/s914_frontend_trip_kimseunggyu_yooseungah"><img
                                src="assets/img/gitlab.png" alt="" style="height: 25px;"></a><br><br>
                    </p>
                </div>

                <div class="col-lg-3 col-md-6 footer-links">
                    <h4>Contact</h4>
                    <h6><strong>김승규</strong></h6>
                    <strong>GitLab: </strong>@kimsg64090<br><br>
                    <h6><strong>유승아</strong></h6>
                    <strong>GitLab: </strong>@ysa8497<br>
                </div>

            </div>
        </div>
    </div>

    <div class="container py-4">
        <div class="copyright">
            &copy; Copyright <strong><span>Enjoy Trip</span></strong>. All Rights Reserved
        </div>
        <div class="credits">
            <!-- All the links in the footer should remain intact. -->
            <!-- You can delete the links only if you purchased the pro version. -->
            <!-- Licensing information: https://bootstrapmade.com/license/ -->
            <!-- Purchase the pro version with working PHP/AJAX contact form: https://bootstrapmade.com/bizland-bootstrap-business-template/ -->
            Designed by <a href="https://bootstrapmade.com/">BootstrapMade</a>
        </div>
    </div>
</footer><!-- End Footer -->

<div id="preloader"></div>
<a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

<!-- Vendor JS Files -->
<script src="assets/vendor/purecounter/purecounter_vanilla.js"></script>
<script src="assets/vendor/aos/aos.js"></script>
<script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
<script src="assets/vendor/glightbox/js/glightbox.min.js"></script>
<script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
<script src="assets/vendor/swiper/swiper-bundle.min.js"></script>
<script src="assets/vendor/waypoints/noframework.waypoints.js"></script>
<script src="assets/vendor/php-email-form/validate.js"></script>

<!-- Template Main JS File -->
<script src="assets/js/main.js"></script>
</body>
</html>