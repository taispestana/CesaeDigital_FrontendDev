import shoppingList from "../data/shoppingList"
import { Link } from "react-router-dom"

export default function ShoppingList (){
    return(
        <div>
            <h6>A minha lista de compras</h6>
                {shoppingList.map((item) =>
                <p key={item.item}> {item.item} : {item.quantidade}</p>
                )}

                <Link to="/">Minha homepage</Link>
        </div>
    )
}