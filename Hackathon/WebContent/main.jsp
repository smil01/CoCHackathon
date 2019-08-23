<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
  <meta name="description" content="">
  <meta name="author" content="">

  <title>Hackathon - AI Counseling</title>

  <!-- Font Awesome Icons -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Merriweather+Sans:400,700" rel="stylesheet">
  <link href='https://fonts.googleapis.com/css?family=Merriweather:400,300,300italic,400italic,700,700italic' rel='stylesheet' type='text/css'>

  <!-- Plugin CSS -->
  <link href="vendor/magnific-popup/magnific-popup.css" rel="stylesheet">

  <!-- Theme CSS - Includes Bootstrap -->
  <link href="css/creative.min.css" rel="stylesheet">
  <style type="text/css">
  	.table h5{
  		color: white;
  	}
  	.table td{
  		vertical-align: middle;
  	}
  	.table input {
		width: 100%;
		border-radius: 4px;
		padding-left: 10px;
		padding-right: 10px;
		color: #495057;
		font-size: 1rem;
	}
	#services th, td, a{
		color: white;
	}
	#services tr:hover{
		background-color: #FF8200;
	}
  </style>
</head>

<body id="page-top">

  <!-- Navigation -->
  <nav class="navbar navbar-expand-lg navbar-light fixed-top py-3" id="mainNav">
    <div class="container">
      <a class="navbar-brand js-scroll-trigger" href="#page-top">AI Counseling</a>
      <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
      </button>
      <div class="collapse navbar-collapse" id="navbarResponsive">
        <ul class="navbar-nav ml-auto my-2 my-lg-0">
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#about" id="img_link1">AI 민원신청</a>
          </li>
          <li class="nav-item">
            <a class="nav-link js-scroll-trigger" href="#services">민원조회</a>
          </li>
        </ul>
      </div>
    </div>
  </nav>

  <!-- Masthead -->
  <header class="masthead">
    <div class="container h-100">
      <div class="row h-100 align-items-center justify-content-center text-center">
        <div class="col-lg-10 align-self-end">
          <h1 class="text-uppercase text-white font-weight-bold">AI 원 클 릭<br>민 원 처 리</h1>
          <hr class="divider my-4">
        </div>
        <div class="col-lg-8 align-self-baseline">
          <p class="text-white-75 font-weight-light mb-5">지금까지 경험해보지 못했던 획기적인 방법으로 민원 서비스를 받아보세요.<br><small>(공지사항 : 짧은시간 프로젝트에 이해력을 높이기 위하여 사용자와 관리자 페이지를 통합하였습니다.)</small></p>
          <a class="btn btn-primary btn-xl js-scroll-trigger" href="#about" id="img_link2"><h5 class="text-uppercase text-white font-weight-bold">민 원 신 청</h5></a>
        </div>
      </div>
    </div>
  </header>

  <!-- About Section -->
  <section class="page-section bg-primary" id="about">
    <div class="container">
      <div class="row justify-content-center">
        <div class="col-lg-8 text-center">
          <h2 class="text-white mt-0">AI 민 원 신 청 서</h2>
          <hr class="divider light my-4">
          <p class="text-white-50 mb-4">신청전 주의사항 : 민원보내기 버튼을 클릭전에 민원분류가 잘 되었는지 확인하여 주시기 바랍니다.</p>
          <form id="target" method="post" enctype="multipart/form-data">
	          <table class="table" id="on_table" style="display: none;">
	          	<tr>
	          		<td width="40%">
	          			<h5>민원내용</h5>
	          		</td>
	          		<td width="60%">
						<select class="was-validated custom-select" id="img_content" name="img_content">
						    <option value="">민원선택</option>
						    <option value="0">불법주차</option>
						    <option value="1">인도파손</option>
						    <option value="2">불법쓰레기</option>
						    <option value="3">구분하기힘듬</option>
						</select>
						<input style="display: none;" type="file" id="camera" name="camera" capture="camera" accept="image/*" />
	          		</td>
	          	</tr>
	          	<tr>
	          		<td>
	          			<h5>작성자</h5>
	          		</td>
	          		<td>
	          			 <input type="text" id="img_writer" name="img_writer">
	          		</td>
	          	</tr>
	          	<tr>
	          		<td>
	          			<h5>작성기기</h5>
	          		</td>
	          		<td>
	          			 <input type="text" id="img_machine" name="img_machine">
	          		</td>
	          	</tr>
	          	<tr>
	          		<td>
	          			<h5>GPS</h5>
	          		</td>
	          		<td>
	          			<input type="text" id="img_gps" name="img_gps">
	          		</td>
	          	</tr>
	          	<tr>
	          		<td>
	          			<h5>주소</h5>
	          		</td>
	          		<td>
	          			<input type="text" id="img_addr" name="img_addr">
	          		</td>
	          	</tr>
	          	<tr>
	          		<td>
	          			<h5>시간</h5>
	          		</td>
	          		<td>
	          			 <input type="text" id="img_time" name="img_time">
	          		</td>
	          	</tr>
	          	<tr>
	          		<td>
	          			 <h5>사진확인</h5>
	          		</td>
	          		<td align="left">
	          			 <img id="img_img" height=200 width="100%" style="border-radius: 8px;">
	          			 <input type="text" id="img_src" name="img_src" style="display: none;">
	          		</td>
	          	</tr>
	          	<tr>
	          		<td colspan="2">
	          			<a class="btn btn-light btn-xl js-scroll-trigger" id="a_submit" href="#about">민원보내기</a> 
	          			<a class="btn btn-light btn-xl js-scroll-trigger" id="a_clean" href="#about">취소</a>
	          		</td>
	          	</tr>
	          </table>
          </form>
          <table class="table" id="off_table">
          	<tr>
          		<td>
          			<a id="img_link3" class="btn btn-light btn-xl js-scroll-trigger" href="#about">AI카메라 활성화</a>
          		</td>
          	</tr>
          </table>
        </div>
      </div>
    </div>
  </section>

  <!-- Services Section -->
  <section class="page-section">
    <div class="container">
      <h2 class="text-center mt-0">At Your AI-Service</h2>
      <hr class="divider my-4">
      <div class="row">
        <div class="col-lg-3 col-md-6 text-center">
          <div class="mt-5">
            <i class="fas fa-4x fa-gem text-primary mb-4"></i>
            <h3 class="h4 mb-2">Sturdy Themes</h3>
            <p class="text-muted mb-0">Our Service are updated regularly to keep AI bug free!</p>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 text-center">
          <div class="mt-5">
            <i class="fas fa-4x fa-laptop-code text-primary mb-4"></i>
            <h3 class="h4 mb-2">Up to Date</h3>
            <p class="text-muted mb-0">All AI-Model are kept current to keep things fresh.</p>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 text-center">
          <div class="mt-5">
            <i class="fas fa-4x fa-globe text-primary mb-4"></i>
            <h3 class="h4 mb-2">Ready to Publish</h3>
            <p class="text-muted mb-0">You can use this AI-Service as is, or you can make changes!</p>
          </div>
        </div>
        <div class="col-lg-3 col-md-6 text-center">
          <div class="mt-5">
            <i class="fas fa-4x fa-heart text-primary mb-4"></i>
            <h3 class="h4 mb-2">Made with Love</h3>
            <p class="text-muted mb-0">Is it really AI-Counseling if it's not made with love?</p>
          </div>
        </div>
      </div>
    </div>
  </section>



  <!-- Call to Action Section -->
  <section class="page-section bg-dark text-white" id="services">
    <div class="container text-center">
      <h2 class="mb-4">민원현황을 확인해보세요!</h2>
		<table class="table">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>내용</th>
				<th>구분</th>
			</tr>
			<c:forEach var="dto" items="${list}">
				<tr>
					<td><a href="#">${dto.num}</a></td>
					<td><a href="#">${dto.writer}</a></td>
					<td><a href="#">${dto.content == "0" ? "불법주차" : dto.content == "1" ? "인도파손" : dto.content == "2" ? "불법쓰레기" : "구분하기힘듬"}</a></td>
					<td><a href="#">${dto.state == 0 ? "접수중" : dto.state == 1 ? "처리중" : "완료"}</a></td>
				</tr>
			</c:forEach>
		</table>
    </div>
  </section>


  <!-- Footer -->
  <footer class="bg-light py-5">
    <div class="container">
      <div class="small text-center text-muted">Copyright &copy; 2019 - Team찰칵</div>
    </div>
  </footer>

  <!-- Bootstrap core JavaScript -->
  <script src="vendor/jquery/jquery.min.js"></script>
  <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

  <!-- Plugin JavaScript -->
  <script src="vendor/jquery-easing/jquery.easing.min.js"></script>
  <script src="vendor/magnific-popup/jquery.magnific-popup.min.js"></script>

  <!-- Custom scripts for this template -->
  <script src="js/creative.min.js"></script>
  <script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=c3d6d27cf94f7191b731054546ed89d6&libraries=services"></script>
