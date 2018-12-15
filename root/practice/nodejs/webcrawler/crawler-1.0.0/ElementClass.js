// 


function getPagingClass(){

    return '.pagination__number';

}
exports.getPagingClass=getPagingClass;



function getPageNum($){

    var pn=$(this.getPagingClass());

    var length;
            if (pn == null) {
                length = 1;
            } else {
                if(pn.length<1){
                    length = 1;
                }else{
                    length = pn.length;
                }
                
            }

    return length;

}
exports.getPageNum=getPageNum;


