import { useState } from "react";
import { Button } from "./Button";
import { CORE_CONCEPTS, EXAMPLES } from "../data/coreConcepts";

export default function ReactSubject(){

    const [description, setDescription] = useState(null)

    function changeSubject(selectedTopic){
        setDescription(selectedTopic)
    }

    return(
    <div>
        <h3>Matéria de React</h3>

    <menu>
        <Button functionForClick={() => changeSubject('jsx')}>JSX</Button>
        <Button functionForClick={() => changeSubject('props')}>Props</Button>
        <Button functionForClick={() => changeSubject('state')}>State</Button>
    </menu>
    
    
    <div id='tab-content'>
        <h3>{EXAMPLES[description].title}</h3>
        <p>{EXAMPLES[description].description}</p>
        <pre>
            <code>{EXAMPLES[description].code}</code>
        </pre>
    </div>
     </div>
    )
}