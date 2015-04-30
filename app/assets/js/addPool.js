/**
 * Created by jeffy on 2015/4/30 0030.
 */
$(document).ready(function () {
    var isPoolName, isHost, isPort, isVersion = false;

    $('#poolName').bind('input propertychange', function () {
        var poolName = $(this).val();
        if (poolName.length > 16 || poolName.length < 1) {
            $(this).prev("span").removeClass("label-primary").addClass("label-danger");
        } else {
            $(this).prev("span").removeClass("label-danger").addClass("label-primary");
            isPoolName = true;
            add();
        }
    });

    $('#host').bind('input propertychange', function () {
        var host = $(this).val();
        var reg = new RegExp("^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?).){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$");
        if (!reg.test(host) || host.length > 16 || host.length < 1) {
            $(this).prev("span").removeClass("label-primary").addClass("label-danger");
        } else {
            $(this).prev("span").removeClass("label-danger").addClass("label-primary");
            isHost = true;
            add();
        }
    });

    $('#port').bind('input propertychange', function () {
        var number = $(this).val();
        var reg = new RegExp("^[0-9]*$");
        if (!reg.test(number) || number.length > 16 || number.length < 1) {
            $(this).prev("span").removeClass("label-primary").addClass("label-danger");
        } else {
            $(this).prev("span").removeClass("label-danger").addClass("label-primary");
            isPort = true;
            add();
        }
    });

    $('#version').bind('input propertychange', function () {
        var version = $(this).val();
        if (version.length > 16 || version.length < 1) {
            $(this).prev("span").removeClass("label-primary").addClass("label-danger");
        } else {
            $(this).prev("span").removeClass("label-danger").addClass("label-primary");
            isVersion = true;
            add();
        }
    });

    function add() {
        if(isPort && isHost && isPoolName && isVersion) {
            $("#add").attr("disabled", false);
        }
    }

});