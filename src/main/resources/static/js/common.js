/**
 * 
 */
var common = {
	model:		{
		ajax: function(params) {
			$.ajax(params.url, {
				async: (params.async == null)? true : params.async
				
			});
		}
	},
	view:		{},
	controller: {},
	err:		{}
}