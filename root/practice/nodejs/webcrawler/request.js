// 
var request=require('request');

var cheerio = require('cheerio');

var option={
url:'https://www.npmjs.com/package/sync-request',
async:false
};

for(var i=0;i<10;i++){

(function(i){
    

request(option,function (error,response,body) {
    var $=cheerio.load(body);
console.log(i);
console.log($('title').html());
    


});

})(i);

}





