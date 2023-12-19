import React from 'react';
import '../styles/footer.css';


function Footer() {
  return (
    <div className='main-footer'>
     
      <div className='footer-row'>
       <div>
      
        <p>mail adresi</p></div><p>
          &copy;{new Date().getFullYear()} Ilanaraba.com.tr | Tum Haklari Saklidir
        </p>
      </div>
    </div>
  );
}

export default Footer;