package repositories.dispositivo

import models.usuario.Usuario
import models.dispositivoUsuario.DispositivoUsuario
import models.dispositivo.Dispositivo
import play.api.libs.json.Json
import org.anormcypher._
import play.api.Logger
import models.connection.Connection
trait DispositivoRepositoryComponent {
    val dispositivoRepository: DispositivoRepository
    
    trait DispositivoRepository {

        def createDispositivoUsuario(dispositivo: DispositivoUsuario): DispositivoUsuario

        def listDispositivoByUsuario(usuario:String): List[Dispositivo]

        def getDispositivoByUuid(uuid:String):Dispositivo
        
    }
}

trait DispositivoRepositoryComponentImpl extends DispositivoRepositoryComponent with Connection{
    override val dispositivoRepository = new DispositivoRepositoryImpl
     
   
    
    class DispositivoRepositoryImpl extends DispositivoRepository {
        
        
        
       override def createDispositivoUsuario(dispositivoUsuario: DispositivoUsuario): DispositivoUsuario = {
        
        val usuario: String=dispositivoUsuario.usuario
        val dispositivo: Dispositivo=dispositivoUsuario.dispositivo
        

         Logger.info("Repository: Guardando dispositivo"+dispositivo)
         Logger.info("Repository: Usuario"+usuario)

            val result = Cypher("""MATCH (usr:Usuario) WHERE usr.user={user} CREATE (dp:Dispositivo {tipo:{tipo}, nombre:{nombre}, uuid:{uuid}}), (usr)-[:AGREGO]->(dp)""").on("user"->usuario, "tipo"->dispositivo.tipo,"nombre"->dispositivo.nombre, "uuid"->dispositivo.uuid).execute()
            
            if(result==true)
                return dispositivoUsuario
            else
                return null
        }

        override def listDispositivoByUsuario(usuario:String): List[Dispositivo]={
            Logger.info("Repository: Buscando data:"+usuario)
           

            val allDispositivos = Cypher("MATCH (cl:Usuario)-[r:AGREGO]->(n:Dispositivo) RETURN n.tipo, n.nombre, n.uuid")().map { row =>
              (Dispositivo(row[String]("tipo"),row[String]("nombre"),row[String]("uuid")))
            }
           
            val lista=allDispositivos.toList
            Logger.info("lista"+lista)

            if(lista.size>0)
                    return lista
                else
                    return null
        }

        override def getDispositivoByUuid(uuid:String):Dispositivo={
            Logger.info("Buscando data:"+uuid)
            val allDispositivos= Cypher("MATCH (n:Dispositivo) WHERE n.uuid={uuid} RETURN n.tipo, n.nombre as nombre").on("uuid"->uuid)().map{     
                case CypherRow(tipo:String, nombre: String, uuid: String)=>Dispositivo(tipo, nombre, uuid)     
            }

            val lista=allDispositivos.toList
            if(lista.size>0)
                    return lista.iterator.next
                else
                    return null
        }


        
    }
    
}