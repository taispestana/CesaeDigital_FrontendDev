import { useContext } from "react";
import { AuthContext } from "../contexts/AuthContext";
import { Navigate } from "react-router-dom";

export default function RouteForStudents({element}){
const {user} = useContext(AuthContext);

if((user && user.role != 'student') || !user){
    return <Navigate to="/login" replace/>;
}

return element;

}