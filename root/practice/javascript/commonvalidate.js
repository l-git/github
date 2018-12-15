
layui.define(['layer','common'],function(exports){ 
	
	var $=layer.jquery;
	
	var common=layui.common;
	
	
	var obj = {};
	obj.field='field';
	obj.title='title';
	obj.r='r';//required must input
	obj.l='l';//length
	obj.v='v';//data format valid
	
	
	function inValidAlert(msg){
		common.alert(msg);
	}
	
	var validateArr=[];
	var validateObj={};
	
	//验证空
	obj.vRequire='require';
	obj.require=function(col,field){
		
		if(col[obj.r]){
			var f =col[obj.field];
			var value=field[f];
			if(value==''){
				var msg=col.title+'不能为空';
				inValidAlert(msg);
				return false;
			}
		}
		return true;
	}
	
	validateObj={};
	validateObj.name=obj.require;
	validateArr.push(validateObj);
	
	
	
	//验证长度
	obj.vLength='l';
	obj.lengthValidate=function(col,field){
		
		if(col[obj.l]){
			var f =col[obj.field];
			var value=field[f];
			var title=col[obj.title];
			if(value.length>col.l){
				var msg=title+'长度不能超过'+col[obj.l]+'个字';
				inValidAlert(msg);
				return false;
			}

		}
		
		
		return true;
	}
	validateObj={};
	validateObj.name=obj.lengthValidate;
	validateArr.push(validateObj);
	
	
	
	//验证数字
	obj.vNum='isNum';
	
	obj.isNum=function(col,field){
		
		if(col[obj.v]==obj.vNum){
			var f=col[obj.field];
			var value=field[f];
			
			if(value==''){
				//不验证空
				return true;
			}
			
			if(/^[0-9]*$/.test(value)){
				
				return true;
			}
			var title=col.title||'';
			var msg=title+'必须是数字';
			inValidAlert(msg);
			return false;
		}
		return true;
	}
	
	validateObj={};
	validateObj.name=obj.isNum;
	validateArr.push(validateObj);

	
	
	obj.validate=function(field,cols){
		
		for(var i=0;i<cols.length;i++){
			var col=cols[i];
			
			/*var f=col[obj.field];*/
			
			/*if(col[obj.r]){
				
				if(!obj.require(field[f])){
					return false;
				}
				
			}*/
			
			for(var j=0;j<validateArr.length;j++){
				var vObj=validateArr[j];
				var name=vObj.name;
				if(!name(col,field)){
					return false;
				}
				
			}

			
		}
		
		return true;;
	}
	
	
	
	exports('commonvalidate', obj);
});




