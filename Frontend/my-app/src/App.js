import './App.css';
import Register from './componentes/register/register';
import ConfirmationPage from './componentes/confirmation-page/confirmation-page';
import { BrowserRouter as Router, Routes, Route } from 'react-router-dom';

function App() {
  return (
    <div>
      <h1>Mi Aplicación React</h1>
      <Router>
        <Routes>
          <Route path="/" element={<Register />} />
          <Route path="/confirmation" element={<ConfirmationPage />} />
        </Routes>
    </Router>
    </div>
  );
}

export default App;