<script type="text/javascript">
$('document').ready(function(){
	/* 필요함수 */
   function cameraClick() {
      if($('#on_table').css("display") != "table"){
         $('#camera').click();
      }
   }
   
   /* 초기화 */
   if("${msg}" != "null" && "${msg}" != "") {
	   alert("${msg}");
   } <%session.removeAttribute("msg");%>

   $('#img_link1').click(function() {
	   cameraClick();
  });
  $('#img_link2').click(function() {
	  cameraClick();
  });
  $('#img_link3').click(function() {
	  cameraClick();
  });

  
  $('#a_submit').click(function() {
	  if(confirm("민원을 신청합니다. 민원내용을 하셨나요?")){
		  $("#target").attr("enctype", "");
		  $("#target").attr("action", "/UploadService");
		  $('#target').submit();
	  }
  });
  $('#a_clean').click(function() {
	    $('#on_table').attr('style', 'display:none');
	    $('#off_table').attr('style', 'display:display');
  });
  
  
  /* 제어부 */
  $('#camera').change(function(){
    $('#on_table').attr('style', 'display:display');
    $('#off_table').attr('style', 'display:none');
    
    var form = $('#target')[0];
    var formData = new FormData(form);
    $.ajax({
        url: '/StudyService',
        processData: false,
            contentType: false,
        data: formData,
        type: 'POST',
        success: function(result){
        	if(result == null){
        		alert("이미지를 다시 확인하여 주세요.\n(gps가 켜져있지 않거나 핸드폰으로 촬영되지 않은 이미지)");
        	} else {
	            var geocoder = new kakao.maps.services.Geocoder();
	            var coord = new kakao.maps.LatLng(result.x, result.y);
	            var callback = function(result, status) {
	                if (status === kakao.maps.services.Status.OK) {
	                    $('#img_addr').val(result[0].address.address_name);
	                }
	            };
	            geocoder.coord2Address(coord.getLng(), coord.getLat(), callback);
	            
	        	$("#img_img").attr("src", result.src);
	        	$("#img_src").val(result.src);
	            $("#img_content").val(result.content).prop("selected", true);
	            $('#img_writer').val(result.writer);
	            $('#img_machine').val(result.machine);
	            $('#img_gps').val(result.x + ', ' + result.y);
	            $('#img_time').val(result.time);
        	}
        }
    });    
  });
});
</script>

  <!-- Modal -->
  <div class="modal" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <h4 class="modal-title">Modal Header</h4>
		  <button type="button" class="close" data-dismiss="modal">×</button>
        </div>
        <div class="modal-body">
          <p>Some text in the modal.</p>
        </div>
        <div class="modal-footer">
          <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
        </div>
      </div>
      
    </div>
  </div>
</body>
</html>
