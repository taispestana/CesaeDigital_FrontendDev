import { Link, useParams } from "react-router-dom"

export default function Course(){
    //vai a base de dados, tabela, cursos e traz o curso na base de dados

    let {course_name} = useParams();
    
    return(
        <div>
            <h6>Aqui esta o meu curso de {course_name}</h6>

            {/* ciclo for que itera o array de cursos  e para cada um mostra nome do curso, duracao, regime e link para abrir uma nova pagina com toda a info do curso
            link */}

          

            </div>
    )
}