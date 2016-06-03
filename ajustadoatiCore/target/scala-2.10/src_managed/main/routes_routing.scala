// @SOURCE:/Volumes/Macintosh HD/ajustadoati/ajustadoatiCore/conf/routes
// @HASH:0330a6ded67b926a6ccb4cce1047412c07f99cb9
// @DATE:Sat May 21 12:24:36 VET 2016


import play.core._
import play.core.Router._
import play.core.Router.HandlerInvokerFactory._
import play.core.j._

import play.api.mvc._
import _root_.controllers.Assets.Asset

import Router.queryString

object Routes extends Router.Routes {

import ReverseRouteContext.empty

private var _prefix = "/"

def setPrefix(prefix: String) {
  _prefix = prefix
  List[(String,Routes)]().foreach {
    case (p, router) => router.setPrefix(prefix + (if(prefix.endsWith("/")) "" else "/") + p)
  }
}

def prefix = _prefix

lazy val defaultPrefix = { if(Routes.prefix.endsWith("/")) "" else "/" }


// @LINE:6
private[this] lazy val controllers_Application_listBooks0_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("books"))))
private[this] lazy val controllers_Application_listBooks0_invoker = createInvoker(
controllers.Application.listBooks,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listBooks", Nil,"GET", """ Home page""", Routes.prefix + """books"""))
        

// @LINE:7
private[this] lazy val controllers_Application_saveBook1_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("books"))))
private[this] lazy val controllers_Application_saveBook1_invoker = createInvoker(
controllers.Application.saveBook,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveBook", Nil,"POST", """""", Routes.prefix + """books"""))
        

// @LINE:8
private[this] lazy val controllers_Application_findProveedorByUser2_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/proveedor/"),DynamicPart("user", """[^/]+""",true))))
private[this] lazy val controllers_Application_findProveedorByUser2_invoker = createInvoker(
controllers.Application.findProveedorByUser(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "findProveedorByUser", Seq(classOf[String]),"GET", """""", Routes.prefix + """ajustadoati/proveedor/$user<[^/]+>"""))
        

// @LINE:9
private[this] lazy val controllers_Application_listProveedores3_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/proveedor/"))))
private[this] lazy val controllers_Application_listProveedores3_invoker = createInvoker(
controllers.Application.listProveedores,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listProveedores", Nil,"GET", """""", Routes.prefix + """ajustadoati/proveedor/"""))
        

// @LINE:10
private[this] lazy val controllers_Application_listConsultas4_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/consulta/"))))
private[this] lazy val controllers_Application_listConsultas4_invoker = createInvoker(
controllers.Application.listConsultas,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listConsultas", Nil,"GET", """""", Routes.prefix + """ajustadoati/consulta/"""))
        

// @LINE:11
private[this] lazy val controllers_Application_saveConsulta5_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/consulta/"))))
private[this] lazy val controllers_Application_saveConsulta5_invoker = createInvoker(
controllers.Application.saveConsulta,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveConsulta", Nil,"POST", """""", Routes.prefix + """ajustadoati/consulta/"""))
        

// @LINE:12
private[this] lazy val controllers_Application_listByCategoria6_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/proveedor/categoria/"),DynamicPart("categoria", """[^/]+""",true))))
private[this] lazy val controllers_Application_listByCategoria6_invoker = createInvoker(
controllers.Application.listByCategoria(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listByCategoria", Seq(classOf[String]),"GET", """""", Routes.prefix + """ajustadoati/proveedor/categoria/$categoria<[^/]+>"""))
        

// @LINE:13
private[this] lazy val controllers_Application_saveProveedor7_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/proveedor/"))))
private[this] lazy val controllers_Application_saveProveedor7_invoker = createInvoker(
controllers.Application.saveProveedor,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveProveedor", Nil,"POST", """""", Routes.prefix + """ajustadoati/proveedor/"""))
        

// @LINE:14
private[this] lazy val controllers_Application_listCategorias8_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/categoria/"))))
private[this] lazy val controllers_Application_listCategorias8_invoker = createInvoker(
controllers.Application.listCategorias,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listCategorias", Nil,"GET", """""", Routes.prefix + """ajustadoati/categoria/"""))
        

// @LINE:15
private[this] lazy val controllers_Application_saveCategoria9_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/categoria/"))))
private[this] lazy val controllers_Application_saveCategoria9_invoker = createInvoker(
controllers.Application.saveCategoria,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveCategoria", Nil,"POST", """""", Routes.prefix + """ajustadoati/categoria/"""))
        

// @LINE:16
private[this] lazy val controllers_Application_saveUsuario10_route = Route("POST", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/usuario/"))))
private[this] lazy val controllers_Application_saveUsuario10_invoker = createInvoker(
controllers.Application.saveUsuario,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "saveUsuario", Nil,"POST", """""", Routes.prefix + """ajustadoati/usuario/"""))
        

// @LINE:17
private[this] lazy val controllers_Application_listUsuarios11_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/usuario/"))))
private[this] lazy val controllers_Application_listUsuarios11_invoker = createInvoker(
controllers.Application.listUsuarios,
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "listUsuarios", Nil,"GET", """""", Routes.prefix + """ajustadoati/usuario/"""))
        

// @LINE:18
private[this] lazy val controllers_Application_findUsuarioByUser12_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("ajustadoati/usuario/"),DynamicPart("user", """[^/]+""",true))))
private[this] lazy val controllers_Application_findUsuarioByUser12_invoker = createInvoker(
controllers.Application.findUsuarioByUser(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "findUsuarioByUser", Seq(classOf[String]),"GET", """""", Routes.prefix + """ajustadoati/usuario/$user<[^/]+>"""))
        

// @LINE:19
private[this] lazy val controllers_Application_preflight13_route = Route("OPTIONS", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),DynamicPart("all", """.+""",false))))
private[this] lazy val controllers_Application_preflight13_invoker = createInvoker(
controllers.Application.preflight(fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Application", "preflight", Seq(classOf[String]),"OPTIONS", """""", Routes.prefix + """$all<.+>"""))
        

// @LINE:21
private[this] lazy val controllers_Assets_versioned14_route = Route("GET", PathPattern(List(StaticPart(Routes.prefix),StaticPart(Routes.defaultPrefix),StaticPart("assets/"),DynamicPart("file", """.+""",false))))
private[this] lazy val controllers_Assets_versioned14_invoker = createInvoker(
controllers.Assets.versioned(fakeValue[String], fakeValue[String]),
HandlerDef(this.getClass.getClassLoader, "", "controllers.Assets", "versioned", Seq(classOf[String], classOf[String]),"GET", """ Map static resources from the /public folder to the /assets URL path""", Routes.prefix + """assets/$file<.+>"""))
        
def documentation = List(("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """books""","""controllers.Application.listBooks"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """books""","""controllers.Application.saveBook"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/proveedor/$user<[^/]+>""","""controllers.Application.findProveedorByUser(user:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/proveedor/""","""controllers.Application.listProveedores"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/consulta/""","""controllers.Application.listConsultas"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/consulta/""","""controllers.Application.saveConsulta"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/proveedor/categoria/$categoria<[^/]+>""","""controllers.Application.listByCategoria(categoria:String)"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/proveedor/""","""controllers.Application.saveProveedor"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/categoria/""","""controllers.Application.listCategorias"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/categoria/""","""controllers.Application.saveCategoria"""),("""POST""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/usuario/""","""controllers.Application.saveUsuario"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/usuario/""","""controllers.Application.listUsuarios"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """ajustadoati/usuario/$user<[^/]+>""","""controllers.Application.findUsuarioByUser(user:String)"""),("""OPTIONS""", prefix + (if(prefix.endsWith("/")) "" else "/") + """$all<.+>""","""controllers.Application.preflight(all:String)"""),("""GET""", prefix + (if(prefix.endsWith("/")) "" else "/") + """assets/$file<.+>""","""controllers.Assets.versioned(path:String = "/public", file:String)""")).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
  case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
  case l => s ++ l.asInstanceOf[List[(String,String,String)]]
}}
      

def routes:PartialFunction[RequestHeader,Handler] = {

// @LINE:6
case controllers_Application_listBooks0_route(params) => {
   call { 
        controllers_Application_listBooks0_invoker.call(controllers.Application.listBooks)
   }
}
        

// @LINE:7
case controllers_Application_saveBook1_route(params) => {
   call { 
        controllers_Application_saveBook1_invoker.call(controllers.Application.saveBook)
   }
}
        

// @LINE:8
case controllers_Application_findProveedorByUser2_route(params) => {
   call(params.fromPath[String]("user", None)) { (user) =>
        controllers_Application_findProveedorByUser2_invoker.call(controllers.Application.findProveedorByUser(user))
   }
}
        

// @LINE:9
case controllers_Application_listProveedores3_route(params) => {
   call { 
        controllers_Application_listProveedores3_invoker.call(controllers.Application.listProveedores)
   }
}
        

// @LINE:10
case controllers_Application_listConsultas4_route(params) => {
   call { 
        controllers_Application_listConsultas4_invoker.call(controllers.Application.listConsultas)
   }
}
        

// @LINE:11
case controllers_Application_saveConsulta5_route(params) => {
   call { 
        controllers_Application_saveConsulta5_invoker.call(controllers.Application.saveConsulta)
   }
}
        

// @LINE:12
case controllers_Application_listByCategoria6_route(params) => {
   call(params.fromPath[String]("categoria", None)) { (categoria) =>
        controllers_Application_listByCategoria6_invoker.call(controllers.Application.listByCategoria(categoria))
   }
}
        

// @LINE:13
case controllers_Application_saveProveedor7_route(params) => {
   call { 
        controllers_Application_saveProveedor7_invoker.call(controllers.Application.saveProveedor)
   }
}
        

// @LINE:14
case controllers_Application_listCategorias8_route(params) => {
   call { 
        controllers_Application_listCategorias8_invoker.call(controllers.Application.listCategorias)
   }
}
        

// @LINE:15
case controllers_Application_saveCategoria9_route(params) => {
   call { 
        controllers_Application_saveCategoria9_invoker.call(controllers.Application.saveCategoria)
   }
}
        

// @LINE:16
case controllers_Application_saveUsuario10_route(params) => {
   call { 
        controllers_Application_saveUsuario10_invoker.call(controllers.Application.saveUsuario)
   }
}
        

// @LINE:17
case controllers_Application_listUsuarios11_route(params) => {
   call { 
        controllers_Application_listUsuarios11_invoker.call(controllers.Application.listUsuarios)
   }
}
        

// @LINE:18
case controllers_Application_findUsuarioByUser12_route(params) => {
   call(params.fromPath[String]("user", None)) { (user) =>
        controllers_Application_findUsuarioByUser12_invoker.call(controllers.Application.findUsuarioByUser(user))
   }
}
        

// @LINE:19
case controllers_Application_preflight13_route(params) => {
   call(params.fromPath[String]("all", None)) { (all) =>
        controllers_Application_preflight13_invoker.call(controllers.Application.preflight(all))
   }
}
        

// @LINE:21
case controllers_Assets_versioned14_route(params) => {
   call(Param[String]("path", Right("/public")), params.fromPath[String]("file", None)) { (path, file) =>
        controllers_Assets_versioned14_invoker.call(controllers.Assets.versioned(path, file))
   }
}
        
}

}
     