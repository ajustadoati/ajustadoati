package services.consulta

import models.consulta.Consulta
import repositories.consulta.ConsultaRepositoryComponent

trait ConsultaServiceComponent {
    
    val consultaService: ConsultaService
    
    trait ConsultaService {
        
        def createConsulta(consulta: Consulta): Consulta

        def list(): List[Consulta]

    }

}

trait ConsultaServiceComponentImpl extends ConsultaServiceComponent {
    self: ConsultaRepositoryComponent =>
    
    override val consultaService = new ConsultaServiceImpl
    
    class ConsultaServiceImpl extends ConsultaService {
        
        override def createConsulta(consulta: Consulta): Consulta = {
            consultaRepository.createConsulta(consulta)
        }
        

        override def list(): List[Consulta] = {
            consultaRepository.list()
        }
        
        
        
    }
}