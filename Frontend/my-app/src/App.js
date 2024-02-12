// import './App.css';
import Register from './componentes/register/register';
import ConfirmationPage from './componentes/confirmation-page/confirmation-page';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';
import NavBar from './componentes/nav-bar/nav-bar';
import Footer from "./componentes/footer/footer";

function App() {
  return (
    <div>
      <Router>
        <NavBar/>
        <Routes>
          <Route path="/register" element={<Register />} />
          <Route path="/confirmation" element={<ConfirmationPage />} />
        </Routes>
        <Footer/>
      </Router>
    </div>
  );
}

export default App;
