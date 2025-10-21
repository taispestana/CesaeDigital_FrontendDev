import'./Button.css'

export function Button({children, functionForClick}){
    
          return (
       <button onClick={functionForClick}>{children}</button>
)
    
}