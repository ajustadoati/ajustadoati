// @SOURCE:/Volumes/Macintosh HD/ajustadoati/ajustadoatiCore/conf/routes
// @HASH:0330a6ded67b926a6ccb4cce1047412c07f99cb9
// @DATE:Sat May 21 12:24:36 VET 2016

import Routes.{prefix => _prefix, defaultPrefix => _defaultPrefix}
import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString


// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers {

// @LINE:21
class ReverseAssets {


// @LINE:21
def versioned(file:String): Call = {
   implicit val _rrc = new ReverseRouteContext(Map(("path", "/public")))
   Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[PathBindable[String]].unbind("file", file))
}
                        

}
                          

// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:19
def preflight(all:String): Call = {
   import ReverseRouteContext.empty
   Call("OPTIONS", _prefix + { _defaultPrefix } + implicitly[PathBindable[String]].unbind("all", all))
}
                        

// @LINE:6
def listBooks(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "books")
}
                        

// @LINE:14
def listCategorias(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajustadoati/categoria/")
}
                        

// @LINE:9
def listProveedores(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajustadoati/proveedor/")
}
                        

// @LINE:17
def listUsuarios(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajustadoati/usuario/")
}
                        

// @LINE:13
def saveProveedor(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ajustadoati/proveedor/")
}
                        

// @LINE:8
def findProveedorByUser(user:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajustadoati/proveedor/" + implicitly[PathBindable[String]].unbind("user", dynamicString(user)))
}
                        

// @LINE:12
def listByCategoria(categoria:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajustadoati/proveedor/categoria/" + implicitly[PathBindable[String]].unbind("categoria", dynamicString(categoria)))
}
                        

// @LINE:11
def saveConsulta(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ajustadoati/consulta/")
}
                        

// @LINE:7
def saveBook(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "books")
}
                        

// @LINE:16
def saveUsuario(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ajustadoati/usuario/")
}
                        

// @LINE:10
def listConsultas(): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajustadoati/consulta/")
}
                        

// @LINE:15
def saveCategoria(): Call = {
   import ReverseRouteContext.empty
   Call("POST", _prefix + { _defaultPrefix } + "ajustadoati/categoria/")
}
                        

// @LINE:18
def findUsuarioByUser(user:String): Call = {
   import ReverseRouteContext.empty
   Call("GET", _prefix + { _defaultPrefix } + "ajustadoati/usuario/" + implicitly[PathBindable[String]].unbind("user", dynamicString(user)))
}
                        

}
                          
}
                  


// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.javascript {
import ReverseRouteContext.empty

// @LINE:21
class ReverseAssets {


// @LINE:21
def versioned : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Assets.versioned",
   """
      function(file) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("file", file)})
      }
   """
)
                        

}
              

// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:19
def preflight : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.preflight",
   """
      function(all) {
      return _wA({method:"OPTIONS", url:"""" + _prefix + { _defaultPrefix } + """" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("all", all)})
      }
   """
)
                        

// @LINE:6
def listBooks : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.listBooks",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "books"})
      }
   """
)
                        

// @LINE:14
def listCategorias : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.listCategorias",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/categoria/"})
      }
   """
)
                        

// @LINE:9
def listProveedores : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.listProveedores",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/proveedor/"})
      }
   """
)
                        

// @LINE:17
def listUsuarios : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.listUsuarios",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/usuario/"})
      }
   """
)
                        

// @LINE:13
def saveProveedor : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.saveProveedor",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/proveedor/"})
      }
   """
)
                        

// @LINE:8
def findProveedorByUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.findProveedorByUser",
   """
      function(user) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/proveedor/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user", encodeURIComponent(user))})
      }
   """
)
                        

// @LINE:12
def listByCategoria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.listByCategoria",
   """
      function(categoria) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/proveedor/categoria/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("categoria", encodeURIComponent(categoria))})
      }
   """
)
                        

// @LINE:11
def saveConsulta : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.saveConsulta",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/consulta/"})
      }
   """
)
                        

// @LINE:7
def saveBook : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.saveBook",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "books"})
      }
   """
)
                        

// @LINE:16
def saveUsuario : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.saveUsuario",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/usuario/"})
      }
   """
)
                        

