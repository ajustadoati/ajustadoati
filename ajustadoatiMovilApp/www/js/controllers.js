angular.module('app.controllers', [])
  
.controller('loginCtrl', function($scope) {

})
   
.controller('registroCtrl', function($scope) {

})
   
.controller('registroVendedorCtrl', function($scope, $state, categoriaService, proveedorService, $cordovaGeolocation, MapService) {
	console.log("registroVendedorCtrl");
	$scope.proveedor={};
  $scope.categorias=[];
  $scope.categoriasSelected=[];
  $scope.proveedor.usuario={};
  $scope.proveedor.categorias=[];

 
      //cargando mapa desde el service
      MapService.createByCurrentLocation(function (marker) {
                console.log("Llamando al service");
                marker.options.labelContent = 'Usted esta aqu&iacute;';
                $scope.proveedor.usuario.latitud=marker.latitude;
                $scope.proveedor.usuario.longitud=marker.longitude;
                //$scope.map.markers.push(marker);
                //refresh(marker
                  var latLng = new google.maps.LatLng($scope.proveedor.usuario.latitud, $scope.proveedor.usuario.longitud);
 
          var mapOptions = {
            center: latLng,
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
          };
       
          $scope.map = new google.maps.Map(document.getElementById("map"), mapOptions);
          google.maps.event.addListenerOnce($scope.map, 'idle', function(){
       
                var marker = new google.maps.Marker({
                  map: $scope.map,
                  animation: google.maps.Animation.DROP,
                  position: latLng
              });      
             
              var infoWindow = new google.maps.InfoWindow({
                  content: "Here I am!"
              });
             
            google.maps.event.addListener(marker, 'click', function () {
                infoWindow.open($scope.map, marker);
            });
          });
     });
  //$scope.data = [{id: 1, value: "Item 1"}, {id: 2, value: "Item 2"}, {id: 3, value: "Item 3"}];

  $scope.onValueChanged = function(value){
    console.log(value);
    var cats=value.split("-");  
    if(cats.length>0){
      
      for(var i=0;i<cats.length;i++){
        console.log("categoria:"+cats[i]);
        for(var j=0; j<$scope.categorias.length;j++){
                    var categoria=[];
                    
                    //categoria.selected=false;
                    categoria.id=j;
                    categoria.nombre=$scope.categorias[j].nombre;
                    categoria.descripcion=$scope.categorias[j].descripcion;
                    
                    if(categoria.nombre===cats[i]){
                      console.log("Se agrega la categoria:"+categoria.nombre);
                      $scope.categoriasSelected.push(categoria);
                    }
               }
      }
    }

  }

  getCategorias();

   function getCategorias() {
    console.log("Ctrl. getting categorias")
        categoriaService.getCategorias()
            .success(function (categorias) {
                for(var i=0; i<categorias.length;i++){
                    var categoria=[];
                    
                    categoria.selected=false;
                    categoria.id=i;
                    categoria.nombre=categorias[i].nombre;
                    categoria.descripcion=categorias[i].descripcion;
                    $scope.categorias.push(categoria);
                
               }
                $scope.data = categorias;
            })
            .error(function (error) {
                $scope.status = 'Unable to load customer data: ' + error.message;
            });
    }


	$scope.crearVendedor = function (newVendedorForm) {
                console.log("guardando proveedor !!"+ $scope.proveedor);
                console.log("nombre: "+$scope.proveedor.usuario.nombre);
                console.log("email: "+$scope.proveedor.usuario.email);
               // console.log("lat: "+$scope.usuario.latitud);
                //console.log("long: "+$scope.usuario.longitud);
                console.log("user: "+$scope.proveedor.usuario.user);
                console.log("pass: "+$scope.proveedor.usuario.password);
                console.log("twitter:"+$scope.proveedor.usuario.twitter);
                console.log("twitter:"+$scope.proveedor.usuario.telefono);


               //$scope.proveedor.usuario.latitud=2.992929;
               //$scope.proveedor.usuario.longitud=55.992929;

               for(var i=0; i<$scope.categoriasSelected.length;i++){
                console.log("categorias:"+$scope.categoriasSelected[i].nombre);
                var categoria={};
                //categoria.id=$scope.selection[i];
                categoria.nombre=$scope.categoriasSelected[i].nombre;
                categoria.descripcion=$scope.categoriasSelected[i].descripcion;
                $scope.proveedor.categorias.push(categoria);
              }
              for(var i=0; i<$scope.proveedor.categorias.length;i++){
                console.log("categoriasrazon:"+$scope.proveedor.categorias[i].nombre);
                
              }
               
        		proveedorService.saveProveedor($scope.proveedor)
	            .success(function () {
	                console.log('Saved Proveedor.');
	                $scope.proveedor={};
                  $scope.categoriasSelected=[];
	                $state.go("/login");
	                //$scope.customers.push(cust);

	            }).
	            error(function(error) {
	                $scope.status = 'Unable to insert proveedor: ' + error.message;
	            });
      }
})

   
.controller('registroUsuarioCtrl', function($scope, usuarioService, $state) {
	console.log("registroUsuarioCtrl");
	$scope.usuario={};
	$scope.crearUsuario = function (newUsuarioForm) {
                console.log("guardando usuario !!"+ $scope.usuario);
                console.log("nombre: "+$scope.usuario.nombre);
                console.log("email: "+$scope.usuario.email);
               // console.log("lat: "+$scope.usuario.latitud);
                //console.log("long: "+$scope.usuario.longitud);
                console.log("user: "+$scope.usuario.user);
                console.log("pass: "+$scope.usuario.password);
                console.log("twitter:"+$scope.usuario.twitter);
                console.log("twitter:"+$scope.usuario.telefono);

               $scope.usuario.latitud=2.992929;
               $scope.usuario.longitud=55.992929;
               
        		usuarioService.saveUsuario($scope.usuario)
	            .success(function () {
	                console.log('Saved Usuario.');
	                $scope.usuario={};
	                $state.go("/login");
	                //$scope.customers.push(cust);

	            }).
	            error(function(error) {
	                $scope.status = 'Unable to insert usuario: ' + error.message;
	            });
      }

})
   
