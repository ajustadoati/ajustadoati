angular.module('app.routes', [])

.config(function($stateProvider, $urlRouterProvider) {

  // Ionic uses AngularUI Router which uses the concept of states
  // Learn more here: https://github.com/angular-ui/ui-router
  // Set up the various states which the app can be in.
  // Each state's controller can be found in controllers.js
  $stateProvider
    
      
        
    .state('login', {
      url: '/login',
      templateUrl: 'templates/login.html',
      controller: 'loginCtrl'
    })
        
      
    
      
        
    .state('registro', {
      url: '/homeRegister',
      templateUrl: 'templates/registro.html',
      controller: 'registroCtrl'
    })
        
      
    
      
        
    .state('registroVendedor', {
      url: '/serverRegister',
      templateUrl: 'templates/registroVendedor.html',
      controller: 'registroVendedorCtrl'
    })
        
      
    
      
        
    .state('registroUsuario', {
      url: '/userRegister',
      templateUrl: 'templates/registroUsuario.html',
      controller: 'registroUsuarioCtrl'
    })
        
      
    
      
        
    .state('busqueda', {
      url: '/searchItem',
      templateUrl: 'templates/busqueda.html',
      controller: 'busquedaCtrl'
    })
        
      
    
      
        
    .state('resultadoBusqueda', {
      url: '/searchResult',
      templateUrl: 'templates/resultadoBusqueda.html',
      controller: 'resultadoBúSquedaCtrl'
    })
        
      
    
      
        
    .state('tabsController.solicitudes', {
      url: '/requests',
      views: {
        'tab4': {
          templateUrl: 'templates/busqueda.html',
          controller: 'busquedaCtrl'
        }
      }
    })
        
      
    
      
        
    .state('tabsController.ubicacion', {
      url: '/location',
      views: {
        'tab5': {
          templateUrl: 'templates/ubicacion.html',
          controller: 'ubicacionCtrl'
        }
      }
    })
        
      
    
      
        
    .state('tabsController.productos', {
      url: '/items',
      views: {
        'tab6': {
          templateUrl: 'templates/productos.html',
          controller: 'productosCtrl'
        }
      }
    })
        
      
    
      
    .state('tabsController', {
      url: '/homeVendedor',
      abstract:true,
      templateUrl: 'templates/tabsController.html'
    })
      
    
      
        
    .state('tabsController.perfil', {
      url: '/profile',
      views: {
        'tab7': {
          templateUrl: 'templates/perfil.html',
          controller: 'perfilCtrl'
        }
      }
    })
        
      
    
      
        
    .state('tabsController2.solicitud', {
      url: '/solicitudUser',
      views: {
        'tab8': {
          templateUrl: 'templates/solicitud.html',
          controller: 'solicitudCtrl'
        }
      }
    })
        
      
    
      
        
    .state('tabsController2.solicitudes2', {
      url: '/solicitudesUser',
      views: {
        'tab9': {
          templateUrl: 'templates/solicitudes2.html',
          controller: 'solicitudes2Ctrl'
        }
      }
    })
        
      
    
      
        
    .state('tabsController2.ubicacionUsuario', {
      url: '/locationUser',
      views: {
        'tab10': {
          templateUrl: 'templates/ubicacionUsuario.html',
          controller: 'ubicacióNUsuarioCtrl'
        }
      }
    })
        
      
    
      
    .state('tabsController2', {
      url: '/homeUser',
      abstract:true,
      templateUrl: 'templates/tabsController2.html'
    })
      
    
      
        
    .state('tabsController2.perfilUsuario', {
      url: '/profileUser',
      views: {
        'tab11': {
          templateUrl: 'templates/perfilUsuario.html',
          controller: 'perfilUsuarioCtrl'
        }
      }
    })
        
      
    
      
        
    .state('detalleResultado', {
      url: '/detailResult',
      templateUrl: 'templates/detalleResultado.html',
      controller: 'detalleResultadoCtrl'
    })
        
      
    ;

  // if none of the above states are matched, use this as the fallback
  $urlRouterProvider.otherwise('/login');

});