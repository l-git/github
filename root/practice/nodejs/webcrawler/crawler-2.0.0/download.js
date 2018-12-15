

var fs = require('fs');
var url = require('url');
var http = require('http');
var exec = require('child_process').exec;
var spawn = require('child_process').spawn;

// Function to download file using curl


var main = require('./main');

var result;

var download_file_curl = function (albumsArr) {

    

    result = {
        fail: albumsArr,
        success: [],
        total: albumsArr.length
    };

    //downloadImg();

    d(albumsArr);


};


var download_file_curl1 = function(albumObj) {

    var h=albumObj.href;
    
    

    var file_url="http:"+albumObj.imgSrc;

    var pathnameArr=url.parse(file_url).pathname.split('/');

    var lastName=pathnameArr.pop();

    


    var ext=lastName.substr(lastName.lastIndexOf('.'));


    

    // extract the file name
    var file_name =pathnameArr.pop()+ext;

    //var shopName=pathnameArr.pop();
    var shopName=main.getShopName();

    var exist=fs.existsSync(shopName);
    if(!exist){
        fs.mkdirSync(shopName);
    }

    var DOWNLOAD_DIR=h.substr(h.lastIndexOf('=')+1);

    var cDir=shopName+'/'+DOWNLOAD_DIR;
    var exist=fs.existsSync(cDir);
    if(!exist){
        fs.mkdirSync(cDir);
    }
    
    cDir+='/';


    // create an instance of writable stream
    
    var p=cDir + file_name;

    if(fs.existsSync(p)){
        
        console.log('exist:'+p);
        return ;
    }

    var file = fs.createWriteStream(cDir + file_name);
    // execute curl using child_process' spawn function
    var curl = spawn('curl', [file_url]);
    // add a 'data' event listener for the spawn instance
    curl.stdout.on('data', function(data) { file.write(data); });
    // add an 'end' event listener to close the writeable stream
    curl.stdout.on('end', function(data) {
        file.end();
        console.log(file_name + ' downloaded to ' + DOWNLOAD_DIR);
    });
    // when the spawn child process exits, check if there were any errors and close the writeable stream
    curl.on('exit', function(code) {
        if (code != 0) {
            console.log('Failed: ' + code);
        }
    });
};



function d(albumsArr){

    for(var i=0;i<albumsArr.length;i++){

        
        var albumObj=albumsArr[i];


        download_file_curl1(albumObj);



    }


}


function downloadImg() {

    if(result.fail.length==0){

        console.log(result);
        console.log('download complete');

        return;

    }

    // if (result.fail.length + result.success.length < result.total) {

    //     console.log("wait async complete");
    //     //console.log(result);

    // } else {

        for (var i = 0; i < result.fail.length; i++) {

            console.log(i);
            // (function (i) {

            try{
                var albumObj = result.fail.shift();

                var file_url = "http:" + albumObj.imgSrc;

                var DOWNLOAD_DIR = 'images/';
                var pathname = url.parse(file_url).pathname;

                var pathArr = pathname.split('/');

                var sizeName = pathArr.pop();

                var ext = sizeName.substr(sizeName.indexOf('.'));
                var imgName = pathArr.pop();


                var file_name = imgName + ext;

                var filepath = DOWNLOAD_DIR + file_name;

                var file = fs.createWriteStream(filepath);

                var curl = spawn('curl', [file_url]);

                curl.stdout.on('data', function (data) {
                    file.write(data);
                });

                curl.stdout.on('end', function (data) {
                    file.end();
                });

                curl.on('exit', function (code) {
                    if (code != 0) {
                        //console.log('Failed: ' + code);
                        //result.fail.push(albumObj);
                        console.log("fail:" + albumObj);
                    } else {

                        //download success
                        //result.success.push(albumObj);
                        //console.log("success:" + albumObj);
                    }

                    //downloadImg();

                });

            }catch(e){
                console.log(e);
            }
            // })(i);
        }
    // }

}






exports.download_file_curl = download_file_curl;





// var imgUrl = 'http://photo.yupoo.com/xyj1105/b1ceb2aa/small.jpg';




// for (var i = 0; i < arr.length; i++) {
//     var a = arr[i];
//     download_file_curl(a);
// }




