import React from 'react';
import GetAll from '../requests/GetAll';
import Footer from '../components/Footer';
function HomePage() {
  return (
    <div>
    <GetAll />
    <Footer/>
    </div>
  );
}

export default HomePage;