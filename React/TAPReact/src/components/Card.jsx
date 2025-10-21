// Por defeito vai assumir o silva e programador
export default function Card({firstName, lastName='Silva', title='Programador'}){
  return(
       <div className="card">
          <p>{firstName} {lastName}</p> 
          <p>{title}</p>
          </div> 
  )
};
