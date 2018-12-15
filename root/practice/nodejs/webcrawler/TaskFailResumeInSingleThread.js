
var request = require('request');



var Task = {
total: [],
success: [],
fail: [],
failTmp:[]
}

var tryCounter=0;

var n = 20;
for (var i = 0; i < n; i++) {
Task.total.push(i);
Task.fail.push(i);
}

dealTask();

function dealTask() {

if (Task.total.length == Task.success.length) {

console.log('task complete');

console.log(Task);


} else {

var taskToDeal=Task.fail;

// if (Task.fail.length > 0) {
// taskToDeal = Task.fail;
// } else {

// taskToDeal = Task.total;

// }



for (var i = 0; i < taskToDeal.length; i++) {

var obj = taskToDeal.shift();

(function(obj){

var u;
u = 'http://localhost:8082/a.json';
request(u, function (error, response, body) {
if (error) {
Task.fail.push(obj);
} else {
Task.success.push(obj);
}
completeMonitor();
});

})(obj)


}

}

}



function completeMonitor(){

if((Task.success.length+Task.fail.length)<Task.total.length){

console.log('wait for event');
return;
}


if (Task.total.length == Task.success.length) {


console.log(Task);

console.log('task complete');
console.log('try:'+tryCounter);

}else{

tryCounter++;
dealTask();

}



}




