angular.module('app.services', [])

.factory('BlankFactory', [function(){

}])


.factory('usuarioService', ['$http', function ($http) {

  var url = 'http://localhost:9000/ajustadoati/usuario/';

  var usuarioService ={};

  usuarioService.saveUsuario = function (usuario) {
  		console.log("Service: Guardando Usuario");
        return $http.post(url, usuario);
    };

    usuarioService.getUsuarios = function () {
        return $http.get(url);
    };

return usuarioService;
  
  
}])

.factory('proveedorService', ['$http', function ($http) {

  var url = 'http://localhost:9000/ajustadoati/proveedor/';

  var proveedorService ={};

  proveedorService.saveProveedor = function (proveedor) {
  		console.log("Service: Guardando Proveedor");
        return $http.post(url, proveedor);
    };

    proveedorService.getProveedores = function () {
        return $http.get(url);
    };

return proveedorService;
  
  
}])
.factory('consultaService', ['$http', function ($http) {

  var url = 'http://localhost:9000/ajustadoati/consulta/';

  var consultaService ={};

  consultaService.saveConsulta = function (consulta) {
        console.log("Service: Guardando Proveedor");
        return $http.post(url, consulta);
    };

    

return consultaService;
  
  
}])
.factory('categoriaService', ['$http', function ($http) {
console.log("Service: Getting gategorias")
  var url = 'http://localhost:9000/ajustadoati/categoria/';

  var categoriaService ={};

  

    categoriaService.getCategorias = function () {
        return $http.get(url);
    };

return categoriaService;
  
  
}])
.factory('MapService', function ($cordovaGeolocation) {

    var markerId = 0;

    function create(latitude, longitude) {
        console.log("creando ubicacion");
        var marker = {
            options: {
                animation: 1,
                labelAnchor: "28 -5",
                labelClass: 'markerlabel'    
            },
            latitude: latitude,
            longitude: longitude,
            id: ++markerId          
        };
        return marker;        
    }

    function getPosition(latitude, longitude) {
        var position = {
            
            latitude: latitude,
            longitude: longitude,
                    
        };
        return position;        
    }

function getCurrentLocation(successCallback) {
        console.log("current position");
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                var marker = create(position.coords.latitude, position.coords.longitude);
                invokeSuccessCallback(successCallback, marker);
            });
        } else {
            alert('Unable to locate current position');
        }
    }
    function invokeSuccessCallback(successCallback, marker) {
        if (typeof successCallback === 'function') {
            successCallback(marker);
        }
    }

    function createByCoords(latitude, longitude, successCallback) {
        var marker = create(latitude, longitude);
        invokeSuccessCallback(successCallback, marker);
    }

    function createByAddress(address, successCallback) {
        var geocoder = new google.maps.Geocoder();
        geocoder.geocode({'address' : address}, function (results, status) {
            if (status === google.maps.GeocoderStatus.OK) {
                var firstAddress = results[0];
                var latitude = firstAddress.geometry.location.lat();
                var longitude = firstAddress.geometry.location.lng();
                var marker = create(latitude, longitude);
                invokeSuccessCallback(successCallback, marker);
            } else {
                alert("Unknown address: " + address);
            }
        });
    }

    function createByCurrentLocation(successCallback) {
        console.log("cargando posicion");
         var options = {timeout: 10000, enableHighAccuracy: true};
        $cordovaGeolocation.getCurrentPosition(options).then(function(position){
          var marker = create(position.coords.latitude, position.coords.longitude);
                invokeSuccessCallback(successCallback, marker);
        
       
        }, function(error){
          console.log("Could not get location");
        });
        if (navigator.geolocation) {
            navigator.geolocation.getCurrentPosition(function (position) {
                
            });
        } else {
            alert('Unable to locate current position');
        }
    }


    

    return {
        getCurrentLocation: getCurrentLocation,
        createByCoords: createByCoords,
        createByAddress: createByAddress,
        createByCurrentLocation: createByCurrentLocation
        
    };

})



.service('BlankService', [function(){

}]);

