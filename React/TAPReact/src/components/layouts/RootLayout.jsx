import { Outlet } from "react-router-dom";

export default function RootLayout(){
    return (
        <>
        <nav>
        <p>Menu de navegação</p>
        </nav>

        <Outlet/>

        <footer>
            <p>Meu footer</p>
        </footer>
        </>
    )
}