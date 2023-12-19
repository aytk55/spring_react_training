import React, { useState } from 'react';
import axios from 'axios';
import '../styles/contact.css'
function Contact() {
  const [email, setEmail] = useState('');
  const [name, setName] = useState('');
  const [phoneNumber, setPhoneNumber] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();

    try {
      
      const formData = {
        email,
        name,
        phoneNumber,
        message,
      };

    
      await axios.post('http://192.168.1.108:8080/contact', formData);

     
      alert('Form başarıyla gönderildi.');
    } catch (error) {
      console.error('Form gönderiminde hata oluştu: ', error);
    }
  };

  return (
    
    <div className='contact-container'>
      <p>Aşağıda bulunan formu doldurarak bize ulaşabilirsiniz.</p>
      <form onSubmit={handleSubmit}>
        <div>
          <label htmlFor="email">E-posta:</label>
          <input
            type="email"
            id="email"
            value={email}
            onChange={(e) => setEmail(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="name">Adınız:</label>
          <input
            type="text"
            id="name"
            value={name}
            onChange={(e) => setName(e.target.value)}
            required
          />
        </div>
        <div>
          <label htmlFor="phoneNumber">Telefon Numarası:</label>
          <input
            type="tel"
            id="phoneNumber"
            value={phoneNumber}
            onChange={(e) => setPhoneNumber(e.target.value)}
          />
        </div>
        <div>
          <label htmlFor="message">Mesajınız:</label>
          <textarea
            id="message"
            value={message}
            onChange={(e) => setMessage(e.target.value)}
            required
          />
        </div>
        <button type="submit">Gönder</button>
      </form>
    </div>
  );
}

export default Contact;