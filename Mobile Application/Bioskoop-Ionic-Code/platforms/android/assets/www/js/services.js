angular.module('starter.services', [])


.factory('$localstorage', ['$window', function($window) {
    return {
        set: function(key, value) {
            $window.localStorage[key] = value;
        },
        get: function(key, defaultValue) {
            return $window.localStorage[key] || defaultValue;
        },
        setObject: function(key, value) {
            $window.localStorage[key] = JSON.stringify(value);
        },
        getObject: function(key) {
            return JSON.parse($window.localStorage[key] || '{}');
        }
    }
}])


.factory('CategoryService', ['$localstorage', function($localstorage) {
    var maleTweetList = [];         // Segregation By Male
    var femaleTweetList = [];       // Segregation By Female

    var ageMapping = {
      age24:"18-24",
      age34:"25-34",
      age44:"35-44",
      age54:"45-54",
      age64:"55-64",
      ageX:">64"
    };
    var ageGroup = {
      age18:{total:0, posCount:0, negCount:0, neuCount:0},
      age24:{total:0, posCount:0, negCount:0, neuCount:0},
      age34:{total:0, posCount:0, negCount:0, neuCount:0},
      age44:{total:0, posCount:0, negCount:0, neuCount:0},
      age54:{total:0, posCount:0, negCount:0, neuCount:0},
      age64:{total:0, posCount:0, negCount:0, neuCount:0},
      ageX:{total:0, posCount:0, negCount:0, neuCount:0},
      ageMisc:{total:0, posCount:0, negCount:0, neuCount:0},
    };
    return {
        getKeyByValue : function(_this,value) {
            for( var prop in _this ) {
                if( _this.hasOwnProperty(prop) ) {
                     if( _this[prop] === value )
                         return prop;
                }
            }
        },
        clearGenderLevelSeperation: function(){
            maleTweetList = [];
            femaleTweetList = [];
        },
        getGenderCategory: function(gender){
          if(gender == "MALE"){
            return maleTweetList.length;
          }else{
            return femaleTweetList.length;
          }
        },
        constructAgeLevelSeperation: function(tweets, sentiment){
          if(tweets != undefined){
            counts = 0;
            for(var i=0; i<tweets.length;i++){
              g = tweets[i];
              if(tweets[i] != undefined && tweets[i].userDetails != undefined && tweets[i].userDetails.imageFaces!=undefined && tweets[i].userDetails.imageFaces[0]!=undefined){
                if(tweets[i].userDetails.imageFaces[0].age != undefined && tweets[i].userDetails.imageFaces[0].age.ageRange != undefined){
                    var ageRange = tweets[i].userDetails.imageFaces[0].age.ageRange;
                    if(ageRange != "<18")
                      this.injectAgeLevelSeperation(this.getKeyByValue(ageMapping, ageRange), sentiment);
                }

                var genderObj = tweets[i].userDetails.imageFaces[0].gender;
                if(genderObj != undefined){
                  var gender = genderObj.gender;
                  gender == "MALE" ? maleTweetList.push(tweets[i]) : femaleTweetList.push(tweets[i]);
                }
              }
            }
          }
        },
        injectAgeLevelSeperation: function(cat, sentiment){
          ageGroup[cat].total += 1;
          if(sentiment == "pos"){
            ageGroup[cat].posCount += 1;
          }else if(sentiment == "neg"){
            ageGroup[cat].negCount += 1;
          }else{
            ageGroup[cat].neuCount += 1;
          }
        },
        clearAgeLevelSeperation: function(cat){
            age18 = [];
            age24 = [];
            age34 = [];
            age44 = [];
            age54 = [];
            age64 = [];
            ageX = [];
            ageMisc = [];
        },
        getAgeGroups: function(){
          return ageMapping;
        },
        getAgeCategory: function(cat){
          return ageGroup[cat];
        }
    };
}])

.factory('WatsonService', ['$localstorage', function($localstorage) {
    // Variables
    var hashtagsList = [];
    var tweetData = [];

    return {
        getHashtags: function(){
        
          var hashTagsObject = $localstorage.getObject("KEY_HASHTAGS");
          hashtagsList = [];
          for(var i = 0; i < hashTagsObject.length; i++){
              hashtagsList.push(hashTagsObject[i]);
          }
          console.log(hashtagsList);
          return hashtagsList;
        },
        getTweetObject: function(hashtag){
          console.log("Service::"+hashtag);
          return tweetData.filter(function(e){return e.hashTag==hashtag});
        },
        addTweetData: function(obj){
          if(obj != undefined){
            obj.positiveTweets.tweets = this.processTweets(obj.positiveTweets.tweets);
            obj.negativeTweets.tweets = this.processTweets(obj.negativeTweets.tweets);
            obj.neutralTweets.tweets = this.processTweets(obj.neutralTweets.tweets);

            obj.positiveTweets.count = obj.positiveTweets.tweets.length;
            obj.negativeTweets.count = obj.negativeTweets.tweets.length;
            obj.neutralTweets.count = obj.neutralTweets.tweets.length;
            obj.totalCount = obj.positiveTweets.count + obj.negativeTweets.count + obj.neutralTweets.count;
            
            if(DEFAULT_IMAGES[obj.hashTag] != undefined){
              obj.imageUrl = DEFAULT_IMAGES[obj.hashTag];
            }

            tweetData.push(obj);
          }
        },
        processTweets: function(tweets){
          var proTweets = [];
          if(tweets != undefined){
            for(var i=0; i<tweets.length;i++){
              if(tweets[i]!=null || tweets[i]!=undefined){
                proTweets.push(tweets[i]);
              }
            }
          }
          return proTweets;
        },
        clearTweetData: function(){
          tweetData = [];
        },
        addHashObj: function(tag){
          hashtagsList.push(tag);
          $localstorage.setObject("KEY_HASHTAGS", hashtagsList);
        },
        removeHashObj: function(tag){
          hashtagsList.splice(hashtagsList.indexOf(tag), 1);
          $localstorage.setObject("KEY_HASHTAGS", hashtagsList);
        },
        getHashTagIndex: function(tag){
          return hashtagsList.indexOf(tag);
        }
    };
}]);

