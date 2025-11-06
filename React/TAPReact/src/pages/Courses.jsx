import { Link } from "react-router-dom"
import ComponentsCard from "../components/ComponentsCard"
import { CORE_CONCEPTS } from "../data/coreConcepts"

export default function Courses(){

    //vai a base de dados, tabela, cursos e traz todos os cursos inscritos na base de dados numa fomra de array: cursos=[]
    return(
        <div>
            <h6>Aqui estao os meus cursos do Cesae</h6>

            {/* ciclo for que itera o array de cursos  e para cada um mostra nome do curso, duracao, regime e link para abrir uma nova pagina com toda a info do curso
            link */}

            <Link to='/course/react'>Curso React</Link>
            <br />
            <Link to='/course/laravel'>Curso Laravel</Link>
            <br />
            <Link to='/course/js'>Curso JavaScript</Link>

            <div className="container"> 
                {CORE_CONCEPTS.map((item) =>
                <ComponentsCard
                key={item.title}
                {...item}
                /> 
                )}
            </div>

            </div>
    )
}