<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="shortcut icon" type="image/x-icon" href="../../images/icon.png">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/css/bootstrap.min.css" rel="stylesheet">
<link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.1/font/bootstrap-icons.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.1/dist/js/bootstrap.bundle.min.js" ></script>
<meta charset="UTF-8">
<title>獎學網首頁</title>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
	<div class="container-fluid">
		<a class="navbar-brand" href="#">獎學網</a>
		<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
			data-bs-target="#navbarSupportedContent"
			aria-controls="navbarSupportedContent" aria-expanded="false"
			aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav me-auto mb-2 mb-lg-0">
				<li class="nav-item"><a class="nav-link active"
					aria-current="page" href="#">首頁</a></li>
				<li class="nav-item"><a class="nav-link" href="#">關於我們</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#" id="navbarDropdown"
					role="button" data-bs-toggle="dropdown" aria-expanded="false">
						更多資訊 </a>
					<ul class="dropdown-menu" aria-labelledby="navbarDropdown">
						<li><a class="dropdown-item" href="../backend/backendmain.jsp">後台</a></li>
						<li><a class="dropdown-item" href="./register.jsp">註冊頁</li>
						<li><hr class="dropdown-divider"></li>
						<li><a class="dropdown-item" href="#">Something else here</a></li>
					</ul></li>
				  <!--<li class="nav-item"><a class="nav-link disabled">Disabled</a>
				</li>-->
			</ul>
			<form class="d-flex" action="./login.jsp">
				<button class="btn btn-outline-success" type="submit" >Login</button>
			</form>
		</div>
	</div>
</nav>

</head>
<body>
	<tr>
		<td valign="top">
				<legend class="m-3">請輸入查詢條件</legend>
				<div class="p-3 border border-2 border-warning bg bg-warning">
			<form method="post" action="" class="mb-3  " >
				 &emsp;身分別:&nbsp;<input type="text" id="personGroup" name="personGroup" placeholder="請輸入身分別" required />
				 &emsp;年齡:&nbsp; <input type="number" id="personAge" name="personAge" placeholder="請輸入年齡" required />
				 &emsp;獎學金額度:&nbsp; <input type="number" id="scholarDegree" name="scholarDegree"
					placeholder="例:50000" required />
				<button type="submit">送出</button>
			</form>
			</div>
		</td>
	<tr>

		<table class="table table-warning">
			<thead>
				<tr>
					<th scope="col">#</th>
					<th scope="col">獎助機構</th>
					<th scope="col">獎學金名稱</th>
					<th scope="col">獎學金額度</th>
					<th scope="col">聯絡資訊</th>
				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row">1</th>
					<td>行天宮</td>
					<td>清寒獎助學金</td>
					<td>50000</td>
					<td>陳小姐 0912345678</td>
				</tr>
				<tr>
					<th scope="row">2</th>
					<td>華山文教基金會</td>
					<td>偏鄉繁星獎勵金</td>
					<td>80000</td>
					<td>劉小姐 0988811112</td>
				</tr>
				<tr>
					<th scope="row">3</th>
					<td>崇禮文教基金會</td>
					<td>小狀元就學獎勵金</td>
					<td>30000</td>
					<td>蔡先生 0977716665</td>
				</tr>
				<tr>
					<th scope="row">4</th>
					<td colspan="4" >未完待續</td>
				</tr>
			</tbody>
		</table>
</body>
</html>