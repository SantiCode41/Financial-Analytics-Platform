import {useState, useEffect} from 'react';
import { BrowserRouter, Routes, Route } from 'react-router';
import Home from './Components/Home.tsx';
//import About from './components/About';
//import './App.css';

function App() {
    const [data, setData] = useState<{ message: string } | null>(null);
    const [error, setError] = useState<string | null>(null);

    useEffect(() => {
        fetch('/api/data')
            .then(res => {
                if (!res.ok) throw new Error(`HTTP error ${res.status}`);
                return res.json();
            })
            .then(data => setData(data))
            .catch(err => setError(err.message));
    }, []);

    if (error) {
        return <div>Error: {error}</div>;
    }

    if (!data) {
        return <div>Loading...</div>;
    }

    return (
        <BrowserRouter>
            <div className="App">
                    <Routes>
                        <Route path="/" element={<Home data={data} />} />
                        {/*}<!--<Route path="/about" element={<About />} />-->*/}
                        {/*<Route path="/" element={<Home />} />*/}
                    </Routes>
            </div>
        </BrowserRouter>
    );
}

export default App;
