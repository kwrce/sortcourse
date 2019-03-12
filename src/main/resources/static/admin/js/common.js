layui.config({
	base: 'admin/js/module/'
}).extend({
	dialog: 'dialog',
});

layui.use(['form', 'jquery', 'laydate', 'layer', 'laypage', 'dialog',   'element'], function() {
	var form = layui.form(),
		layer = layui.layer,
		$ = layui.jquery,
		dialog = layui.dialog;
	//获取当前iframe的name值
	var iframeObj = $(window.frameElement).attr('name');
	//全选
	form.on('checkbox(allChoose)', function(data) {
		var child = $(data.elem).parents('table').find('tbody input[type="checkbox"]');
		child.each(function(index, item) {
			item.checked = data.elem.checked;
		});
		form.render('checkbox');
	});
	//渲染表单
	form.render();	
	//顶部添加
	$('.addBtn').click(function() {
		var url=$(this).attr('data-url');
		//将iframeObj传递给父级窗口,执行操作完成刷新
		//parent.page("菜单添加", url, iframeObj, w = "700px", h = "620px");
        window.location.href=url;
        return false;

	}).mouseenter(function() {

		dialog.tips('添加', '.addBtn');

	})
	//顶部排序
	$('.listOrderBtn').click(function() {
		var url=$(this).attr('data-url');
		dialog.confirm({
			message:'您确定要进行排序吗？',
			success:function(){
				layer.msg('确定了')
			},
			cancel:function(){
				layer.msg('取消了')
			}
		})
		return false;

	}).mouseenter(function() {

		dialog.tips('批量排序', '.listOrderBtn');

	})	
	//顶部批量删除
	$('.delBtn').click(function() {
		var url=$(this).attr('data-url');
		dialog.confirm({
			message:'您确定要删除选中项',
			success:function(){
				var dataSource=[];
				var change=[];
				//执行批量删除操作
				//console.log($("#table-list").find("input[name ='id']"));
                //$("#table-list").find("input[name ='id']")
				//获取所有id
                $("#table-list").find("td[name ='id']").each(function () {
					console.log($(this).attr("value"));
					dataSource.push($(this).attr("value"));
                });
                // console.log(dataSource);
                // //转换为json串
				// change.push({rooms:dataSource});
                var str=JSON.stringify(dataSource);
                console.log("批量删除之前的数据："+str)
                $.ajax({
                    type: "POST",
                    url: url,
                    data: str,
                    dataType: "json",
                    success: function (data) {
                        // $('#resText').empty();   //清空resText里面的所有内容
                        // var html = '';
                        // $.each(data, function (commentIndex, comment) {
                        //     html += '<div class="comment"><h6>' + comment['username']
                        //         + ':</h6><p class="para"' + comment['content']
                        //         + '</p></div>';
                        // });
                        // $('#resText').html(html);
                        layer.msg('删除了');
                    }
                });
            },
			cancel:function(){
				layer.msg('取消了')
			}
		})
		return false;

	}).mouseenter(function() {

		dialog.tips('批量删除', '.delBtn');

	})	
	//列表添加
	$('#table-list').on('click', '.add-btn', function() {
		var url=$(this).attr('data-url');
		//将iframeObj传递给父级窗口
		//parent.page("菜单添加", url, iframeObj, w = "700px", h = "620px");
		window.location.href=url;
		return false;
	})
	//列表删除
	$('#table-list').on('click', '.del-btn', function() {
		var url=$(this).attr('data-url');
		var id = $(this).attr('data-id');
		var urlList = $(this).attr('data-list');
		dialog.confirm({
			message:'您确定要进行删除吗？',
			success:function(){
				//console.log(url)
                $.ajax({
                    type: "POST",
                    url: url,
                    async: false,
                    data: {_method:"DELETE"},
                    dataType: "json",
                    success: function(){
                        layer.msg('确定了')
                    }
                });
                layer.msg('已删除');
				console.log('123'+url);
                window.location.reload();
			},
			cancel:function(){
				layer.msg('已取消')
			}
		})
		return false;
	})
	//列表跳转
	$('#table-list,.tool-btn').on('click', '.go-btn', function() {
		var url=$(this).attr('data-url');
		var id = $(this).attr('data-id');
		window.location.href=url+"?id="+id;
		return false;
	})
	//编辑栏目
	$('#table-list').on('click', '.edit-btn', function() {
		var That = $(this);
		var id = That.attr('data-id');
		var url=That.attr('data-url');
		//将iframeObj传递给父级窗口
		parent.page("菜单编辑", url + "?id=" + id, iframeObj, w = "700px", h = "620px");
		return false;
	})
});

/**
 * 控制iframe窗口的刷新操作
 */
var iframeObjName;

//父级弹出页面
function page(title, url, obj, w, h) {
	if(title == null || title == '') {
		title = false;
	};
	if(url == null || url == '') {
		url = "404.html";
	};
	if(w == null || w == '') {
		w = '700px';
	};
	if(h == null || h == '') {
		h = '350px';
	};
	iframeObjName = obj;
	//如果手机端，全屏显示
	if(window.innerWidth <= 768) {
		var index = layer.open({
			type: 2,
			title: title,
			area: [320, h],
			fixed: false, //不固定
			content: url
		});
		layer.full(index);
	} else {
		var index = layer.open({
			type: 2,
			title: title,
			area: [w, h],
			fixed: false, //不固定
			content: url
		});
	}
}

/**
 * 刷新子页,关闭弹窗
 */
function refresh() {
	//根据传递的name值，获取子iframe窗口，执行刷新
	if(window.frames[iframeObjName]) {
		window.frames[iframeObjName].location.reload();

	} else {
		window.location.reload();
	}
	layer.closeAll();
}