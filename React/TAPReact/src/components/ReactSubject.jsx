import { useState } from "react";
import { Button } from "./Button";
import { EXAMPLES } from "../data/coreConcepts";

export default function ReactSubject(){

    const [description, setDescription] = useState()

    function changeSubject(selectedTopic){
        setDescription(selectedTopic)
    }
    

    return(
    <div>
        <h3>Matéria de React</h3>

    <menu>
        <Button isActive={description == 'jsx'} functionForClick={() => changeSubject('jsx')}>JSX</Button>
        <Button isActive={description == 'props'} functionForClick={() => changeSubject('props')}>Props</Button>
        <Button isActive={description == 'state'} functionForClick={() => changeSubject('state')}>State</Button>
    </menu>
    
    {!description ? 'Por favor escolha um tema:' :
    <div id='tab-content'>
        <h3>{EXAMPLES[description].title ? EXAMPLES[description].title : 'título não carregado'}</h3>
        <p>{EXAMPLES[description].description ? EXAMPLES[description].description : 'descrição não carregada'}</p>
        <pre>
            <code>{EXAMPLES[description].code ? EXAMPLES[description].code : 'código não carregado'}</code>
        </pre>
    </div>
}
     </div>
    )
}