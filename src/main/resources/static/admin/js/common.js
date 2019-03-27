
layui.config({
	base: 'admin/js/module/'
}).extend({
	dialog: 'dialog',
});
//加载动画
var _index; //用来关闭遮罩
var _lp_baseTime = 0;
var _lp_startTime = 0;
function updateLoadProgress() {
    if (_lp_baseTime < 0) {
        layer.close(_index);
        return;
    }
    var dval = parseInt(new Date().valueOf())- parseInt(_lp_startTime);
    var timeDifference = (dval / _lp_baseTime).toFixed(2);
    var lp = timeDifference < 1 ? timeDifference * 100 : 99;
    $("#loadProgress").html(parseInt(lp));
    setTimeout(function () { updateLoadProgress(); return; }, 650);
}
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
        var token =$("meta[name='_csrf']").attr("content");
        var header=$("meta[name='_csrf_header']").attr("content");
		dialog.confirm({
			message:'您确定要删除选中项',
			success:function(){
				var dataSource=[];
				var change=[];
				var i=0;
				//获取所有id
                $("#table-list").find("td[name ='id']").each(function () {
					console.log($(this).attr("value"));
					console.log($(this).siblings(".box").find("div"))
					if($(this).siblings(".box").find("div").attr("class")=="layui-unselect layui-form-checkbox layui-form-checked"){
                        i++;
                        dataSource.push(parseInt($(this).attr("value")));
					}
                });
                console.log("批量删除之前的数据："+dataSource);
                $(document).ajaxSend(function(e,xhr,options){
                    xhr.setRequestHeader(header, token);
                });
                $.ajax({
                    type: "POST",
                    url: url,
                    data: {"ids":dataSource},
                    traditional: true,
                    async: false,
                    success: function (data) {
                        layer.msg('已删除');
                        window.setTimeout(function () {
                            window.location.reload();
                        },500)

                    },
                    error:function (data) {
                        layer.msg('服务器出现错误，请联系管理员');
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
        var token =$("meta[name='_csrf']").attr("content");
        var header=$("meta[name='_csrf_header']").attr("content");
		dialog.confirm({
			message:'您确定要进行删除吗？',
			success:function(){
                _index = layer.load(1, {
                    content: "<div style='margin-left:-47px;padding-top:44px;width:120px;color:#FFF;text-align: center'>正在删除</div>",
                    shade: [0.5, '#000']
                });
				//console.log(url)
                $(document).ajaxSend(function(e,xhr,options){
                    xhr.setRequestHeader(header, token);
                });
                $.ajax({
                    type: "POST",
                    url: url,
                    async: false,
                    data: {_method:"DELETE"},
                    beforeSend:function(){
                    },
                    success: function(data){
                        _lp_baseTime = -1;
                        $("#loadProgress").html("100");layer.close(_index);
                        layer.msg('已删除');
                        window.setTimeout(function () {
                            window.location.reload();
                        },500)
                    },
                    error :function (data) {
                        layer.msg(data)
                    }
                });
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
