import Header from "./components/Header";
import { BrowserRouter,Routes,Route } from "react-router-dom";
import OneCarPage from "./pages/OneCarPage";
import ContactPage from"./pages/ContactPage"
import HomePage from "./pages/HomePage";
function App() {
  return (
    <div className="App">
      
          <BrowserRouter>
          <Header/>
      <hr></hr>
          <Routes>
         
            <Route path="/bizelasin"  element={<ContactPage/>}/>
            <Route path="/car/:id" element={<OneCarPage/>} />
           
            <Route exact path="/" element={<HomePage />}>
            </Route>
          </Routes>
        </BrowserRouter>
        
      
    </div>
  );
}

export default App;
