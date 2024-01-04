import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Ilan from '../components/Ilan';
import { useNavigate } from 'react-router-dom';
import '../styles/ilan.css';
import '../styles/btn.css';
function GetAll() {
  const [ilanlar, setIlanlar] = useState([]);
  const [minPrice, setMinPrice] = useState(null);
  const [maxPrice, setMaxPrice] = useState(null);
  const [marka, setMarka] = useState(null);
  const [filteredIlans, setFilteredIlans] = useState([]);
  const navigate = useNavigate();
  const [siralamaTuru, setSiralamaTuru] = useState('artan');
  const [pageSize, setPageSize] = useState(10); 
  const [totalPages, setTotalPages] = useState(1);
  useEffect(() => {
    axios.get(`http://localhost:8080/ilanlar`, {
      params: {
        totalPages: totalPages,
        pageSize: pageSize
      }
    })
      .then(response => {
        if (totalPages === 1) {
          setIlanlar(response.data);
        } else {
          setIlanlar((prevIlanlar) => [...prevIlanlar, ...response.data]);
        }
      })
      .catch(error => {
        console.error('Hata:', error);
      });
  }, [totalPages, pageSize]);

  const handleFilterClick = () => {
   
    axios.get('http://localhost:8080/filter', {
      params: {
        marka: marka || null,
        minPrice: minPrice || null,
        maxPrice: maxPrice || null,
        siralama  : siralamaTuru,
        totalPages:totalPages,
        pageSize:pageSize

      },
      
    })
    .then(response => {
      setFilteredIlans(response.data);
    })
    .catch(error => {
      console.error('Hata oluştu: ', error);
    });
 
  };

  const handleClick = (carId) => {
    navigate(`/car/${carId}`);
  };

  const handleSiralamaTuruChange = (event) => {
    setSiralamaTuru(event.target.value);
  };
  const handleMarkaChange=(event)=>{
    setMarka(event.target.value);
  }

  return (
    <div>
    <div className="container">
      <div className="filter">
        <div>Sırala</div>
      <select className="custom-select" value={siralamaTuru} onChange={handleSiralamaTuruChange}>
        
          <option value="artan">Artan Fiyat</option>
          <option value="azalan">Azalan Fiyat</option>
        </select>
        <div>Marka</div>
         <select className="custom-select" value={marka} onChange={handleMarkaChange}>
          <option value="">Hepsi</option>
          <option value="Abarth">Abarth</option>
          <option value="Alfa Romeo">Alfa Romeo</option>
          <option value="Aston Martin">Aston Martin</option>
          <option value="Audi">Audi</option>
          <option value="Bentley">Bentley</option>
          <option value="BMW">BMW</option>
          <option value="Bugatti">Bugatti</option>
          <option value="Buick">Buick</option>
          <option value="Cadillac">Cadillac</option>
          <option value="Chevrolet">Chevrolet</option>
          <option value="Citroen">Citroen</option>
          <option value="Ferrari">Ferrari</option>
          <option value="Ford">Ford</option>
          <option value="Hyundai">Hyundai</option>
          <option value="Honda">Honda</option>
          <option value="Jaguar">Jaguar</option>
          <option value="Koeningsegg">Koeningsegg</option>
          <option value="Lamborghini">Lamborghini</option>
          <option value="Lotus">Lotus</option>
          <option value="Maserati">Maserati</option>
          <option value="Mazda">Mazda</option>
          <option value="Mercedes-Benz">Mercedes-Benz</option>
          <option value="Mitsubishi">Mitsubishi</option>
          <option value="Nissan">Nissan</option>
          <option value="Opel">Opel</option>
          <option value="Peugeot">Peugeot</option>
          <option value="Porsche">Porsche</option>
          <option value="Renault">Renault</option>
          <option value="Rolls Royce">Rolls Royce</option>
          <option value="Saab">Saab</option>
          <option value="Skoda">Skoda</option>
          <option value="Ssangyong">Ssangyong</option>
          <option value="Subaru">Subaru</option>
          <option value="toyota">Toyota</option>
          <option value="Volkswagen">Volkswagen</option>
          <option value="Volvo">Volvo</option>

        </select>
        <label>
        <div>Minimum fiyat</div>
          <input type="number"  value={minPrice} onChange={(e) => setMinPrice(e.target.value)} />
        </label>
        <label>
        <div>Maximum fiyat</div>
          <input type="number"  value={maxPrice} onChange={(e) => setMaxPrice(e.target.value)} />
        </label>
        
       <p>Lütfen filtrelemek için tüm alanları doldurunuz </p>
        <button  className="bn632-hover bn25" onClick={handleFilterClick}>Ilan Ara</button>
      </div>
      
      <div className="ilanlar">
        {(filteredIlans.length > 0 ? filteredIlans : ilanlar).map((ilan) => (
          <div key={ilan.id} onClick={() => handleClick(ilan.id)}>
            <Ilan ilan={ilan} />
          </div>
        ))}
      </div>
    </div>
    <div className='btn-div'>
    <button onClick={()=>setTotalPages(totalPages+1)}>Devamını gör</button></div>
    </div>
  );
}

export default GetAll;
