
function log(m) {
    console.log(m);
}

var requestCounter=0;

var request = require('request');
var cheerio = require('cheerio');
var URL = require('url-parse');
var fs = require('fs');

var download = require('./download');
var shopsModule = require('./shopsModule');


var db = require('./db');

//process.chdir('image');

var shops = shopsModule.getShops();


var albums = [];

var album = {};

var domain = "http://x.yupoo.com";


function getPageToVisit(shopName, page) {

    var pageToVisit = "http://x.yupoo.com/photos/" + shopName + "/albums?page=" + page;

    return pageToVisit;
}

function getCollectionsPage(collection, page) {
    var pageToVisit = domain + collection.href + '?page=' + page;
    return pageToVisit;
}


function getAlbumPage(album, page) {
    var pageToVisit = domain + album.href + '?page=' + page;
    return pageToVisit;
}







function requestFunction(cb, pageToVisit) {
    requestCounter++;
    console.log('requestCounter:'+requestCounter);
    request(pageToVisit, function (error, response, body) {
        if (error) {
            console.log("Error: " + error);
        }else if (response.statusCode === 200) {
            var $ = cheerio.load(body);
            cb($);
        }
    });
}

start(shops);

function start(shops) {

    for (var s = 0; s < shops.length; s++) {

        var shopObj = shops[s]

        var shopName = shopObj.shopName;

        var pageToVisit = getPageToVisit(shopName, 1);

        requestFunction(function ($) {

            var pn = $('.pagination__number');
            var length;
            if (pn == null) {
                length = 1;
            } else {
                length = pn.length;
            }

            shopObj.totalPage = length;

            var page = 1;
            parseShop(shops,shopObj, page);


        }, pageToVisit);


    }

}


function parseShop(shops,shop, page) {



    var pageToVisit = getPageToVisit(shop.shopName, page);

    parsePage(shops, shop, page,pageToVisit);

}


function parsePage(shops, shop, page,pageToVisit) {

    if (page > shop.totalPage) {

        parseCollections(shops,shop);

        return;
    }


    requestFunction(function ($) {

        var sectionArr;
        if (shop.collections == undefined) {
            sectionArr = [];
            shop.collections = sectionArr;
        } else {
            sectionArr = shop.collections;
        }

        var category = $('.show-layout-category__catewrap');
        for (var i = 0; i < category.length; i++) {

            var cObj = {};


            var c = category[i];
            var a = $(c).find('a');
            var title = a.attr('title');
            cObj.categoryName = title;
            cObj.href = a.attr('href');
            cObj.collectionId = cObj.href.substr(cObj.href.lastIndexOf('/') + 1);

            //cObj.href=$(c).find('a').attr('href');

            // var cAlbum = [];


            // if ('Guciheaven古奇天伦通知库存活动相关' == cObj.categoryName) {
            //     continue;
            // }


            // var showindex__children = $(c).find('.showindex__children');

            // for (var j = 0; j < showindex__children.length; j++) {


            //     var a1 = {};
            //     var obj = showindex__children[j];

            //     a1.albumTitle = $(obj).find('a').attr('title');
            //     a1.albumHref = $(obj).find('a').attr('href');
            //     a1.albumImgSrc = $(obj).find('img').attr('src');

            //     a1.localSrc = download.download_file_curl( a1.albumImgSrc);


            //     cAlbum.push(a1);

            // }
            // cObj.album = cAlbum;


            sectionArr.push(cObj);

        }


        page++;
        var pageToVisit = getPageToVisit(shop.shopName, page);
        parsePage(shops, shop, page,pageToVisit);


    }, pageToVisit);

}


function parseCollections(shops,shop) {

    recursiveCollection(shops,shop,0);

    // var collections = shop.collections;

    // for (var i = 0; i < collections.length; i++) {

    //     var collection = collections[i];
    //     var pageToVisit = getCollectionsPage(collection, 1);
    //     (function (shops,shop,collection) {

    //         requestFunction(function ($) {

    //             var pn = $('.pagination__number');
    //             var length;
    //             if (pn == null) {
    //                 length = 1;
    //             } else {
    //                 length = pn.length;
    //                 if (length < 1) {
    //                     length = 1;
    //                 }
    //             }
    //             collection.totalPage = length;

    //             parseCollection(shops,shop,collection, 1);

    //         }, pageToVisit);

    //     })(shops,shop,collection);





    // }

}


function recursiveCollection(shops,shop,collectionNum){

    if(collectionNum>=shop.collections.length){



        db.insert(shops,afterInsert);


       // parseCollection(shops,shop,collection, 0);


    }else{

        var collections = shop.collections;
        var collection=collections[collectionNum];

        var pageToVisit = getCollectionsPage(collection, 1);


            requestFunction(function ($) {

                var pn = $('.pagination__number');
                var length;
                if (pn == null) {
                    length = 1;
                } else {
                    length = pn.length;
                    if (length < 1) {
                        length = 1;
                    }
                }
                collection.totalPage = length;

                collectionNum++;
                recursiveCollection(shops,shop,collectionNum);

            }, pageToVisit);


        

    }

    


}



function afterInsert(shop,id){


    var collections=shop.collections;
    for(var i=0;i<collections.length;i++){

        var collection=collections[i];

        db.insertCollection(collection,id,afterInsertCollection);



    }




}


