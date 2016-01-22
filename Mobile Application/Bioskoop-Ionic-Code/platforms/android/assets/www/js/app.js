// Ionic Starter App

// angular.module is a global place for creating, registering and retrieving Angular modules
// 'starter' is the name of this angular module example (also set in a <body> attribute in index.html)
// the 2nd parameter is an array of 'requires'
// 'starter.services' is found in services.js
// 'starter.controllers' is found in controllers.js
angular.module('starter', ['ionic', 'starter.controllers', 'starter.services'])

.run(function($ionicPlatform, $rootScope) {
  $ionicPlatform.ready(function() {
    // Hide the accessory bar by default (remove this to show the accessory bar above the keyboard
    // for form inputs)
    if (window.cordova && window.cordova.plugins && window.cordova.plugins.Keyboard) {
      cordova.plugins.Keyboard.hideKeyboardAccessoryBar(true);
    }
    if (window.StatusBar) {
      // org.apache.cordova.statusbar required
      StatusBar.styleLightContent();
    }

    // Call Controller Functions on Clicking tab Everytime
    $rootScope.$on( "$ionicView.enter", function( scopes, states ) {
        if( states.stateName == "tab.dash" ) {
            callWatsonServices();
        }else if( states.stateName == "tab.hashtag" ){
            getHashtags();
        }
    }); 
  });
})

.config(['$ionicConfigProvider', function($ionicConfigProvider) {
  $ionicConfigProvider.tabs.position('bottom'); //other values: top
}])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider

  // setup an abstract state for the tabs directive
  .state('tab', {
    url: "/tab",
    abstract: true,
    templateUrl: "templates/tabs.html"
  })

  // Each tab has its own nav history stack:

  .state('tab.dash', {
    url: '/dash',
    views: {
      'tab-dash': {
        templateUrl: 'templates/tab-dash.html',
        controller: 'DashCtrl'
      }
    }
  })


  .state('tab.detail', {
    url: '/details/:hashTag',
    views: {
      'tab-dash': {
        templateUrl: 'templates/details.html',
        controller: 'DetailsCtrl'
      }
    }
  })

  .state('tab.posDetail', {
    url: '/positivePage/:hashTag',
    views: {
      'tab-dash': {
        templateUrl: 'templates/positivePage.html',
        controller: 'PositiveDetailsCtrl'
      }
    }
  })

  .state('tab.negDetail', {
    url: '/negativePage/:hashTag',
    views: {
      'tab-dash': {
        templateUrl: 'templates/negativePage.html',
        controller: 'NegativeDetailsCtrl'
      }
    }
  })

  .state('tab.neuDetail', {
    url: '/neutralPage/:hashTag',
    views: {
      'tab-dash': {
        templateUrl: 'templates/neutralPage.html',
        controller: 'NeutralDetailsCtrl'
      }
    }
  })

  .state('tab.category', {
    url: '/category/:hashTag',
    views: {
      'tab-dash': {
        templateUrl: 'templates/category.html',
        controller: 'CategoryCtrl'
      }
    }
  })

  .state('tab.insights', {
    url: '/insights/:hashTag',
    views: {
      'tab-dash': {
        templateUrl: 'templates/insights.html',
        controller: 'InsightCtrl'
      }
    }
  })

  .state('tab.hashtag', {
    url: '/addHashTag',
    views: {
      'tab-hashtag': {
        templateUrl: 'templates/hashtags.html',
        controller: 'HashtagCtrl'
      }
    }
  });

  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/tab/dash');

});
