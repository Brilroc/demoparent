    layui.use(['form', 'layer'], function () {
        var form = layui.form, layer = layui.layer;

    form.on('submit(uploadSub)', function(data){
        var formData = new FormData()  //创建一个forData
        formData.append('file', $('#upload_file')[0].files[0]) //把file添加进去  name命名为file
        if(!formData){
            return false;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            data: formData,
            url: 'imgUpload',
            contentType: false, //不设置内容类型
            processData: false, //不处理数据
            success: function (result) {
                layer.msg("上传成功")
                console.log(result.data);
                document.getElementById("crop_img").src = result.data; //上传成功后，为主截取区、截取预览区的img赋值
                document.getElementById("url").value = result.data; //用input hidden保存返回值，以便截取时使用
            }
        })
        return false;
    });




    /* 图片裁剪坐标数据上传 */
    form.on('submit(btn_crop)', function(data){
        $.ajax({
            type: "POST",
            dataType: "json",
            data:data.field,
            url:'imgClip',
            success: function (result) {
                layer.msg("裁剪成功")
            }
        })
        return false;
    });
    })

    /* 截取框选定事件的处理函数，用于获取最左上角的坐标点（x、y），截取框的宽高（w、h） */
    function updateCropData(c) {
        var html = document.documentElement;
        var windowWidth = html.clientWidth;

        jQuery("#x").val(parseInt((c.x)));
        jQuery("#y").val(parseInt((c.y)));
        jQuery("#w").val(parseInt((c.w)));
        jQuery("#h").val(parseInt((c.h)));

        console.group('updateCropData');
        console.info("html字体大小："+html.style.fontSize)
        console.info(c.x)
        console.info(c.y)
        console.info(c.w)
        console.info(c.h)
        console.groupEnd('updateCropData');
    }



//打开头像上传弹框
function openImgClip() {
    layer.open({
        type: 1,
        skin: 'layui-layer-rim', //加上边框
        area: ['510px', '410px'], //宽高
        title: '头像上传',
        btn: ['选择图片', '上传', '裁剪'],
        btn1: function(index, layero) {
            // 选择文件
            $("#upload_file").click();
            return false;
        },
        btn2: function(index, layero) {
            //上传
            $("#uploadSub").click();
            return false;
        },
        btn3: function(index, layero) {
            //裁剪提交
            $("#btn_crop").click();
        },
        content: $('#imgClip').html(), //调到新增页面
        success: function (layero, index) {
            /* jcrop 所需参数 */
            var jcrop_api;
            var boundx;
            var boundy;
            jQuery(function($){
                $("#crop_img").Jcrop({
                    bgOpacity: 0.5,
                    bgColor: 'black',
                    addClass: 'jcrop-light',
                    allowResize: false,
                    allowSelect: false,
                    onSelect: updateCropData //截取框选定事件，主要用于获得截取框的4个坐标点
                    //aspectRatio: 1 //截取框的比例，1则是正方形
                }, function () {
                    jcrop_api = this;

                    // var bounds = this.getBounds(); //获取图片实际尺寸，格式为：[w,h]
                    // boundx = bounds[0];
                    // boundy = bounds[1];
                    // var size = Math.min(boundx, boundy);

                    jcrop_api.setSelect([0,0,300,300]); //4个坐标点设定一个截取框
                });
            });
        }

    });
}


	


