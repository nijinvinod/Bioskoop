var MOCK = true;

//MOCK DATA
var SERVER_URL = "https://api.myjson.com/";
var SERVLET_URL = SERVER_URL + "bins/";
var SERVLET_PARAMETER = false;
var MOCK_CODE = ['27sg5','3jdet','29xlx'];



//LOCAL
// var SERVER_URL = "http://192.168.1.233:8080/";
// var SERVLET_URL = SERVER_URL + "WatsonBioSkoopV4/BioSkoop";
// var SERVLET_PARAMETER = true;

//PRODUCTION
// var BLUEMIX_URL = "http://watsonbioskoopv5.mybluemix.net/";
// var BLUEMIX_URL = "http://bioskoopas.mybluemix.net/";
// var SERVLET_PARAMETER_DATA = "?hashtag=";
// var ALCHEMY_API = "&alchemyApi=";
// var SERVLET_URL = BLUEMIX_URL + "WatsonBioSkoop/BioSkoop";
// var SERVLET_PARAMETER = true;
// var PI_SERVLET_URL = BLUEMIX_URL + "WatsonBioSkoop/BioSkoopPIServlet?";


var APP_REFRESH = false;
var STORED_TWEET = {};

var DEFAULT_IMAGES = {
	"Interstellar":"http://cdn-media-2.lifehack.org/wp-content/files/2014/12/Interstellar-2014-Poster-Wallpaper.jpg",
	"Twilight":"http://www.breakingdawn-themovie.com/images/mainbg.jpg",
	"Cinderella":"http://images5.fanpop.com/image/articles/139000/disney-princess_139463_6.jpg"
};

var DEFAULT_ALCHEMY_KEYS = [
	"99e48a6a29e357d28a923977dd6c67b921923056",
    "b3c7a49ba35df25dfcf64a0556902fb225cba8f3",
    "e3f2d4b540c335cfffbebc49fff464b676221038",
    "e8e74d6bdd3210dfea42f3386d7b2ffda7417c4e",
    "e8e74d6bdd3210dfea42f3386d7b2ffda7417c4e",
    "f230b7e2a864d95bacc133772fdbb7a00354f966"
];

var CURRENT_ALCHEMY_KEYS = DEFAULT_ALCHEMY_KEYS[5];
