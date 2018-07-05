$(document).ready(function () {

    var id = $('#id').text();
    console.debug("id=%d", id);

    $('input').click(function () {
        console.debug("#veryLike click");
        var bSuccess = false;
        console.debug("$(this)={}", $(this));
        $.ajax({
            type:"POST",
            url:"/answer.action",
            dataType:"json",
            async:false,
            data:{
                id:id,
                value:$(this).val()
            },
            success:function (data) {
                console.debug(data);
                console.debug(data.code);
                if (data.code == 0) {
                    bSuccess = true;
                }
            }
        });
        console.debug("bSuccess=%s", bSuccess);
        if (bSuccess) {
            if (id != 240) {
                console.debug("getQuestion.action id=%d", id + 1);
                window.location.href="/getQuestion.action?id="+(parseInt(id)+1);
            } else {
                console.debug("id=240");
                window.location.href="/result.action";
            }
        }
    });

});