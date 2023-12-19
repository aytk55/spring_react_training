import React from 'react';
import GetById from'../requests/GetById';
import Footer from '../components/Footer';

function OneCarPage() {
  return (
    <div>
      <GetById/>
      <Footer/>
    </div>
  );
}

export default OneCarPage;