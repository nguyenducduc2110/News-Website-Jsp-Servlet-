<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@include file="/common/taglib.jsp" %>
	<c:url var ="NewsURL" value="/admin-news"/>
	<c:url var="APIurl" value="/api-admin-news"/> <!--Khai báo biến url có value = "1URL" để cho hàm ajax sử dụng -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Danh sách bài viết</title>
</head>
<body>
<div class="main-content">
	<!-- action="/admin-news" đc hiểu là nó sẽ gửi biểu mẫu đến url admin-new dựa vào method get -->
	
<form action="/quan-tri/bai-viet/danh-sach"  id="formSubmit">
	
		<div class="main-content-inner">
			<div class="breadcrumbs ace-save-state" id="breadcrumbs">
				<ul class="breadcrumb">
					<li><i class="ace-icon fa fa-home home-icon"></i> <a href="#">Trang
							chủ</a></li>
				</ul>
				<!-- /.breadcrumb -->
			</div>
			
			<div class="page-content">
				<div class="row">
					<div class="col-xs-12">
						<c:if test="${not empty requestScope.messageResponse}"><!-- Lấy value từ request đc set Attribute -->
							<div class="alert alert-${requestScope.alert}">
  								<strong>${requestScope.alert} </strong>${requestScope.messageResponse} 
							</div>
						</c:if>
						<div class="widget-box table-filter">
							<div class="table-btn-controls">
								<div class="pull-right tableTools-container">
									<div class="dt-buttons btn-overlap btn-group">
										<!-- NÚT + thêm bài viết(chỉnh sửa và thêm bài VIẾT CHUNG 1 trang JSP) -->
										<!-- Và dựa vào id truyền vào của URL để phân biệt ADD MỚI Và CHỈNH SỬa -->
										<a flag="info"				
										   class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"										 	
										   title='Thêm bài viết' href='<c:url value="/admin-news?type=edit"/>'>
													<span>
														<i class="fa fa-plus-circle bigger-110 purple"></i>
													</span>
										</a>
										<!-- Nút xoá bài viết có id=btnDelete và hàm dưới khi dùng id này để khi kích vào nút có id này hàm sẽ xoá -->
										<button id="btnDelete" type="button"
												class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa bài viết'>
														<span>
															<i class="fa fa-trash-o bigger-110 pink"></i>
														</span>
										</button>
									</div>
								</div>
							</div>
						</div>
						<div class="row">
							<div class="col-xs-12">
								<div class="table-responsive">
									<table class="table table-bordered">
										<thead>
											<tr>
												
												<th><input type="checkbox"  id="checkAll" title="Xoá tất cả"></th>
												<th>Tên bài viết</th>
												<th>Mô tả ngắn</th>
												<th>Thao tác</th>
											</tr>
										</thead>
										<tbody>
											<!-- Đây là 1 vòng lặp lấy các newsModel trong List -->
											<!-- var ở đây là 1 biến đại diện cho 1 element 1 newsModel trong List -->
											<!--items là 1 list -->
											<c:forEach var ="item" items ="${requestScope.list}"> <!--list bài báo tính từ offset(chỉ số đầu) -->
												<tr>
													<!-- Mỗi check box sẽ có id giống id của bài viết đó để biết tích vào checkbox nào và VALUE dùng để biết xoá bài viết nào  -->
													<!--SSSAAAIII:(TÍCH HAY KO NÓ VẤNSET VALUE)CÁCH CHECKBOX HOẠT ĐỘNG: Nếu check đc tính thì VALUE mới đc gán giá trị là: ${item.id} -->
													<td><input type="checkbox"  id="checkbox_${item.id}" value= "${item.id}" ></td>
												 	<!-- Trong jstl chỉ cần object.atributte là truy cập đc vào value atributte -->
													<td>${item.title}</td>
													<td>${item.shortDescription}</td>
													<td>
														<!--Biến editURL nhận value là 1 url khi url đc hoàn thiện xong dựa vào các pram -->
														<!--Khi người dùng nhấn vào url đã đc tạo hoàn chỉnh SẼ CÓ THAM SỐ là id bài viết và khi id bài viết + tham số edit đến servlet thì servlet sẽ chỉnh sửa bài viết có id đó -->
														<!-- c:url chính là 1 url -->
														<c:url var="editURL" value="/admin-news">
															<c:param name="type" value="edit"/>
															<c:param name="id" value="${item.id}"/><!--Tức là mỗi item trong list bài viết sẽ có 1 nút edit chứa id của item đó(Là id bài viết)-->
														</c:url>	
														<!-- Nút edit bài viết ở mỗi row bài viết và biến editURL ở trên-->								
														<a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
													   	title="Cập nhật bài viết" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
														</a>
													</td>		
												</tr>
											</c:forEach>
										</tbody>
									</table>
									<!-- Đây là thanh paging -->
									 <ul class="pagination" id="pagination"></ul>	
<!--==================> Cho vào các thanh input nhằm mục đích để nhận value từ từ hàm và icon paging và gửi lên request  rồi map cho object của server-->
 <!--==================> name = "page" đặt tên giống model để ánh xạ key-value sang atribute.Những name="..." có trong thẻ form này mới đc ánh xạ lên server thôi-->
									 <input type="hidden" value="" id="page" name="page"/>		
									 <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>										
									 <input type="hidden" value="" id="sortName" name="sortName"/>										
									 <input type="hidden" value="" id="sortBy" name="sortBy"/>		
									  <input type="hidden" value="list" id="type" name="type"/>		
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	
</form>
</div>	
	<script type="text/javascript">
	
	var totalPages = ${requestScope.newsModel.totalPage};
	var currentPage = ${requestScope.newsModel.page}; 
	var limit = 2;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 10,
			startPage:currentPage,
            onPageClick: function (event, page) {
            	if(currentPage != page){
            		$('#maxPageItem').val(limit);
    				$('#page').val(page);
					$('#sortName').val("title");
    				$('#sortBy').val("desc");
                    $('#formSubmit').submit();
				}
        	}
        });
    });
    
    $("#btnDelete").click(function(){
    	var longValues = [];
    	
    	
    	var dataArray = $('tbody input[type=checkbox]:checked').map(function(){
    		
    		return parseInt($(this).val());
    	}).get();
    	
    	
    	longValues.push(...dataArray);
    	
    	 deleteNews(longValues);
    });
    
    function deleteNews(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            
           	
            success: function (result) {
            	window.location.href = "${NewsURL}?type=list&maxPageItem=2&page=1&message=delete_success";
            },
            error: function (error) {
            	window.location.href = "${NewsURL}?type=list&maxPageItem=2&page=1&message=error_system";
            }
        });
    }
</script>
</body>
</html>