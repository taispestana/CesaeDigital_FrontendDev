import reactLogo from '../assets/react.svg'
import '../components/ComponentsCard.css'

export default function ComponentsCard ({title, description}){
    return(
        <div className="c-card">
            <h3>{title}</h3>
            <h6>{description}</h6>
            <img src={reactLogo} alt="" />
        </div>
    )
}