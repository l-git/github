var mysql  = require('mysql');  



var connection = mysql.createConnection({     
  host     : 'localhost',       
  user     : 'root',              
  password : 'root',       
  port: '3306',                   
  database: 'a', 
}); 

connection.connect();

function insert(shops,cb){

    
      
      
      for(var i=0;i<shops.length;i++){


        var shop=shops[i];

        var  addSql = 'INSERT INTO t_yupoo_shop(shop_name,create_date) VALUES(?,now())';
      var  addSqlParams = [shop.shopName];
      //增
      connection.query(addSql,addSqlParams,function (err, result) {
              if(err){
               console.log('[INSERT ERROR] - ',err.message);
               return;
              }        
       
             console.log('--------------------------INSERT----------------------------');
             //console.log('INSERT ID:',result.insertId);        
             console.log('INSERT ID:',result);        
             console.log('-----------------------------------------------------------------\n\n');  


             cb(shop,result.insertId);


      });
       




      }


}



exports.insert=insert;


function insertCollection(collection,shopId,cb){


    
    
    //for(var i=0;i<shops.length;i++){


      

      var  addSql = 'INSERT INTO t_yupoo_collection(collection_num,collection_title,shop_id,create_date) VALUES(?,?,?,now())';
    var  addSqlParams = [collection.collectionId,collection.categoryName,shopId];
    //增
    connection.query(addSql,addSqlParams,function (err, result) {
            if(err){
             console.log('[INSERT ERROR] - ',err.message);
             return;
            }        
     
           console.log('--------------------------INSERT----------------------------');
           //console.log('INSERT ID:',result.insertId);        
           console.log('INSERT ID:',result);        
           console.log('-----------------------------------------------------------------\n\n');  


           cb(collection,result.insertId);


    });
     




    //}


}



exports.insertCollection=insertCollection;





function insertAlbum(albumObj,dbCollectionId,cb){


    
    //for(var i=0;i<shops.length;i++){


      

      var  addSql = 'INSERT INTO t_yupoo_album(album_num,album_name,collection_id,create_date) VALUES(?,?,?,now())';
    var  addSqlParams = [albumObj.href,albumObj.title,dbCollectionId];
    //增
    connection.query(addSql,addSqlParams,function (err, result) {
            if(err){
             console.log('[INSERT ERROR] - ',err.message);
             return;
            }        
     
           console.log('--------------------------INSERT----------------------------');
           //console.log('INSERT ID:',result.insertId);        
           console.log('INSERT ID:',result);        
           console.log('-----------------------------------------------------------------\n\n');  


           cb(albumObj,result.insertId);


    });
     




    //}


}



exports.insertAlbum=insertAlbum;












function insertPhoto(photoObj,dbId,cb){



    
    
    //for(var i=0;i<shops.length;i++){


      

      var  addSql = 'INSERT INTO t_yupoo_photo(photo_num,photo_name,album_id,create_date) VALUES(?,?,?,now())';
    var  addSqlParams = [photoObj.imgSrc,photoObj.title,dbId];
    //增
    connection.query(addSql,addSqlParams,function (err, result) {
            if(err){
             console.log('[INSERT ERROR] - ',err.message);
             return;
            }        
     
           console.log('--------------------------INSERT----------------------------');
           //console.log('INSERT ID:',result.insertId);        
           console.log('INSERT ID:',result);        
           console.log('-----------------------------------------------------------------\n\n');  


           cb&&cb(photoObj,result.insertId);


    });
     




    //}


}



exports.insertPhoto=insertPhoto;






