<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-news"/> <!--Khai báo biến url có value = "1URL" để cho hàm ajax sử dụng -->
<c:url var ="NewsURL" value="/admin-news"/>
<html>
<head>
    <title>Chỉnh sửa bài viết</title>
</head>
<body>
<div class="main-content">
    <div class="main-content-inner">
        <div class="breadcrumbs" id="breadcrumbs">
            <script type="text/javascript">
                try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
            </script>
            <ul class="breadcrumb">
                <li>
                    <i class="ace-icon fa fa-home home-icon"></i>
                    <a href="#">Trang chủ</a>
                </li>
                <li class="active">Chỉnh sửa bài viết</li>
            </ul><!-- /.breadcrumb -->
        </div>
        <div class="page-content">
            <div class="row">
                <div class="col-xs-12">
                        <!-- Thông báo khi add, delete done one a bài viết -->
                        <c:if test="${not empty requestScope.messageResponse}"><!-- Lấy value từ request đc set Attribute -->
							<div class="alert alert-${requestScope.alert}">
  								<strong>${requestScope.alert} </strong>${requestScope.messageResponse} 
							</div>
						</c:if>
                        <form id="formSubmit">
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Thể loại</label>
                                <div class="col-sm-9">
                                    <select class="form-control" id="categoryId" name="categoryId">
                                    <!-- NẾu là thêm mới -->
                                        <c:if test="${empty newsModel}">
                                            <option value="">Chọn loại bài viết</option>
                                            <c:forEach var="item" items="${categories}">
                                            <!-- tức là set value cho thẻ option thì ta có thể dùng biến của js để lấy value trong option -->
                                            	<!--value="${item.id}" là khi chọn category Thể thao thì value này sẽ set id cho value của thẻ <select> ở trên và ánh xạ sang servlet-->
                                                <option value="${item.id}">${item.name}</option>
                                            </c:forEach>
                                               
                                            
                                        </c:if>
                                        <!-- Nếu là update -->
                                        <c:if test="${not empty newsModel}">
                                            <option value="">Chọn loại bài viết</option>
                                            <c:forEach var="item" items="${categories}">
                                            								<!--Đoạn code trên là khi đkiện đúng thì lựa chọn của người dùng lúc trước sẽ đc set ở option(hayđc hiểu là set thuộc tính selected cho option  -->
                                            								<!-- Nếu id của category hiện tại = categoryId của newsModel lấy catogoryName mà id đại diện cho -->
                                                <option value="${item.id}" <c:if test="${item.id == newsModel.categoryId}">selected="selected"</c:if>>
                                                        ${item.name} 
                                                </option>
                                            </c:forEach>
                                        </c:if>
                                    </select>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Tiêu đề</label>
                                <div class="col-sm-9">
                                	<!-- INput để là text thì value sẽ hiện chữ lên  -->
                                	
                                    <input type="text" class="form-control" id="title" name="title" value="${newsModel.title}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Hình đại diện</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="thumbnail" name="thumbnail" value="${newsModel.thumbnail}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Mô tả ngắn</label>
                                <div class="col-sm-9">
                                    <input type="text" class="form-control" id="shortDescription" name="shortDescription" value="${newsModel.shortDescription}"/>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <label class="col-sm-3 control-label no-padding-right">Nội dung</label>
                                <div class="col-sm-9">                                 
                                    <textarea rows="" cols="" id="content" name="content" style="width: 750px;height: 175px">${newsModel.content}</textarea>
                                </div>
                            </div>
                            <br/>
                            <br/>
                            <div class="form-group">
                                <div class="col-sm-12">
                                <!-- Ktra nếu có newsModel thì nút có chữ Cập nhật bài viết và ngược lại-->
                                    <c:if test="${not empty requestScope.newsModel}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Cập nhật bài viết" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                    <c:if test="${empty requestScope.newsModel}">
                                        <input type="button" class="btn btn-white btn-warning btn-bold" value="Thêm bài viết" id="btnAddOrUpdateNew"/>
                                    </c:if>
                                </div>
                            </div>
                            <!-- Dùng để chứa id của newsModel set sang và thẻ input này dùng để lấy biến ở thẻ input cho hàm JS ở dưới dùng -->
                            <input type="hidden" value="${newsModel.id}" id="id" name="id"/>
                        </form>
                        <!-- All thằng trong form này sẽ đc submit nhưng nó khác formSubmit thuần ở phân trang -->
                        <!--vì thẻ input này vừa hiển thị và nhập vào đc rồi gửi xuống server.Còn submit ở phân trang chỉ gửi value xuống server -->
                </div>
            </div>
        </div>
    </div>
</div>
<script>

var editor = '';
$(document).ready(function(){
	editor = CKEDITOR.replace( 'content');
});


$('#btnAddOrUpdateNew').click(function (e) {
    e.preventDefault();
    var data = {};
    var formData = $('#formSubmit').serializeArray();
  
    $.each(formData, function (i, v) {
        data[""+v.name+""] = v.value;
    });

    
    var id = $('#id').val();
    if (id == "") {
        addNew(data);
    } else {
        updateNew(data);
    }
});

function addNew(data) {
    $.ajax({
        url: '${APIurl}',
        type: 'POST',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',
        
       	
        success: function (result) {
        	
        	window.location.href =  "${NewsURL}?type=edit&id="+result.id+"&message=insert_success";
        },
        error: function (error) {
        	window.location.href = "${NewsURL}?type=list&maxPageItem=2&page=1&message=error_system";
        }
    });
}
function updateNew(data) {
    $.ajax({
        url: '${APIurl}',
        type: 'PUT',
        contentType: 'application/json',
        data: JSON.stringify(data),
        dataType: 'json',

		
        success: function (result) {
        	window.location.href ="${NewsURL}?type=edit&id="+result.id+"&message=insert_success";
        },
        error: function (error) {
        	window.location.href = "${NewsURL}?type=list&maxPageItem=2&page=1&message=error_system";
        }
    });
}
	
</script>
</body>
</html>