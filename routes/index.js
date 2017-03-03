var express = require('express');
var router = express.Router();
// var file = document.getElementById("fileForUpload").files[0];

// Get Homepage
router.get('/', ensureAuthenticated, function(req, res){
	res.render('index');
});

function ensureAuthenticated(req, res, next){
	if(req.isAuthenticated()){
		return next();
	} else {
		//req.flash('error_msg','You are not logged in');
		res.redirect('/users/login');
	}
}

module.exports = router;


// if (file) {
//     var reader = new FileReader();
//     reader.readAsText(file, "UTF-8");
//     reader.onload = function (evt) {
//         document.getElementById("fileContents").innerHTML = evt.target.result;
//     }
//     reader.onerror = function (evt) {
//         document.getElementById("fileContents").innerHTML = "error reading file";
//     }
// }

