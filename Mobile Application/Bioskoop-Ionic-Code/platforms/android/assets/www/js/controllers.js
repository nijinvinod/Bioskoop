angular.module('starter.controllers', [])


.controller('DashCtrl', function($scope, $rootScope, $http, WatsonService) {
	var hashtagsList = [];

	$scope.refresh = function(){
		APP_REFRESH == true;
		$scope.items = [];
		$scope.loadDashboard();
	};

	$scope.loadDashboard = function(){
		$scope.error = undefined;
		hashtagsList = WatsonService.getHashtags();
		if(hashtagsList.length == 0){
			$scope.noHashtag = true;
		}else{
			$scope.noHashtag = false;
		}
		console.log(hashtagsList);
		if(APP_REFRESH == true){
			$scope.loadWatsonServices();
			APP_REFRESH = false;
		}
	};

	$scope.loadWatsonServices = function(){
		$scope.items = [];
		WatsonService.clearTweetData();

		for(var i = 0 ; i < hashtagsList.length; i++){

			console.log("List:"+hashtagsList[i]);
			var url = SERVLET_URL;
			console.log(SERVLET_PARAMETER);
			if(SERVLET_PARAMETER){
				url+=SERVLET_PARAMETER_DATA+hashtagsList[i];
				url+=ALCHEMY_API + CURRENT_ALCHEMY_KEYS;
			}else{
				url += MOCK_CODE[i];
			}
			console.log("my url:" +url);
			$http({
				method: 'GET', 
				url: url,
				headers: {'Content-Type': 'application/json'},
				config:{
					timeout: 300000
				}
			}).
		    success(function(result, status, headers, config) {
		    	f = result;
		    	if(result != undefined){
			    	WatsonService.addTweetData(result);
			    	if(MOCK == false)
			    		result.hashTag = result.hashTag.substring(1);

			    	result.imageUrl = DEFAULT_IMAGES[result.hashTag];

			    	$scope.items.push(result);
			    }
		    }).
		    error(function(data, status, headers, config) {
		    	alert("Error in Data");
		    	$scope.error = true;
		    	console.log("Error"+data);
		    });
		}
	};


	callWatsonServices = function(){
		console.log("Dashboard Loading");
		$scope.loadDashboard();
	};

	$scope.loadDashboard();
	$scope.loadWatsonServices();
})



.controller('DetailsCtrl', function($scope, $stateParams, WatsonService) {
	g = $stateParams;
	console.log($stateParams.hashTag);
	h = WatsonService;
	$scope.item = WatsonService.getTweetObject($stateParams.hashTag)[0];
})


.controller('PositiveDetailsCtrl', function($scope, $stateParams, WatsonService) {
	$scope.item = WatsonService.getTweetObject($stateParams.hashTag)[0];
	$scope.showTweet = function(tweet){
		STORED_TWEET = tweet;
	};
})


.controller('NegativeDetailsCtrl', function($scope, $stateParams, WatsonService) {
	$scope.item = WatsonService.getTweetObject($stateParams.hashTag)[0];
	$scope.showTweet = function(tweet){
		STORED_TWEET = tweet;
	};
})

.controller('NeutralDetailsCtrl', function($scope, $stateParams, WatsonService) {
	$scope.item = WatsonService.getTweetObject($stateParams.hashTag)[0];
	$scope.showTweet = function(tweet){
		STORED_TWEET = tweet;
	};
})

.controller('CategoryCtrl', function($scope, $stateParams, WatsonService, CategoryService) {
	$scope.item = WatsonService.getTweetObject($stateParams.hashTag)[0];
	$scope.ageCategories = [];

	var positiveTweets = $scope.item.positiveTweets.tweets;

	$scope.action = "age";
	$scope.tabAction = function(category){
		category == "age" ? $scope.action = "age" : $scope.action = "gender";
	};


	$scope.categorizeByAge = function(){
		CategoryService.clearAgeLevelSeperation();
		CategoryService.clearGenderLevelSeperation();
		if($scope.item != undefined){
			if($scope.item.positiveTweets != undefined){
				CategoryService.constructAgeLevelSeperation($scope.item.positiveTweets.tweets, "pos");
			}
			if($scope.item.negativeTweets != undefined){
				CategoryService.constructAgeLevelSeperation($scope.item.negativeTweets.tweets, "neg");
			}
			if($scope.item.neutralTweets != undefined){
				CategoryService.constructAgeLevelSeperation($scope.item.neutralTweets.tweets, "neu");
			}
		}
	};


	$scope.getGenderCategory = function(){

		var malSupport = CategoryService.getGenderCategory("MALE");
		var femSupport = CategoryService.getGenderCategory("FEMALE");

		$scope.maleSupport = Math.round((malSupport/(malSupport+femSupport)) * 100);
		$scope.femaleSupport = Math.round((femSupport/(malSupport+femSupport)) * 100);
	};

	$scope.getAgeCategory = function(){
		console.log("Entering::Controller::Get Age Category");
		var ageGroups = CategoryService.getAgeGroups();

		for(var key in ageGroups){
			var ageGrp = CategoryService.getAgeCategory(key);
			if(ageGrp != undefined){
				var ageGrpObj = {};
				if(ageGrp.total != 0 && ageGrp.posCount != 0 ){
					var value = (ageGrp.posCount/ageGrp.total) * 100;
					ageGrpObj.supportPercent = Math.round(value);	
				}
				else{
					ageGrpObj.supportPercent = 0;
				}
				console.log(key.toString());
				ageGrpObj.supportGroup = ageGroups[key.toString()];
				$scope.ageCategories.push(ageGrpObj);	
			}
		}
		n = $scope.ageCategories;	
		if(MOCK == true){
			$scope.ageCategories[2].supportPercent = "67";
			$scope.ageCategories[4].supportPercent = "10";
		}
	};

	$scope.categorizeByAge();
	$scope.getAgeCategory();
	$scope.getGenderCategory();
})

