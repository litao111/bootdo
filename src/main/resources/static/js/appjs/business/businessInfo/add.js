$(document).ready(function() {
	validateRule();
    // getConsumeLevelData();
	getDict("consumeLevel");
    getDict("numbersLevel");
    getDict("addressType");
});
$.validator.setDefaults({
	submitHandler : function() {
		save();
	}
});
/*function getConsumeLevelData() {
    // var obj = $("#consumeLevel");
    var obj = document.getElementById("consumeLevel");
    $.ajax({
        url:"/business/businessInfo/consumeLevels",
        type: 'get',
        async: true,
        success: function (res) {
            if (res.data.length > 0) {
                $.each(res.data, function (index, e) {
                    // if (city == e.city) {
                    //     obj.add(new Option(e.city, e.city, true, true));
                    // } else {
                    obj.add(new Option(e.value, e.key));
                    // }
                });
                $("#consumeLevel").trigger("chosen:updated");
                $("#consumeLevel").chosen();
            }
        }
    });
}*/
function getDict(dicType) {
    var dicTypeValue = $("#"+dicType).val();
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
function save() {
	$.ajax({
		cache : true,
		type : "POST",
		url : "/business/businessInfo/save",
		// data : $('#signupForm').serialize(),// 你的formid
		data : new FormData($('#signupForm')[0]),// 你的formid
        processData: false,
        contentType: false,
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
				required : icon + "请输入姓名"
			}
		}
	})
}