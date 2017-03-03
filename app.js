var express = require('express');
var path = require('path');
var cookieParser = require('cookie-parser');
var bodyParser = require('body-parser');
var exphbs = require('express-handlebars');
var expressValidator = require('express-validator');
var flash = require('connect-flash');
var session = require('express-session');
var passport = require('passport');
var LocalStrategy = require('passport-local').Strategy;
var mongo = require('mongodb');
var mongoose = require('mongoose');
var homeController = require('./controllers/indexcont');
var profile = require('./controllers/profile');
var portfolio = require('./controllers/portfolio');
var multer = require('multer');
var mime = require('mime');
var crypto = require('crypto');
var image;

var storage = multer.diskStorage({

    destination : function(req, file, cb){
      cb(null, '.public/uploads/')
    },
    filename: function(req, file, cb){
      crypto.pseudoRandomBytes(16, function(err, raw){
        cb(null, raw.toString('hex') + Date.now() +'.' +mime.extension(file.mimetype));
      })
    }
})
var upload = multer({storage: storage});

mongoose.Promise = global.Promise;


mongoose.connect('mongodb://localhost/dodo');
var db = mongoose.connection;

// Init App
var app = express();

// View Engine
app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'ejs');

// BodyParser Middleware
app.use(bodyParser.json());
app.use(bodyParser.urlencoded({ extended: false }));
app.use(cookieParser());

// Set Static Folder
app.use(express.static(path.join(__dirname, 'public')));

// Express Session
app.use(session({
    secret: 'secret',
    saveUninitialized: true,
    resave: true
}));

// Passport init
app.use(passport.initialize());
app.use(passport.session());

// Express Validator
app.use(expressValidator({
  errorFormatter: function(param, msg, value) {
      var namespace = param.split('.')
      , root    = namespace.shift()
      , formParam = root;

    while(namespace.length) {
      formParam += '[' + namespace.shift() + ']';
    }
    return {
      param : formParam,
      msg   : msg,
      value : value
    };
  }
}));

// Connect Flash
app.use(flash());

// Global Vars
app.use(function (req, res, next) {
  res.locals.success_msg = req.flash('success_msg');
  res.locals.error_msg = req.flash('error_msg');
  res.locals.error = req.flash('error');
  res.locals.user = req.user || null;
  next();
});


app.post('/profilepicture', upload.single('image'), function(err,res){
  console.log(req.file.filename);
  console.log('a');
  var file = req.file.filename;
  var curr = req.user.username;
  image = './uploads'+file;
  User.update({ username: req.user.username}, {image: image}, function(err,res){
    if(err){
            res.send(err.message);

    }
    if(result){

      result.image=image;
      console.log(result);
    }
  })

  res.render('indexstud1', {image, curr});
});



require('./routes.js')(app, passport);
require('./passport')(passport);

// Set Port
app.set('port', (process.env.PORT || 3000));

app.listen(app.get('port'), function(){
	console.log('Server started on port '+app.get('port'));
});