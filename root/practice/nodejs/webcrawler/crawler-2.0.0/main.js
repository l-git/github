

// 

var syncRequest=require('sync-request');
var cheerio = require('cheerio');
var fs=require('fs');

var download_file_curl=require('./download');
var ExceptObj=require('./ExceptObj');


function log(m) {
    console.log(m);
}

function sendRequest(m,u){
    log('request url:'+u);
    var res=syncRequest(m,u);
    return res;
}

var domain='http://x.yupoo.com';

var shopUrl='/photos/xyj1105/albums?page=1';
//var shopNameArr=['xyj1105'];

// var shopName='lkjdfs';
// var shopDisplayName='LAIKAJINDUN莱卡金顿®';


var shopName='xyj1105';
var shopDisplayName='Guciheaven古奇天伦';


//var shopName='xyj1105';

var rootDir='E:/photos/';

var ShopObjArr=[];

// for(var ii=0;ii<shopNameArr.length;ii++){

//     var shopName=shopNameArr[ii];


exports.getShopName=function(){
    return shopName;
}


var ShopObj={
    collections:[],

    shopName:shopName,

    shopDisplayName:shopDisplayName

};

ShopObjArr.push(ShopObj);


function getShopUrl(shopName,page){

    var pageToVisit=domain+'/photos/'+shopName+'/albums?page='+page

    return pageToVisit;
}

var res=sendRequest('GET',getShopUrl(shopName,1));

var $=cheerio.load(res.body.toString());

var pagination__number='.pagination__number';
var pn=$(pagination__number);
var tPage;
if(pn==null){
    tPage=1;
}else{

    if(pn.length==0){
        tPage=1;
    }else{
        tPage=pn.length;
    }

}
ShopObj.collectionsTotalPage=tPage;

log(ShopObj);


var categoryClass='.show-layout-category__catewrap';
for(var i=0;i<ShopObj.collectionsTotalPage;i++){

    res=sendRequest('GET',getShopUrl(shopName,(i+1)));
    $=cheerio.load(res.body.toString());

    var categoryEle=$(categoryClass);

    for(var j=0;j<categoryEle.length;j++){

        var collection={};
        collection.title=$(categoryEle[j]).find('a').attr('title');

        if(ExceptObj.getExceptCollectionName().indexOf(collection.title)!=-1){
            continue;
        }

        collection.href=$(categoryEle[j]).find('a').attr('href');
        ShopObj.collections.push(collection);
    }

}



for(var i=0;i<ShopObj.collections.length;i++){

    var collection=ShopObj.collections[i];

    var pageToVisit=domain+collection.href;
    res=sendRequest('get',pageToVisit);
    $=cheerio.load(res.body.toString());
    var pn=$(pagination__number);
    var albumTotalPage;
    
    if(pn==null){
        albumTotalPage=1;
    }else{
        if(pn.length<1){
            albumTotalPage=1;
        }else{
            albumTotalPage=pn.length;
        }
    }
    collection.albumTotalPage=albumTotalPage;
    
}


log(ShopObj);


function getCollectionPage(href,page){
    var pageToVisit=domain+href+'?page='+page;
    return pageToVisit;
}


var showindex__children='.showindex__children';
for(var i=0;i<ShopObj.collections.length;i++){

    var collection=ShopObj.collections[i];

    collection.albums=[];

    for(var j=1;j<=collection.albumTotalPage;j++){

        var pageToVisit=getCollectionPage(collection.href,j);
        var res=sendRequest('get',pageToVisit);

        var $=cheerio.load(res.body.toString());

        var scArr=$(showindex__children);

        for(var k=0;k<scArr.length;k++){
            var albumObj={};
            albumObj.title=$(scArr[k]).find('a').attr('title');

            if(ExceptObj.getExceptAlbumName().indexOf(albumObj.title)!=-1){
                continue;
            }

            albumObj.href=$(scArr[k]).find('a').attr('href');
            albumObj.imgSrc=$(scArr[k]).find('img').attr('src');
    

            var cFolder=albumObj.href.substr(albumObj.href.lastIndexOf('=')+1);
            
            var srcItem=albumObj.imgSrc.split('/');

            var l0=srcItem.pop();
            var ext=l0.substr(l0.lastIndexOf('.'));
            var name=srcItem.pop();

            albumObj.localSrc='/'+cFolder+'/'+name+ext;


            collection.albums.push(albumObj);
        }
        

    }

}



var albumsArr=[];

for(var i=0;i<ShopObj.collections.length;i++){

    var collection=ShopObj.collections[i];

    albumsArr=albumsArr.concat(collection.albums);

    log('collection'+collection.title);
    log(collection.albums.length);

    for(var j=0;j<collection.albums.length;j++){


        var albumObj=collection.albums[j];
        
        // albumObj.title;
        // albumObj.href;
        // albumObj.imgSrc;

        //console.log(albumObj);

        

    }

}



log("total album is:"+albumsArr.length);




var dir=rootDir+shopName;

var exist=fs.existsSync(dir);
if(!exist){
    fs.mkdirSync(dir);
}

///}
process.chdir(rootDir);

//var shopJson=JSON.stringify(ShopObjArr);
var shopJson=JSON.stringify(ShopObj);

fs.writeFileSync(shopName+'.json',shopJson);


download_file_curl.download_file_curl(albumsArr);




















