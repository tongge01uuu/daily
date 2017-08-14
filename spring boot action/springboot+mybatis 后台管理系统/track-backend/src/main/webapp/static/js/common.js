/**
 *  自定义扩转模块
 */
layui.define(['layer'], function (exports) {
    var $ = layui.jquery, layer = layui.layer;
    var CmsCommon = {
        cmsError: function (msg, title) {
            parent.layer.alert(msg, {
                title: title,
                icon: 2,
                time: 0,
                resize: false,
                zIndex: layer.zIndex,
                anim: Math.ceil(Math.random() * 6)
            });
            return
        }, cmsInfo: function (msg, title) {
            parent.layer.alert(msg, {
                title: title,
                icon: 6,
                time: 0,
                resize: false,
                zIndex: layer.zIndex,
                anim: Math.ceil(Math.random() * 6)
            });
            return
        },
        // ajax Confirm 对话框
        ajaxCmsConfirm: function (title, text, url,param) {
            layer.confirm(text, {
                title: title,
                resize: false,
                btn: ['确定', '取消'],
                btnAlign: 'c',
                anim:1,
                icon: 3
            }, function () {
                $.ajax({
                    url : url,
                    type : 'post',
                    async: false,
                    data : param,
                    success : function(data) {
                        if(data.returnCode == 0000){
                            layer.msg(data.returnMessage);
                            location.reload();
                        }else{
                            layer.msg(data.returnMessage);
                        }
                    },error:function(data){

                    }
                });

            }, function () {

            })

        },
        logOut: function (title, text, url, type, dataType, data, callback) {
            parent.layer.confirm(text, {
                title: title,
                resize: false,
                btn: ['确定退出系统', '不，我点错了！'],
                btnAlign: 'c',
                icon: 3
            }, function () {
                location.href = url
            }, function () {
               
            })
        },logOutRightNow: function (title, text, url, type, dataType, data, callback) {
            parent.layer.confirm(text, {
                title: title,
                resize: false,
                btn: ['确定退出系统'],
                btnAlign: 'c',
                icon: 3
            }, function () {
                var index = parent.layer.getFrameIndex(window.name); //先得到当前iframe层的索引
                parent.layer.close(index); //再执行关闭                        //刷新父页面
                parent.location.reload();
                location.href = url
            }, function () {
            })
        }
    };
    exports('common', CmsCommon)
})