.controller('InsightCtrl', function($scope, $http , $ionicPopup, $timeout, $stateParams, WatsonService) {
	$scope.item = WatsonService.getTweetObject($stateParams.hashTag)[0];
	$scope.tweet = STORED_TWEET;
	$scope.insights = [];
	$scope.error = undefined;

	$scope.data = {
		myHandle : "mohit5mex"
	}
	

	$scope.editHandle = function() {
	   $scope.data = {}

	   // An elaborate, custom popup
	   var myPopup = $ionicPopup.show({
	     template: '<input type="text" ng-model="data.myHandle">',
	     title: 'Enter Twitter Handle',
	     subTitle: '',
	     scope: $scope,
	     buttons: [
	       { text: 'Cancel' },
	       {
	         text: '<b>Save</b>',
	         type: 'button-positive',
	         onTap: function(e) {
	           if (!$scope.data.myHandle) {
	             //don't allow the user to close unless he enters wifi password
	             e.preventDefault();
	           } else {
	           	// $scope.getInsights();
	             return $scope.data.myHandle;
	           }
	         }
	       },
	     ]
	   });
	   myPopup.then(function(res) {
	     console.log('Tapped!', res);
	     $scope.getInsights();
	   });
	};

	$scope.getInsights = function(){
		$scope.insights = [];
		var url = PI_SERVLET_URL;
		url += "user1handle=" + $scope.data.myHandle + "&user2handle=" + $scope.tweet.userHandlerName;

		$http({
			method: 'GET', 
			url: url,
			headers: {'Content-Type': 'application/json'},
		}).
	    success(function(result, status, headers, config) {
	    	f = result;
	    	var userA = result.user1PI;
	    	var userB = result.user2PI;
	    	if(userA != undefined && userB != undefined && userA.tree != undefined && userB.tree != undefined ){
	    		piUserA = userA.tree.children[0].children[0].children;
	    		piUserB = userB.tree.children[0].children[0].children;

	    		for(var i=0; i<piUserA.length; i++){
	    			var insightObj = {};
	    			insightObj.name = piUserA[i].name;
	    			insightObj.aScore = Math.round(piUserA[i].percentage * 100) / 100;
	    			insightObj.bScore = Math.round(piUserB[i].percentage * 100) / 100;

	    			var diff = insightObj.aScore - insightObj.bScore;
	    			if(diff > -0.1 && diff < 0.1) {
	    				insightObj.val = "green";
	    			}else{
	    				insightObj.val = "red";
	    			}
	    			$scope.insights.push(insightObj);
	    		}
	    	}else{
	    		$scope.error = "Insufficient Tweet Data to Compare";
	    	}

	    }).
	    error(function(data, status, headers, config) {
	    	console.log("Error"+data);
	    });
	};
	$scope.getInsights();
})


.controller('HashtagCtrl', function($scope, $stateParams, WatsonService) {
	$scope.item = {
		hashTag : ""
	};
	
	$scope.getHashTagsFromLocal = function(){
		$scope.hashtagsList = WatsonService.getHashtags();
	};
	$scope.addHashtag = function(){
		console.log(WatsonService.getHashTagIndex($scope.item.hashTag));
		if(WatsonService.getHashTagIndex($scope.item.hashTag) < 0 && $scope.item.hashTag.length != 0){
			WatsonService.addHashObj($scope.item.hashTag);
			$scope.getHashTagsFromLocal();
			$scope.item.hashTag = "";
			APP_REFRESH = true;
		}	
	};
	$scope.removeHashtag = function(hashtag){
		WatsonService.removeHashObj(hashtag);
		$scope.getHashTagsFromLocal();
	};

	getHashtags = function(){
		console.log("Getting Hashtags");
		$scope.getHashTagsFromLocal();
	}
});

