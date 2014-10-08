//手机号码验证
var phoneReg = /^(?:13\d|15[0-9]|18[0-9])-?\d{5}(\d{3}|\*{3})$/;
Ext.apply(Ext.form.field.VTypes, {
    phone: function(val, field) {
        return phoneReg.test(val);
    },
    phoneText: '该输入项必须为手机号码',
    phoneMask: /[\d\s:amp]/i
});