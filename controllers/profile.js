let Work = require('../models/Work');
let User = require('../models/user');
let WorkImage= require('../models/WorkImage');
var works;

let profile = {


    createnewwork:function(req, res){
        let work = new Work(req.body);


        work.save(function(err, project){
            if(err){
                res.send(err.message)
            }
            else{
                res.redirect('/profile');
            }
        })
    },
    createnewworkImage:function(req, res){
        let work = new WorkImage(req.body);

        work.save(function(err, project){
            if(err){
                res.send(err.message)
            }
            else{
                res.redirect('/profile');
            }
        })



    },


    getallworks:function(req, res){
        
        var WorkImag;
        Work.find({user_id: req.user._id.toString()}, function(err, workArray){
            if(err)
                res.send(err.message);
            else
               works=workArray
            }); 
         
        WorkImage.find({user_id: req.user._id.toString()}, function(err, worksImage){
            if(err)
                res.send(err.message);
       
            else
            res.render('profile', {works,worksImage, user : req.user});


                 })
          
    }

}

module.exports = profile;