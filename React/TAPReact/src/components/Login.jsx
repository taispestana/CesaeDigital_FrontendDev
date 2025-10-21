import { Button } from "./Button";
import "../Login.css";

export default function Login() {
    function alertLogin(){
        alert('Olá, Taís!')
    }
  return (
    <form>
      <h2>Login</h2>
      <div className="control-row">
        <div className="control no-margin">
          <label htmlFor="email">Email</label>
          <input
          />
        </div>

        <div className="control no-margin">
          <label htmlFor="password">Password</label>
          <input  
            id="password" type="password" name="password"/>
        </div>
 
      </div>

      <p className="form-actions">
        <Button functionForClick={alertLogin}>Enviar</Button>
      </p>
    </form>
  );
}