.controller('busquedaCtrl', function($scope, categoriaService, consultaService, $cordovaGeolocation, MapService) {
  console.log("busquedaCtrl")
  $scope.categorias=[];
  $scope.categoriasSelected=[];
  $scope.latitud="";
  $scope.longitud="";
  $scope.consulta={};
  $scope.consulta.producto={};
  $scope.consulta.usuario={};
  $scope.consulta.categoria={};
  $scope.proveedores=[];
  $scope.map={};


  var ws = new WebSocket('ws://localhost:8080/ajustadoatiWS/openfire');

    ws.onopen = function () {
        console.log('open');
        
        //this.send('hello');         // transmit "hello" after connecting
    };

    ws.onmessage = function (event) {
        console.log(event.data);   
        console.log("receiving"+event.data);
        var obj = JSON.parse(event.data);

        console.log("receiving from: "+obj.user);
        console.log("message: "+obj.message);
        //var user=$scope.getUser(obj.user);
        
        //console.log("obteniendo usuario: "+user.nombre);
        $scope.addLocation(obj.latitud, obj.longitud); // will be "hello"
        //this.close();
    };

    ws.onerror = function () {
        console.log('error occurred!');
    };

    ws.onclose = function (event) {
        console.log('close code=' + event.code);
    };

     $scope.addLocation= function(latitud, longitud){
          console.log("creando la location del proveedor");
          
              
                var latLng = new google.maps.LatLng(latitud, longitud);
   
               
                google.maps.event.addListenerOnce($scope.map, 'idle', function(){
                   console.log("listeners");
                  var marker = new google.maps.Marker({
                    map: $scope.map,
                    animation: google.maps.Animation.DROP,
                    position: latLng
                });      
               
                var infoWindow = new google.maps.InfoWindow({
                    content: "Yo vendo!"
                });
               
              google.maps.event.addListener(marker, 'click', function () {
                  infoWindow.open($scope.map, marker);
              });
            });
           // $scope.map.markers.push(marker);
            //refresh(marker);
          
        }

  //$scope.proveedor.usuario={};
  //$scope.proveedor.categorias=[];

 
      //cargando mapa desde el service


      MapService.createByCurrentLocation(function (marker) {
                console.log("Llamando al service");
                marker.options.labelContent = 'Usted esta aqu&iacute;';
                $scope.consulta.usuario.latitud=marker.latitude;
                $scope.consulta.usuario.longitud=marker.longitude;
                //$scope.map.markers.push(marker);
                //refresh(marker
                  var latLng = new google.maps.LatLng($scope.consulta.usuario.latitud, $scope.consulta.usuario.longitud);
 
          var mapOptions = {
            center: latLng,
            zoom: 15,
            mapTypeId: google.maps.MapTypeId.ROADMAP
          };
       
          $scope.map = new google.maps.Map(document.getElementById("map"), mapOptions);
          google.maps.event.addListenerOnce($scope.map, 'idle', function(){
       
                var marker = new google.maps.Marker({
                  map: $scope.map,
                  animation: google.maps.Animation.DROP,
                  position: latLng
              });      
             
              var infoWindow = new google.maps.InfoWindow({
                  content: "Servidor!"
              });
             
            google.maps.event.addListener(marker, 'click', function () {
                infoWindow.open($scope.map, marker);
            });
          });
     });

  $scope.onValueChanged = function(value){
    console.log(value); 
    var cats=value.split("-");  
    if(cats.length>0){
      
      for(var i=0;i<cats.length;i++){
        console.log("categoria:"+cats[i]);
        for(var j=0; j<$scope.categorias.length;j++){
                    var categoria=[];
                    
                    //categoria.selected=false;
                    categoria.id=j;
                    categoria.nombre=$scope.categorias[j].nombre;
                    categoria.descripcion=$scope.categorias[j].descripcion;
                    
                    if(categoria.nombre===cats[i]){
                      console.log("Se agrega la categoria:"+categoria.nombre);
                      $scope.categoriasSelected.push(categoria);
                    }
               }
      }
    }

  }

  getCategorias();

 

   function getCategorias() {
    console.log("Ctrl. getting categorias")
        categoriaService.getCategorias()
            .success(function (categorias) {
                for(var i=0; i<categorias.length;i++){
                    var categoria=[];
                    
                    categoria.selected=false;
                    categoria.id=i;
                    categoria.nombre=categorias[i].nombre;
                    categoria.descripcion=categorias[i].descripcion;
                    $scope.categorias.push(categoria);
                
               }
                $scope.data = categorias;
            })
            .error(function (error) {
                $scope.status = 'Unable to load customer data: ' + error.message;
            });
    }

    $scope.buscar = function (newSearchForm) {
      console.log("realizando busqueda");
                
               
                $scope.consulta.usuario.nombre="anonimo";
                $scope.consulta.usuario.email="anonimo@anonimo";
                $scope.consulta.usuario.user="anonimo";
                $scope.consulta.usuario.password="anonimo";
                $scope.consulta.usuario.telefono="04838383";
                $scope.consulta.usuario.twitter="@anonimo";
                $scope.consulta.producto.descripcion=$scope.consulta.producto.nombre;
                $scope.consulta.producto.id=0;
               //$scope.usuario.latitud=2.992929;
               //$scope.usuario.longitud=55.992929;

               for(var i=0; i<$scope.categoriasSelected.length;i++){
                console.log("categorias:"+$scope.categoriasSelected[i].nombre);
                var categoria={};
                categoria.id=i;
                categoria.nombre=$scope.categoriasSelected[i].nombre;
                categoria.descripcion=$scope.categoriasSelected[i].descripcion;
                $scope.consulta.categoria=categoria;

              }
              /*for(var i=0; i<$scope.categorias.length;i++){
                console.log("categoriasrazon:"+$scope.categorias[i].nombre);
                
              }*/
               var resp="";
               var men="";
               men=$scope.consulta.producto.nombre;
            consultaService.saveConsulta($scope.consulta)
              .success(function (data) {
                  console.log('Saved Consulta.');
                  console.log('response:'+data[0].usuario.user);
                  $scope.proveedores=data;
                  $scope.consulta={};
                  $scope.categoriasSelected=[];
                  
                  //$state.go("/login");
                  //$scope.customers.push(cust);

              }).
              error(function(error) {
                  $scope.status = 'Unable to insert consulta: ' + error.message;
              }).finally(function(data){
                
                  console.log("size"+$scope.proveedores.length);
                      for(var i=0; i<$scope.proveedores.length; i++){
                          console.log("proveedor: "+$scope.proveedores[i].usuario.user);
                          if($scope.proveedores.length==(i+1)){
                            console.log("fin de ciclo");
                              resp=resp+$scope.proveedores[i].usuario.user;
                          }else{
                            console.log("sigue el ciclo");
                              resp=resp+$scope.proveedores[i].usuario.user+"&&";
                          }
                          
                        }
                        console.log("resp"+resp);
                        console.log("data a proveedores");
                        //$scope.sendData();

                        var msg = '{"mensaje":"' + men + '", "users":"'+resp+'"}';
                        ws.send(msg);

                        
                    });
      }

    
})
   
.controller('resultadoBusquedaCtrl', function($scope) {

})
   
.controller('solicitudesCtrl', function($scope) {

})
   
.controller('ubicacionCtrl', function($scope) {

})
   
.controller('productosCtrl', function($scope) {

})
      
.controller('perfilCtrl', function($scope) {

})
   
.controller('solicitudCtrl', function($scope) {

})
   
.controller('solicitudes2Ctrl', function($scope) {

})
   
.controller('ubicacionUsuarioCtrl', function($scope) {

})
      
.controller('perfilUsuarioCtrl', function($scope) {

})
   
.controller('detalleResultadoCtrl', function($scope) {

})
 