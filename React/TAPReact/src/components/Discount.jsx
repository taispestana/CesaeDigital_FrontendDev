 import { useState } from "react";
import { Button } from "./Button";
 
 export default function Discount() {
    const [price, setPrice] = useState(100);

    function applyDiscount(){
        
         if (price === 100) {
    setPrice(price * 0.75);
  }

    }

    const priceFormat = price.toFixed(2) + ' €'

     return (
         <div>
             <p data-testid="price">{priceFormat}</p>
             <Button functionForClick={applyDiscount}>Apply Discount</Button>
         </div>
     );
 }