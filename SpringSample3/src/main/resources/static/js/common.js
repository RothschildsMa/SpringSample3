/**
 * 
 */

function submitForm(formId,url,method=undefined){
	var form = document.getElementById(formId);
	form.action=url;
	if(method !== undefined) form.method=method;
	form.submit();
}
 
 