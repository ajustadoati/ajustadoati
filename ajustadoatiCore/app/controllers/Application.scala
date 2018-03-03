package controllers

import play.api.libs.json._
import play.api.mvc._
import models.Book._
import models.categoria.Categoria
import models.proveedor.Proveedor
import models.cliente.Cliente
import models.producto.Producto
import models.consulta.Consulta
import models.usuario.Usuario
import models.dispositivo.Dispositivo
import models.dispositivoUsuario.DispositivoUsuario
import services.dispositivo.DispositivoServiceComponent
import services.dispositivo.DispositivoServiceComponentImpl

import repositories.dispositivo.DispositivoRepositoryComponentImpl
import models.usuarioLogin.UsuarioLogin
import services.proveedor.ProveedorServiceComponentImpl
import repositories.proveedor.ProveedorRepositoryComponentImpl
import services.categoria.CategoriaServiceComponentImpl
import repositories.categoria.CategoriaRepositoryComponentImpl
import services.consulta.ConsultaServiceComponent
import services.consulta.ConsultaServiceComponentImpl
import repositories.consulta.ConsultaRepositoryComponentImpl
import services.usuario.UsuarioServiceComponent
import services.usuario.UsuarioServiceComponentImpl
import repositories.usuario.UsuarioRepositoryComponentImpl
import controllers.proveedor.ProveedorController
import org.anormcypher._
import play.api.Logger

object Application extends ProveedorController with ProveedorRepositoryComponentImpl with ProveedorServiceComponentImpl with CategoriaServiceComponentImpl with CategoriaRepositoryComponentImpl with ConsultaServiceComponentImpl with ConsultaRepositoryComponentImpl with UsuarioServiceComponentImpl with UsuarioRepositoryComponentImpl with DispositivoServiceComponentImpl with DispositivoRepositoryComponentImpl {

     def preflight(all: String) = Action {
        Ok("").withHeaders("Access-Control-Allow-Origin" -> "*",
          "Allow" -> "*",
          "Access-Control-Allow-Methods" -> "POST, GET, PUT, DELETE, OPTIONS",
          "Access-Control-Allow-Headers" -> "Origin, X-Requested-With, Content-Type, Accept, Referrer, User-Agent");
      }
  implicit val usuarioWrites = Json.writes[Usuario]
  implicit val usuarioReads = Json.reads[Usuario]
  implicit val usuarioLoginWrites = Json.writes[UsuarioLogin]
  implicit val usuarioLoginReads = Json.reads[UsuarioLogin]
  implicit val dispositivoWrites = Json.writes[Dispositivo]
  implicit val dispositivoReads = Json.reads[Dispositivo]
  implicit val dispositivoUsuarioWrites = Json.writes[DispositivoUsuario]
  implicit val dispositivoUsuarioReads = Json.reads[DispositivoUsuario]
  def saveUsuario = Action(BodyParsers.parse.json) { request =>
      val b = request.body.validate[Usuario]

      b.fold(
        errors => {
          BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors)))
        },
        usuario => {
       
          Logger.info("guardando usuario"+usuario)
          val p=usuarioService.createUsuario(usuario)
          Created(Json.obj("status" -> "Registro Creado"))
        }
      )
    }

    def listUsuarios = Action {
        Logger.info("obteniendo usuarios")
        Ok(Json.toJson(usuarioService.list()))
    }

    def findUsuarioByUser(user: String) = Action {
      Logger.info("Controller: buscando usuario"+user)
        val usuario = usuarioService.tryFindByUser(user)
        if(usuario != null)
            Ok(Json.toJson(usuario))
        else
            Ok(Json.obj("status" -> "Registro no Existe"))
       
    }


    def findUsuarioByUserAndPassword = Action(BodyParsers.parse.json) { request =>
      val usuarioLogin = request.body.validate[UsuarioLogin]

      usuarioLogin.fold(
        errors => {
          BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors)))
        },
        usuarioLogin => {
       
          Logger.info("guardando usuario"+usuarioLogin)
          val usuario=usuarioService.tryFindByUserAndPassword(usuarioLogin.user, usuarioLogin.password)
          if(usuario!=null)
            Ok(Json.toJson(usuario))
          else
            Ok(Json.obj("status" -> "Registro no Existe"))
        }
      )
    }

    def addContact(contact:String, user: String) = Action {
      Logger.info("Controller: agregando contacto")
      val response = usuarioService.addContactToUser(contact,user)
      if(response != null)
        Ok(Json.obj("status" -> "OK"))
      else
        Ok(Json.obj("status" -> "KO"))
    }

    def saveCategoria = Action(BodyParsers.parse.json) { request =>
      val b = request.body.validate[Categoria]

      b.fold(
        errors => {
          BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors)))
        },
        categoria => {
       
          Logger.info("guardando categoria"+categoria)
          val p=categoriaService.createCategoria(categoria)
          Created(Json.obj("status" -> "Registro Creado"))
        }
      )
    }

    
    
    def listCategorias = Action {

        Ok(Json.toJson(categoriaService.list()))
    }

    

  def listBooks = Action {
    Ok(Json.toJson(books))
  }

  def saveBook = Action(BodyParsers.parse.json) { request =>
    val b = request.body.validate[Book]
    b.fold(
      errors => {
        BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors)))
      },
      book => {
        addBook(book)
        Ok(Json.obj("status" -> "OK"))
      }
    )
  }
  

   def saveConsulta = Action(BodyParsers.parse.json) { request =>
    val b = request.body.validate[Consulta]

    b.fold(
      errors => {
        BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors)))
      },
      consulta => {
     
        Logger.info("guardando consulta"+consulta)
        val p=consultaService.createConsulta(consulta)
        val lista:List[Proveedor]= proveedorService.listByCategoria(consulta.categoria.nombre)
        Created(Json.toJson(lista))
      }
    )
  }
    
    def listConsultas= Action {

        Ok(Json.toJson(consultaService.list()))
    }

    def saveDispositivoUsuario = Action(BodyParsers.parse.json){request =>
      val b = request.body.validate[DispositivoUsuario]
      b.fold(
            errors => {
          BadRequest(Json.obj("status" -> "OK", "message" -> JsError.toFlatJson(errors)))
        },
        dispositivoUsuario => {
       
          Logger.info("guardando dispositivo"+dispositivoUsuario)
          val p=dispositivoService.createDispositivoUsuario(dispositivoUsuario)
          
          Created(Json.toJson(p))
        }
      )
    }

    def listDispositivoByUsuario(usuario:String)= Action {
      Logger.info("Controller: buscando usuario"+usuario)
        
        val lista:List[Dispositivo]= dispositivoService.listDispositivoByUsuario(usuario)
        if(lista != null)
            Ok(Json.toJson(lista))
        else{
          Ok(Json.obj("status" -> "No existen dispositivos"))
        }
    }

     def findDispositivoByUuid(uuid: String) = Action {
      Logger.info("Controller: buscando dispositivo"+uuid)
        val dispositivo = dispositivoService.getDispositivoByUuid(uuid)
        if(dispositivo != null)
            Ok(Json.toJson(dispositivo))
        else
            Ok(Json.obj("status" -> "Registro no Existe"))
       
    }

      def listDispositivoByListUsuarios(listUsuarios:String)= Action {
      Logger.info("Controller: buscando dispositivos para usuarios"+listUsuarios)
        
        val lista:List[Dispositivo]= dispositivoService.listDispositivoByListUsuarios(listUsuarios)
        if(lista != null)
            Ok(Json.toJson(lista))
        else{
          Ok(Json.obj("status" -> "No existen dispositivos"))
        }
    }

    
}
