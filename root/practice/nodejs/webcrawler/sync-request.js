// 

var request = require('sync-request');
var cheerio = require('cheerio');




for(var i=0;i<10;i++){

var res = request('GET', 'https://www.npmjs.com/package/sync-request');

var $=cheerio.load(res.body.toString());

console.log($('title').html());



console.log(i);
}

