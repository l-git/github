

// 

function log(m) {
    console.log(m);
}

var requestCounter=0;

var request = require('request');
var cheerio = require('cheerio');
var URL = require('url-parse');
var fs = require('fs');


var ShopUrl=require('./ShopUrl');

var ElementClass=require('./ElementClass');


var ShopObj={

    collectionTotalPage:0,
    collectionTotalPageCounter:0,
    collections:[],
    collectionAlbumPageCounter:0

};







function requestFunction(cb, pageToVisit,i) {
    requestCounter++;
    log('requestCounter:'+requestCounter);
    request(pageToVisit, function (error, response, body) {
        if (error) {
            log("Error: " + error);
        }else if (response.statusCode === 200) {
            var $ = cheerio.load(body);
            cb($,i);
        }
    });
}

var shopName='xyj1105';

function main(){

    
    var pageToVisit=ShopUrl.getShopUrl(shopName);

    requestFunction(afterLoadShop,pageToVisit);



}

main();

function afterLoadShop($){


    ShopObj.collectionTotalPage=ElementClass.getPageNum($);

    log(ShopObj);

    parseCollection();



}

function parseCollection(){

    for(var i=1;i<=ShopObj.collectionTotalPage;i++){

        (function(i){


            var pageToVisit=ShopUrl.getShopUrl(shopName,i);

            getCollectionList(pageToVisit);



        })(i);
        

    }

}




function getCollectionList(pageToVisit){

    requestFunction(getCollection,pageToVisit)


}

function getCollection($){

    var collectionsEle=$('.show-layout-category__catewrap');

    

    for(var i=0;i<collectionsEle.length;i++){

        var collection={};

        var collectionEle=collectionsEle[i];

        collection.title=$(collectionEle).find('a').attr('title');
        collection.href=$(collectionEle).find('a').attr('href');


        ShopObj.collections.push(collection);


    }

    ShopObj.collectionTotalPageCounter++;
    afterGetCollectionOfPage();

}


function afterGetCollectionOfPage(){

    if(ShopObj.collectionTotalPage==ShopObj.collectionTotalPageCounter){

       
        console.log(ShopObj.collections);
        log('collections get complement');
        log('total collections:'+ShopObj.collections.length);
        

        startParseAlbum();


    }else{

        log('collection:');
        log(ShopObj.collections[ShopObj.collections.length-1]);



    }


}


//startParseAlbum

function startParseAlbum(){

    for(var i=0;i<ShopObj.collections.length;i++){

        (function(i){
            var collection=ShopObj.collections[i];
            //ShopObj.collections[i].albums=[];

            var pageToVisit=ShopUrl.getCollectionUrl(collection.href);

            requestFunction(getTotalPageOfCollection,pageToVisit,i);

        })(i);
    
    }

    
    for(var i=0;i<ShopObj.collections.length;i++){

        // var collection=ShopObj.collections[i];
        // var pageToVisit=domain+collection.href
        // requestFunction(,)

        // ShopObj.collections[i].albums=[];





    }



}


function getTotalPageOfCollection($,i){

    ShopObj.collections[i].albumTotalPage=ElementClass.getPageNum($);
    ShopObj.collectionAlbumPageCounter++;
    if(ShopObj.collectionAlbumPageCounter==ShopObj.collections.length){

        log(ShopObj);
        log('every collection total album calc complete');

        //complete total page of every collection

    }
}












