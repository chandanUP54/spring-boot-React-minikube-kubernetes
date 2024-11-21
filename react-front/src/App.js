import logo from './logo.svg';
import './App.css';
import Navbar from './navbar/Navbar';
import Form from "./auth/Form"
function App() {
  return (
    <div className="App">
      <Navbar />
      <h1>HELLO WORLD KUBERNETES</h1>
      <Form />
    </div>
  );
}

export default App;
