Ext.define("ComboboxModel", {
	extend : 'Ext.data.Model',
	fields : [ {
		name : 'name'
	}, {
		name : 'id'
	} ]
});
//区域下拉框
var areaStore = Ext.create("Ext.data.Store", {
	model : 'ComboboxModel',
	proxy : {
		type : 'ajax',
		url : './network/getNetworks',
		reader : {
			type : 'json'
		}
	},
	autoLoad : false
});
//网点下拉框
var nodeStore = Ext.create("Ext.data.Store", {
	model : 'ComboboxModel',
	proxy : {
		type : 'ajax',
		url : './network/getNetworks',
		reader : {
			type : 'json'
		},
		extraParams : {expressAreaId : 1}
	},
	autoLoad : true
});

required = '<span style="color:red;font-weight:bold" data-qtip="Required">*</span>';