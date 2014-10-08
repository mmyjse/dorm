/**
 * @author	J
 * @date	2013-04-16
 */
jQuery.extend({
	util : {},
	widget : {},
	culture : 'zh-CN',
	getSubMainWidth : function() {
		return window.parent.document.body.clientWidth - 240;
	},
	namespace : function(){
        var a=arguments, o=null, i, j, d, rt;
        for (i=0; i<a.length; ++i) {
            d=a[i].split(".");
            rt = d[0];
            eval('if (typeof ' + rt + ' == "undefined"){' + rt + ' = {};} o = ' + rt + ';');
            for (j=1; j<d.length; ++j) {
                o[d[j]]=o[d[j]] || {};
                o=o[d[j]];
            }
        }
    },
    urlEncode : function(o){
        if(!o){
            return "";
        }
        var buf = [];
        for(var key in o){
            var ov = o[key], k = encodeURIComponent(key);
            var type = typeof ov;
            if(type == 'undefined'){
                buf.push(k, "=&");
            }else if(type != "function" && type != "object"){
                buf.push(k, "=", encodeURIComponent(ov), "&");
            }else if(MOA.isDate(ov)){
                var s = MOA.encode(ov).replace(/"/g, '');
                buf.push(k, "=", s, "&");
            }else if(MOA.isArray(ov)){
                if (ov.length) {
                    for(var i = 0, len = ov.length; i < len; i++) {
                        buf.push(k, "=", encodeURIComponent(ov[i] === undefined ? '' : ov[i]), "&");
                    }
                } else {
                    buf.push(k, "=&");
                }
            }
        }
        buf.pop();
        return buf.join("");
    },
    urlDecode : function(string, overwrite){
        if(!string || !string.length){
            return {};
        }
        var obj = {};
        var pairs = string.split('&');
        var pair, name, value;
        for(var i = 0, len = pairs.length; i < len; i++){
            pair = pairs[i].split('=');
            name = decodeURIComponent(pair[0]);
            value = decodeURIComponent(pair[1]);
            if(overwrite !== true){
                if(typeof obj[name] == "undefined"){
                    obj[name] = value;
                }else if(typeof obj[name] == "string"){
                    obj[name] = [obj[name]];
                    obj[name].push(value);
                }else{
                    obj[name].push(value);
                }
            }else{
                obj[name] = value;
            }
        }
        return obj;
    },
    isArray : function(v){
        return v && typeof v.length == 'number' && typeof v.splice == 'function';
    },

    /**
     * Returns true if the passed object is a JavaScript date object, otherwise false.
     * @param {Object} object The object to test
     * @return {Boolean}
     */
    isDate : function(v){
        return v && typeof v.getFullYear == 'function';
    },
    getSysTheme : function() {
        var theme =  $('body').data('theme');
        if (theme == null) {
            theme = '';
        }
        else {
//            var url = $("#htdocsBaseUrl").val() + "/js/libs/jqwidgets/styles/jqx." + theme + '.css';
//            $(document).find('head').append('<link rel="stylesheet" href="' + url + '" media="screen" />');
            return theme;
        }
        var themestart = window.location.toString().indexOf('?');
        if (themestart == -1) {
            return '';
        }

        var theme = window.location.toString().substring(1 + themestart);
        var url = $("#htdocsBaseUrl").val() + "/js/libs/jqwidgets/styles/jqx." + theme + '.css';

        if (document.createStyleSheet != undefined) {
            var hasStyle = false;
            $.each(document.styleSheets, function (index, value) {
                if (value.href != undefined && value.href.indexOf(theme) != -1) {
                    hasStyle = true;
                    return false;
                }
            });
            if (!hasStyle) {
                document.createStyleSheet(url);
            } 
        }
        else $(document).find('head').append('<link rel="stylesheet" href="' + url + '" media="screen" />');
      
        return theme;
    },
    pagerRenderer : function(id) {
    	//pagenum 0 pagescount 0 pagesize 10
    	var element = $("<div class='wi-pagination'></div>");
    	var paginginfo = $("#" + id).jqxGrid('getpaginginformation');
		
    	//下一页
    	var anchor = $("<a href='javascript:void(0)'><span>" + '下一页' + "</span></a>");
    	if (paginginfo.pagescount > 1 && paginginfo.pagenum != paginginfo.pagescount - 1) {
    		anchor.addClass("enable");
    	} else {
    		anchor.addClass("disable");
    	}
		anchor.appendTo(element);
        anchor.click(function (event) {
        	//计算下一页
        	var next = paginginfo.pagescount;
        	if (paginginfo.pagenum >= paginginfo.pagescount - 1) {
        		next = paginginfo.pagescount - 1;
        	} else {
        		next = paginginfo.pagenum + 1;
        	}
        	$("#" + id).jqxGrid('gotopage', next);
        });
    	
        //数字分页
        var countPrePoint = 0, countNextPoint = 0;
        for (var i = paginginfo.pagescount - 1; i >= 0 ; i--) {
        	var showPrePoint = paginginfo.pagescount > 5 
        					&& i != 0
        					&& paginginfo.pagenum > 3
        					&& i < paginginfo.pagenum - 2
        					&& i < paginginfo.pagescount - 5;
        	var showNextPoint = paginginfo.pagescount > 5 
								&& i != paginginfo.pagescount - 1
								&& paginginfo.pagenum < paginginfo.pagescount - 4
								&& i > paginginfo.pagenum + 2
								&& i > 4;				
        	if (showPrePoint) {
        		if (countPrePoint++ == 0) {
        			anchor = $("<span class='points'>...</span>");
        			anchor.appendTo(element);
        		}
        	} else if (showNextPoint) {
        		if (countNextPoint++ == 0) {
        			anchor = $("<span class='points'>...</span>");
        			anchor.appendTo(element);
        		}
        	} else {
        		anchor = $("<a href='javascript:void(0)'><span>" + (i + 1) + "</span></a>");
        		if (i == paginginfo.pagenum) {
        			anchor.addClass("this");
        		}
        		anchor.appendTo(element);
        		anchor.click(function (event) {
        			var pagenum = parseInt($(event.target).text()) - 1;
        			$("#" + id).jqxGrid('gotopage', pagenum);
        		});
        	}
        }
		
        //上一页
        anchor = $("<a href='javascript:void(0)'><span>" + '上一页' + "</span></a>");
        if (paginginfo.pagenum != 0) {
    		anchor.addClass("enable");
    	} else {
    		anchor.addClass("disable");
    	}
		anchor.appendTo(element);
        anchor.click(function (event) {
        	//计算上一页
        	var pre = 0;
        	if (paginginfo.pagenum == 0) {
        		pre = 0;
        	} else {
        		pre = paginginfo.pagenum - 1;
        	}
        	$("#" + id).jqxGrid('gotopage', pre);
        });
    	return element;
    }
});

var Global = {
		Import : function(filePath,charSet){
	    	var alpRoot = 'http://portal.bew.jwsz.net:5918/js/';
	    	if(typeof(charSet)!='string') charSet='utf-8';
	    	var src = '';
	    	if (filePath.match(/\.js$/i)) {
	    		src = (filePath.indexOf('http') == 0) ? filePath : alpRoot + filePath;
	    		document.write('<script charset="'+charSet+'" type="text/javascript" src="' + src + '"></script>');
	    	}
	    }
}; 


