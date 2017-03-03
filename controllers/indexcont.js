let User = require('../models/user');

let homeController = {

//get all users
    getusers:function(req, res){


	         User.find(function(err, users) {
  				 if(err)
	                res.send(err.message);
	            else
	            	
	               	res.render('index', {users, user : req.user});
			});

    	
    }
}


module.exports = homeController;