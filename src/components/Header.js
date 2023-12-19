import React from 'react';
import '../styles/header.css';
import resim1 from '../assets/ilan.png';
import { useNavigate } from 'react-router-dom';
function Header() {

  const navigate = useNavigate();

  const handleClick=()=>{
    navigate('/');
  };
  return (
    <div>
    <header>
      <img onClick={handleClick} className='logo' src={resim1} alt="My Logo" />
      <nav>
        
        <ul className='nav__links'>
          <li><a href='/'>Tüm Arabalar</a></li>
        
        </ul>
        
      </nav>
      <a className='cta' href='/bizelasin'><button >Bize Ulaşın</button></a>
    </header>
    </div>
  );
}

export default Header;