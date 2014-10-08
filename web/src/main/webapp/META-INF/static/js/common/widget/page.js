var MOA= MOA || {};
(function(ns, $) {
	
	function toDBC(str) {
	    var dbc = str.replace(/\u3000/g, ' ').replace(/[\uFF00-\uFF65]/g, function(code){
	        return str.fromCharCode(code.charCodeAt(0) - 65248);
	    });
	    
	    return dbc;	
	}
	
	function isInteger(num) {
		return (/^[\d]+$/i).test(num);
	}
	
	ns.Page = function(){};
	
	var pages={};

	/**
	 * 
	 * @param {JSelect} $id  组件Jid  '#id'
	 * @param {Object} param param = {curPage:10,totalPage:20,hasBtn:true,isSimple:false} 
	 * @param {Object} callback(targetPage, act) 目标页码， 动作[prve, next, goto, num] 表示点击的上一页，下一页，确定，页码
	 */	
	ns.getPage = function($id, param, callback){
		if (!pages[$id]) {
			pages[$id] = new ns.Page();
			pages[$id]._cb = callback;
			pages[$id]._$node = $($id);
			pages[$id]._$id = $id;
			pages[$id]._param = {};
			
			if (param.curPage) {
				pages[$id]._param.curPage = parseInt(param.curPage, 10);
			}
			if (param.totalPage) {
				pages[$id]._param.totalPage = parseInt(param.totalPage, 10);
			}
			if (param.hasBtn) {
				pages[$id]._param.hasBtn = param.hasBtn;
			}
			if (param.isSimple) {
				pages[$id]._param.isSimple = param.isSimple;
			}
		}
		return pages[$id];
	};
			
	$.extend(ns.Page.prototype,{
		/**
		 * 初始化，绑定事件，如果$node中没有分页，则先创建
		 */
		init: function(){
			var self = this;
			if (this._$node.attr("hide")) {
				return;
			}
			if (this._$node.find('.lt-page').length == 0) {
				this.create();
			}
			
			this._$node.find("a").bind("click", function(e){
				var $t = $(this);
				var target = {act:$t.attr('rel'), txt: $t.text(), inputVal: parseInt(self.getFormatInputVal(),10)};
				
				self._clickHandler(target);
				return false;
			});
			// bind Key Enter for input
			this._$node.find("input").bind("keyup", function(e){
				if (e.which == 13) {
					self._$node.find("a[rel=goto]").click();
				}
			});
		},

		
		/**
		 * @param {Object} target {act:String, txt: String, inputVal: Int} act的值：prev/next/goto/undefined[表示点击的是页码]
		 */
		_clickHandler: function(target) {

			var tarPage //target page
			,	act = target.act || 'num'
			,	curPage = this._param.curPage
			,	totalPage = this._param.totalPage
			;
			
			tarPage = this.getTargetPage(target, curPage, totalPage);

			this.setInputVal(tarPage);
			
			if (tarPage == curPage) {
				return;
			}
			// gc
			this.release();
			
			// callback 
			this._cb(tarPage, act);	

		},
		/**
		 * 获得目标页码
		 * @param {Object} target {act:String, txt: String, inputVal: Int} act的值：prev/next/goto/num[表示点击的是页码]
		 * @param {Int} curPage 当前页
		 * @param {Int} totalPage 总页数
		 */
		getTargetPage: function(target, curPage, totalPage) {
			var tarPage
			,	act = target.act
			;
			
			if (this[act]) {
				tarPage = this[act](curPage, totalPage, target.inputVal);
			} else {
				tarPage = parseInt(target.txt);
				
			}
			
			return tarPage;
			
		},		
		
		/**
		 * 格式化页码
		 * @param {Int} tarPage 目标页码
		 * @param {Int} totalPage 总页数
		 */
		formatPage: function(tarPage, totalPage) {
			
			if (tarPage < 1) {
				tarPage = 1;
			}
			if (tarPage > totalPage) {
				tarPage = totalPage;
			}
			return tarPage;			
		},
		
		/**
		 * 返回上一页页码
		 * @param {Int} curPage 当前页
		 */
		prev: function(curPage, totalPage) {
	
			var tarPage = curPage - 1;
			tarPage = this.formatPage(tarPage, totalPage);
			return tarPage;
			
		},
		/**
		 * 返回下一页页码
		 * @param {Int} curPage 当前页
		 */		
		next: function(curPage, totalPage) {
						
			var tarPage = curPage + 1;
			tarPage = this.formatPage(tarPage, totalPage);			
			return tarPage;
		},
		
		/**
		 * 返回目标页页码
		 * @param {Int} curPage 当前页
		 * @param {Int} valPage 目标页码
		 */		
		'goto': function(curPage, totalPage, valPage) {
			
			if (isNaN(valPage)) {
				return this.formatPage(curPage, totalPage);
			}
			return this.formatPage(valPage, totalPage);
		},
		
		/**
		 * 设置输入框中的值
		 * @param {Int} tarPage 目标页码
		 */
		setInputVal: function(tarPage) {
			this._$node.find("input:text").val(tarPage);
		},
		
		/**
		 * 获取格式化后的输入框中的值
		 */
		getFormatInputVal: function() {
			var val = this._$node.find("input:text").val();
			val = val || '';
			val =jQuery.trim(toDBC(val)); 
			return val;
		},	
		/**
		 * 获取分页model
		 */
		getPageModel: function() {
			
			var model = []
			,	curPage = this._param.curPage
			,	totalPage = this._param.totalPage
			,	isSimple = this._param.isSimple
			,	hasBtn = this._param.hasBtn
			,	n
			;			
			
			if (curPage != 1) {
				model[0] = ['prev'];
			}
			if (isSimple) {
				model.push('simple');
			}
			if (!isSimple) {
				
				// 当前页 之左侧页码
				if (curPage >= 5) {
					model = ['prev',1,2,'omit',curPage - 1];
				} else {
					for (n = 1; n < curPage; n++) {
						model.push(n);
					}				
				}
				
				// 当前页 
				model.push('curPage');
				
				// 当前页 之右侧页码
				if (totalPage != curPage) {
					if (totalPage - curPage >= 4) {
						model = model.concat([curPage + 1, 'omit', totalPage - 1, totalPage]);
					} else {
						for ( n = curPage + 1; n <= totalPage; n++) {
							model.push(n);
						}	
					}
				}				
			}
			
			if (totalPage != curPage) {
				model.push('next');
			}
			
			if (hasBtn) {
				model.push('button');
			}	
			return model;
		},
		/**
		 * 获取分页view
		 * @param {Array} model
		 */
		getPageView: function(model) {
			var page = []
			,	i
			,	tpl = {'prev' : '<a class="node" rel="prev" href="#prevPage">&lt;&nbsp;上一页</a>',
					'next' : '<a href="javascript:;" rel="next" class="node node_cn">下一页&nbsp;&gt;</a>',
					'omit' : '<i>...</i>',
					'simple' : '<span class="info lt-page-s"><span class="current">' + this._param.curPage + '</span><span class="split">/</span><span>' + this._param.totalPage + '</span></span>',
					'button' : '<span class="goto">到<input type="text" class="ac">页<a href="javascript:;" rel="goto" class="lt-btn-page">确定</a></span>',
					'curPage' : '<a class="current">' + this._param.curPage + '</a>',
					'default': function(page){
							return '<a class="node" href="javascript:;">' + page + '</a>';
						}
				}
			;
			
			page.push('<span class="lt-page lt-page-l">');
					
			for (i = 0; i < model.length; i++) {
				
				if (isInteger(model[i])) {
					page[i + 1] = tpl['default'](model[i]);
				} else {
					page[i + 1] = tpl[model[i]];
					
				}
			}
		
			page.push('</span>');
			
			return page.join('');
		},

		create: function(){
			var totalPage, model=[];
			
			this.release();
			this._$node = $(this._$id);
	
			totalPage = this._param.totalPage;
			
			if (totalPage === 1 || totalPage === 0 || isNaN(totalPage)) {
				this._$node.hide();
				return;
			} else {
				this._$node.show();
			}
			
			model = this.getPageModel();
			this._$node.html(this.getPageView(model));
		},
		/**
		 * 释放$node
		 */
		release: function(){
			this._$node.find("a").unbind("click");
			this._$node.find("input").unbind("keyup");
			this._$node = undefined;
		}		
	});
	
})(MOA, jQuery);
