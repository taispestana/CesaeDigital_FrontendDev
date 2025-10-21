import { Button } from "./Button"

export function CourseGoal({title, description}){
    function alertHeySend(){
        alert('Documentos enviados!')
    }

    return (
        <>
    <h2>TITLE:{title}</h2>
    <p>DESCRIPTION:{description}</p>
    <Button functionForClick={alertHeySend}>Enviar</Button>
    </>
)
}