function afterInsertCollection(collection,dbCollectionId){


    for(var i=0;i<=collection.totalPage;i++){

        var pageToVisit=getCollectionsPage(collection,i);

        requestFunction(function ($) {

            var showindex__children = $('.showindex__children');
            
            for(var j=0;j<showindex__children.length;j++){

                var sc=showindex__children[j];

                var a=$(sc).find('a');

                var title=a.attr('title');
                var href=a.attr('href');


                var albumObj={};
                albumObj.title=title;
                albumObj.href=href;
                albumObj.imgSrc=$(sc).find('img').attr('src');

                db.insertAlbum(albumObj,dbCollectionId,afterInsertAlbum);
                
                // console.log('INSERT INTO t_yupoo_album(album_num,album_name,collection_id,create_date) VALUES(\''
                // +albumObj.imgSrc+','+albumObj.title+',now())');

                // afterInsertAlbum(albumObj,100);




            }



        }, pageToVisit);


    }



    }
    




    function afterInsertAlbum(album,dbId){

        var pageToVisit=getAlbumPage(album,1);


        requestFunction(function ($) {

                var pn = $('.pagination__number');
                var length;
                if (pn == null) {
                    length = 1;
                } else {
                    length = pn.length;
                    if (length < 1) {
                        length = 1;
                    }
                }
                album.totalPage = length;

                parseAlbum(album,dbId);


            }, pageToVisit);




    }



    function parseAlbum(album,dbId){

        for(var i=1;i<=album.totalPage;i++){

        var pageToVisit=getAlbumPage(album,i);


        requestFunction(function ($) {

                var showalbum__children=$('.showalbum__children');


                for(var j=0;j<showalbum__children.length;j++){

                    var sc=showalbum__children[j];

                    var photoObj={};
                    photoObj.imgSrc=$(sc).find('img').attr('src');
                    photoObj.title=$(sc).find('h3').attr('title');
                    photoObj.date=$(sc).find('.text_overflow').html();
                    //text_overflow

                    db.insertPhoto(photoObj,dbId)
                    // console.log('INSERT INTO t_yupoo_photo(photo_num,photo_name,album_id,create_date) VALUES('
                    // +photoObj.imgSrc+','+photoObj.title+','+dbId+',now())')




                }

                



            }, pageToVisit);


        }

    }




function parseCollection(shops,shop,collection, page) {

    if (page > collection.totalPage) {

        //parseAlbum(collection);
        //log(collection);

        //data parse ok here ,begin to down load image

        
        downloadImage(shops);


        return;
    }

    var pageToVisit = getCollectionsPage(collection, page);

    requestFunction(function ($) {

        var album;
        if (collection.album == undefined) {
            album = [];
            collection.album = album;
        } else {
            album = collection.album;
        }


        var showindex__children = $('.showindex__children');

        for (var i = 0; i < showindex__children.length; i++) {

            var sc = showindex__children[i];

            var albumObj = {};
            albumObj.title = $(sc).find('a').attr('title');

            albumObj.imgSrc = $(sc).find('img').attr('src');

            album.push(albumObj);


        }


        page++;

        parseCollection(shops,shop,collection, page);

    }, pageToVisit);


}





// function parseAlbum(collection) {



//     var pageToVisit=getAlbumPage(collection,page)



// }























var downloadFlag=false;

function downloadImage(shops){

    if(downloadFlag==false){
        
        downloadFlag=true;
        
        downloadShops(shops);
    }else{
        
    }
    

}

process.chdir('yupoo');

function downloadShops(shops){

    for(var i=0;i<shops.length;i++){
        var shop=shops[i];


        {
            var p=shop.shopName;
                var exist=fs.existsSync(p);
                if(!exist){
                    fs.mkdirSync(p);
                }
        }
        

        var collections=shop.collections;

        for(var i=0;i<collections.length;i++){
            var collection=collections[i];

            {
                var p=shop.shopName+'/'+collection.collectionId;
                var exist=fs.existsSync(p);
                if(!exist){
                    fs.mkdirSync(p);
                }
            }


            var albums=collection.album;

            if(albums){
                for(var i=0;i<albums.length;i++){

                    var album=albums[i];

                    console.log(album)

                    



                }

            }



        }







    }


}






function parsePhoto(albumUrl, albumObj) {




    var url = domain + albumUrl;



    request(url, function (error, response, body) {
        if (error) {
            console.log("Error: " + error);
        }
        // Check status code (200 is HTTP OK)
        //console.log("Status code: " + response.statusCode);
        if (response.statusCode === 200) {
            // Parse the document body
            var $ = cheerio.load(body);




            //console.log(url);

            var showalbum__children = $('.showalbum__children');
            var photos = new Array();

            albumObj.photos = photos;

            for (var i = 0; i < showalbum__children.length; i++) {
                totalImg++;

                if (totalImg > numImg) {
                    console.log(totalImg);
                    console.log('\n======================================');


                    //console.log(JSON.stringify(shops));
                    var shopsJson = JSON.stringify(shops);

                    fs.writeFile('shops.json', shopsJson, (err) => {
                        // throws an error, you could also catch it here
                        if (err) throw err;

                        // success case, the file was saved
                        //console.log('shops saved!');
                    });

                    console.log('======================================\n');

                    return;
                }

                var photo = new Object();
                var photoDiv = showalbum__children[i];

                var h3 = $(photoDiv).find('h3').attr('title');
                photo.photoTitle = h3;
                // console.log(h3)

                // console.log('-------------------');


                var text_overflow = $(photoDiv).find('time.text_overflow').html();
                photo.photoTime = text_overflow;
                //console.log(text_overflow.html());

                //var imgSrc=$(photoDiv).find('img').attr('src');
                //console.log(imgSrc)


                var dataOriginSrc = $(photoDiv).find('img').attr('data-origin-src');
                // console.log(dataOriginSrc);
                // totalImg++;
                // console.log(totalImg);
                photo.dataOriginSrc = dataOriginSrc;

                var dUrl = 'http:' + photo.dataOriginSrc;
                photo.localSrc = download.download_file_curl(dUrl);


                console.log(dUrl);

                photos.push(photo);






            }



        }
    });



}










