import './nav-bar.css';
import { NavLink } from 'react-router-dom';

function NavBar() {

    return (
        <header>
            <nav>
                <ul>
                    <li id="#home"><NavLink to='/'>Inicio sesión</NavLink></li>
                    <li id="#home"><NavLink to='/register'>Registrarse</NavLink></li>  
                </ul>
            </nav>
        </header>
    );
}

export default NavBar;