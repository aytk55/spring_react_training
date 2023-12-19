import React from 'react';
import '../styles/ilan.css'; // stil dosyasını içe aktarın

function Ilan({ ilan,onClick }) {
  return (
    <div className='ilan-box' onClick={onClick}>
      <img src={ilan.resimUrlList[0].url} alt="ilan Resmi" />
      <div className="ilan-details">
        
        <p>{ilan.marka} {ilan.model}</p>
       <p>{ilan.fiyat} TL</p>
      </div>
    </div>
  );
}

export default Ilan;