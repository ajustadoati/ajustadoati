package models.usuarioDispositivo

import play.api.libs.json.Json
import models.usuario.Usuario
import models.dispositivo.Dispositivo


 case class UsuarioDispositivo(usuario:String, dispositivo:Dispositivo)

