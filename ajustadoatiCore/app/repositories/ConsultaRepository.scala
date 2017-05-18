package repositories.consulta


import models.consulta.Consulta
import models.cliente.Cliente
import models.producto.Producto
import models.usuario.Usuario
import models.categoria.Categoria
import play.api.libs.json.Json
import org.anormcypher._
import play.api.Logger
import models.connection.Connection
trait ConsultaRepositoryComponent {
    val consultaRepository: ConsultaRepository
    
    trait ConsultaRepository {
        
        def createConsulta(consulta: Consulta): Consulta

        def list(): List[Consulta]
        
    }
}

trait ConsultaRepositoryComponentImpl extends ConsultaRepositoryComponent with Connection{
    override val consultaRepository = new ConsultaRepositoryImpl
     
   
    
    class ConsultaRepositoryImpl extends ConsultaRepository {
        
        
        
       override def createConsulta(consulta: Consulta): Consulta = {
        
        
        val producto: Producto=consulta.producto
        val categoria: Categoria=consulta.categoria

         Logger.info("Guardando consulta"+consulta)
         Logger.info("Guardando consulta"+consulta.usuario)
         Logger.info("Guardando consulta"+producto)
         Logger.info("Guardando consulta"+categoria)
            //Cypher("""CREATE (cl:Cliente { nombre: {nombre}, email: {email}, twitter: {twitter}, telefono:{telefono}, latitud:{latitud}, longitud:{longitud}}) CREATE (pr:Producto {nombre:{pnombre}, descripcion:{descripcion}}) CREATE (cl)-[:BUSCO]->(pr)""").on("nombre"->cliente.nombre, "email"->cliente.email, "twitter"->cliente.twitter, "latitud"->cliente.latitud.toFloat, "longitud"->cliente.longitud.toFloat, "pnombre"->producto.nombre, "descripcion"->producto.descripcion).execute()
            //CREATE (pr:Producto {nombre:{pnombre}, descripcion:{descripcion}})//, "pnombre"->producto.nombre, "descripcion"->producto.descripcion
             val allUsuarios= Cypher("MATCH (n:Usuario) WHERE n.user={user} RETURN n.nombre as nombre, n.email as email, n.latitud as latitud, n.longitud as longitud, n.user as user, n.password as password, n.telefono as telefono").on("user"->consulta.usuario.user)().map{     
                case CypherRow(nombre: String, email: String, latitud:BigDecimal,longitud:BigDecimal, user:String, password:String, telefono:String)=>Usuario(nombre, email, latitud, longitud, user, password, telefono)     
            }

            val lista=allUsuarios.toList
            if(lista.size>0){
                Logger.info("El usuario existe")
                val usuario: Usuario = lista.iterator.next

                val result = Cypher("""MATCH (c:Categoria) WHERE c.nombre={catnombre} MATCH (usr:Usuario) WHERE usr.user={user} CREATE (pr:Producto {nombre:{pnombre}, descripcion:{descripcion}}), (pr)-[:PERTENECE]->(c), (usr)-[:BUSCO]->(pr)""").on("catnombre"->categoria.nombre, "user"->usuario.user, "pnombre"->producto.nombre, "descripcion"->producto.descripcion).execute()
            
                if(result==true)
                    return consulta
                else
                    return null
                }
            else{
                Logger.info("Se crea el usuario anonimo")
                   val usuario: Usuario = consulta.usuario
                    val result = Cypher("""MATCH (c:Categoria) WHERE c.nombre={catnombre} CREATE (usr:Usuario { nombre: {nombre}, email: {email}, telefono:{telefono}, latitud:{latitud}, longitud:{longitud}, user:{user},password:{password}}) CREATE (pr:Producto {nombre:{pnombre}, descripcion:{descripcion}}), (pr)-[:PERTENECE]->(c), (usr)-[:BUSCO]->(pr)""").on("catnombre"->categoria.nombre, "nombre"->usuario.nombre, "email"->usuario.email, "telefono"->usuario.telefono, "latitud"->usuario.latitud.toDouble, "longitud"->usuario.longitud.toDouble, "user"->usuario.user,"password"->usuario.password, "pnombre"->producto.nombre, "descripcion"->producto.descripcion).execute()
            
                    if(result==true)
                        return consulta
                    else
                        return null    
            }
                            
            
        
            
        }

        override def list(): List[Consulta]={
            Logger.info("BUscando data")
           

            val allConsultas = Cypher("MATCH (cl:Usuario)-[r:BUSCO]->(n:Producto)-[p:PERTENECE]->(c:Categoria) RETURN cl.nombre as nombre, cl.email as cemail, cl.telefono as ctelefono, cl.latitud as clatitud, cl.longitud as clongitud, id(n) as id, n.nombre as pnombre, n.descripcion as pdescripcion, c.nombre as catnombre, c.descripcion as catdesc")().map { row =>
              (Consulta(Usuario(row[String]("nombre"),row[String]("cemail"),row[BigDecimal]("clatitud"),row[BigDecimal]("clongitud"),row[String]("ctelefono"),row[String]("ctelefono"),row[String]("ctelefono")),(Producto(row[Long]("id"), row[String]("pnombre"),row[String]("pdescripcion"))),Categoria(row[String]("catnombre"),row[String]("catdesc"))))
            }
           
            val lista=allConsultas.toList
            Logger.info("lista"+lista)
            return lista
        }
        
    }
    
}