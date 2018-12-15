// 
var domain='http://x.yupoo.com';


function getShopUrl(shopName,page){

    var pageToVisit=domain+'/photos/'+shopName+'/albums?page='+page;


    return pageToVisit;

}

exports.getShopUrl=getShopUrl;






function getCollectionUrl(href,page){

    var pageToVisit=domain+href+'?page='+page;

    return pageToVisit;


}

exports.getCollectionUrl=getCollectionUrl;


