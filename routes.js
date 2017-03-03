var homeController = require('./controllers/indexcont');
var profile = require('./controllers/profile');
var portfolio = require('./controllers/portfolio');


module.exports = function(app, passport) {

   app.get('/login', function(req, res) {
        res.render('login.ejs', { message: req.flash('loginMessage'), user : req.user }); 
    });
    app.get('/', homeController.getusers);
    app.post('/profile', profile.createnewwork);
    app.post('/profileScreenshot',profile.createnewworkImage);
    
    app.get('/work/:id', portfolio.previewwork);

    app.get('/register', function(req, res) {
        res.render('register.ejs', { message: req.flash('signupMessage'), user : req.user });
    });
    app.post('/register', passport.authenticate('local-signup', {
        successRedirect : '/profile',
        failureRedirect : '/register', 
        failureFlash : true
    }));

    app.post('/login', passport.authenticate('local-login', {
        successRedirect : '/profile', 
        failureRedirect : '/login',
        failureFlash : true 
    }));
    app.get('/profile', isLoggedIn , profile.getallworks)
    app.get('/portfolio/:id', portfolio.getallworks);
    app.get('/view-work/:id', portfolio.previewwork);

    app.get('/logout', function(req, res) {
        req.logout();
        res.redirect('/');
    });
};

function isLoggedIn(req, res, next) { 
    if (req.isAuthenticated())
        return next();
    res.redirect('/');
}