import { Button } from "./Button";
import { useState } from "react";

export default function Delete(){
    const [showAlert, setShowAlert] = useState(false);

    return (
<div>
    {/* alerta aparece se showAlert for true */}
  {showAlert && (
<div data-testid="alert" id="alert" onClick={()=>setShowAlert(false)}>

<h2>Are you sure?</h2>
<p>These changes can't be reverted!</p>
<Button>Proceed</Button>
</div> 
)}

{/* Mostra o alerta */}
<Button functionForClick={() => setShowAlert(true)}>Delete</Button>
</div>    
      );
}