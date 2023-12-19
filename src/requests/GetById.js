import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useParams } from 'react-router-dom';
import '../styles/oneilan.css';

function GetById() {
  const { id } = useParams();
  const [ilan, setIlan] = useState(null);
  const [selectedImage, setSelectedImage] = useState(0); 

  useEffect(() => {
    axios.get(`http://192.168.1.108:8080/ilanlar/ilan/${id}`)
      .then(response => {
        setIlan(response.data);
      })
      .catch(error => {
        console.error('Hata:', error);
      });
  }, [id]);

  const handleImageClick = () => {
   
    setSelectedImage((selectedImage + 1) % ilan.resimUrlList.length);
  };

  return (
    <div className='one_ilan'>
      {ilan ? (
        <div>
          <div className='ilan-baslik'>
            <p>{ilan.ilanbasligi}</p>
          </div>
        <div className='centered-container'>
          
          <div className='image-container'>
            <img
              src={ilan.resimUrlList[selectedImage].url}
              alt='resim'
              onClick={handleImageClick} 
            />
          </div>
          <div className='data-container'>
            <ul className='one_ilan_unorderedlist'>
              <li>Fiyat: {ilan.fiyat} TL</li>
              <li>Marka: {ilan.marka}</li>
              <li>Model: {ilan.model}</li>
              <li>Yıl: {ilan.yil}</li>
              <li>Yakıt: {ilan.yakit}</li>
              <li>Vites: {ilan.vites}</li>
              <li>Kilometre: {ilan.kilometre}</li>
              <li>Hasar Kaydı: {ilan.hasarkaydi}</li>
              <li>Değişen Parçalar: {ilan.degisenParcalar}</li>
              <li>Boyalı Parçalar: {ilan.boyaliparcalar}</li>
              <li>Kasa Tipi: {ilan.kasatipi}</li>
              <li>Fiyat: {ilan.fiyat}</li>
              <li>Araç Sahibi: {ilan.aracsahibi}</li>
              <li>Instagram: {ilan.instagram}</li>
              <li>Konum: {ilan.konum}</li>
              <li>Telefon Numarası: {ilan.telefonnumarasi}</li>
              <li>İlan Tarihi: {ilan.ilantarihi}</li>
            </ul>
          </div>
          
        </div>
        <div className='ilan-aciklama'>
            <p>{ilan.aciklama}</p>
          </div>
        </div>
      ) : ilan === null ? (
        <p>Yükleniyor...</p>
      ) : (
        <p>İlan bulunamadı veya bir hata oluştu.</p>
      )}
    </div>
  );
}

export default GetById;



