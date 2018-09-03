$(document).ready(function() {
	validateRule();
    // getConsumeLevelData();
    getDict("consumeLevel");
    getDict("numbersLevel");
    getDict("addressType");
});

$.validator.setDefaults({
	submitHandler : function() {
		update();
	}
});
/*function getConsumeLevelData() {
    // var obj = $("#consumeLevel");
    var consumeLevel =$("#consumeLevelHidden").val();
    var obj = document.getElementById("consumeLevel");
    $.ajax({
        url:"/business/businessInfo/consumeLevel",
        type: 'get',
        async: true,
        success: function (res) {
            if (res.data.length > 0) {
                $.each(res.data, function (index, e) {
                    if (consumeLevel == e.key) {
                        obj.add(new Option(e.value, e.key, true, true));
                    } else {
                    	obj.add(new Option(e.value, e.key));
                    }
                });
                $("#consumeLevel").trigger("chosen:updated");
                $("#consumeLevel").chosen();
            }
        }
    });
}*/
function getDict(dicType) {
    var dicTypeValue = $("#_"+dicType).val();
    var obj = document.getElementById(dicType);
    $.ajax({
        url:"/business/businessInfo/"+dicType,
        type: 'get',
        async: true,
        success: function (res) {
            if (res.data.length > 0) {
                $.each(res.data, function (index, e) {
                    if (dicTypeValue == e.key) {
                        obj.add(new Option(e.value, e.key, true, true));
                    } else {
                        obj.add(new Option(e.value, e.key));
                    }
                });
                $("#"+dicType).trigger("chosen:updated");
                $("#"+dicType).chosen();
            }
        }
    });
}
function update() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/business/businessInfo/update",
		data : $('#signupForm').serialize(),// 你的formid
		async : false,
		error : function(request) {
			parent.layer.alert("Connection error");
		},
		success : function(data) {
			if (data.code == 0) {
				parent.layer.msg("操作成功");
				parent.reLoad();
				var index = parent.layer.getFrameIndex(window.name); // 获取窗口索引
				parent.layer.close(index);

			} else {
				parent.layer.alert(data.msg)
			}

		}
	});

}
function validateRule() {
	var icon = "<i class='fa fa-times-circle'></i> ";
	$("#signupForm").validate({
		rules : {
			name : {
				required : true
			}
		},
		messages : {
			name : {
				required : icon + "请输入名字"
			}
		}
	})
}