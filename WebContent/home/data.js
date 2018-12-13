/**
 * 
 */
function upData(){
	$.post("../AtyGetData", {"operation":3, "year":year, "farm":farm}, function (data) {
		data = $.parseJSON(data);
		var option ={ 
			    series: [{
			        data: data,
			        type: 'bar'
			    }],
			};
		column_chart.hideLoading();
		column_chart.setOption(option);
	});
	$.post("../AtyGetData", {"operation":4, "year":year, "farm":farm}, function (data) {
		data = $.parseJSON(data);
		var option ={ 
			    series: [{
			        data: data,
			        type: 'line'
			    }],
			};
		line_chart.hideLoading();
		line_chart.setOption(option);
	});
}
$(function () {
	column_chart = echarts.init(document.getElementById('column_chart'), 'dark');
	line_chart = echarts.init(document.getElementById('line_chart'), 'dark');
	line_chart.setOption({ 
		title: {
			text: '价格走势图(元/斤)',
		},
	    xAxis: {
	        type: 'category',
	        data: ['1-3月','4-6月','7-9月','10-12月',],
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: ['820', '932', 901, 934],
	        type: 'line'
	    }],
	});
    column_chart.setOption({ 
		title: {
			text: '交易量直观图(万斤)',
		},
	    xAxis: {
	        type: 'category',
	        data: ['1-3月','4-6月','7-9月','10-12月',],
	    },
	    yAxis: {
	        type: 'value'
	    },
	    series: [{
	        data: ['820', '932', 901, 934],
	        type: 'bar'
	    }],
	});
    column_chart.showLoading();
    line_chart.showLoading();
	$.post("../AtyGetData",{"operation":1}, function(d) {
		var data = $.parseJSON(d);
		str1 = "";
		for(var i = 0; i < data.length; i++){
			str1 += "<option value='"+data[i]+"'>"+data[i]+"</option>   ";
		}
		year = data[0];
		str2 = "";
		$.post("../AtyGetData",{"operation":2}, function(da){
			var dat = $.parseJSON(da);
			for(var i = 0; i < dat.length; i++){
				str2 += "<option value='"+dat[i]+"'>"+dat[i]+"</option>   ";
				
			}
			farm = dat[0];
			$("#year").html(str1).change(function () {
				year= $("#year").val();
				upData();
			});
			$("#farm").html(str2).change(function () {
				farm = $("#farm").val();
				upData();
			});
			upData();
		});
	});


	
	
	
});