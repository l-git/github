
function getShops() {

    var shops = [];


    var shopsNameArr = [
        "xyj1105"
    ];

    for(var i=0;i<shopsNameArr.length;i++){
        var shopObj={};
        shopObj.shopName=shopsNameArr[i];
        shops.push(shopObj);
    }

    return shops;

}




exports.getShops = getShops;