// @LINE:10
def listConsultas : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.listConsultas",
   """
      function() {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/consulta/"})
      }
   """
)
                        

// @LINE:15
def saveCategoria : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.saveCategoria",
   """
      function() {
      return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/categoria/"})
      }
   """
)
                        

// @LINE:18
def findUsuarioByUser : JavascriptReverseRoute = JavascriptReverseRoute(
   "controllers.Application.findUsuarioByUser",
   """
      function(user) {
      return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "ajustadoati/usuario/" + (""" + implicitly[PathBindable[String]].javascriptUnbind + """)("user", encodeURIComponent(user))})
      }
   """
)
                        

}
              
}
        


// @LINE:21
// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
package controllers.ref {


// @LINE:21
class ReverseAssets {


// @LINE:21
def versioned(path:String, file:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Assets.versioned(path, file), HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[String]), "GET", """ Map static resources from the /public folder to the /assets URL path""", _prefix + """assets/$file<.+>""")
)
                      

}
                          

// @LINE:19
// @LINE:18
// @LINE:17
// @LINE:16
// @LINE:15
// @LINE:14
// @LINE:13
// @LINE:12
// @LINE:11
// @LINE:10
// @LINE:9
// @LINE:8
// @LINE:7
// @LINE:6
class ReverseApplication {


// @LINE:19
def preflight(all:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.preflight(all), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "preflight", Seq(classOf[String]), "OPTIONS", """""", _prefix + """$all<.+>""")
)
                      

// @LINE:6
def listBooks(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.listBooks(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listBooks", Seq(), "GET", """ Home page""", _prefix + """books""")
)
                      

// @LINE:14
def listCategorias(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.listCategorias(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listCategorias", Seq(), "GET", """""", _prefix + """ajustadoati/categoria/""")
)
                      

// @LINE:9
def listProveedores(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.listProveedores(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listProveedores", Seq(), "GET", """""", _prefix + """ajustadoati/proveedor/""")
)
                      

// @LINE:17
def listUsuarios(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.listUsuarios(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listUsuarios", Seq(), "GET", """""", _prefix + """ajustadoati/usuario/""")
)
                      

// @LINE:13
def saveProveedor(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.saveProveedor(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveProveedor", Seq(), "POST", """""", _prefix + """ajustadoati/proveedor/""")
)
                      

// @LINE:8
def findProveedorByUser(user:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.findProveedorByUser(user), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "findProveedorByUser", Seq(classOf[String]), "GET", """""", _prefix + """ajustadoati/proveedor/$user<[^/]+>""")
)
                      

// @LINE:12
def listByCategoria(categoria:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.listByCategoria(categoria), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listByCategoria", Seq(classOf[String]), "GET", """""", _prefix + """ajustadoati/proveedor/categoria/$categoria<[^/]+>""")
)
                      

// @LINE:11
def saveConsulta(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.saveConsulta(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveConsulta", Seq(), "POST", """""", _prefix + """ajustadoati/consulta/""")
)
                      

// @LINE:7
def saveBook(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.saveBook(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveBook", Seq(), "POST", """""", _prefix + """books""")
)
                      

// @LINE:16
def saveUsuario(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.saveUsuario(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveUsuario", Seq(), "POST", """""", _prefix + """ajustadoati/usuario/""")
)
                      

// @LINE:10
def listConsultas(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.listConsultas(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listConsultas", Seq(), "GET", """""", _prefix + """ajustadoati/consulta/""")
)
                      

// @LINE:15
def saveCategoria(): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.saveCategoria(), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveCategoria", Seq(), "POST", """""", _prefix + """ajustadoati/categoria/""")
)
                      

// @LINE:18
def findUsuarioByUser(user:String): play.api.mvc.HandlerRef[_] = new play.api.mvc.HandlerRef(
   controllers.Application.findUsuarioByUser(user), HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "findUsuarioByUser", Seq(classOf[String]), "GET", """""", _prefix + """ajustadoati/usuario/$user<[^/]+>""")
)
                      

}
                          
}
        
    