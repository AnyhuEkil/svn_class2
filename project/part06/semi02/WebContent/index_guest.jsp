<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>PentAcorn</title>

<!-- Bootstrap Core CSS -->

<link href="css/bootstrap.min.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="css/stylish-portfolio.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="font-awesome/css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,700,300italic,400italic,700italic"
	rel="stylesheet" type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->



<style type="text/css">
.guestheader {
	display: table;
	position: relative;
	width: 100%;
	height: 100%;
	background: url(img/bg2.jpg) no-repeat center center scroll;
	-webkit-background-size: cover;
	-moz-background-size: cover;
	background-size: cover;
	-o-background-size: cover;
	color: white;
}
</style>
</head>
<body>
<%
	String pid = request.getParameter("id");
	int rank=5;
	int money=5000;
%>
<!-- login Modal -->
	<div class="modal fade" id="loginModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Login to pentAcorn</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group">
							<label for="inputId">ID</label> <input type="email"
								class="form-control" id="inputId" placeholder="ID">
						</div>
						<div class="form-group">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="exampleInputPassword1"
								placeholder="Password">
						</div>

						<button type="submit" class="btn btn-default col-md-offset-5">login</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-primary">Register</button>
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	<!-- register Modal -->
	<div class="modal fade" id="regModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Login to pentAcorn</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">ID</label>
						</div>
						<div class="row">
							<div class="col-md-offset-2 col-md-7">
								<input type="text" class="form-control" id="inputIdReg"
									placeholder="ID">
							</div>
							<div class="form-group col-md-2">
								<button class="btn btn-default" type="submit">�ߺ� Ȯ��</button>
							</div>
						</div>
						<!-- /.col-lg-6 -->
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="inputPasswordReg"
								placeholder="Password">
						</div>
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">Password Ȯ��</label> <input
								type="password" class="form-control" id="inputConfirmPassReg"
								placeholder="Password Ȯ��">
						</div>
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">�̸�</label> <input type="text"
								class="form-control" id="inputName" placeholder="�̸�">
						</div>
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">�ּ�</label> <input type="text"
								class="form-control" id="inputAddr" placeholder="�ּ�">
						</div>
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">����ó</label> <input type="text"
								class="form-control" id="inputTel" placeholder="����ó">
						</div>

						<button type="submit" class="btn btn-primary col-md-offset-5">Register</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>
	
	<!-- modify Modal -->
	<div class="modal fade" id="modifyModal" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Modify user info</h4>
				</div>
				<div class="modal-body">
					<form>
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">ID</label>
						</div>
						<div class="row">
							<div class="col-md-offset-2 col-md-7">
								<label for="exampleInputPassword1">  <%=pid %></label>
							</div>
						</div>
						<!-- /.col-lg-6 -->
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">Password</label> <input
								type="password" class="form-control" id="inputPasswordReg"
								placeholder="Password">
						</div>
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">Password Ȯ��</label> <input
								type="password" class="form-control" id="inputConfirmPassReg"
								placeholder="Password Ȯ��">
						</div>
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">�̸�</label> <input type="text"
								class="form-control" id="inputName" placeholder="�̸�">
						</div>
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">�ּ�</label> <input type="text"
								class="form-control" id="inputAddr" placeholder="�ּ�">
						</div>
						<div class="form-group col-md-offset-2 col-md-7">
							<label for="exampleInputPassword1">����ó</label> <input type="text"
								class="form-control" id="inputTel" placeholder="����ó">
						</div>

						<button type="submit" class="btn btn-primary col-md-offset-5">Register</button>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
				</div>
			</div>
		</div>
	</div>

	<!-- Navigation -->
	<a id="menu-toggle" href="#" class="btn btn-dark btn-lg toggle"><i
		class="fa fa-bars"></i></a>
	<nav id="sidebar-wrapper">
		<ul class="sidebar-nav">
			<a id="menu-close" href="#"
				class="btn btn-light btn-lg pull-right toggle"><i
				class="fa fa-times"></i></a>
			<!-- TODO: �α��� �� id���, �α׾ƿ� �� '�α��� ���ּ���' �޼��� ���  -->
			<li class="sidebar-brand"><a href="#top" onclick=$("#menu-close").click();>Wellcome,
					<%=pid%></a></li>
			<!-- �α׾ƿ� ������ �� hidden -->
			<li><a href="#portfolio" onclick=$("#menu-close").click();>�α׾ƿ�</a>
			</li>
			<!-- TODO: �α����� �Ǿ� ������ hidden  -->
			<li>
				<a onclick=	
					$("#loginModal").modal("show");>�α���</a>
			</li>
			<!-- TODO: �α����� �Ǿ� ������ hidden  -->
			<li>
				 <a onclick=$("#regModal").modal("show");>ȸ������</a>
			</li>
			<!-- TODO: �α׾ƿ��� �Ǿ� ������ hidden  -->
			<li><a onclick=$("#modifyModal").modal("show");>ȸ������
					����</a></li>
			<li><br> <br></li>
			<li><a href="#top" onclick=$("#menu-close").click();>Home</a></li>
			<li><a href="#search" onclick=$("#menu-close").click();>���� �˻�</a>
			</li>
			<!-- �α׾ƿ� ������ �� ���� �α��� â�� ����. -->
			<li><a href="#game03" onclick=$("#menu-close").click();>�渶
					����</a></li>
		</ul>
	</nav>

	<section id="top" class="guestheader">
	<div class="text-vertical-center">
		<h1>
				Wellcome,
				<%=pid%></h1>
			<h3>
				���� ����:
				<%=rank%></h3>
			<h3>
				���� ������:
				<%=money%></h3>
			<br> <a href="#search" class="btn btn-primary btn-lg">�� ���� Ȯ���ϱ�</a>
		<br>
	</div>
	</section>
	<section id="search">
	 <iframe 
		 width="100%" height="1400px" frameborder="0"
		scrolling="no" src="search.jsp"></iframe>
	</section>
	<!-- Game3 -->
	<section id="game03" class="game03"> <iframe id="my_iframe02"
		width="100%" height="100%" frameborder="0"
		scrolling="no" marginheight="0" marginwidth="0" src="game_manager.html"></iframe>
	</section>
</body>
<!-- jQuery -->
<script src="js/jquery.js"></script>

<!-- Bootstrap Core JavaScript -->
<script src="js/bootstrap.min.js"></script>

<!-- Custom Theme JavaScript -->
<script type="text/javascript">
    
    
    // �޴� �ݱ�
    $("#menu-close").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // �޴� ����
    $("#menu-toggle").click(function(e) {
        e.preventDefault();
        $("#sidebar-wrapper").toggleClass("active");
    });
    // �̱������� �ش� �޴��� �̵�
    $(function() {
        $('a[href*=#]:not([href=#],[data-toggle],[data-target],[data-slide])').click(function() {
            if (location.pathname.replace(/^\\/, '') == this.pathname.replace(/^\\/, '') || location.hostname == this.hostname) {
                var target = $(this.hash);
                target = target.length ? target : $('[name=' + this.hash.slice(1) + ']');
                if (target.length) {
                    $('html,body').animate({
                        scrollTop: target.offset().top
                    }, 1000);
                    return false;
                }
            }
        });
    });
	</script>

</html>