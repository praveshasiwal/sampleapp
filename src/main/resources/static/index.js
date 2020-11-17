$(document).ready(function () {
	var baseUrl = "http://localhost:8080/api/v1/finance";
	
	var ajaxCall = function(usedURL) {
        $.ajax({
            url: usedURL,
            method: 'GET',
            success: function (data, status, xhr) {
                inflate(data);
            },
            error: function (jqXhr, textStatus, errorMessage) {
                alert(JSON.stringify(errorMessage));
            }
        });
    }

    $('#selector').on('change', function (e) {
        var optionSelected = $("option:selected", this);
        var valueSelected = this.value;
        console.log(valueSelected);
        ajaxCall(baseUrl + '/search?sector=' + valueSelected);
    });
    
    ajaxCall(baseUrl);
    var inflate = function (datas) {
        $("#data").empty();
        $.each(datas, function (index, value) {
            var record = "<div class='row'><div class='col-sm-3'>" + value.id + "</div>"
                + "<div class='col-sm-3'>" + value.sector + "</div>"
                + "<div class='col-sm-3'>" + value.numberOfFacilities + "</div>"
                + "<div class='col-sm-3'>" + value.numberOfCustomer + "</div>"
                + "</div>";
            console.log(record);
            $("#data").append(record);
        });
    }
});




